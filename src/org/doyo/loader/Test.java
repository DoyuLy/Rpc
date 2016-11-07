package org.doyo.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args) 
			throws FileNotFoundException, IOException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//读取本地的class文件内的字节码，转换成字节码数组  
        File file = new File(".");  
        //bin\org\doyo\loader
        InputStream  input = new FileInputStream(file.getCanonicalPath()+"\\bin\\org\\doyo\\loader\\Programmer.class");  
        byte[] result = new byte[1024];  
          
        int count = input.read(result);  
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象  
        MyClassLoader loader = new MyClassLoader();  
        Class clazz = loader.defineMyClass( result, 0, count);  
        System.out.println(clazz.getClassLoader());
        //测试加载是否成功，打印class 对象的名称  
		System.out.println(clazz.getCanonicalName());

		// 实例化一个Programmer对象
		Object o = clazz.newInstance();
		try {
			// 调用Programmer的code方法
			clazz.getMethod("code", null).invoke(o, null);
		} catch (IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
               
		//类加载器
		ClassLoader appClassLoader = Test.class.getClassLoader(); //clazz.getClassLoader();
		System.out.println(appClassLoader); //sun.misc.Launcher$AppClassLoader@ec6b00
		
		ClassLoader extClassLoader = appClassLoader.getParent();  
		System.out.println(extClassLoader); //sun.misc.Launcher$ExtClassLoader@164dbd5
		
		ClassLoader bootStrapClassLoader = extClassLoader.getParent();
		System.out.println(bootStrapClassLoader); // null 由于bootStrap是c代码，没有对应的java对象，所以返回了null
		
		
		System.out.println(System.getProperty("user.dir"));
	}

}
