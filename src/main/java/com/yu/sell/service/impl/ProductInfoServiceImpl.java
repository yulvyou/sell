package com.yu.sell.service.impl;

import com.yu.sell.dao.ProductInfoDao;
import com.yu.sell.dataobject.ProductInfo;
import com.yu.sell.enums.ProductStatusEnum;
import com.yu.sell.service.interf.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *ProductInfoService的实现类
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String productId) {
        return productInfoDao.findOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
