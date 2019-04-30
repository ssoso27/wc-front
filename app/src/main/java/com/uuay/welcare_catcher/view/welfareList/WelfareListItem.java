package com.uuay.welcare_catcher.view.welfareList;
/*

 */
public class WelfareListItem {
    private String titleStr ;
    private String descStr ;
//    private String periodStr ;
    private String ratingStr ;
    private String typeStr ;
    private String categoryStr ;

    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }
//    public void setPeriod(String period) {
//        periodStr = period ;
//    }
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
//    public String getPeriod() {
//        return this.periodStr ;
//    }
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
