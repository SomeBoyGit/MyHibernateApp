package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            //Получение списка всех объектов, имя которого начинается на символ "Т"
//            List<Person> people = session.createQuery("FROM Person where name LIKE 'T%'").getResultList();
//            people.forEach(System.out::println);

            //Переименование(обновление) всех объектов, у которых поле возраст меньше 30
//            session.createQuery("update Person set name='Test' where age < 30 ").executeUpdate();

            //Удаление всех объектов, у которых поле возраст меньше 30
            session.createQuery("delete Person where age < 30 ").executeUpdate();


            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }
}
