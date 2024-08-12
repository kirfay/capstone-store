package com.example.capstone.store.controller;

import com.example.capstone.store.database.dao.OrderDAO;
import com.example.capstone.store.database.dao.OrderDetailDAO;
import com.example.capstone.store.database.dao.ProductDAO;
import com.example.capstone.store.database.entity.Order;
import com.example.capstone.store.database.entity.OrderDetail;
import com.example.capstone.store.database.entity.Product;
import com.example.capstone.store.database.entity.User;
import com.example.capstone.store.security.AuthenticatedUserUtilities;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
public class OrderController {

    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private AuthenticatedUserUtilities authenticatedUserUtilities;


    @GetMapping("/order/orderdetail")
    public ModelAndView orderDetail() {
        ModelAndView response = new ModelAndView("order/orderdetail");

        // get the logged in user
        User user = authenticatedUserUtilities.getCurrentUser();

        // now we need to get the order from the database where the status is 'CART'
        Order order = orderDAO.findOrderInCartStatus(user.getId());

        if ( order != null ) {
            // get the order details for the order
            List<Map<String, Object>> orderDetails = orderDAO.getOrderDetails(order.getId());
            response.addObject("orderDetails", orderDetails);

            // lets get the total order amount
            Double orderTotal = orderDAO.getOrderTotal(order.getId());
            response.addObject("orderTotal", orderTotal);
        }

        return response;
    }


    @GetMapping("/order/addToCart")
    public ModelAndView addToCart(@RequestParam Integer productId) {
        ModelAndView response = new ModelAndView();

        // first we can look up the product in the database given the incoming productId
        Product product = productDAO.findById(productId);

        // get the logged in user
        User user = authenticatedUserUtilities.getCurrentUser();

        // now we need to get the order from the database where the status is 'CART' and the user is the logged in user
        Order order = orderDAO.findOrderInCartStatus(user.getId());
        if ( order == null ) {
            // the user does not have an order in cart status so we need to create one
            order = new Order();
            order.setUser(user);
            order.setOrderDate(new Date());
            order.setStatus("CART");
            orderDAO.save(order);
        }

        // now we have to look to see if the product is already in the order details table
        OrderDetail orderDetail = orderDetailDAO.isProductInCart(order.getId(), productId);
        if ( orderDetail == null ) {
            // this product is not part of this order; we can create a new order details
            orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(1);

            orderDetailDAO.save(orderDetail);
        } else {
            // the product is already in the cart so we need to increment the quantity
            orderDetail.setQuantity(orderDetail.getQuantity() + 1);
            orderDetailDAO.save(orderDetail);
        }

        response.setViewName("redirect:/order/orderdetail");
        return response;
    }

    @GetMapping("/order/checkout")
    public ModelAndView checkout() {
        ModelAndView response = new ModelAndView();

        // get the loggedin user
        User user = authenticatedUserUtilities.getCurrentUser();

        // now we need to get the order from the database where the status is 'CART'
        Order order = orderDAO.findOrderInCartStatus(user.getId());
        if ( order == null ) {
            log.error("There is no order with items in the cart to checkout");
        } else {
            // there was an order with items in the cart so we change the status to COMPLETE
            order.setStatus("COMPLETE");
            orderDAO.save(order);
        }

        response.setViewName("redirect:/order/orderdetail");
        return response;
    }


}


