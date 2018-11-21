package com.yu.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 商品类目
 */
@Entity
@DynamicUpdate   //动态更新注解
@Data            //lombok注解，写了这个注解就不要再写get,set和toString方法了。
public class ProductCategory {
    //类目id
    @Id
    @GeneratedValue
    private Integer categoryId;
    //类目名称
    private String categoryName;
    //类目编号
    private Integer categoryType;

    public ProductCategory(){}

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }


//    //创建日期


//    private Date createTime;
//    //更新日期
//    private Date updateTime;

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public Integer getCategoryType() {
//        return categoryType;
//    }
//
//    public void setCategoryType(Integer categoryType) {
//        this.categoryType = categoryType;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductCategory{" +
//                "categoryId=" + categoryId +
//                ", categoryName='" + categoryName + '\'' +
//                ", categoryType=" + categoryType +
//                '}';
//    }
}//end
