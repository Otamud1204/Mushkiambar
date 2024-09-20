package uz.repository;

import jakarta.persistence.EntityManager;
import uz.entity.Harid;

import java.util.List;
import java.util.Optional;

import static uz.Datasource.entityManagerFactory;

public class HaridRepo {
    public void save(Harid harid) {
        if (harid.getId() != null) {
            edit(harid);
            return;
        }
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(harid);
        em.getTransaction().commit();
    }

    private void edit(Harid harid) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(harid);
        em.getTransaction().commit();
    }

    public List<Harid> haridAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();

        List resultList = em.createQuery("select h from Harid h", Harid.class).getResultList();
        em.getTransaction().commit();
        return resultList;
    }

    private static HaridRepo instance;

    public static HaridRepo getInstance() {
        if (instance == null) {
            instance = new HaridRepo();
        }
        return instance;
    }

    public Optional<Harid> haridById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Harid harid = em.find(Harid.class, id);
        em.getTransaction().commit();
        return Optional.ofNullable(harid);
    }


    public void delete(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Harid.class, id));
        em.getTransaction().commit();
    }
}
