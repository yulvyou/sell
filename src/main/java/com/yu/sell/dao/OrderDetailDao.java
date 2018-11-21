package com.yu.sell.dao;

import com.yu.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情页dao
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    List<OrderDetail> findByOrderId(String orderId);

}
