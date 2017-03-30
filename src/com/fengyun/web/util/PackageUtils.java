package com.fengyun.web.util;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 包工具类，用以获取某个指定package，或者某个指定JAR文件里的所有类实例对象。
 *
 */
public class PackageUtils {

	private static final String PROTOCOL_FILE = "file";
	private static final String PROTOCOL_JAR = "jar";

	private static final String PREFIX_FILE = "file:";

	private static final String JAR_URL_SEPERATOR = "!/";
	private static final String CLASS_FILE = ".class";	//class文件的后缀名

	private final static Log log = LogFactory.getLog(PackageUtils.class);

	/**
	 * 返回某个包下的所有的类
	 * @param packageName
	 * @return
	 */
	public static List<Class<?>> getClasses(String packageName) {
		// Assert.notNull(packageName,"packageName can not be null for PackageUtils.getClasses");
		//包名不能为空弄个
		if (packageName == null) {
			log.error("packageName can not be null");
			return null;
		}
		//返回类列表
		List<Class<?>> list = new ArrayList<Class<?>>();
		Enumeration<URL> en = null;
		try {
			en = PackageUtils.class.getClassLoader().getResources(
					nameToPath(packageName));
			while (en.hasMoreElements()) {
				URL url = en.nextElement();
				//class文件的方式
				if (PROTOCOL_FILE.equals(url.getProtocol())) {
					String path = url.getFile();
					path = URLDecoder.decode(path, "utf-8");	//url解码
					File root = new File(path);
					findInDirectory(list, root, root, packageName);
				}
				//JAR的方式
				else if (PROTOCOL_JAR.equals(url.getProtocol())){
					findInJar(list, getJarFile(url), packageName);
				}
			}
		} catch (IOException e) {
			log.error("无效的包名:" + packageName, e.getCause());
		}
		return list;
	}
	
	/**
	 * 返回某个包下特定父类或接口的所有子类
	 * @param <T>
	 * @param packageName	包名
	 * @param clazz		父类
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public  static <T extends Object> List<Class<T>> getClasses(String packageName,Class<T> clazz) {
		List<Class<?>> classes = getClasses(packageName);
		List<Class<T>> returnClasses = new ArrayList<Class<T>>();
		for(Class<?> cls : classes){
			//不是脚本类，跳过
			if(!clazz.isAssignableFrom(cls)){
				continue;
			}
			//抽象类，跳过
			if(Modifier.isAbstract(cls.getModifiers())){
				continue;
			}
			returnClasses.add((Class<T>)cls);
		}
		return returnClasses;
	}

	/**
	 * 返回jar文件file对象
	 * @param url 文件url
	 * @return jar文件的file对象
	 */
	public static File getJarFile(URL url) {
		String file = url.getFile();
		if (file.startsWith(PREFIX_FILE))
			file = file.substring(PREFIX_FILE.length());
		int end = file.indexOf(JAR_URL_SEPERATOR);
		if (end != (-1))
			file = file.substring(0, end);
		return new File(file);
	}

	/**
	 * 从指定的目录查找指定包的所有类，适用于.class的方式
	 * @param results 指定包目录下所有的类，返回结果
	 * @param rootDir	类根目录
	 * @param dir	当前目录
	 * @param packageName	包名
	 */
	private static void findInDirectory(List<Class<?>> results, File rootDir,
			File dir, String packageName) {
		File[] files = dir.listFiles();	//列出目录下的文件
		if(files == null){
			return;
		}
		String rootPath = rootDir.getPath();
		//遍历
		for (File file : files)
			//是文件
			if (file.isFile()) {
				String classFileName = file.getPath();
				//后缀名为class
				if (classFileName.endsWith(CLASS_FILE)) {
					String className = classFileName.substring(rootPath
							.length()
							- packageName.length(), classFileName.length()
							- CLASS_FILE.length());
					try {
						Class<?> clz = Class.forName(pathToName(className));
						results.add(clz);
					} catch (ClassNotFoundException e) {
						log.error("无法获取类:" + className, e.getCause()); // 该错误应该不会出现
					}
				}
			} 
			//递归此目录
			else if (file.isDirectory()){
				findInDirectory(results, rootDir, file, packageName);
			}
	}

	/**
	 * 从指定的JAR文件中查找指定包的所有的类，适用于jar的方式
	 * @param results
	 * @param file
	 * @param packageName
	 */
	private static void findInJar(List<Class<?>> results, File file,
			String packageName) {
		JarFile jarFile = null;
		String packagePath = nameToPath(packageName) + "/";
		try {
			jarFile = new JarFile(file);
			Enumeration<JarEntry> en = jarFile.entries();
			while (en.hasMoreElements()) {
				JarEntry je = en.nextElement();
				String name = je.getName();
				if (name.startsWith(packagePath) && name.endsWith(CLASS_FILE)) {
					String className = name.substring(0, name.length()
							- CLASS_FILE.length());
					try {
						Class<?> clz = Class.forName(pathToName(className));
						results.add(clz);
					} catch (ClassNotFoundException e) {
						log.error("无法获取类:" + className, e.getCause()); // 该错误应该不会出现
					}
				}
			}
		} catch (IOException e) {
			log.error("无法读取 Jar 文件:" + file.getName(), e);
		} finally {
			if (jarFile != null)
				try {
					jarFile.close();
				} catch (IOException e) {
				}
		}
	}

	/**
	 * 将类名的字符串形式转换为路径表现形式
	 * 
	 * @param className	类名
	 * @return 路径的字符串
	 */
	private static String nameToPath(String className) {
		return className.replace('.', '/');
	}

	/**
	 * 将路径转换为类的字符串表现形式
	 * 
	 * @param path 路径
	 * @return 类名的字符串形式
	 */
	private static String pathToName(String path) {
		return path.replace('/', '.').replace('\\', '.');
	}

	public static List<Method> getSortedMethodList(Class<?> clazz) {
		List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
		Collections.sort(methods, new Comparator<Method>() {
			public int compare(Method m1, Method m2) {
				String lower1 = m1.toString().toLowerCase();
				String lower2 = m2.toString().toLowerCase();
				return lower1.compareTo(lower2);
			}
		});

		return methods;
	}
}
