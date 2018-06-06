package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.entity.User;
import com.bookpublisher.bookpublisher.models.CartItem;
import com.bookpublisher.bookpublisher.models.Order;
import com.bookpublisher.bookpublisher.repositories.CartItemRepository;
import com.bookpublisher.bookpublisher.repositories.OrderRepository;
import com.bookpublisher.bookpublisher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    OrderRepository orderRepository;

    @RequestMapping("/user/shippingDetails")
    public ModelAndView showShippingDetailsPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        int totalPrice = 0;
        for (CartItem cart : user.getCartItems()) {
            totalPrice = totalPrice + cart.getNetPrice();
        }
        modelAndView.addObject("totalPrice",totalPrice+40);
        modelAndView.addObject("order" , new Order());

        modelAndView.setViewName("shippingDetails");
        return modelAndView;
    }

    @RequestMapping(value = "/user/paymentDetails", method = RequestMethod.POST)
    public ModelAndView showPaymentDetailsPage(@ModelAttribute("order") Order order, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        order.setCartItems(user.getCartItems());
        modelAndView.addObject("order",order);
        int totalPrice = 0;
        for (CartItem cart : order.getCartItems()) {
            totalPrice = totalPrice + cart.getNetPrice();
        }
        modelAndView.addObject("totalPrice",totalPrice+40);
        modelAndView.setViewName("paymentDetails");
        return modelAndView;
    }


    @RequestMapping(value = "/user/confirmOrder", method = RequestMethod.POST)
    public ModelAndView confirmOrder(Principal principal, HttpSession session, @ModelAttribute("order") Order order) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        List<CartItem> userCartItems = new ArrayList<>();
        userCartItems.addAll(user.getCartItems());
        user.getCartItems().clear();
        userRepository.save(user);
        List<CartItem> orderCartItems = new ArrayList<>();
        for (CartItem cartItem: userCartItems) {
            CartItem orderCartItem = new CartItem(cartItem.getQuantity(), cartItem.getBook());
            orderCartItems.add(orderCartItem);
            cartItemRepository.deleteByCartItemID(cartItem.getCartItemId());
        }
        session.setAttribute("cartItems", user.getCartItems());
        order.setCartItems(orderCartItems);
        order.setStatus("Undelivered");
        order.setOrderDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        orderRepository.save(order);
        modelAndView.setViewName("thankYouPage");
        return modelAndView;
    }


    @RequestMapping("/admin/allOrders")
    public ModelAndView showAllOrdersPage() {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orders = orderRepository.findAll();
        modelAndView.addObject("orders", orders);
        modelAndView.setViewName("allOrders");
        return modelAndView;
    }

    @RequestMapping("/admin/setOrderStatus")
    public ModelAndView setOrderStatus(@RequestParam("orderStatus") String orderStatus, @RequestParam("orderNo") long orderNo) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderRepository.findOne(orderNo);
        order.setStatus(orderStatus);
        orderRepository.save(order);
        modelAndView.setViewName("redirect:/admin/allOrders");
        return modelAndView;
    }

    @RequestMapping("/admin/orderDetails")
    public ModelAndView showOrderDetails(@RequestParam("orderNo") long orderNo) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderRepository.findOne(orderNo);
        modelAndView.addObject("order", order);
        int totalPrice = 0;
        for (CartItem cart : order.getCartItems()) {
            totalPrice = totalPrice + cart.getNetPrice();
        }
        modelAndView.addObject("totalPrice",totalPrice+40);
        modelAndView.setViewName("orderDetails");
        return modelAndView;
    }

    @RequestMapping("/admin/deleteOrder")
    public ModelAndView deleteOrder(@RequestParam("orderNo") long orderNo) {
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderRepository.findOne(orderNo);
        orderRepository.deleteByOrderNoFromCustomerCartItem(orderNo);
        orderRepository.delete(orderNo);
        modelAndView.setViewName("redirect:/admin/allOrders");
        return modelAndView;
    }
}
