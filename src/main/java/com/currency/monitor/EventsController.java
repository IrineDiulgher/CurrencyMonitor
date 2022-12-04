package com.currency.monitor;


import com.currency.monitor.entities.User;
import com.currency.monitor.services.EventsService;
import com.currency.monitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String listEvents(Model model, Principal principal) {
        String username = principal.getName();
        Optional<User> user = usersService.getUser(username);
        if (user.isPresent()) {
            model.addAttribute("events", eventsService.getEvents(user.get().getId()));
        }
        return "events";
    }

    @GetMapping("/delete/{id}")
    public String deleteEvent(@PathVariable long id) {
        eventsService.deleteEvent(id);
        return "redirect:/events";
    }

}
