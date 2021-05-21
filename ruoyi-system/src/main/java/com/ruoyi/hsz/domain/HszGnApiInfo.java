package com.ruoyi.hsz.domain;

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
@ApiModel(description="接口",parent=BaseEntity.class)
public class HszGnApiInfo extends BaseEntity{

    private static final long serialVersionUID=1L;
    
    @ApiModelProperty(value="",name="id")
    private Integer id;
        
    @ApiModelProperty(value="接口地址",name="url")
    private String url;
        
    @ApiModelProperty(value="项目",name="project")
    private String project;
        
    @ApiModelProperty(value="安卓",name="android")
    private Integer android;
        
    @ApiModelProperty(value="安卓专业版",name="android_pro")
    private Integer android_pro;
        
    @ApiModelProperty(value="安卓云控",name="android_cloud")
    private Integer android_cloud;
        
    @ApiModelProperty(value="红云",name="ios_red_cloud")
    private Integer ios_red_cloud;
        
    @ApiModelProperty(value="红雨",name="ios_red_rain")
    private Integer ios_red_rain;
        
    @ApiModelProperty(value="h5",name="h5")
    private Integer h5;
        
    @ApiModelProperty(value="pc",name="pc")
    private Integer pc;
        
    @ApiModelProperty(value="pc专业版",name="pc_pro")
    private Integer pc_pro;
        
    @ApiModelProperty(value="pc云控",name="pr_cloud")
    private Integer pr_cloud;
        
    @ApiModelProperty(value="重构地址",name="recod_url")
    private String recod_url;
        
    @ApiModelProperty(value="描述",name="descript")
    private String descript;
    
}
