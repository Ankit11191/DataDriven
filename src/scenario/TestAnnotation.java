package testCases;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface Ankit{
	int value() default 0;
	String name() default "ankit";
}

public class TestAnnotation{
	@Ankit(value = 100)
	public void sayHello() {
	}
	public static void main(String args[]) throws Exception {

		TestAnnotation h = new TestAnnotation();
		Method m = h.getClass().getMethod("sayHello");

		Ankit ankit = m.getAnnotation(Ankit.class);
		System.out.println("value is " + ankit.value() + "% " + ankit.name());
	}
}