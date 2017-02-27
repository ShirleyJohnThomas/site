package com.blossom.tools.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

import com.blossom.tools.reflex.ReflectUtils;
;



/**
 * @Description: 集合工具类
 * @author Blossom
 * @time 2017年2月27日 下午3:06:05
 */
public class CollectionUtils extends org.apache.commons.collections.CollectionUtils {

	/**
	 * @Description:  提取集合中的对象的两个属性(通过Getter函数), 组合成Map.
	 * @param collection 来源集合.
	 * @param keyPropertyName 要提取为Map中的Key值的属性名.
	 * @param valuePropertyName 要提取为Map中的Value值的属性名.
	 * @author Blossom
	 * @time 2017年2月27日 下午3:06:31 
	 * @return_type Map
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Map extractToMap(final Collection collection, final String keyPropertyName,
			final String valuePropertyName) {
		Map map = new HashMap(collection.size());

		try {
			for (Object obj : collection) {
				map.put(PropertyUtils.getProperty(obj, keyPropertyName),
						PropertyUtils.getProperty(obj, valuePropertyName));
			}
		} catch (Exception e) {
			throw ReflectUtils.convertReflectionExceptionToUnchecked(e);
		}

		return map;
	}

	/**
	 * @Description:提取集合中的对象的一个属性(通过Getter函数), 组合成List.
	 * @param collection 来源集合.
	 * @param propertyName 要提取的属性名. 
	 * @author Blossom
	 * @time 2017年2月27日 下午3:06:53 
	 * @return_type List
	 *
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List extractToList(final Collection collection, final String propertyName) {
		List list = new ArrayList(collection.size());

		try {
			for (Object obj : collection) {
				list.add(PropertyUtils.getProperty(obj, propertyName));
			}
		} catch (Exception e) {
			throw ReflectUtils.convertReflectionExceptionToUnchecked(e);
		}

		return list;
	}

	/**
	 * @Description:提取集合中的对象的一个属性(通过Getter函数), 组合成由分割符分隔的字符串.
	 * @param collection 来源集合.
	 * @param propertyName 要提取的属性名.
	 * @param separator 分隔符. 
	 * @author Blossom
	 * @time 2017年2月27日 下午3:07:10 
	 * @return_type String
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static String extractToString(final Collection collection, final String propertyName, final String separator) {
		List list = extractToList(collection, propertyName);
		return StringUtils.join(list, separator);
	}

	/**
	 * @Description:转换Collection所有元素(通过toString())为String, 中间以 separator分隔。 
	 * @author Blossom
	 * @time 2017年2月27日 下午3:07:22 
	 * @return_type String
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static String convertToString(final Collection collection, final String separator) {
		return StringUtils.join(collection, separator);
	}

	/**
	 * @Description: 转换Collection所有元素(通过toString())为String, 每个元素的前面加入prefix，后面加入postfix，如<div>mymessage</div>。
	 * @author Blossom
	 * @time 2017年2月27日 下午3:07:32 
	 * @return_type String
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static String convertToString(final Collection collection, final String prefix, final String postfix) {
		StringBuilder builder = new StringBuilder();
		for (Object o : collection) {
			builder.append(prefix).append(o).append(postfix);
		}
		return builder.toString();
	}

	/**
	 * @Description:判断是否为空. 
	 * @author Blossom
	 * @time 2017年2月27日 下午3:07:42 
	 * @return_type boolean
	 *
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Collection collection) {
		return (collection == null || collection.isEmpty());
	}

	/**
	 * @Description: 取得Collection的第一个元素，如果collection为空返回null.
	 * @author Blossom
	 * @time 2017年2月27日 下午3:07:55 
	 * @return_type T
	 *
	 */
	public static <T> T getFirst(Collection<T> collection) {
		if (isEmpty(collection)) {
			return null;
		}

		return collection.iterator().next();
	}

	/**
	 * @Description:获取Collection的最后一个元素 ，如果collection为空返回null 
	 * @author Blossom
	 * @time 2017年2月27日 下午3:08:07 
	 * @return_type T
	 *
	 */
	public static <T> T getLast(Collection<T> collection) {
		if (isEmpty(collection)) {
			return null;
		}

		//当类型为List时，直接取得最后一个元素 。
		if (collection instanceof List) {
			List<T> list = (List<T>) collection;
			return list.get(list.size() - 1);
		}

		//其他类型通过iterator滚动到最后一个元素.
		Iterator<T> iterator = collection.iterator();
		while (true) {
			T current = iterator.next();
			if (!iterator.hasNext()) {
				return current;
			}
		}
	}

	/**
	 * @Description:返回a+b的新List. 
	 * @author Blossom
	 * @time 2017年2月27日 下午3:08:17 
	 * @return_type List<T>
	 *
	 */
	public static <T> List<T> union(final Collection<T> a, final Collection<T> b) {
		List<T> result = new ArrayList<T>(a);
		result.addAll(b);
		return result;
	}

	/**
	 * @Description: 返回a-b的新List
	 * @author Blossom
	 * @time 2017年2月27日 下午3:08:27 
	 * @return_type List<T>
	 *
	 */
	public static <T> List<T> subtract(final Collection<T> a, final Collection<T> b) {
		List<T> list = new ArrayList<T>(a);
		for (T element : b) {
			list.remove(element);
		}

		return list;
	}

	/**
	 * @Description: 返回a与b的交集的新List
	 * @author Blossom
	 * @time 2017年2月27日 下午3:08:36 
	 * @return_type List<T>
	 *
	 */
	public static <T> List<T> intersection(Collection<T> a, Collection<T> b) {
		List<T> list = new ArrayList<T>();

		for (T element : a) {
			if (b.contains(element)) {
				list.add(element);
			}
		}
		return list;
	}
}
