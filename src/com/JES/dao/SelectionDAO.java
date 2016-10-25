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

import com.JES.model.Selection;

/**
 	* A data access object (DAO) providing persistence and search support for Selection entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see com.JES.model.Selection
  * @author MyEclipse Persistence Tools 
 */
    @Transactional   
public class SelectionDAO  {
	     private static final Logger log = LoggerFactory.getLogger(SelectionDAO.class);
		//property constants
	public static final String UID = "uid";
	public static final String CNAME = "cname";
	public static final String BILL = "bill";
	public static final String SELECTTIME = "selecttime";
	



    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){
       this.sessionFactory = sessionFactory;
    }

    private Session getCurrentSession(){
     return sessionFactory.getCurrentSession(); 
    }
	protected void initDao() {
		//do nothing
	}
    
    public void save(Selection transientInstance) {
        log.debug("saving Selection instance");
        try {
            getCurrentSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Selection persistentInstance) {
        log.debug("deleting Selection instance");
        try {
            getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Selection findById( java.lang.String id) {
        log.debug("getting Selection instance with id: " + id);
        try {
            Selection instance = (Selection) getCurrentSession()
                    .get("com.JES.model.Selection", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Selection instance) {
        log.debug("finding Selection instance by example");
        try {
            List results = getCurrentSession().createCriteria("com.JES.model.Selection") .add(Example.create(instance)).list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Selection instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Selection as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getCurrentSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}
    
    public Object sumbills(String mid,String stime,String etime){
    	try {
            String queryString = "select sum(model.bill) from Selection as model, Student as stu"
            						+" where  stu.mid=? and stu.uid=model.uid "
            		+" and cast(model.selecttime as date)>=cast('"+stime+"' as date)"
            		+" and cast(model.selecttime as date)<=cast('"+etime+"' as date)";
    		Query queryObject = getCurrentSession().createQuery(queryString);
   		 queryObject.setParameter(0, mid);
   		 if(queryObject.list().get(0)!=null)
   			 return queryObject.list().get(0);
   		 else return 0;
         } catch (RuntimeException re) {
            throw re;
         }
    }
    
    public List countclasstype(String mid,String stime,String etime){
    	try {
            String queryString = "select model.cname,count(model) from Selection as model, Student as stu"
            						+" where stu.mid=? and  stu.uid=model.uid and cast(model.selecttime as date)>=cast('"+stime+"' as date) "
            						+"and cast(model.selecttime as date)<=cast('"+etime+"' as date) "
            						+"group by model.cname";
    		Query queryObject = getCurrentSession().createQuery(queryString);
   		 queryObject.setParameter(0, mid);
   		 return queryObject.list();
         } catch (RuntimeException re) {
            throw re;
         }
    }

	public List findByUid(Object uid
	) {
		return findByProperty(UID, uid
		);
	}
	
	public List findByCname(Object cname
	) {
		return findByProperty(CNAME, cname
		);
	}
	
	public List findByBill(Object bill
	) {
		return findByProperty(BILL, bill
		);
	}
	
	public List findBySelecttime(Object selecttime
	) {
		return findByProperty(SELECTTIME, selecttime
		);
	}
	

	public List findAll() {
		log.debug("finding all Selection instances");
		try {
			String queryString = "from Selection";
	         Query queryObject = getCurrentSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Selection merge(Selection detachedInstance) {
        log.debug("merging Selection instance");
        try {
            Selection result = (Selection) getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Selection instance) {
        log.debug("attaching dirty Selection instance");
        try {
            getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Selection instance) {
        log.debug("attaching clean Selection instance");
        try {
                      	getCurrentSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static SelectionDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (SelectionDAO) ctx.getBean("SelectionDAO");
	}
}