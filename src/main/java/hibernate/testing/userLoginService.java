package hibernate.testing;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class userLoginService {
	public static void main(String[] args) {
		userLoginService log = new userLoginService();
		Boolean logged = log.login("test0001", "test_pass0001");
		System.out.println("Logged In?: "  + logged);
	}
	
	public Boolean login(String username, String password) {
		Boolean successfulLogin = false;
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
            Query query = session.createQuery("from User where username = :username and password = :password");
            query.setParameter("username", username);
            query.setParameter("password", password);
            User user = (User) query.uniqueResult();
            
            if (user != null) successfulLogin = true;
        	else System.out.println("Incorrect username/password.");

            session.close();
        	}
        
		return successfulLogin;
	
	}
}
