package com.rex.accountbook.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class PageController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login(@RequestParam(value = "error", defaultValue = "false") Boolean error, Model model) {
        // error 由 WebSecurity 的 failureForwardUrl 傳遞過來
        if (error) {
            logger.info("login failure");
            model.addAttribute("errorMessage", "帳號或密碼錯誤");
        }
        return "login";
    }


}
