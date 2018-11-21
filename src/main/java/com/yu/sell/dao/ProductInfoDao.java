package com.yu.sell.dao;

import com.yu.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.Max;
import java.util.List;

/**
 *商品信息Dao
 */
public interface ProductInfoDao extends JpaRepository<ProductInfo, String> {
    //查询上架的商品
    List<ProductInfo> findByProductStatus(Integer productStatus);

}//End
