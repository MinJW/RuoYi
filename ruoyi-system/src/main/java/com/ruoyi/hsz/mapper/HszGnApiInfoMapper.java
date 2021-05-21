package com.ruoyi.hsz.mapper;

import com.ruoyi.hsz.domain.HszGnApiInfo;
import java.util.List;

/**
 * 接口 数据层
 *
 * @author junwen
 * @date 2021-05-22
 */
public interface HszGnApiInfoMapper {
    /**
     * 查询接口信息
     *
     * @param id 接口ID
     * @return 接口信息
     */
    public HszGnApiInfo selectHszGnApiInfoById(Integer id);

    /**
     * 查询接口列表
     *
     * @param hszGnApiInfo 接口信息
     * @return 接口集合
     */
    public List<HszGnApiInfo> selectHszGnApiInfoList(HszGnApiInfo hszGnApiInfo);

    /**
     * 新增接口
     *
     * @param hszGnApiInfo 接口信息
     * @return 结果
     */
    public int insertHszGnApiInfo(HszGnApiInfo hszGnApiInfo);

    /**
     * 修改接口
     *
     * @param hszGnApiInfo 接口信息
     * @return 结果
     */
    public int updateHszGnApiInfo(HszGnApiInfo hszGnApiInfo);

    /**
     * 删除接口
     *
     * @param id 接口ID
     * @return 结果
     */
    public int deleteHszGnApiInfoById(Integer id);

    /**
     * 批量删除接口
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteHszGnApiInfoByIds(String[] ids);

}