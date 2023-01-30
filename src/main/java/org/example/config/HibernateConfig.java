package org.example.config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;


import java.util.Properties;

/**
 * @author kurstan
 * @created at 27.01.2023 11:18
 */
public class HibernateConfig {

    public static EntityManagerFactory getEntityManager(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");//"org.hibernate.driver_class"
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "postgres");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Instructor.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Task.class);

        EntityManagerFactory entityManagerFactory =
                configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        return entityManagerFactory;
    }
}
