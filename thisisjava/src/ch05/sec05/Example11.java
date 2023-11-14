package ch05.sec05;

public class Example11 {

	public static void main(String[] args) {
		
		
		//파일 첨부해서 서버에 저장 
		// 내사진.jpg ->업로드 ->내사진.jpg (서버에 저장)
		// 이때 파일 명을 한글로 하지말자 
		//파일명 변경(영문+숫자)
		
		//문제 파일명을 
		String temp =System.currentTimeMillis()+"";
		
		
		String file = "내사진.jpg";
		String newFilename = file.replace(file.substring(0,file.indexOf(".")), temp);
		System.out.println("fileName = "+file+" new FileName = "+newFilename);
		
		//DB에는 원래 파일명 + 서버에 저장된 파일명 두개 저장해둠 
		
		int idx = file.indexOf(".");
		String ext = file.substring(idx);
		String filename2 = "notice"+temp+ext;
		System.out.println(filename2);
		
		//이래도 겹칠 수 있음 nanoTime()혹은 랜덤영어를 가져와서 조합해서 사용하자
		
	}

}
