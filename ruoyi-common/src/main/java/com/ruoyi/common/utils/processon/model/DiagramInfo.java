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
public class DiagramInfo {

    private String category;
    private String title;
    private Date created;
    private String creator;
    private Date modified;
    public void setCategory(String category) {
         this.category = category;
     }
     public String getCategory() {
         return category;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setCreated(Date created) {
         this.created = created;
     }
     public Date getCreated() {
         return created;
     }

    public void setCreator(String creator) {
         this.creator = creator;
     }
     public String getCreator() {
         return creator;
     }

    public void setModified(Date modified) {
         this.modified = modified;
     }
     public Date getModified() {
         return modified;
     }

}