package br.com.db1.anymarket.sqlinjectiondemo.controller;

import br.com.db1.anymarket.sqlinjectiondemo.model.dto.TokenValidResponse;
import br.com.db1.anymarket.sqlinjectiondemo.model.dto.UserRequest;
import br.com.db1.anymarket.sqlinjectiondemo.model.dto.UserResponse;
import br.com.db1.anymarket.sqlinjectiondemo.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/token")
    public ResponseEntity<TokenValidResponse> isTokenValid(@RequestParam String token) {
        return ResponseEntity.ok(authenticationService.isTokenValid(token));
    }
}
