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
public class Elements {

    private String id;
    private String structure;
    private List<String> leftChildren;
    private String title;
    private String watermark;
    private boolean root;
    private String theme;
    private List<String> summaries;
    private List<Children> children;
    private String note;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setStructure(String structure) {
         this.structure = structure;
     }
     public String getStructure() {
         return structure;
     }

    public void setLeftChildren(List<String> leftChildren) {
         this.leftChildren = leftChildren;
     }
     public List<String> getLeftChildren() {
         return leftChildren;
     }

    public void setTitle(String title) {
         this.title = title;
     }
     public String getTitle() {
         return title;
     }

    public void setWatermark(String watermark) {
         this.watermark = watermark;
     }
     public String getWatermark() {
         return watermark;
     }

    public void setRoot(boolean root) {
         this.root = root;
     }
     public boolean getRoot() {
         return root;
     }

    public void setTheme(String theme) {
         this.theme = theme;
     }
     public String getTheme() {
         return theme;
     }

    public void setSummaries(List<String> summaries) {
         this.summaries = summaries;
     }
     public List<String> getSummaries() {
         return summaries;
     }

    public void setChildren(List<Children> children) {
         this.children = children;
     }
     public List<Children> getChildren() {
         return children;
     }

    public void setNote(String note) {
         this.note = note;
     }
     public String getNote() {
         return note;
     }

}