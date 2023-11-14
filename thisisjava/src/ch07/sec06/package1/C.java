package ch07.sec06.package1;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class C {
  public static void main() {
	  Class classa = A.class;
	  Method[] me = classa.getDeclaredMethods();
	  for(Method m : me) {
		 Annotation a = m.getAnnotation(myano.class);
		Class b =a.annotationType();
		
	  }
  }
}
