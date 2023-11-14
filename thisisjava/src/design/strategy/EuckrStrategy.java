package design.strategy;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EuckrStrategy implements EncodingStrategy {

	@Override
	public String encode(String text) {
		String result = "";
		
		try {
			result = URLEncoder.encode(text,"EUC-KR");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		return result;
	}

}
