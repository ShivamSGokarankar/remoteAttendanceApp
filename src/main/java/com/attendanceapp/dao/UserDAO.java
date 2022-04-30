package com.attendanceapp.dao;

import com.attendanceapp.Util.HibernateUtil;
import com.attendanceapp.model.User;
import com.attendanceapp.model.UserService;
import com.logger.LogFileCreator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class UserDAO implements UserService {

    private static Session session;
    private LogFileCreator logFileCreator = null;

    {
        try {
            logFileCreator = new LogFileCreator("D:\\Logs");
            session = HibernateUtil.getSessionFactory().openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUser(User u) {
        try {
            logFileCreator.WriteLog("Session created");
            Transaction transaction = session.beginTransaction();
            session.save(u);
            transaction.commit();
        } catch (Exception e) {
            logFileCreator.WriteLog("Error Occured creating session \n" + e.toString());
        }
    }

    @Override
    public User getUser(String username) {
        User user = null;
        Transaction transaction = session.beginTransaction();
        user = (User) session.get(User.class, username);
        transaction.commit();
        return user;

    }

    @Override
    public void updateUser(String username) {

    }

    @Override
    public void deleteUser(String username) {

    }
}
