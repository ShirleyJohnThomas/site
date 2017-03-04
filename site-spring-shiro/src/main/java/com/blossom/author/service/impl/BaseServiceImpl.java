package com.blossom.author.service.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.blossom.author.dao.IBaseDao;
import com.blossom.author.service.IBaseService;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月4日 下午11:35:09
 */
public abstract class BaseServiceImpl<T, PK extends Serializable> implements IBaseService<T, PK> {

	private IBaseDao<T, PK> dao;
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseServiceImpl() {
		ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) type.getActualTypeArguments()[0];
	}

	
	public IBaseDao<T, PK> getDao() {
		return dao;
	}

	/**
	 * @Description: 注入baseDao
	 * @author Blossom
	 * @time 2017年3月4日 下午11:37:05 
	 * @return_type void
	 *
	 */
	@Resource
	public void setDao(IBaseDao<T, PK> dao) {
		this.dao = dao;
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#saveEntity(java.lang.Object)
	 */
	public void saveEntity(T t) {
		dao.saveEntity(t);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#saveOrUpdateEntity(java.lang.Object)
	 */
	public void saveOrUpdateEntity(T t) {
		dao.saveOrUpdateEntity(t);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#updateEntity(java.lang.Object)
	 */
	public void updateEntity(T t) {
		dao.updateEntity(t);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#deleteEntity(java.lang.Object)
	 */
	public void deleteEntity(T t) {
		dao.deleteEntity(t);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#batchEntityByHQL(java.lang.String,
	 *      java.util.Map)
	 */
	public int batchEntityByHQL(String hql, Map<String, Object> pMap) {

		return dao.batchEntityByHQL(hql, pMap);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#executeSQL(java.lang.String,
	 *      java.util.List)
	 */
	public int executeSQL(String sql, List<Object> pList) {

		return dao.executeSQL(sql, pList);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#loadEntity(java.io.Serializable)
	 */
	public T loadEntity(PK pk) {

		return dao.loadEntity(pk);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#getEntity(java.io.Serializable)
	 */
	public T getEntity(PK pk) {

		return dao.getEntity(pk);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#findEntityByHQL(java.lang.String,
	 *      java.util.Map)
	 */
	public List<T> findEntityByHQL(String hql, Map<String, Object> pMap) {

		return dao.findEntityByHQL(hql, pMap);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#uniqueResult(java.lang.String,
	 *      java.util.Map)
	 */
	public Object uniqueResult(String hql, Map<String, Object> pMap) {

		return dao.uniqueResult(hql, pMap);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#findAllEntities()
	 */
	public List<T> findAllEntities() {
		String hql = "FROM" + clazz.getSimpleName();
		return dao.findEntityByHQL(hql, null);
	}

	/**
	 * @Description:
	 * @author Blossom
	 * @time 2017年3月4日 下午11:35:36
	 * @see com.blossom.author.service.IBaseService#executeSQLQuery(java.lang.Class,
	 *      java.lang.String, java.util.List)
	 */
	@SuppressWarnings("rawtypes")
	public List executeSQLQuery(Class clazz, String sql, List<Object> pList) {

		return dao.executeSQLQuery(clazz, sql, pList);
	}

}
