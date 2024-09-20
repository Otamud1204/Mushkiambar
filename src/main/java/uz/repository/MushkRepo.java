package uz.repository;

import jakarta.persistence.EntityManager;
import uz.entity.Mushkiambar;

import java.util.List;
import java.util.Optional;

import static uz.Datasource.entityManagerFactory;

public class MushkRepo {

    public void save(Mushkiambar mushk) {
        if (mushk.getId() != null) {
            edit(mushk);
            return;
        }
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(mushk);
        em.getTransaction().commit();
    }

    private void edit(Mushkiambar mushk) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.merge(mushk);
        em.getTransaction().commit();
    }

    public List<Mushkiambar> mushkAll() {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        List resultList = em.createNativeQuery("select * from mushkiambar", Mushkiambar.class).getResultList();
        em.getTransaction().commit();
        return resultList;
    }

    private static MushkRepo instance;

    public static MushkRepo getInstance() {
        if (instance == null) {
            instance = new MushkRepo();
        }
        return instance;
    }

    public Optional<Mushkiambar> findById(Integer id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        Mushkiambar mushk = em.find(Mushkiambar.class, id);
        em.getTransaction().commit();
        return Optional.ofNullable(mushk);
    }


    public void delete(int id) {
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Mushkiambar.class, id));
        em.getTransaction().commit();
    }
}
