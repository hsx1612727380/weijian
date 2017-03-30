package com.fengyun.web.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import mmo.core.amf.ASAmf3Serializer;

import org.apache.commons.io.IOUtils;

public class FileUtils {


	/**
	 * 序列化amf3对象到文件 是否压缩根据配置文件
	 * 
	 * @param object
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void serializeAMF3Object(Object object, String filePath) throws FileNotFoundException, IOException {
		byte[] data = ASAmf3Serializer.writeBytes2(object);

		// 内容相等就不用写入了
		if (compareFileData(data, filePath)) {
			return;
		}

		saveBytes(filePath, data);
	}

	/**
	 * 序列化amf3对象到文件
	 * 
	 * @param object
	 * @param filePath
	 * @param isCompress
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void serializeAMF3Object(Object object, String filePath, boolean isCompress)
			throws FileNotFoundException, IOException {
		byte[] data = ASAmf3Serializer.writeBytes2(object, isCompress);

		// 内容相等就不用写入了
		if (compareFileData(data, filePath)) {
			return;
		}

		saveBytes(filePath, data);
	}

	/**
	 * 序列化并且zip压缩amf3对象
	 * 
	 * @param object
	 * @param filePath
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void serializeAndCompressAMF3Object(Object object, String filePath) throws FileNotFoundException,
			IOException {
		serializeAMF3Object(object, filePath, true);
	}

	/**
	 * 判断两个字节数组是否相等
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean compareBytes(byte[] a, byte[] b) {
		int l = a.length;
		if (l != b.length) {
			return false;
		}

		for (int i = 0; i < l; ++i) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断文件内容是否相等
	 * 
	 * @param data
	 * @param filePath
	 * @return
	 */
	public static boolean compareFileData(byte[] data, String filePath) {
		try {
			byte[] t = getFileBytes(filePath);
			return compareBytes(t, data);
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 判断文件内容是否相等
	 * 
	 * @param data
	 * @param filePath
	 * @param charset
	 * @return
	 */
	public static boolean compareFileData(StringBuffer data, String filePath, Charset charset) {
		try {
			return data.toString().equals(readFile(filePath, charset));
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean delAllFile(String directory, String extention) {
		boolean flag = false;
		File file = new File(directory);
		if (!file.exists()) {
			return flag;
		}
		if (!file.isDirectory()) {
			return flag;
		}
		String[] tempList = file.list();
		File temp = null;
		for (int i = 0; i < tempList.length; i++) {
			if (directory.endsWith(File.separator)) {
				temp = new File(directory + tempList[i]);
			} else {
				temp = new File(directory + File.separator + tempList[i]);
			}
			if (temp.isFile() && temp.getName().endsWith(extention)) {
				temp.delete();
			}
			if (temp.isDirectory()) {
				// delAllFile(path + "/" + tempList[i], extention);// 删除文件夹里面的文件
				flag = true;
			}
		}
		return flag;
	}

	/**
	 * 删除文件或文件夹
	 * 
	 * @param path
	 * @return
	 */
	public static boolean delFile(String path) {
		return org.apache.commons.io.FileUtils.deleteQuietly(new File(path));
	}

	/**
	 * 复制文件
	 * 
	 * @param srcFile
	 * @param destFile
	 */
	public static void copy(File srcFile, File destFile) {
		try {
			org.apache.commons.io.FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 复制文件
	 * 
	 * @param oldfile
	 * @param newPath
	 */
	public static void copy(File oldfile, String newPath) {
		copy(oldfile, new File(newPath));
	}

	/**
	 * 复制文件
	 * 
	 * @param srcPath
	 * @param newPath
	 */
	public static void copy(String srcPath, String newPath) {
		copy(new File(srcPath), newPath);
	}

	/**
	 * 保存字节到文件
	 * 
	 * @param path
	 * @param bytes
	 * @throws IOException
	 */
	public static void saveBytes(String path, byte[] bytes) throws IOException {
		org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(path), bytes);
	}

	/**
	 * 保存字符串
	 * 
	 * @param path
	 * @param content
	 * @throws IOException
	 */
	public static void saveString(String path, String content) throws IOException {
		System.out.println("file save:" + path);
		org.apache.commons.io.FileUtils.writeStringToFile(new File(path), content);
	}

	/**
	 * 读取文件的所有字节
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static byte[] getFileBytes(String path) throws IOException {
		return org.apache.commons.io.FileUtils.readFileToByteArray(new File(path));
	}

	/**
	 * 复制文件(zip压缩)
	 * 
	 * @param srcPath
	 * @param newPath
	 */
	public static void compressCopy(String srcPath, String newPath) {
		try {
			byte[] bytes = getFileBytes(srcPath);
			bytes = ASAmf3Serializer.compressBytes(bytes);

			// 内容相等就不用写入了
			if (compareFileData(bytes, newPath)) {
				return;
			}

			saveBytes(newPath, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 读取文件字符串
	 * 
	 * @param inStream
	 * @return
	 * @throws Exception
	 */
	public static String readFile(InputStream inStream, Charset charset) throws Exception {
		if (charset == null)
			charset = Charset.forName("UTF-8");

		try {
			return IOUtils.toString(inStream, charset);
		} finally {
			IOUtils.closeQuietly(inStream);
		}
	}

	/**
	 * 读取文件字符串
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	public static String readFile(String filePath, Charset charset) throws Exception {
		if (charset == null)
			charset = Charset.forName("UTF-8");

		return org.apache.commons.io.FileUtils.readFileToString(new File(filePath), charset);
	}

	/**
	 * 删除目标文件夹多余的子文件
	 * 
	 * @param srcPaths
	 * @param dstFolder
	 * @param filters
	 */
	public static void deleteMoreFiles(List<String> srcPaths, String dstFolder, String[] filters) {
		File dstDir = new File(dstFolder);
		File[] dstFiles = dstDir.listFiles();
		if (dstFiles == null) {
			return;
		}

		File[] srcFiles = new File[srcPaths.size()];
		int i = 0;
		for (String s : srcPaths) {
			srcFiles[i++] = new File(s);
		}

		for (File dst : dstFiles) {
			if (containString(filters, dst.getName())) {
				continue;
			}

			if (!pathsContainFileName(srcFiles, dst.getName())) {
				dst.delete();
			}
		}

	}

	/**
	 * 路径数组中的文件是否包含指定的文件名
	 * 
	 * @param srcFiles
	 * @param fileName
	 * @return
	 */
	private static boolean pathsContainFileName(File[] srcFiles, String fileName) {
		for (File s : srcFiles) {
			if (s.getName().equals(fileName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 是否包含字符串
	 * 
	 * @param a
	 * @param s
	 * @return
	 */
	private static boolean containString(String[] a, String s) {
		for (String t : a) {
			if (t.equals(s)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 获得文件扩展名
	 * 
	 * @param f
	 * @return
	 */
	public static String getExtension(File f) {
		return (f != null) ? getExtension(f.getName()) : "";
	}

	/**
	 * 获得文件扩展名
	 * 
	 * @param filename
	 * @return
	 */
	public static String getExtension(String filename) {
		return getExtension(filename, "");
	}

	/**
	 * 获得文件扩展名
	 * 
	 * @param filename
	 * @param defExt
	 * @return
	 */
	public static String getExtension(String filename, String defExt) {
		if ((filename != null) && (filename.length() > 0)) {
			int i = filename.lastIndexOf('.');

			if ((i > -1) && (i < (filename.length() - 1))) {
				return filename.substring(i + 1);
			}
		}
		return defExt;
	}

	/**
	 * 读取文件，每一行add到一个List返回
	 * 
	 * @param path
	 *            文件路径
	 * @param check
	 *            是否检查文件是否存在，不存在则不读取
	 * @return
	 */
	public static List<String> loaderFile(String path, boolean check) {

		List<String> retList = null;
		try {
			if (check) {
				File dir = new File(path);
				if (!dir.exists()) {
					return null;
				}
			}
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
			String line;
			retList = new ArrayList<String>();
			while ((line = in.readLine()) != null) {
				line.trim().split("\t");
				retList.add(line);
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;
	}
}
