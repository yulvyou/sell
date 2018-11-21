package com.yu.sell.dao;

import com.yu.sell.dataobject.OrderMaster;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao dao;

    private final String OPENID = "110110";
    @Test
    public  void saveTest(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("654312");
        orderMaster.setBuyerName("师姐");
        orderMaster.setBuyerPhone("123456789123");
        orderMaster.setBuyerAddress("幕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.66));//订单金额

        OrderMaster result = dao.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        //分页的参数
        PageRequest pageRequest = new PageRequest(0,1);
        Page<OrderMaster> result = dao.findByBuyerOpenid(OPENID,pageRequest);
        System.out.println(result.getTotalElements());
    }

}