package com.ruoyi.web.controller.hsz;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.utils.file.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hsz.domain.HszGnApiInfo;
import com.ruoyi.hsz.service.IHszGnApiInfoService;
import com.ruoyi.framework.web.base.BaseController;
import com.ruoyi.common.page.TableDataInfo ;
import com.ruoyi.common.base.AjaxResult;
import com.ruoyi.common.utils.ExcelUtil;

/**
 * 接口 信息操作处理
 *
 * @author junwen
 * @date 2021-05-22
 */
@Controller
@RequestMapping("/hsz/hszGnApiInfo")
public class HszGnApiInfoController extends BaseController {
    private String prefix = "hsz/hszGnApiInfo" ;

    @Autowired
    private IHszGnApiInfoService hszGnApiInfoService;

    @RequiresPermissions("hsz:hszGnApiInfo:view")
    @GetMapping()
    public String hszGnApiInfo() {
        return prefix + "/hszGnApiInfo" ;
    }

    /**
     * 查询接口列表
     */
    @RequiresPermissions("hsz:hszGnApiInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(HszGnApiInfo hszGnApiInfo) {
        startPage();
        List<HszGnApiInfo> list = hszGnApiInfoService.selectHszGnApiInfoList(hszGnApiInfo);
        return getDataTable(list);
    }


    /**
     * 导出接口列表
     */
    @RequiresPermissions("hsz:hszGnApiInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(HszGnApiInfo hszGnApiInfo) {
        List<HszGnApiInfo> list = hszGnApiInfoService.selectHszGnApiInfoList(hszGnApiInfo);
        ExcelUtil<HszGnApiInfo> util = new ExcelUtil<HszGnApiInfo>(HszGnApiInfo. class);
        return util.exportExcel(list, "hszGnApiInfo");
    }

    /**
     * 新增接口
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add" ;
    }

    /**
     * 新增保存接口
     */
    @RequiresPermissions("hsz:hszGnApiInfo:add")
    @Log(title = "接口" , businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(HszGnApiInfo hszGnApiInfo) {
        return toAjax(hszGnApiInfoService.insertHszGnApiInfo(hszGnApiInfo));
    }

    /**
     * 修改接口
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap) {
        HszGnApiInfo hszGnApiInfo =hszGnApiInfoService.selectHszGnApiInfoById(id);
        mmap.put("hszGnApiInfo" , hszGnApiInfo);
        return prefix + "/edit" ;
    }

    /**
     * 修改保存接口
     */
    @RequiresPermissions("hsz:hszGnApiInfo:edit")
    @Log(title = "接口" , businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(HszGnApiInfo hszGnApiInfo) {
        return toAjax(hszGnApiInfoService.updateHszGnApiInfo(hszGnApiInfo));
    }

    /**
     * 删除接口
     */
    @RequiresPermissions("hsz:hszGnApiInfo:remove")
    @Log(title = "接口" , businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(hszGnApiInfoService.deleteHszGnApiInfoByIds(ids));
    }

    @RequestMapping("/build")
    @ResponseBody
    public String build() throws Exception {
        HszGnApiInfo info = new HszGnApiInfo();

        List<String> list = FileUtils.readLine2List("C:\\Users\\junwen\\Desktop\\api.txt");
        Map<String,String> map = new HashMap<>(list.size());
        for(String s : list){
            String[] split = s.split("\t");
            if(split.length == 2){
                System.out.println(split[0] + " ==> " + split[1]);
                info.setUrl("/fingerauth"+split[1]);
                info.setDescript(split[0]);
                int i = hszGnApiInfoService.updateDescript(info);
                System.out.println("修改" + split[1] + " ==> " + i);
            }
        }
        return "OK";
    }


    /*@RequestMapping("/build")
    @ResponseBody
    public String build() throws Exception {
        FileInputStream excelFileInputStream = new FileInputStream("C:\\Users\\junwen\\Desktop\\redfinger-gn 接口整理.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream);
        excelFileInputStream.close();

        List<HszGnApiInfo> infoList = new ArrayList<>();
        XSSFSheet sheet = workbook.getSheetAt(2);
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            HszGnApiInfo info = new HszGnApiInfo();
            // XSSFRow 代表一行数据
            XSSFRow row = sheet.getRow(rowIndex);
            if (row == null) {
                continue;
            }


            //设置单元格类型
            XSSFCell urlCell = row.getCell(0);
            XSSFCell numCell = row.getCell(1);
            XSSFCell androidCell = row.getCell(2);
            XSSFCell androidProCell = row.getCell(3);

            if(urlCell == null || numCell == null || androidCell == null || androidProCell == null ){
                continue;
            }

            urlCell.setCellType(CellType.STRING);
            numCell.setCellType(CellType.STRING);
            androidCell.setCellType(CellType.STRING);
            androidProCell.setCellType(CellType.STRING);


            info.setUrl(urlCell.getStringCellValue());
            info.setProject(numCell.getStringCellValue());
            info.setAndroid(Integer.parseInt(androidCell.getStringCellValue()));
            info.setAndroid_pro(Integer.parseInt(androidProCell.getStringCellValue()));


            infoList.add(info);
        }

        workbook.close();
        System.out.println(infoList);
        for(HszGnApiInfo hszGnApiInfo : infoList){
            int i = hszGnApiInfoService.insertHszGnApiInfo(hszGnApiInfo);
        }
        return "OK";
    }*/

}
