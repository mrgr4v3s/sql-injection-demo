package br.com.db1.anymarket.sqlinjectiondemo.repository;

import br.com.db1.anymarket.sqlinjectiondemo.model.User;

public interface UserRepository {

    User getUser(String username, String password);
}
