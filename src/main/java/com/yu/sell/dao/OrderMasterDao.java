package com.yu.sell.dao;

import com.yu.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 主订单dao
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable );

}
