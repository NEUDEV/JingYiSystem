package com.JES.model;

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

import com.JES.model.Report;

/**
 * A data access object (DAO) providing persistence and search support for
 * Report entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.JES.model.Report
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ReportDAO {
	private static final Logger log = LoggerFactory.getLogger(ReportDAO.class);
	// property constants
	public static final String INFORMALSTU = "informalstu";
	public static final String PLATESTU = "platestu";
	public static final String TYPEFACESTU = "typefacestu";
	public static final String BRANDSTU = "brandstu";
	public static final String FULLSTU = "fullstu";
	public static final String ILLUSTRATION = "illustration";
	public static final String ONLINESTU = "onlinestu";
	public static final String LIFETIMESTU = "lifetimestu";
	public static final String TRANSRATE = "transrate";
	public static final String ROLE = "role";

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

	public void save(Report transientInstance) {
		log.debug("saving Report instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Report persistentInstance) {
		log.debug("deleting Report instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Report findById(java.lang.String id) {
		log.debug("getting Report instance with id: " + id);
		try {
			Report instance = (Report) getCurrentSession().get(
					"com.JES.model.Report", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Report instance) {
		log.debug("finding Report instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.JES.model.Report")
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
		log.debug("finding Report instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Report as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInformalstu(Object informalstu) {
		return findByProperty(INFORMALSTU, informalstu);
	}

	public List findByPlatestu(Object platestu) {
		return findByProperty(PLATESTU, platestu);
	}

	public List findByTypefacestu(Object typefacestu) {
		return findByProperty(TYPEFACESTU, typefacestu);
	}

	public List findByBrandstu(Object brandstu) {
		return findByProperty(BRANDSTU, brandstu);
	}

	public List findByFullstu(Object fullstu) {
		return findByProperty(FULLSTU, fullstu);
	}

	public List findByIllustration(Object illustration) {
		return findByProperty(ILLUSTRATION, illustration);
	}

	public List findByOnlinestu(Object onlinestu) {
		return findByProperty(ONLINESTU, onlinestu);
	}

	public List findByLifetimestu(Object lifetimestu) {
		return findByProperty(LIFETIMESTU, lifetimestu);
	}

	public List findByTransrate(Object transrate) {
		return findByProperty(TRANSRATE, transrate);
	}

	public List findByRole(Object role) {
		return findByProperty(ROLE, role);
	}

	public List findAll() {
		log.debug("finding all Report instances");
		try {
			String queryString = "from Report";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Report merge(Report detachedInstance) {
		log.debug("merging Report instance");
		try {
			Report result = (Report) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Report instance) {
		log.debug("attaching dirty Report instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Report instance) {
		log.debug("attaching clean Report instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ReportDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ReportDAO) ctx.getBean("ReportDAO");
	}
}