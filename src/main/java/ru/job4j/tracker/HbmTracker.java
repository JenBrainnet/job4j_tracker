package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        try (Session session = sf.openSession()) {
            var tx = session.beginTransaction();
            try {
                session.save(item);
                tx.commit();
                return item;
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    @Override
    public boolean replace(int id, Item item) {
        try (Session session = sf.openSession()) {
            var tx = session.beginTransaction();
            try {
                int result = session.createQuery("UPDATE Item SET name = :name WHERE id = :id")
                        .setParameter("name", item.getName())
                        .setParameter("id", id)
                        .executeUpdate();
                tx.commit();
                return result > 0;
            } catch (Exception e) {
                tx.rollback();
                throw e;
            }
        }
    }

    @Override
    public void delete(int id) {
        try (Session session = sf.openSession()) {
            var tx = session.beginTransaction();
            try {
                session.createQuery("DELETE FROM Item WHERE id = :id")
                        .setParameter("id", id)
                        .executeUpdate();
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
            }
        }
    }

    @Override
    public List<Item> findAll() {
        try (Session session = sf.openSession()) {
            return session.createQuery("FROM Item", Item.class)
                    .list();
        }
    }

    @Override
    public List<Item> findByName(String key) {
        try (Session session = sf.openSession()) {
            return session.createQuery("FROM Item WHERE name = :name", Item.class)
                    .setParameter("name", key)
                    .list();
        }
    }

    @Override
    public Item findById(int id) {
        try (Session session = sf.openSession()) {
            return session.createQuery("FROM Item WHERE id = :id", Item.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    @Override
    public void close() {
        sf.close();
        StandardServiceRegistryBuilder.destroy(registry);
    }

}