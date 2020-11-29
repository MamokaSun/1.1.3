package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties setting = new Properties();
                setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                setting.put(Environment.URL, "jdbc:mysql://localhost/myusers?user=root&useSSL=false&serverTimezone=UTC");
                setting.put(Environment.USER, "root");
                setting.put(Environment.PASS, "12345678");
                setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                setting.put(Environment.SHOW_SQL, "true");
                setting.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                setting.put(Environment.HBM2DDL_AUTO, "create-drop");
//                setting.put(Environment.JDBC_TIME_ZONE, "")
                configuration.setProperties(setting);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
    public static void shutdown() {
        getSessionFactory().close();
    }

}
