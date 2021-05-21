package com.ruoyi.web.controller.hsz;

import java.util.List;

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

}
