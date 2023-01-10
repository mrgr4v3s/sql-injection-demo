package br.com.db1.anymarket.sqlinjectiondemo.service;

import br.com.db1.anymarket.sqlinjectiondemo.model.User;
import br.com.db1.anymarket.sqlinjectiondemo.model.UserRequest;
import br.com.db1.anymarket.sqlinjectiondemo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private UserRepository userRepository;

    public AuthenticationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User doAuthentication(UserRequest user) {
        return userRepository.getUser(user.username(), user.password());
    }

}
