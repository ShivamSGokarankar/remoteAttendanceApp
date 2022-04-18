package com.attendanceapp.dao;

import com.attendanceapp.Util.HibernateUtil;
import com.attendanceapp.model.User;
import com.attendanceapp.model.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.BootstrapServiceRegistryBuilder;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import com.logger.*;

public class UserDAO implements UserService {

    private static SessionFactory sessionFactory;
    private LogFileCreator logFileCreator=null;

    @Override
    public void insertUser(User u) {
        try {
            logFileCreator = new LogFileCreator("D:\\Logs");
            Session session = HibernateUtil.getSessionFactory().openSession();
            logFileCreator.WriteLog("Session created");

            Transaction transaction = session.beginTransaction();
            session.save(u);
            transaction.commit();
            session.close();
            session.close();

        } catch (Exception e) {

           logFileCreator.WriteLog("Error Occured creating session \n" + e.toString());
        }
    }

    @Override
    public User getUserById(int userid) {
        return null;
    }

    @Override
    public void updateUser(int userid) {

    }

    @Override
    public void deleteUser(int userid) {

    }
}
