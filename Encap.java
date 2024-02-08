package JavaPackage;


class A
{
	private int value;
	public void setValue(int x) // data encapsulation
	{
		value = x; // value = 100
		
	}
	public int getValue()
	{
		return value; //return private int value
		
	}
}
public class Encap {
	public static void main(String[] args) {
		A ref = new A();
		ref.setValue(100);
		System.out.println(ref.getValue());
		
	}

}
