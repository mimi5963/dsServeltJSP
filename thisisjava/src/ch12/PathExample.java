package ch12;

import java.io.IOException;
import java.util.Properties;

public class PathExample {

	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();
		pr.load(PathExample.class.getResourceAsStream("../config.properties"));
		//PathExample.class와 같은 폴더에 있는 리소스 읽는 법
		System.out.println(pr);
		System.out.println(pr.get("name"));
	}

}
