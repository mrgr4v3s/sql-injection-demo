package br.com.db1.anymarket.sqlinjectiondemo.controller;

import br.com.db1.anymarket.sqlinjectiondemo.model.UserRequest;
import br.com.db1.anymarket.sqlinjectiondemo.model.UserResponse;
import br.com.db1.anymarket.sqlinjectiondemo.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<UserResponse> authenticate(@RequestBody UserRequest user) {

        return ResponseEntity.ok()
                .body(authenticationService.doAuthentication(user));
    }
}
