package com.alex.demo.application.login;

import com.alex.demo.modell.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView login(@RequestParam("emailAddess") String emailAddess, @RequestParam("password") String password) {
        if (userRepository.existsByEmailAddessAndPassword(emailAddess, password)) {
            return new RedirectView("/home");
        }
        return new RedirectView("/login");
    }

}
