package hibernate.testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class getUserByUsername {
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
            session.beginTransaction();
            
            // Perform Query
            String username = "test0001";
            Query query = session.createQuery("from User where username = :username");
            query.setParameter("username", username);
            User user = (User) query.uniqueResult();
            
            // Debug print results
            // Can access any information using the User class' get methods.
        	System.out.println(user.getUsername() + " " + user.getPassword());
        	
            session.close();
        }
	}
}
