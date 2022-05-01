package com.attendanceapp.dao;

import com.attendanceapp.Util.HibernateUtil;
import com.attendanceapp.model.User;
import com.attendanceapp.model.UserService;
import com.logger.LogFileCreator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class UserDAO implements UserService {

    public enum InfoMessage {
        Hibernate_Session_Created,
        Hibernate_SessionCreation_Failed,
        Hibernate_Transaction_Failed,
        Hibernate_Transaction_Committed,
        Hibernate_Transaction_RollBacked,
        Hibernate_Transaction_created;


    }

    private static Session session;
    private LogFileCreator logFileCreator = null;

    {
        try {
            logFileCreator = new LogFileCreator("D:\\Logs");
            session = HibernateUtil.getSessionFactory().getCurrentSession();
            logFileCreator.WriteLog(InfoMessage.Hibernate_Session_Created.name());
        } catch (IOException e) {
            logFileCreator.WriteLog(InfoMessage.Hibernate_SessionCreation_Failed.name());
        }
    }

    @Override
    public void insertUser(User u) {
        try {

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
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            transaction.begin();
            logFileCreator.WriteLog(InfoMessage.Hibernate_Transaction_created.name());
            user = (User) session.get(User.class, username);
            transaction.commit();
            logFileCreator.WriteLog(InfoMessage.Hibernate_Transaction_Committed.name());
        }
        catch(Exception e)
        {
            if (transaction!=null) transaction.rollback();
            logFileCreator.WriteLog(InfoMessage.Hibernate_Transaction_Failed.name() + " " + InfoMessage.Hibernate_Transaction_RollBacked.name());
        }
        finally
        {
            return user;
        }
}

    @Override
    public void updateUser(String username) {

    }

    @Override
    public void deleteUser(String username) {

    }
}
