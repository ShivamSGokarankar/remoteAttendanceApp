package com.attendanceapp.dao;

import com.attendanceapp.Util.HibernateUtil;
import com.attendanceapp.Util.InfoMessage;
import com.attendanceapp.model.User;
import com.logger.LogFileCreator;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    public LogFileCreator l ;

    {
        try {
            l =  new LogFileCreator("D:\\logs");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void createUser(User user)
    {

    }

    @Override
    public List<User> getAllUsers(User user)
    {
        return null;
    }

    @Override
    public void updateUser(User user)
    {

    }

    @Override
    public void deleteUser(User user)
    {

    }

    @Override
    public User getUser(User user) throws NullPointerException
    {
        User u=null;
        Transaction tx=null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            tx=session.beginTransaction();
            l.WriteLog(InfoMessage.Hibernate_Transaction_created.name());
            u=(User)session.get(User.class, user.getUsername());
            tx.commit();
            l.WriteLog(InfoMessage.Hibernate_Transaction_Committed.name());
        }
        finally {
            return u;
        }

    }
}
