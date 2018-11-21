package com.yu.sell.service.impl;

import com.yu.sell.dataobject.ProductInfo;
import com.yu.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;
    @Test
    public void findOne() {
        ProductInfo productInfo = productInfoService.findOne("123456");
        Assert.assertEquals("123456",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        Assert.assertNotEquals(0,productInfoList.size());
    }

    @Test
    public void findAll() {
        PageRequest request = new PageRequest(0,2);
        Page<ProductInfo> productInfoPage = productInfoService.findAll(request);
//        System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals(0,productInfoPage.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("654321");
        productInfo.setProductName("啤酒鸭");
        productInfo.setProductPrice(new BigDecimal(16.5));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("真好吃");
        productInfo.setProductIcon("http://www.d.com/a.jpg");
        productInfo.setProductStatus(ProductStatusEnum.DOWN.getCode());
        productInfo.setCategoryType(1);
        ProductInfo result = productInfoService.save(productInfo);
        Assert.assertNotNull(result);
    }
}//End