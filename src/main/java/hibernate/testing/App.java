package hibernate.testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		// Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(User.class);
 
        // Create Session Factory and auto-close with try-with-resources.
        try (SessionFactory sessionFactory
                = configuration.buildSessionFactory()) {
 
            // Initialize Session Object
            Session session = sessionFactory.openSession();
 
            User user = new User();
 
            user.setUsername("TEST");
            user.setEmail("TEST@email.com");
            user.setPassword("test123");
 
            session.beginTransaction();
 
            // Here we have used
            // persist() method of JPA
            session.persist(user);
 
            session.getTransaction().commit();
            
            session.close();
        }
	}
}
