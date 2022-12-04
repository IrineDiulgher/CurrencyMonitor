package com.currency.monitor;

import com.currency.monitor.entities.User;
import com.currency.monitor.entities.dto.AlarmDto;
import com.currency.monitor.services.AlarmsService;
import com.currency.monitor.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/alarms")
public class AlarmsController {

    @Autowired
    private AlarmsService alarmsService;

    @Autowired
    private UsersService usersService;

    @GetMapping
    public String listAlarms(Model model, Principal principal) {
        String username = principal.getName();
        Optional<User> user = usersService.getUser(username);
        if (user.isPresent()) {
            model.addAttribute("alarms", alarmsService.getAlarms(user.get().getId()));
        }
        model.addAttribute("alarmDto", new AlarmDto());
        return "alarms";
    }

    @PostMapping("/add")
    public String addAlarm(@Valid AlarmDto alarmDto, BindingResult result, Model model, Principal principal) {
        if (result.hasErrors()) {
            String username = principal.getName();
            Optional<User> user = usersService.getUser(username);
            if (user.isPresent()) {
                model.addAttribute("alarms", alarmsService.getAlarms(user.get().getId()));
            }
            return "alarms";
        }
        String username = principal.getName();
        Optional<User> user = usersService.getUser(username);
        if (user.isPresent()) {
            alarmsService.createAlarm(alarmDto.getCurrency(), alarmDto.getLowerExchangeRate(),
                    alarmDto.getUpperExchangeRate(), user.get());
        }
        return "redirect:/alarms";
    }

    @GetMapping("/delete/{id}")
    public String deleteAlarm(@PathVariable long id) {
        alarmsService.deleteAlarm(id);
        return "redirect:/alarms/";
    }

}
