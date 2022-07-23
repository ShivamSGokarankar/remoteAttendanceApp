package com.attendanceapp.dao;

import com.attendanceapp.Util.HibernateUtil;
import com.attendanceapp.Util.InfoMessage;
import com.attendanceapp.model.User;
import com.logger.LogFileCreator;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JpaQlInspection")
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
        Transaction tx=null;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            tx=session.beginTransaction();
            session.persist(user);
            tx.commit();
        }
        catch (Exception e )
        {
        	
        }
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

    @SuppressWarnings("deprecation")
    @Override
    public User getUser(User user) throws NullPointerException,IllegalArgumentException
    {
        User u=null;
        Transaction tx=null;
        List<User> list;
        try(Session session = HibernateUtil.getSessionFactory().openSession())
        {
            tx=session.beginTransaction();
            l.WriteLog(InfoMessage.Hibernate_Transaction_created.name());
            //u=(User)session.get(User.class, user.getUsername());
            TypedQuery query = session.createQuery("From com.attendanceapp.model.User where username =:username",User.class);
            query.setParameter("username",user.getUsername());
            list = (List<User>)query.getResultList();
            u=(list.size()!=0)?list.get(0):null;
            tx.commit();
            l.WriteLog(InfoMessage.Hibernate_Transaction_Committed.name());
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
        finally {
            return u;
        }

    }
}
