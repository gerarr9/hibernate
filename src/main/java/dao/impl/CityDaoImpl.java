package dao.impl;

import config.HibernateSessionFactoryUtil;
import dao.CityDao;
import entity.City;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class CityDaoImpl implements CityDao {
    @Override
    public City add(City city) {
//        Optional<City> optionalCity=readById(city.getCityId());
//        if (optionalCity.isPresent()) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {

            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
            return city;

//            Transaction transaction = session.beginTransaction();
//            Serializable createdId = session.save(optionalCity);
//            City createdCity = session.get(City.class, createdId);
//            transaction.commit();
//            return Optional.ofNullable(createdCity);
        }
//        } return Optional.empty();
    }

    @Override
    public Optional<City> readById(long id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return Optional.ofNullable(session.get(City.class, id));
        }
    }

    @Override
    public List<City> findAll() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From City", City.class).list();
        }
    }

    @Override
    public City updateCity(City city) {
        EntityManager entityManager = HibernateSessionFactoryUtil.getSessionFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        City updated=entityManager.merge(city);
        entityTransaction.commit();
        return updated;
    }

    @Override
    public Optional<City> delete(City city) {
        Optional<City> optionalCity=readById(city.getId());
        if (optionalCity.isPresent()) {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(optionalCity.get());
                transaction.commit();
                System.out.println("удаление прошло успешно");
                return optionalCity;

            }
        }
        System.out.println("удаление не прошло");
        return Optional.empty();
    }
}
