package model.storeModel;

/**
 * Created by leo on 2017/7/7.
 */

//产品分类
public class Category {
    private int categoryId;
    private String name;
    private String remark;


    public Category(){

    }

    public Category(int categoryId, String name, String remark) {
        this.categoryId = categoryId;
        this.name = name;
        this.remark = remark;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
