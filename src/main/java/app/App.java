package app;

import com.github.javafaker.Faker;
import entity.Book;
import org.hibernate.Transaction;
import util.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App {
    public static void main(String[] args) {
        Faker faker = new Faker();
        SessionFactory factory = HibernateUtils.getSessionFactory();

        //Get an object by id
        Session session = factory.openSession();
        System.out.println(session.get(Book.class, 1L));
        session.close();

        //insert into table
        session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new Book(2L,faker.book().author()));
        transaction.commit();
        session.close();

        //delete from table
    //   session = factory.openSession();
     //  transaction = session.beginTransaction();
      // final Book book = session.get(Book.class,1L);
     //  session.delete(book);
     //  transaction.commit();
      // session.close();

        //Update book in table
        session = factory.openSession();
        transaction = session.beginTransaction();
        final Book book2 = session.get(Book.class,2L);
        book2.setAuthor("noul autor");
        session.update(book2);
        transaction.commit();
        session.close();

    }
}
