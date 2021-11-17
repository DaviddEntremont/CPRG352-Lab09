package dataaccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    
    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Lab9_JPA");
    
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}