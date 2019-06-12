package com.uuay.welcare_catcher.view.selfcheckList;

public class SelfCheckListItem {
    private String titleStr ;
    private String descStr ;
    private String ratingStr ;
    private String typeStr ;
    private String categoryStr ;

    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }
    public void setRating(String rating) {
        ratingStr = rating ;
    }
    public void setType(String type) {
        typeStr = type ;
    }
    public void setCategory(String category) {
        categoryStr = category;
    }

    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
    public String getRating() {
        return this.ratingStr ;
    }
    public String getType() {
        return this.typeStr ;
    }
    public String getCategory() {
        return this.categoryStr ;
    }
}
