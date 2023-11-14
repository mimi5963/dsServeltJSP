package ch6;

public class StudentMain {

	public static void main(String[] args) {
		
		StudentVO s1 = new StudentVO();
		s1.stduno=1;
		s1.name="홍길동";
		s1.grade =1;
		
		StudentVO s2 = new StudentVO();
		s2.stduno = 2;
		s2.name ="김길동";
		
		//20명의 학생 데이터 배열로 저장
		StudentVO[] sarr = new StudentVO[20];
		
		
		for(int i=0; i<sarr.length;i++) {
			StudentVO s = new StudentVO();
			s.stduno = i+1;
			s.name ="홍길동"+i;
			s.grade = i%4+1;
			sarr[i] = s;
		}
	}

}
