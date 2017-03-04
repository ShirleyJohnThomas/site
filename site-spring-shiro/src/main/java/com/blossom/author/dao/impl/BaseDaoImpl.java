package com.blossom.author.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.blossom.author.dao.IBaseDao;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月4日 下午11:21:22
 */
public abstract class BaseDaoImpl<T, PK extends Serializable> implements IBaseDao<T, PK> {


	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:18
	 * @see com.blossom.author.dao.IBaseDao#saveEntity(java.lang.Object)
	 */
	public void saveEntity(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:23
	 * @see com.blossom.author.dao.IBaseDao#saveOrUpdateEntity(java.lang.Object)
	 */
	public void saveOrUpdateEntity(T t) {
		sessionFactory.getCurrentSession().saveOrUpdate(t);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:27
	 * @see com.blossom.author.dao.IBaseDao#updateEntity(java.lang.Object)
	 */
	public void updateEntity(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:31
	 * @see com.blossom.author.dao.IBaseDao#deleteEntity(java.lang.Object)
	 */
	public void deleteEntity(T t) {
		sessionFactory.getCurrentSession().delete(t);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:37
	 * @see com.blossom.author.dao.IBaseDao#batchEntityByHQL(java.lang.String, java.util.Map)
	 */
	public int batchEntityByHQL(String hql, Map<String, Object> pMap) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (pMap == null) {
			return query.executeUpdate();
		}
		Set<String> keys = pMap.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			query.setParameter(key, pMap.get(key));
		}
		return query.executeUpdate();
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:41
	 * @see com.blossom.author.dao.IBaseDao#executeSQL(java.lang.String, java.util.List)
	 */
	public int executeSQL(String sql, List<Object> pList) {
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (pList.size() == 0 || pList.isEmpty()) {
			return sqlQuery.executeUpdate();
		}
		int len = pList.size();
		for (int i = 0; i < len; i++) {
			sqlQuery.setParameter(i, pList.get(i));
		}
		return sqlQuery.executeUpdate();
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:46
	 * @see com.blossom.author.dao.IBaseDao#loadEntity(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T loadEntity(PK pk) {
		return (T) sessionFactory.getCurrentSession().load(clazz, pk);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:50
	 * @see com.blossom.author.dao.IBaseDao#getEntity(java.io.Serializable)
	 */
	@SuppressWarnings("unchecked")
	public T getEntity(PK pk) {
		return (T) sessionFactory.getCurrentSession().get(clazz, pk);
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:53
	 * @see com.blossom.author.dao.IBaseDao#findEntityByHQL(java.lang.String, java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	public List<T> findEntityByHQL(String hql, Map<String, Object> pMap) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (pMap == null) {
			return query.list();
		}
		Set<String> keys = pMap.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			query.setParameter(key, pMap.get(key));
		}
		return query.list();
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:31:57
	 * @see com.blossom.author.dao.IBaseDao#uniqueResult(java.lang.String, java.util.Map)
	 */
	public Object uniqueResult(String hql, Map<String, Object> pMap) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		if (pMap == null) {
			return query.uniqueResult();
		}
		Set<String> keys = pMap.keySet();
		Iterator<String> iterator = keys.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			query.setParameter(key, pMap.get(key));
		}
		return query.uniqueResult();
	}

	/**
	 * @Description: 
	 * @author Blossom
	 * @time 2017年3月4日 下午11:32:03
	 * @see com.blossom.author.dao.IBaseDao#executeSQLQuery(java.lang.Class, java.lang.String, java.util.List)
	 */
	@SuppressWarnings("rawtypes")
	public List executeSQLQuery(Class class1, String sql, List<Object> pList) {
		SQLQuery sqlQuery = sessionFactory.getCurrentSession().createSQLQuery(sql);
		if (class1 != null) {
			sqlQuery.addEntity(class1);
		}
		if (pList.size() == 0 || pList.isEmpty()) {
			return sqlQuery.list();
		}
		int len = pList.size();
		for (int i = 0; i < len; i++) {
			sqlQuery.setParameter(i, pList.get(i));
		}
		return sqlQuery.list();
	}

}
