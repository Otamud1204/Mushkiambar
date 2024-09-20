package uz.repository;

import jakarta.persistence.EntityManager;
import uz.entity.Cheka;
import uz.entity.Mushkiambar;

import java.util.List;
import java.util.Optional;

import static uz.Datasource.entityManagerFactory;

public class ChekRepo {

public void save(Cheka cheka) {
    if (cheka.getId() != null) {
        edit(cheka);
        return;
    }
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    em.persist(cheka);
    em.getTransaction().commit();
}

private void edit(Cheka cheka) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    em.merge(cheka);
    em.getTransaction().commit();
}

public List<Mushkiambar> chekAll() {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    List resultList = em.createNativeQuery("select * from cheka", Cheka.class).getResultList();
    em.getTransaction().commit();
    return resultList;
}

private static ChekRepo instance;

public static ChekRepo getInstance() {
    if (instance == null) {
        instance = new ChekRepo();
    }
    return instance;
}

public Optional<Cheka> findById(Integer id) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    Cheka cheka = em.find(Cheka.class, id);
    em.getTransaction().commit();
    return Optional.ofNullable(cheka);
}


public void delete(int id) {
    EntityManager em = entityManagerFactory.createEntityManager();
    em.getTransaction().begin();
    em.remove(em.find(Cheka.class, id));
    em.getTransaction().commit();
}
}
