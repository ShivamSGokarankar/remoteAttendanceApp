package com.attendanceapp.Util;

import com.logger.*;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.io.IOException;

public class HibernateUtil
{
    private static SessionFactory sessionFactory;
    private static Configuration configuration;
    private static ServiceRegistry serviceRegistry;
    private static StandardServiceRegistry standardServiceRegistry;
    private static StandardServiceRegistryBuilder standardServiceRegistryBuilder;
    private static LogFileCreator logFileCreator = null;

    static
    {
        try {
            if(serviceRegistry==null)
            {
                logFileCreator=new  LogFileCreator("D:\\Logs");
                configuration= new Configuration().configure();
                serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory=configuration.buildSessionFactory(serviceRegistry);
            }
        } catch (HibernateException | IOException e) {
            logFileCreator.WriteLog("Error Occured while creating session Factory");
            logFileCreator.WriteLog(e.toString());
            if(sessionFactory==null)
            {
                StandardServiceRegistryBuilder.destroy(serviceRegistry);
            }
        }
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }

}
