package com.blossom.tools.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @Description:Java反射工具类
 * @author Blossom
 * @time 2017年2月27日 下午3:11:56
 */
public class ReflectUtils {

	/**
	 * 获取成员变量的修饰符
	 * 
	 * @param clazz
	 * @param field
	 * @return
	 * @throws Exception
	 */
	public static <T> int getFieldModifier(Class<T> clazz, String field) throws Exception {
		// getDeclaredFields可以获取所有修饰符的成员变量，包括private,protected等getFields则不可以
		Field[] fields = clazz.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equals(field)) {
				return fields[i].getModifiers();
			}
		}
		throw new Exception(clazz + " has no field \"" + field + "\"");
	}

	/**
	 * 获取成员方法的修饰符
	 * 
	 * @param clazz
	 * @param method
	 * @return
	 * @throws Exception
	 */
	public static <T> int getMethodModifier(Class<T> clazz, String method) throws Exception {

		// getDeclaredMethods可以获取所有修饰符的成员方法，包括private,protected等getMethods则不可以
		Method[] m = clazz.getDeclaredMethods();

		for (int i = 0; i < m.length; i++) {
			if (m[i].getName().equals(m)) {
				return m[i].getModifiers();
			}
		}
		throw new Exception(clazz + " has no method \"" + m + "\"");
	}

	/**
	 * [对象]根据成员变量名称获取其值
	 * 
	 * @param clazzInstance
	 * @param field
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static <T> Object getFieldValue(Object clazzInstance, Object field)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

		Field[] fields = clazzInstance.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equals(field)) {
				// 对于私有变量的访问权限，在这里设置，这样即可访问Private修饰的变量
				fields[i].setAccessible(true);
				return fields[i].get(clazzInstance);
			}
		}

		return null;
	}

	/**
	 * [类]根据成员变量名称获取其值（默认值）
	 * 
	 * @param clazz
	 * @param field
	 * @return
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static <T> Object getFieldValue(Class<T> clazz, String field) throws NoSuchFieldException, SecurityException,
			IllegalArgumentException, IllegalAccessException, InstantiationException {

		Field[] fields = clazz.getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			if (fields[i].getName().equals(field)) {
				// 对于私有变量的访问权限，在这里设置，这样即可访问Private修饰的变量
				fields[i].setAccessible(true);
				return fields[i].get(clazz.newInstance());
			}
		}

		return null;
	}

	/**
	 * 获取所有的成员变量(通过GET，SET方法获取)
	 * 
	 * @param clazz
	 * @return
	 */
	public static <T> String[] getFields(Class<T> clazz) {

		Field[] fields = clazz.getDeclaredFields();

		String[] fieldsArray = new String[fields.length];

		for (int i = 0; i < fields.length; i++) {
			fieldsArray[i] = fields[i].getName();
		}

		return fieldsArray;
	}

	/**
	 * 获取所有的成员变量,包括父类
	 * 
	 * @param clazz
	 * @param superClass
	 *            是否包括父类
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public static <T> Field[] getFields(Class<T> clazz, boolean superClass) throws Exception {

		Field[] fields = clazz.getDeclaredFields();
		Field[] superFields = null;
		if (superClass) {
			Class superClazz = clazz.getSuperclass();
			if (superClazz != null) {
				superFields = superClazz.getDeclaredFields();
			}
		}

		Field[] allFields = null;

		if (superFields == null || superFields.length == 0) {
			allFields = fields;
		} else {
			allFields = new Field[fields.length + superFields.length];
			for (int i = 0; i < fields.length; i++) {
				allFields[i] = fields[i];
			}
			for (int i = 0; i < superFields.length; i++) {
				allFields[fields.length + i] = superFields[i];
			}
		}

		return allFields;
	}

	/**
	 * 获取所有的成员变量,包括父类
	 * 
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> Field[] getClassFieldsAndSuperClassFields(Class<T> clazz) throws Exception {

		Field[] fields = clazz.getDeclaredFields();

		if (clazz.getSuperclass() == null) {
			throw new Exception(clazz.getName() + "没有父类");
		}

		Field[] superFields = clazz.getSuperclass().getDeclaredFields();

		Field[] allFields = new Field[fields.length + superFields.length];

		for (int i = 0; i < fields.length; i++) {
			allFields[i] = fields[i];
		}
		for (int i = 0; i < superFields.length; i++) {
			allFields[fields.length + i] = superFields[i];
		}

		return allFields;
	}

	/**
	 * 指定类，调用指定的无参方法
	 * 
	 * @param clazz
	 * @param method
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public static <T> Object invoke(Class<T> clazz, String method) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Object instance = clazz.newInstance();
		Method m = clazz.getMethod(method, new Class[] {});
		return m.invoke(instance, new Object[] {});
	}

	/**
	 * 通过对象，访问其方法
	 * 
	 * @param clazzInstance
	 * @param method
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 */
	public static <T> Object invoke(Object clazzInstance, String method)
			throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, InstantiationException {
		Method m = clazzInstance.getClass().getMethod(method, new Class[] {});
		return m.invoke(clazzInstance, new Object[] {});
	}

	/**
	 * 指定类，调用指定的方法
	 * 
	 * @param clazz
	 * @param method
	 * @param paramClasses
	 * @param params
	 * @return Object
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> Object invoke(Class<T> clazz, String method, Class<T>[] paramClasses, Object[] params)
			throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		Object instance = clazz.newInstance();
		Method _m = clazz.getMethod(method, paramClasses);
		return _m.invoke(instance, params);
	}

	/**
	 * 通过类的实例，调用指定的方法
	 * 
	 * @param clazzInstance
	 * @param method
	 * @param paramClasses
	 * @param params
	 * @return
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public static <T> Object invoke(Object clazzInstance, String method, Class<T>[] paramClasses, Object[] params)
			throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException,
			IllegalArgumentException, InvocationTargetException {
		Method _m = clazzInstance.getClass().getMethod(method, paramClasses);
		return _m.invoke(clazzInstance, params);
	}

	/*
	 * @SuppressWarnings("unchecked") public static void main(String[] args)
	 * throws Exception { // getFields(User.class); User u = new User();
	 * invoke(u, "setName", new Class[] { String.class }, new Object[] {
	 * "xx发大水法大水法x" }); System.out.println(getFieldValue(u, "name")); }
	 */

	private static final String SETTER_PREFIX = "set";

	private static final String GETTER_PREFIX = "get";

	private static final String CGLIB_CLASS_SEPARATOR = "$$";

	private static Logger logger = LoggerFactory.getLogger(ReflectUtils.class);

	/**
	 * 调用Getter方法. 支持多级，如：对象名.对象名.方法
	 */
	public static Object invokeGetter(Object obj, String propertyName) {
		Object object = obj;
		for (String name : StringUtils.split(propertyName, ".")) {
			String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(name);
			object = invokeMethod(object, getterMethodName, new Class[] {}, new Object[] {});
		}
		return object;
	}

	/**
	 * 调用Setter方法, 仅匹配方法名。 支持多级，如：对象名.对象名.方法
	 */
	public static void invokeSetter(Object obj, String propertyName, Object value) {
		Object object = obj;
		String[] names = StringUtils.split(propertyName, ".");
		for (int i = 0; i < names.length; i++) {
			if (i < names.length - 1) {
				String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(names[i]);
				object = invokeMethod(object, getterMethodName, new Class[] {}, new Object[] {});
			} else {
				String setterMethodName = SETTER_PREFIX + StringUtils.capitalize(names[i]);
				invokeMethodByName(object, setterMethodName, new Object[] { value });
			}
		}
	}

	/**
	 * 直接读取对象属性值, 无视private/protected修饰符, 不经过getter函数.
	 */
	public static Object getFieldValue(final Object obj, final String fieldName) {
		Field field = getAccessibleField(obj, fieldName);

		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
		}

		Object result = null;
		try {
			result = field.get(obj);
		} catch (IllegalAccessException e) {
			logger.error("不可能抛出的异常{}", e.getMessage());
		}
		return result;
	}

	/**
	 * 直接设置对象属性值, 无视private/protected修饰符, 不经过setter函数.
	 */
	public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
		Field field = getAccessibleField(obj, fieldName);

		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
		}

		try {
			field.set(obj, value);
		} catch (IllegalAccessException e) {
			logger.error("不可能抛出的异常:{}", e.getMessage());
		}
	}

	/**
	 * 直接调用对象方法, 无视private/protected修饰符.
	 * 用于一次性调用的情况，否则应使用getAccessibleMethod()函数获得Method后反复调用. 同时匹配方法名+参数类型，
	 */
	public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
			final Object[] args) {
		Method method = getAccessibleMethod(obj, methodName, parameterTypes);
		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
		}

		try {
			return method.invoke(obj, args);
		} catch (Exception e) {
			throw convertReflectionExceptionToUnchecked(e);
		}
	}

	/**
	 * 直接调用对象方法, 无视private/protected修饰符，
	 * 用于一次性调用的情况，否则应使用getAccessibleMethodByName()函数获得Method后反复调用.
	 * 只匹配函数名，如果有多个同名函数调用第一个。
	 */
	public static Object invokeMethodByName(final Object obj, final String methodName, final Object[] args) {
		Method method = getAccessibleMethodByName(obj, methodName);
		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
		}

		try {
			return method.invoke(obj, args);
		} catch (Exception e) {
			throw convertReflectionExceptionToUnchecked(e);
		}
	}

	/**
	 * 循环向上转型, 获取对象的DeclaredField, 并强制设置为可访问.
	 * 
	 * 如向上转型到Object仍无法找到, 返回null.
	 */
	public static Field getAccessibleField(final Object obj, final String fieldName) {
		Validate.notNull(obj, "object can't be null");
		Validate.notBlank(fieldName, "fieldName can't be blank");
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass
				.getSuperclass()) {
			try {
				Field field = superClass.getDeclaredField(fieldName);
				makeAccessible(field);
				return field;
			} catch (NoSuchFieldException e) {// NOSONAR
				// Field不在当前类定义,继续向上转型
				continue;// new add
			}
		}
		return null;
	}

	/**
	 * 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问. 如向上转型到Object仍无法找到, 返回null.
	 * 匹配函数名+参数类型。
	 * 
	 * 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object...
	 * args)
	 */
	public static Method getAccessibleMethod(final Object obj, final String methodName,
			final Class<?>... parameterTypes) {
		Validate.notNull(obj, "object can't be null");
		Validate.notBlank(methodName, "methodName can't be blank");

		for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType
				.getSuperclass()) {
			try {
				Method method = searchType.getDeclaredMethod(methodName, parameterTypes);
				makeAccessible(method);
				return method;
			} catch (NoSuchMethodException e) {
				// Method不在当前类定义,继续向上转型
				continue;// new add
			}
		}
		return null;
	}

	/**
	 * 循环向上转型, 获取对象的DeclaredMethod,并强制设置为可访问. 如向上转型到Object仍无法找到, 返回null. 只匹配函数名。
	 * 
	 * 用于方法需要被多次调用的情况. 先使用本函数先取得Method,然后调用Method.invoke(Object obj, Object...
	 * args)
	 */
	public static Method getAccessibleMethodByName(final Object obj, final String methodName) {
		Validate.notNull(obj, "object can't be null");
		Validate.notBlank(methodName, "methodName can't be blank");

		for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType
				.getSuperclass()) {
			Method[] methods = searchType.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					makeAccessible(method);
					return method;
				}
			}
		}
		return null;
	}

	/**
	 * 改变private/protected的方法为public，尽量不调用实际改动的语句，避免JDK的SecurityManager抱怨。
	 */
	public static void makeAccessible(Method method) {
		if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers()))
				&& !method.isAccessible()) {
			method.setAccessible(true);
		}
	}

	/**
	 * 改变private/protected的成员变量为public，尽量不调用实际改动的语句，避免JDK的SecurityManager抱怨。
	 */
	public static void makeAccessible(Field field) {
		if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers())
				|| Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
			field.setAccessible(true);
		}
	}

	/**
	 * 通过反射, 获得Class定义中声明的泛型参数的类型, 注意泛型必须定义在父类处 如无法找到, 返回Object.class. eg.
	 * public UserDao extends HibernateDao<User>
	 *
	 * @param clazz
	 *            The class to introspect
	 * @return the first generic declaration, or Object.class if cannot be
	 *         determined
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> Class<T> getClassGenricType(final Class clazz) {
		return getClassGenricType(clazz, 0);
	}

	/**
	 * 通过反射, 获得Class定义中声明的父类的泛型参数的类型. 如无法找到, 返回Object.class.
	 * 
	 * 如public UserDao extends HibernateDao<User,Long>
	 *
	 * @param clazz
	 *            clazz The class to introspect
	 * @param index
	 *            the Index of the generic ddeclaration,start from 0.
	 * @return the index generic declaration, or Object.class if cannot be
	 *         determined
	 */
	@SuppressWarnings("rawtypes")
	public static Class getClassGenricType(final Class clazz, final int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
					+ params.length);
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
			return Object.class;
		}

		return (Class) params[index];
	}

	@SuppressWarnings("rawtypes")
	public static Class<?> getUserClass(Object instance) {
		Assert.notNull(instance, "Instance must not be null");
		Class clazz = instance.getClass();
		if (clazz != null && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
			Class<?> superClass = clazz.getSuperclass();
			if (superClass != null && !Object.class.equals(superClass)) {
				return superClass;
			}
		}
		return clazz;

	}

	/**
	 * 将反射时的checked exception转换为unchecked exception.
	 */
	public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
		if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
				|| e instanceof NoSuchMethodException) {
			return new IllegalArgumentException(e);
		} else if (e instanceof InvocationTargetException) {
			return new RuntimeException(((InvocationTargetException) e).getTargetException());
		} else if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		}
		return new RuntimeException("Unexpected Checked Exception.", e);
	}

}
