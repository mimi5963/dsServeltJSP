package ch18.sec04.exam01;

import java.io.*;

public class ReadExample {
	public static void main(String[] args) {
		try {
			
			Reader re = null;
			
			re = new FileReader("C:/temp/test.txt");
			while(true) {
				int data = re.read();
				if(data == -1) break;
				System.out.println((char)data);
			}
			re.close();
			System.out.println();
			
			//문자 배열로 읽기
			re = new FileReader("C:/temp/test.txt");
			char[] data = new char[100];
			while(true) {
				int num = re.read(data);
				if(num == -1) break;
				for(int i=0; i<num; i++) {
					System.out.println(data[i]);
				}
			}
			re.close();
			
		}catch(IOException e) {
			
		}
	}
}
