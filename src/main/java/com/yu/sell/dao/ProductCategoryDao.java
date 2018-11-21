package com.yu.sell.dao;

import com.yu.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 商品类目DAO
 */
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {

    //根据Type查询在某个Type集合中的说有记录
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}//End
