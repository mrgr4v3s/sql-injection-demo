package br.com.db1.anymarket.sqlinjectiondemo.service;

import br.com.db1.anymarket.sqlinjectiondemo.model.dto.TokenValidResponse;
import br.com.db1.anymarket.sqlinjectiondemo.model.dto.UserRequest;
import br.com.db1.anymarket.sqlinjectiondemo.model.dto.UserResponse;
import br.com.db1.anymarket.sqlinjectiondemo.model.entity.User;
import br.com.db1.anymarket.sqlinjectiondemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse doAuthentication(UserRequest userRequest) {
        var authenticatedUser = userRepository.getUser(userRequest.username(), userRequest.password());

        return authenticatedUser.map(user -> new UserResponse(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getToken())
        ).orElse(null);

    }

    public TokenValidResponse isTokenValid(String token) {
        Optional<User> tokenUser = userRepository.findUserByToken(token);

        return new TokenValidResponse(tokenUser.isPresent());
    }

}
