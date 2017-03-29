package com.app.dao;




import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.app.util.HibernateUtil;
import com.app.entites.Offre;

	

	@Stateless
	public class OffreDAO {
	  private SessionFactory sessionFactory;

	  public OffreDAO() {
	    sessionFactory = HibernateUtil.getSessionFactory();
	  }

	  public OffreDAO(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	  }

	  public void create(Offre en) {
		  Transaction trns = null;
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        try {
	            trns = session.beginTransaction();
	            session.save(en);
	            session.getTransaction().commit();
	        } catch (RuntimeException e) {
	            if (trns != null) {
	                trns.rollback();
	            }
	            e.printStackTrace();
	        } finally {
	            session.flush();
	            session.close();
	        }
	  }

	  public boolean update(Offre c) {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    try {
	      session.update(c);
	      session.getTransaction().commit();
	    } catch (Exception e) {
	      return false;
	    } finally {
	      session.close();
	    }
	    return true;
	  }

	

	 

	  @SuppressWarnings("unchecked")
	  public List<Offre> getAll() {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    List<Offre> companies = session.createQuery("select * from Offre").list();
	    session.getTransaction().commit();
	    session.close();
	    return companies;
	  }
}


