package com.bookpublisher.bookpublisher.Controllers;

import com.bookpublisher.bookpublisher.entity.Role;
import com.bookpublisher.bookpublisher.entity.User;
import com.bookpublisher.bookpublisher.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult, @ModelAttribute("confirmPassword") String confirmPassword) {
        ModelAndView modelAndView = new ModelAndView();
        User userExist1 = userRepository.findByUserName(user.getUserName());
        User userExist2 = userRepository.findByEmail(user.getEmail());

        if (userExist1 != null || userExist2 != null) {
            bindingResult
                    .rejectValue("userName", "error.user",
                            "There is already a user registered with the username or email provided");
        }

        if (!user.getPassword().equals(confirmPassword)) {
            bindingResult
                    .rejectValue("", "");
            modelAndView.addObject("confirmPasswordError","Password mismatch");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("login");
        } else {
            List roles = new ArrayList();
//            roles.add(new Role("ROLE_ADMIN"));
            roles.add(new Role("ROLE_USER"));
            user.setEnabled(true);
            user.setRoles(roles);

            System.out.println(user);

            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

            userRepository.save(user);

            modelAndView.addObject("successMessage", "User has been registered successfully. You can login now.");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }
}
