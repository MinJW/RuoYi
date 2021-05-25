/**
  * Copyright 2021 json.cn 
  */
package com.ruoyi.common.utils.processon.model;
import java.util.List;

/**
 * Auto-generated: 2021-05-25 14:55:51
 *
 * @author json.cn (i@json.cn)
 * @website http://www.json.cn/java2pojo/
 */
public class Children {

    private String id;
    private String title;
    private LineStyle lineStyle;
    private List<Children> children;
    private String parent;
    private boolean collapsed;
    private String note;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setLineStyle(LineStyle lineStyle) {
         this.lineStyle = lineStyle;
     }
     public LineStyle getLineStyle() {
         return lineStyle;
     }

    public void setChildren(List<Children> children) {
         this.children = children;
     }
     public List<Children> getChildren() {
         return children;
     }

    public void setParent(String parent) {
         this.parent = parent;
     }
     public String getParent() {
         return parent;
     }

    public void setCollapsed(boolean collapsed) {
         this.collapsed = collapsed;
     }
     public boolean getCollapsed() {
         return collapsed;
     }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}