/**
  * Copyright 2021 json.cn 
  */
package com.ruoyi.common.utils.processon.model;
import java.util.Date;

/**
 * Auto-generated: 2021-05-25 14:55:51
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Meta {

    private String id;
    private String member;
    private Date exportTime;
    private DiagramInfo diagramInfo;
    private String type;
    private String version;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setMember(String member) {
         this.member = member;
     }
     public String getMember() {
         return member;
     }

    public void setExportTime(Date exportTime) {
         this.exportTime = exportTime;
     }
     public Date getExportTime() {
         return exportTime;
     }

    public void setDiagramInfo(DiagramInfo diagramInfo) {
         this.diagramInfo = diagramInfo;
     }
     public DiagramInfo getDiagramInfo() {
         return diagramInfo;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setVersion(String version) {
         this.version = version;
     }
     public String getVersion() {
         return version;
     }

}