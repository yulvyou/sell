package com.yu.sell.controller;

import com.yu.sell.dataobject.ProductCategory;
import com.yu.sell.dataobject.ProductInfo;
import com.yu.sell.service.interf.ProductCategoryService;
import com.yu.sell.service.interf.ProductInfoService;
import com.yu.sell.utils.ResultVOUtil;
import com.yu.sell.viewobject.ProductInfoVO;
import com.yu.sell.viewobject.ProductVO;
import com.yu.sell.viewobject.ResultVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *买家商品相关的Controller
 */
@RestController
@RequestMapping("buyer/product")
public class BuyerProductController {

    //注入商品信息Service
    @Autowired
    private ProductInfoService productInfoService;
    //注入类目Service
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("/list")
    public ResultVO list(){
        //1、查询所有的上架商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        //2、查询类目（一次性查询）
        List<Integer> categoryTypeList = new ArrayList<>();
        //得到所有产品的类目List
        for(ProductInfo productInfo:productInfoList){
            categoryTypeList.add(productInfo.getCategoryType());
        }
        List<ProductCategory> productCategoryList = productCategoryService.findByCategoryTypeIn(categoryTypeList);

        //3、数据拼装
        //首先遍历类目
        List<ProductVO> productVOList = new ArrayList<>();
        for(ProductCategory productCategory : productCategoryList){

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            //再遍历商品详情
            for (ProductInfo productInfo:productInfoList){
                if (productCategory.getCategoryType().equals(productInfo.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    //将类目匹配的productInfo中的属性赋值到productInfoVO中
//                    productInfoVO.setProductDescription(productInfo.getProductDescription());
//                    productInfoVO.setProductIcon(productInfo.getProductIcon());
//                    productInfoVO.setProductId(productInfo.getProductId());
//                    productInfoVO.setProductName(productInfo.getProductName());
//                    productInfoVO.setProductPrice(productInfo.getProductPrice());
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }//for

            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }//for

        //将productVOList放入resultVO中
        ResultVO resultVO = ResultVOUtil.sucess(productVOList);

        return resultVO;
    }
}//End
