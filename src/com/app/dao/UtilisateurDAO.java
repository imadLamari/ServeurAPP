
package com.app.dao;




import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.app.util.HibernateUtil;
import com.app.entites.Utilisateur;

	

	@Stateless
	public class UtilisateurDAO {
	  private SessionFactory sessionFactory;

	  public UtilisateurDAO() {
	    sessionFactory = HibernateUtil.getSessionFactory();
	  }

	  public UtilisateurDAO(SessionFactory sessionFactory) {
	    this.sessionFactory = sessionFactory;
	  }

	  public void create(Utilisateur en) {
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

	  public boolean update(Utilisateur c) {
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
	  public List<Utilisateur> getAll() {
	    Session session = sessionFactory.openSession();
	    session.beginTransaction();
	    List<Utilisateur> users = session.createQuery("select * from utilisateur").list();
	    session.getTransaction().commit();
	    session.close();
	    return users;
	  }
}



