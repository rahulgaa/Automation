package JavaPackage;

class Student{
	int roll, marks;
	String name;
	void input() {
		System.out.println("Enter Roll Name & marks: ");
	}
}

public class Test extends Student {
	void disp() {
		roll = 1; name = "Ankit"; marks = 90;
		System.out.println(roll+" "+name+" "+marks );
	}

	public static void main(String[] args) {
		Test r = new Test();
		r.input(); r.disp();

	}

}
