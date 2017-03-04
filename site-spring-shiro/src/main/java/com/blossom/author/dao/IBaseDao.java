package com.blossom.author.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Description: 基础dao操作接口
 * @author Blossom
 * @time 2017年3月4日 下午11:13:43
 */
public interface IBaseDao<T, PK extends Serializable> {

	// 写操作
	void saveEntity(T t);

	void saveOrUpdateEntity(T t);

	void updateEntity(T t);

	void deleteEntity(T t);

	int batchEntityByHQL(String hql, Map<String, Object> pMap);

	// 执行原生的SQL语句
	int executeSQL(String sql, List<Object> pList);

	// 读操作
	T loadEntity(PK pk);

	T getEntity(PK pk);

	List<T> findEntityByHQL(String hql, Map<String, Object> pMap);

	// 单值检索，确保查询结果有且只有一条记录
	Object uniqueResult(String hql, Map<String, Object> pMap);

	// 执行原生的sql查询（可以指定是否封装成实体）
	@SuppressWarnings("rawtypes")
	List executeSQLQuery(Class class1, String sql, List<Object> pList);

}
