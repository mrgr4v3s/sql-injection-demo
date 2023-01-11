package br.com.db1.anymarket.sqlinjectiondemo.repository;

import br.com.db1.anymarket.sqlinjectiondemo.model.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(String username, String password);
}
