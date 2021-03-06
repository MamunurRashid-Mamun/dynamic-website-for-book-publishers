package com.bookpublisher.bookpublisher.controllers;

import com.bookpublisher.bookpublisher.entity.User;
import com.bookpublisher.bookpublisher.models.Book;
import com.bookpublisher.bookpublisher.models.CartItem;
import com.bookpublisher.bookpublisher.repositories.BookRepository;
import com.bookpublisher.bookpublisher.repositories.CartItemRepository;
import com.bookpublisher.bookpublisher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
@SessionAttributes({"cartItems","numberOfCartItems"})

public class CartItemsController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartItemRepository cartItemRepository;

    @RequestMapping(value = "/user/addToCart")
    public ModelAndView addToCart(@RequestParam("isbn") String isbn, Principal principal, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        Book book = bookRepository.findByIsbn(isbn);
        List<CartItem> cartItems = cartItemRepository.findAllByBook(book);
        for (CartItem cartItem : cartItems) {
            if (user.getCartItems().contains(cartItem)) {
                redirectAttributes.addFlashAttribute("errorMessage","This Book has been already added to your Cart");
                modelAndView.setViewName("redirect:/bookDetails?isbn="+isbn);
                return modelAndView;
            }
        }

        user.getCartItems().add(new CartItem(1,book));
        userRepository.save(user);
        int totalPrice = 0;
        for (CartItem cart : user.getCartItems()) {
            totalPrice = totalPrice + cart.getNetPrice();
        }
        modelAndView.addObject("totalPrice",totalPrice+40);
        modelAndView.addObject("cartItems",user.getCartItems());
        modelAndView.setViewName("cartList");
        return modelAndView;
    }

    @RequestMapping(value = "/user/showCartItems")
    public ModelAndView showCartItems(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        modelAndView.addObject("cartItems",user.getCartItems());
        int totalPrice = 0;
        for (CartItem cart : user.getCartItems()) {
            totalPrice = totalPrice + cart.getNetPrice();
        }
        modelAndView.addObject("totalPrice",totalPrice+40);
        modelAndView.setViewName("cartList");
        return modelAndView;
    }

    @RequestMapping(value = "/user/deleteCartItem")
    public ModelAndView deleteCartItems(@RequestParam("cartItemId") long cartItemId, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        user.getCartItems().remove(cartItemRepository.findOne(cartItemId));
        userRepository.save(user);
        cartItemRepository.deleteByCartItemID(cartItemId);
        modelAndView.setViewName("redirect:/user/showCartItems");
        return modelAndView;
    }

    @RequestMapping(value = "/user/increaseCartItem")
    public ModelAndView increaseCartItems(@RequestParam("cartItemId") long cartItemId, Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        List<CartItem> cartItems = user.getCartItems();
        CartItem cartItem = cartItemRepository.findByCartItemId(cartItemId);
        int index = cartItems.indexOf(cartItem);
        cartItem.setQuantity(cartItem.getQuantity() + 1);
        cartItems.set(index, cartItem);
        user.setCartItems(cartItems);
        userRepository.save(user);
        modelAndView.setViewName("redirect:/user/showCartItems");
        return modelAndView;
    }

    @RequestMapping(value = "/user/decreaseCartItem")
    public ModelAndView decreaseCartItems(@RequestParam("cartItemId") long cartItemId, Principal principal, RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userRepository.findByUserNameOrEmail(principal.getName(), principal.getName());
        List<CartItem> cartItems = user.getCartItems();
        CartItem cartItem = cartItemRepository.findByCartItemId(cartItemId);
        int index = cartItems.indexOf(cartItem);
        if (cartItem.getQuantity() > 1) {
            cartItem.setQuantity(cartItem.getQuantity() - 1);
            cartItems.set(index, cartItem);;
            user.setCartItems(cartItems);
            userRepository.save(user);
        } else {
            redirectAttributes.addFlashAttribute("decreaseError","Item should not be less than 1");
        }
        modelAndView.setViewName("redirect:/user/showCartItems");
        return modelAndView;
    }
}
