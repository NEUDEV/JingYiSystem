package com.JES.dao;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.JES.model.AgentNote;

/**
 * A data access object (DAO) providing persistence and search support for
 * AgentNote entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.JES.model.AgentNote
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AgentNoteDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AgentNoteDAO.class);
	// property constants
	public static final String NOTETIME = "notetime";
	public static final String NOTE = "note";
	public static final String AGENTID = "agentid";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(AgentNote transientInstance) {
		log.debug("saving AgentNote instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AgentNote persistentInstance) {
		log.debug("deleting AgentNote instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AgentNote findById(java.lang.String id) {
		log.debug("getting AgentNote instance with id: " + id);
		try {
			AgentNote instance = (AgentNote) getCurrentSession().get(
					"com.JES.model.AgentNote", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AgentNote instance) {
		log.debug("finding AgentNote instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.JES.model.AgentNote")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AgentNote instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from AgentNote as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNotetime(Object notetime) {
		return findByProperty(NOTETIME, notetime);
	}

	public List findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findByAgentid(Object agentid) {
		return findByProperty(AGENTID, agentid);
	}

	public List findAll() {
		log.debug("finding all AgentNote instances");
		try {
			String queryString = "from AgentNote";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AgentNote merge(AgentNote detachedInstance) {
		log.debug("merging AgentNote instance");
		try {
			AgentNote result = (AgentNote) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AgentNote instance) {
		log.debug("attaching dirty AgentNote instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AgentNote instance) {
		log.debug("attaching clean AgentNote instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AgentNoteDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AgentNoteDAO) ctx.getBean("AgentNoteDAO");
	}
}