package com.yu.sell.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yu.sell.dataobject.ProductInfo;
import lombok.Data;

import java.util.List;

/**
 *返回给前端的商品信息（包含类目）
 */
@Data
public class ProductVO {
    @JsonProperty("name")   //使用该注解后categoryName参数返回的时候为“name”
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
