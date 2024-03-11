package hibernate.testing;

import java.sql.Timestamp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class createUser {
	public static void main(String[] args) {
		// Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.setProperty("hibernate.connection.password", System.getenv("db_password"));
        configuration.addAnnotatedClass(User.class);
 
        // Create Session Factory and auto-close with try-with-resources.
        try (SessionFactory sessionFactory
                = configuration.buildSessionFactory()) {
 
            // Initialize Session Object
            Session session = sessionFactory.openSession();
 
            User user = new User();
            String test_num = "0003"; // used for testing. Update this on each new test to ensure username is unique.
            
            user.setUsername("test"+test_num);
            user.setPassword("test_pass"+test_num);
            user.setEmail("test"+test_num+"@email.com");
            user.setPhoto("test"+test_num);
            user.setOnline(false);
            user.setLanguage("EN");
            user.setCity("Atlanta");
            user.setState("GA");
            user.setCountry("US");
            user.setPersonality(1234);
            user.setCreated(new Timestamp(System.currentTimeMillis()));
            user.setUpdated(new Timestamp(System.currentTimeMillis()));
            
            
            session.beginTransaction();
 
            session.persist(user);
 
            session.getTransaction().commit();
            
            session.close();
        }
	}
}
