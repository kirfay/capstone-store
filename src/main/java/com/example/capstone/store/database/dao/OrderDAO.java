package com.example.capstone.store.database.dao;

import com.example.capstone.store.database.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface OrderDAO extends JpaRepository<Order, Long> {

    @Query(value="select o.id as order_id, o.order_date, od.quantity, p.product_name, p.id as product_id, " +
            "p.price" +
            "from orderdetails od, products p, orders o " +
            "where od.product_id = p.id and o.id = od.order_id and o.id = :orderId " +
            "order by order_id;", nativeQuery = true)
    List<Map<String,Object>> getOrderDetails(Integer orderId);

    @Query(value = "select sum(od.quantity * p.buy_price) as orderTotal " +
            "from orderdetails od, products p, orders o " +
            "            where od.product_id = p.id and o.id = od.order_id and o.id = :orderId ", nativeQuery = true)
    Double getOrderTotal(Integer orderId);

    @Query(value = " select * from orders where user_id = :userId and status = 'CART'", nativeQuery = true)
    Order findOrderInCartStatus(Integer userId);


}
