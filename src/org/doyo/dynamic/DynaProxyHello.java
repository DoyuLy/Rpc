package org.doyo.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynaProxyHello implements InvocationHandler {

	private Object operater;

	private Object origin;

	public Object bind(Object delegate, Object proxy) {

		this.operater = proxy;
		this.origin = delegate;
		return Proxy.newProxyInstance(this.origin.getClass().getClassLoader(),
				this.origin.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		try {
			// 反射得到操作者的实例 operation
			Class clazz = this.operater.getClass();
			// 反射得到操作者的Start方法
			Method start = clazz.getDeclaredMethod("start", new Class[] { Method.class });
			// 反射执行start方法
			start.invoke(this.operater, new Object[] { method });
			// 执行要处理对象的原本方法
			result = method.invoke(this.origin, args);
			// 反射得到操作者的end方法
			Method end = clazz.getDeclaredMethod("end", new Class[] { Method.class });
			// 反射执行end方法
			end.invoke(this.operater, new Object[] { method });

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
