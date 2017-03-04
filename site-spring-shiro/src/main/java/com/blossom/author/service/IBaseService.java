package com.blossom.author.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author Blossom
 * @time 2017年3月4日 下午11:33:04
 */
public interface IBaseService<T, PK extends Serializable> {

	// 写操作
	void saveEntity(T t);

	void saveOrUpdateEntity(T t);

	void updateEntity(T t);

	void deleteEntity(T t);

	int batchEntityByHQL(String hql, Map<String, Object> pMap);

	// 执行原生的sql语句
	int executeSQL(String sql, List<Object> pList);

	// 读操作
	T loadEntity(PK pk);

	T getEntity(PK pk);

	List<T> findEntityByHQL(String hql, Map<String, Object> pMap);

	// 单值检索,确保查询结果有且只有一条记录
	Object uniqueResult(String hql, Map<String, Object> pMap);

	// 查询所有实体
	List<T> findAllEntities();

	@SuppressWarnings("rawtypes")
	List executeSQLQuery(Class clazz, String sql, List<Object> pList);

}
