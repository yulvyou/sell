package com.yu.sell.dao;

import com.yu.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 *ProductInfoDao测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoDaoTest {
    //注入ProductInfoDao
    @Autowired
    private ProductInfoDao productInfoDao;

    //测试写入方法
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123456");
        productInfo.setProductName("黄焖鸡");
        productInfo.setProductPrice(new BigDecimal(16.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("好吃");
        productInfo.setProductIcon("http://www.d.com/a.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(2);
        ProductInfo result = productInfoDao.save(productInfo);

        Assert.assertNotNull(result);
    }

    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList = productInfoDao.findByProductStatus(0);
        Assert.assertNotEquals(0,productInfoList.size());
    }
}//END