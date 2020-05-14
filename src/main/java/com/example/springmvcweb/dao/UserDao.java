package com.example.springmvcweb.dao;

import com.example.springmvcweb.dto.AuthenticationDTO;
import com.example.springmvcweb.model.User;
import com.example.springmvcweb.util.common.EncryptionUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements BaseDao<User> {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User get(Long id) {
        Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            transaction.commit();
            return user;
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            return null;
        }
    }

    @Override
    public void save(User obj) {
        Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(obj);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(User obj) {
        Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.delete(obj);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Long getCount() {
        Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.setProjection(Projections.count("id"));
            Long count = (Long) criteria.uniqueResult();
            transaction.commit();
            return count;
        } catch (Exception exception) {
            if(transaction == null) {
                transaction.rollback();
            }
            return null;
        }
    }

    public User isValidUser(AuthenticationDTO authenticationDTO) {
        authenticationDTO.setPassword(EncryptionUtil.encrypt(authenticationDTO.getPassword()));
        Transaction transaction = null;
        try (Session session = this.sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", authenticationDTO.getEmail()));
            criteria.add(Restrictions.eq("password", authenticationDTO.getPassword()));
            User user = (User) criteria.uniqueResult();
            transaction.commit();
            return user;
        } catch (Exception exception) {
            return null;
        }
    }
}
