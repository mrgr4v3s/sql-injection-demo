package br.com.db1.anymarket.sqlinjectiondemo.controller;

import br.com.db1.anymarket.sqlinjectiondemo.model.User;
import br.com.db1.anymarket.sqlinjectiondemo.model.UserRequest;
import br.com.db1.anymarket.sqlinjectiondemo.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/example")
public class ExampleController {

    private AuthenticationService authenticationService;

    public ExampleController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public User authenticate(UserRequest user) {

        return authenticationService.doAuthentication(user);
    }
}
