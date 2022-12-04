package com.currency.monitor;

import com.currency.monitor.services.exchange.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ExchangeService exchangeService;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("exchangeMap", exchangeService.getExchangeRates());
        model.addAttribute("baseCurrency", exchangeService.getBaseCurrency());
        return "home";
    }

}
