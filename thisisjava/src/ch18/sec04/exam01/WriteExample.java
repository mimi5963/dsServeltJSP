package ch18.sec04.exam01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {

	public static void main(String[] args) {
		try {
			File f = new File("C:/temp");
			if(!f.exists()) {
				f.mkdir();
			}
			Writer writer = new FileWriter("C:/temp/test.txt");
			char a = 'A';
			writer.write(a);
			char b = 'B';
			writer.write(b);
			
			char[] arr = {'C','D','E'};
			writer.write(arr);
			
			writer.write("FHG");
			writer.flush();
			writer.close();
		}catch(IOException e) {
			
		}
	}

}
