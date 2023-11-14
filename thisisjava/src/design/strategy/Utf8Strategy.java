package design.strategy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Utf8Strategy implements EncodingStrategy{

	@Override
	public String encode(String text) {
		String result = "";
		try {
			result = URLEncoder.encode(text,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
