package com.yu.sell.service.impl;

import com.yu.sell.dao.ProductCategoryDao;
import com.yu.sell.dataobject.ProductCategory;
import com.yu.sell.service.interf.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ProductCategoryService的实现类
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    //注入DAO
    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    public ProductCategory findOne(Integer categoryId) {
        return productCategoryDao.findOne(categoryId);
    }

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryDao.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryDao.findByCategoryTypeIn(categoryTypeList);
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryDao.save(productCategory);
    }
}//end
