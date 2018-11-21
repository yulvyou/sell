package com.yu.sell.dao;

import com.yu.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDaoTest {
    @Autowired
    private ProductCategoryDao productCategoryDao;
    Integer id = 1;
    @Test
    public void findOneTest(){
        ProductCategory productCategory = productCategoryDao.findOne(id);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        ProductCategory result = productCategoryDao.save(productCategory);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByCategoryTypeIn(){
        //查询的Type集合
        List<Integer> list = Arrays.asList(2,3,4);

        //查询所有Type是2、3或4的记录
        List<ProductCategory> result = productCategoryDao.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,result.size());
    }


}//End