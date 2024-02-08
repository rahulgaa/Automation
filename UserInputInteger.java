package JavaPackage;
import java.util.Scanner; 
public class UserInputInteger {

	public static void main(String[] args) {
		int number;
		System.out.print("Enter Interger Number: ");
		try (Scanner myObj = new Scanner (System.in)) {
		number = myObj.nextInt();
		System.out.println("Input Number is :" + number);
			
		}

	}

}
