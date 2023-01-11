package br.com.db1.anymarket.sqlinjectiondemo.service;

import br.com.db1.anymarket.sqlinjectiondemo.model.UserRequest;
import br.com.db1.anymarket.sqlinjectiondemo.model.UserResponse;
import br.com.db1.anymarket.sqlinjectiondemo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse doAuthentication(UserRequest user) {
        var authenticatedUser = userRepository.getUser(user.username(), user.password());

        return authenticatedUser.map(value -> new UserResponse(
                value.getName(),
                value.getSurname())
        ).orElseGet(() -> new UserResponse("", ""));

    }

}
