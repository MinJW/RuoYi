package com.ruoyi.hsz.service.impl;

import java.util.List;

import cn.hutool.core.convert.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hsz.mapper.HszGnApiInfoMapper;
import com.ruoyi.hsz.domain.HszGnApiInfo;
import com.ruoyi.hsz.service.IHszGnApiInfoService;

/**
 * 接口 服务层实现
 *
 * @author junwen
 * @date 2021-05-22
 */
@Service
public class HszGnApiInfoServiceImpl implements IHszGnApiInfoService {
    @Autowired
    private HszGnApiInfoMapper hszGnApiInfoMapper;

    /**
     * 查询接口信息
     *
     * @param id 接口ID
     * @return 接口信息
     */
    @Override
    public HszGnApiInfo selectHszGnApiInfoById(Integer id) {
        return hszGnApiInfoMapper.selectHszGnApiInfoById(id);
    }

    /**
     * 查询接口列表
     *
     * @param hszGnApiInfo 接口信息
     * @return 接口集合
     */
    @Override
    public List<HszGnApiInfo> selectHszGnApiInfoList(HszGnApiInfo hszGnApiInfo) {
        return hszGnApiInfoMapper.selectHszGnApiInfoList(hszGnApiInfo);
    }

    /**
     * 新增接口
     *
     * @param hszGnApiInfo 接口信息
     * @return 结果
     */
    @Override
    public int insertHszGnApiInfo(HszGnApiInfo hszGnApiInfo) {
        return hszGnApiInfoMapper.insertHszGnApiInfo(hszGnApiInfo);
    }

    /**
     * 修改接口
     *
     * @param hszGnApiInfo 接口信息
     * @return 结果
     */
    @Override
    public int updateHszGnApiInfo(HszGnApiInfo hszGnApiInfo) {
        return hszGnApiInfoMapper.updateHszGnApiInfo(hszGnApiInfo);
    }

    /**
     * 删除接口对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteHszGnApiInfoByIds(String ids) {
        return hszGnApiInfoMapper.deleteHszGnApiInfoByIds(Convert.toStrArray(ids));
    }

}
