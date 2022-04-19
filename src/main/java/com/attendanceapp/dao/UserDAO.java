package com.attendanceapp.dao;

import com.attendanceapp.Util.HibernateUtil;
import com.attendanceapp.model.User;
import com.attendanceapp.model.UserService;
import com.logger.LogFileCreator;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDAO implements UserService {


    private static Session session;
    private LogFileCreator logFileCreator=null;

    @Override
    public void insertUser(User u) {
        try {
            logFileCreator = new LogFileCreator("D:\\Logs");
            session = HibernateUtil.getSessionFactory().openSession();
            logFileCreator.WriteLog("Session created");

            Transaction transaction = session.beginTransaction();
            session.save(u);
            transaction.commit();
            session.close();

        } catch (Exception e) {
           logFileCreator.WriteLog("Error occurred creating session \n" + e.toString());
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
