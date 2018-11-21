package com.yu.sell.service.interf;

import com.yu.sell.dataobject.ProductCategory;
import org.apache.tomcat.jni.Proc;

import java.util.List;

/**
 * 产品类目Service
 */
public interface ProductCategoryService {
    //通过category_id查询一个类目
    ProductCategory findOne(Integer categoryId);

    //查询所有类目
    List<ProductCategory> findAll();

    //查询某个集合中的记录
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    //保存和更新
    ProductCategory save(ProductCategory productCategory);


}//End

