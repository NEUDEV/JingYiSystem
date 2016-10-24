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

import com.JES.model.Account;

/**
 * A data access object (DAO) providing persistence and search support for
 * Account entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.JES.model.Account
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class AccountDAO {
	private static final Logger log = LoggerFactory.getLogger(AccountDAO.class);
	// property constants
	public static final String BANK = "bank";
	public static final String ACCOUNT = "account";
	public static final String AGENT = "agent";

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

	public void save(Account transientInstance) {
		log.debug("saving Account instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Account persistentInstance) {
		log.debug("deleting Account instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Account findById(java.lang.String id) {
		log.debug("getting Account instance with id: " + id);
		try {
			Account instance = (Account) getCurrentSession().get(
					"com.JES.model.Account", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Account instance) {
		log.debug("finding Account instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.JES.model.Account")
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
		log.debug("finding Account instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Account as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBank(Object bank) {
		return findByProperty(BANK, bank);
	}

	public List findByAccount(Object account) {
		return findByProperty(ACCOUNT, account);
	}

	public List findByAgent(Object agent) {
		return findByProperty(AGENT, agent);
	}

	public List findAll() {
		log.debug("finding all Account instances");
		try {
			String queryString = "from Account";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Account merge(Account detachedInstance) {
		log.debug("merging Account instance");
		try {
			Account result = (Account) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Account instance) {
		log.debug("attaching dirty Account instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Account instance) {
		log.debug("attaching clean Account instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AccountDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AccountDAO) ctx.getBean("AccountDAO");
	}
}