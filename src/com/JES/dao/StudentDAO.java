package com.JES.dao;

import java.util.Date;
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

import com.JES.model.Student;

/**
 * A data access object (DAO) providing persistence and search support for
 * Student entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.JES.model.Student
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class StudentDAO {
	private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
	// property constants
	public static final String MSIGN = "msign";
	public static final String NAME = "name";
	public static final String PHONE = "phone";
	public static final String QQ = "qq";
	public static final String WEIXIN = "weixin";
	public static final String MID = "mid";
	public static final String SIGN = "sign";
	public static final String STUID = "stuid";
	public static final String SFROM = "sfrom";
	public static final String MARK = "mark";

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

	public void save(Student transientInstance) {
		log.debug("saving Student instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Student persistentInstance) {
		log.debug("deleting Student instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Student findById(java.lang.String id) {
		log.debug("getting Student instance with id: " + id);
		try {
			Student instance = (Student) getCurrentSession().get(
					"com.JES.model.Student", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Student instance) {
		log.debug("finding Student instance by example");
		try {
			List results = getCurrentSession().createCriteria("com.JES.model.Student")
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
		log.debug("finding Student instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByPropertyWithMid(String propertyName, Object value, String mid){
		try {
			String queryString = "from Student as model where model."
					+ propertyName + "= ? and model.mid='"+mid+"'";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	/*public Integer countunifStudent(String mid){
		try {
			String queryString = "select count(*) from Student as model where model.sign='非正式学员' and model.mid= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, mid);
			return (Integer)queryObject.list().get(0);
		} catch (RuntimeException re) {
			throw re;
		}
	}
	*/
	public Integer countunifStudentbyTime(String mid,String limittime){
		try {
			String queryString = "select count(*) from Student as model where model.sign='非正式学员' and model.mid= ?"
					+" and cast(model.intime as date)>=cast('"+limittime+"' as date)";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, mid);
			return Integer.parseInt(String.valueOf(queryObject.list().get(0)));
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List mystudentList(String mid){
		try {
			String queryString = "select model.uid from Student as model where model.mid= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, mid);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public Object countmystudent(String mid,String time){
		try {
			String queryString = "select count(model) from Student as model where cast(model.intime as date)>=cast('"+time+"' as date) and model.mid= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, mid);
			return queryObject.list().get(0);
		} catch (RuntimeException re) {
			throw re;
		}
	}

	public List findByMsign(Object msign) {
		return findByProperty(MSIGN, msign);
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByQq(Object qq) {
		return findByProperty(QQ, qq);
	}

	public List findByWeixin(Object weixin) {
		return findByProperty(WEIXIN, weixin);
	}

	public List findByMid(Object mid) {
		return findByProperty(MID, mid);
	}

	public List findBySign(Object sign) {
		return findByProperty(SIGN, sign);
	}

	public List findByStuid(Object stuid) {
		return findByProperty(STUID, stuid);
	}

	public List findBySfrom(Object sfrom) {
		return findByProperty(SFROM, sfrom);
	}

	public List findByMark(Object mark) {
		return findByProperty(MARK, mark);
	}

	public List findAll() {
		log.debug("finding all Student instances");
		try {
			String queryString = "from Student";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findByNameWithMid(Object name,String mid){
		return findByPropertyWithMid(MARK, name,mid);
	}
	
	public List findByPhoneWithMid(Object phone,String mid){
		return findByPropertyWithMid(PHONE, phone,mid);
	}
	
	public List findByQqWithMid(Object Qq,String mid){
		return findByPropertyWithMid(QQ, Qq,mid);
	}
	
	public List findByStuidWithMid(Object stuid,String mid){
		return findByPropertyWithMid(STUID, stuid,mid);
	}
	
	public List findJingYiByName(String name) {
		try {
			String queryString = "from Student student where(student.name='" + name +"') and (student.msign='鲸艺代理商')"; 
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List findJingYiByPhone(String phone) {
		try {
			String queryString = "from Student student where(student.phone='" + phone +"') and (student.msign='鲸艺代理商')"; 
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	public List findJingYiByQq(String qq) {
		try {
			String queryString = "from Student student where(student.qq='" + qq +"') and (student.msign='鲸艺代理商')"; 
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	
	

	public Student merge(Student detachedInstance) {
		log.debug("merging Student instance");
		try {
			Student result = (Student) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Student instance) {
		log.debug("attaching dirty Student instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Student instance) {
		log.debug("attaching clean Student instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static StudentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (StudentDAO) ctx.getBean("StudentDAO");
	}
}