package br.com.db1.anymarket.sqlinjectiondemo.repository.implementation;

import br.com.db1.anymarket.sqlinjectiondemo.model.entity.User;
import br.com.db1.anymarket.sqlinjectiondemo.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImp implements UserRepository {
    private static final String FIND_USER_BY_USERNAME_PASSWORD = "select id, username, name, surname, token " +
    "from users u " +
    "where u.username = '%s' " +
    "and u.password = '%s'";

    private static final String FIND_USER_BY_TOKEN = "select id, username, name, surname, token " +
            "from users u " +
            "where u.token = '%s'";

    private static final String FIND_USER_IN_ORDER = "select distinct id, username, name, surname, token " +
            "from injection.users u " +
            "where u.role = '%s'";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<User> getUser(String username, String password) {

        Query query = entityManager.createNativeQuery(FIND_USER_BY_USERNAME_PASSWORD.formatted(username, password), User.class);

        return Optional.of((User) query.getSingleResult());
    }

    @Override
    public Optional<User> findUserByToken(String token) {

        Query query = entityManager.createNativeQuery(FIND_USER_BY_TOKEN.formatted(token), User.class);

        try {
            return Optional.of((User) query.getSingleResult());

        } catch (NoResultException exception) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<User>> findUsersInOrder(String filter) {
        Query query = entityManager.createNativeQuery(FIND_USER_IN_ORDER.formatted(filter), User.class);

        try {
            return Optional.of(query.getResultList());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
