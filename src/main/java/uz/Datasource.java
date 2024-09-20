package uz;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Datasource {
    static public EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
}
