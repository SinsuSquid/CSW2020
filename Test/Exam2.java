class A{}
class B extends A{}
class C extends B{}

public class Exam2{
	public static void main(String[] args){
		A a = new A();
		B b = new B();
		C c = new C();

		if (b instanceof A) 
			System.out.println("1");
		if (c instanceof C) 
			System.out.println("2");
		if (a instanceof java.lang.Object) 
			System.out.println("3");
		if ((new B()) instanceof A) 
			System.out.println("4");
	}
}
