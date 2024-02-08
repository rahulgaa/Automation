package JavaPackage;
import java.util.Scanner ;   // Import Scanner Class from util package
public class UserInputstring {	// Declare a class

	public static void main(String[] args) {	// main method
		String name ; 							// local Variable
		System.out.print("Enter Your Name: ");  // Print text "Enter Your Name"
		try (Scanner myObj = new Scanner(System.in)){	// Create a scanner object to take input
		name = myObj.nextLine();						// Save the name in variable
		System.out.println("Name is: " + name);
		// Print the name from variable
			}
		
		}

	}


