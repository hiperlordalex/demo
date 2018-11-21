package com.alex.demo.application.login;

import com.alex.demo.modell.user.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class LoginController {

    private UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestParam("emailAddess") String emailAddess, @RequestParam("password") String password) {
        userRepository.existByEmailAddessAndPassword(emailAddess, password);
    }

}
