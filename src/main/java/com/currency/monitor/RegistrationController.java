package com.currency.monitor;

import com.currency.monitor.entities.dto.UserDto;
import com.currency.monitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UsersService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "registration";
    }

    @PostMapping("/add")
    public String addUser(@Valid UserDto userDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/registration";
        }
        if (userService.createUser(userDto.getUsername(), userDto.getPassword(),
                userDto.getEmail(), userDto.getPhoneNumber(), userDto.getConfirmPassword()) != null) {
            return "redirect:/login";
        } else {
            return "redirect:/registration";
        }
    }

}
