package com.currency.monitor;


import com.currency.monitor.services.AlarmsService;
import com.currency.monitor.services.EventsService;
import com.currency.monitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private AlarmsService alarmsService;

    @Autowired
    private EventsService eventsService;

    @GetMapping
    public String getUsers(Model model){
        model.addAttribute("users",usersService.getUsers());
        return "users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id){
        alarmsService.deleteByUserId(id);
        eventsService.deleteByUserId(id);
        usersService.deleteUser(id);
        return "redirect:/users/";
    }

}