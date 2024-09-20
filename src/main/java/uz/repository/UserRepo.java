package uz.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import uz.entity.User;

import java.util.Optional;

import static uz.Datasource.entityManagerFactory;


public class UserRepo {


    public void save(User user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public Optional<User> getById(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);

    }

    private static UserRepo instance;
    public static UserRepo getInstance() {
        if (instance == null) {
            instance = new UserRepo();
        }
        return instance;
    }

    public Optional<User> getUserByUsername(String username) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Query query = entityManager.createNativeQuery("select * from Users where username = ?", User.class).setParameter(1, username);
        User singleResult = (User)query.getSingleResult();
        return Optional.ofNullable(singleResult);
    }
}
