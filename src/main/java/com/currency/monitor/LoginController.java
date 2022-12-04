package com.currency.monitor;

import com.currency.monitor.entities.dto.UserDto;
import com.currency.monitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String login(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "login";
    }

}
