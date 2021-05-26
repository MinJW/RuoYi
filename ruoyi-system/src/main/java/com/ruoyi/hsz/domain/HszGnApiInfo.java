package com.ruoyi.hsz.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 接口表 hsz_gn_api_info
 *
 * @author junwen
 * @date 2021-05-22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "接口", parent = BaseEntity.class)
public class HszGnApiInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    //@Excel(name = "参数主键")
    @ApiModelProperty(value = "", name = "id")
    private Integer id;

    @Excel(name = "接口地址")
    @ApiModelProperty(value = "接口地址", name = "url")
    private String url;

    //@Excel(name = "所属项目")
    @ApiModelProperty(value = "所属项目", name = "project")
    private String project;

    @Excel(name = "安卓")
    @ApiModelProperty(value = "安卓", name = "android")
    private Integer android;

    @Excel(name = "安卓专业版")
    @ApiModelProperty(value = "安卓专业版", name = "android_pro")
    private Integer android_pro;

    //@Excel(name = "安卓云控")
    @ApiModelProperty(value = "安卓云控", name = "android_cloud")
    private Integer android_cloud;

    //@Excel(name = "红云")
    @ApiModelProperty(value = "红云", name = "ios_red_cloud")
    private Integer ios_red_cloud;

    //@Excel(name = "红雨")
    @ApiModelProperty(value = "红雨", name = "ios_red_rain")
    private Integer ios_red_rain;

    @Excel(name = "h5")
    @ApiModelProperty(value = "h5", name = "h5")
    private Integer h5;

    @Excel(name = "pc")
    @ApiModelProperty(value = "pc", name = "pc")
    private Integer pc;

    @Excel(name = "pc专业版")
    @ApiModelProperty(value = "pc专业版", name = "pc_pro")
    private Integer pc_pro;

    //@Excel(name = "pc云控")
    @ApiModelProperty(value = "pc云控", name = "pr_cloud")
    private Integer pr_cloud;

    //@Excel(name = "重构地址")
    @ApiModelProperty(value = "重构地址", name = "recod_url")
    private String recod_url;

    //@Excel(name = "描述")
    @ApiModelProperty(value = "描述", name = "descript")
    private String descript;

    @Excel(name = "15天请求量")
    @ApiModelProperty(value = "15天请求量", name = "descript")
    private String fifteen_req_num;

}
