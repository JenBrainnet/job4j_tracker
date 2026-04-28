package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class HQLUsage {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try (SessionFactory sf = new MetadataSources(registry)
                .buildMetadata().buildSessionFactory()) {
            Session session = sf.openSession();
            Item item = new Item("new Item");
            insert(session, item);
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private static void findAll(Session session) {
        Query<Item> query = session.createQuery("FROM Item", Item.class);
        for (Object st : query.list()) {
            System.out.println(st);
        }
    }

    private static void unique(Session session, int id) {
        Query<Item> query = session.createQuery(
                "FROM Item AS i WHERE i.id = :fId", Item.class);
        query.setParameter("fId", id);
        System.out.println(query.uniqueResult());
    }

    public static void update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery(
                    "UPDATE Item SET name = :fName WHERE id = :fId")
                    .setParameter("fName", "new Name")
                    .setParameter("fId", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void insert(Session session, Item item) {
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

}
