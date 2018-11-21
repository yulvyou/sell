package com.yu.sell.service.interf;

import com.yu.sell.dataobject.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 商品详情Service
 */
public interface ProductInfoService {
    //根据商品ID查询商品信息
    ProductInfo findOne(String productId);
    //查询所有在架商品列表
    List<ProductInfo> findUpAll();

    //查询所有商品且做分页操作，返回数据为Page对象
    Page<ProductInfo> findAll(Pageable pageable);//Pageable用于分页操作

    //保存商品信息
    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存

}
