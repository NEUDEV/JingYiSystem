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

import com.JES.model.Agentupstudent;

/**
 * A data access object (DAO) providing persistence and search support for
 * Agentupstudent entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.JES.dao.Agentupstudent
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AgentupstudentDAO {
	private static final Logger log = LoggerFactory
			.getLogger(AgentupstudentDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String WEIXIN = "weixin";
	public static final String PHONE = "phone";
	public static final String STUID = "stuid";
	public static final String PHOTO = "photo";
	public static final String NOTE = "note";
	public static final String MID = "mid";
	public static final String SFROM = "sfrom";

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

	public void save(Agentupstudent transientInstance) {
		log.debug("saving Agentupstudent instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Agentupstudent persistentInstance) {
		log.debug("deleting Agentupstudent instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Agentupstudent findById(java.lang.String id) {
		log.debug("getting Agentupstudent instance with id: " + id);
		try {
			Agentupstudent instance = (Agentupstudent) getCurrentSession().get(
					"com.JES.dao.Agentupstudent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Agentupstudent instance) {
		log.debug("finding Agentupstudent instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.JES.dao.Agentupstudent")
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
		log.debug("finding Agentupstudent instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Agentupstudent as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByWeixin(Object weixin) {
		return findByProperty(WEIXIN, weixin);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByStuid(Object stuid) {
		return findByProperty(STUID, stuid);
	}

	public List findByPhoto(Object photo) {
		return findByProperty(PHOTO, photo);
	}

	public List findByNote(Object note) {
		return findByProperty(NOTE, note);
	}

	public List findByMid(Object mid) {
		return findByProperty(MID, mid);
	}

	public List findBySfrom(Object sfrom) {
		return findByProperty(SFROM, sfrom);
	}

	public List findAll() {
		log.debug("finding all Agentupstudent instances");
		try {
			String queryString = "from Agentupstudent";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Agentupstudent merge(Agentupstudent detachedInstance) {
		log.debug("merging Agentupstudent instance");
		try {
			Agentupstudent result = (Agentupstudent) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Agentupstudent instance) {
		log.debug("attaching dirty Agentupstudent instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Agentupstudent instance) {
		log.debug("attaching clean Agentupstudent instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AgentupstudentDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (AgentupstudentDAO) ctx.getBean("AgentupstudentDAO");
	}
}