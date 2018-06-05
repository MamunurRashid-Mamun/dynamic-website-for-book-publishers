package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.entity.User;
import com.bookpublisher.bookpublisher.models.CartItem;
import com.bookpublisher.bookpublisher.models.Customer;
import com.bookpublisher.bookpublisher.repositories.CartItemRepository;
import com.bookpublisher.bookpublisher.repositories.CustomerRepository;
import com.bookpublisher.bookpublisher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    @RequestMapping("/user/shippingDetails")
    public ModelAndView showShippingDetailsPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        int totalPrice = 0;
        for (CartItem cart : user.getCartItems()) {
            totalPrice = totalPrice + cart.getNetPrice();
        }
        modelAndView.addObject("totalPrice",totalPrice+40);
        modelAndView.addObject("customer" , new Customer());

        modelAndView.setViewName("shippingDetails");
        return modelAndView;
    }

    @RequestMapping(value = "/user/paymentDetails", method = RequestMethod.POST)
    public ModelAndView showPaymentDetailsPage(@ModelAttribute("customer") Customer customer, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        customer.setCartItems(user.getCartItems());
        modelAndView.addObject("customer",customer);
        int totalPrice = 0;
        for (CartItem cart : customer.getCartItems()) {
            totalPrice = totalPrice + cart.getNetPrice();
        }
        modelAndView.addObject("totalPrice",totalPrice+40);
        modelAndView.setViewName("paymentDetails");
        return modelAndView;
    }


    @RequestMapping(value = "/user/confirmOrder", method = RequestMethod.POST)
    public ModelAndView confirmOrder(Principal principal, HttpSession session, @ModelAttribute("customer") Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        List<CartItem> userCartItems = new ArrayList<>();
        userCartItems.addAll(user.getCartItems());
        user.getCartItems().clear();
        userRepository.save(user);
        List<CartItem> customerCartItems = new ArrayList<>();
        for (CartItem cartItem: userCartItems) {
            CartItem customerCartItem = new CartItem(cartItem.getQuantity(), cartItem.getBook());
            customerCartItems.add(customerCartItem);
            cartItemRepository.deleteByCartItemID(cartItem.getCartItemId());
        }
        session.setAttribute("cartItems", user.getCartItems());
        customer.setCartItems(customerCartItems);
        customer.setOrderDate(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        customerRepository.save(customer);
        modelAndView.setViewName("thankYouPage");
        return modelAndView;
    }
}
