package JavaPackage;


class Demo {
	
	int a = 10; String b = "Rahul";
	void Show() {
		System.out.println(a + " " +b);
	}
}
public class CallAMethod {

	public static void main(String[] args) {
		Demo r = new Demo();
		r.Show();

	}

}
