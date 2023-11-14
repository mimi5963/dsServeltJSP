package ch18.sec04.exam01;

import java.io.*;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ReadLineExample {

	public static void main(String[] args) throws Exception{
		
		long start = System.nanoTime();
		String oriFilePath1 = "D:/sqldeveloper-23.1.0.097.1607-x64.zip";
		String targetPath = "C:/temp/2sqldeveloper-23.1.0.097.1607-x64.zip";
		FileInputStream fis = new FileInputStream(oriFilePath1);
		FileOutputStream fos = new FileOutputStream(targetPath);
		
		while(true) {
			int data = fis.read();
			if(data == -1) break;
			fos.write(data);
		}
		fos.flush();
		fis.close();
		fos.close();
		
		long end = System.nanoTime();
		System.out.println(end-start);
		
		long start2 = System.nanoTime();
		String oriFilePath2 = "D:/sqldeveloper-23.1.0.097.1607-x64.zip";
		String targetPath2 = "C:/temp/sqldeveloper2.zip";
		FileInputStream fis2 = new FileInputStream(oriFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetPath2);
		
		
		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		while(true) {
			int data = fis.read();
			if(data == -1) break;
			fos.write(data);
		}
		fos.flush();
		fis.close();
		fos.close();
		
		long end2 = System.nanoTime();
		System.out.println(end2-start2);
		
		
		
	}

	
}
