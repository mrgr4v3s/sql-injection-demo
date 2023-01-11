package br.com.db1.anymarket.sqlinjectiondemo.repository.implementation;

import br.com.db1.anymarket.sqlinjectiondemo.model.User;
import br.com.db1.anymarket.sqlinjectiondemo.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository {
    private static final String FIND_USER_BY_USERNAME_PASSWORD = "select id, username, password, name, surname " +
    "from users u " +
    "where u.username = '%s' " +
    "and u.password = '%s'";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> getUser(String username, String password) {

        Query query = entityManager.createNativeQuery(FIND_USER_BY_USERNAME_PASSWORD.formatted(username, password), User.class);

        return Optional.of((User) query.getSingleResult());
    }
}
