import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

    public static void main(String[] args) {
        // Create a configuration instance
        Configuration configuration = new Configuration();
        // Configure using the hibernate.cfg.xml file
        configuration.configure("hibernate.cfg.xml");

        // Build a SessionFactory
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Open a session
        Session session = sessionFactory.openSession();

        // Begin a transaction
        session.beginTransaction();

        // Perform a simple operation to verify the connection
        User user = new User();
        user.setName("Test User");
        user.setEmail("testuser@example.com");

        session.save(user);

        // Commit the transaction
        session.getTransaction().commit();

        // Close the session
        session.close();

        // Verify if the user is saved
        session = sessionFactory.openSession();
        User savedUser = (User) session.get(User.class, user.getId());
        System.out.println("Saved User: " + savedUser.getName() + ", " + savedUser.getEmail());

        // Close the session
        session.close();

        // Close the SessionFactory
        sessionFactory.close();
    }
}
