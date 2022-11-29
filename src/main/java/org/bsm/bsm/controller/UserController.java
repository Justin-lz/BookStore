package org.bsm.bsm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("BSM/User")
public class UserController {

    @GetMapping("login/{id}")
    public String login
}
