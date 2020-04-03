package eg.edu.alexu.csd.datastructure.stack;
import java.util.Scanner;
/**
 * This is the main method for the Stack application.
 * @author Youssef Hussein
 *
 */
public class StackMain {
	static Stack stack = new Stack();
	 public static void main(String[] args) {
		 System.out.print("\n1: Push\r\n" + 
		 		"2: Pop\r\n" + 
		 		"3: Peek\r\n" + 
		 		"4: Get size\r\n" + 
		 		"5: Check if empty\n");
		 Scanner scan;
		 do {
			 scan = new Scanner (System.in);
		 } while (!scan.hasNextInt());
		 switch (scan.nextInt()){
		 	case 1:
		 		do {
					 scan = new Scanner (System.in);
				 } while (!scan.hasNextInt());
		 		stack.push(scan.nextInt());
		 		break;
		 	case 2:
		 		System.out.print(stack.pop());
		 		break;
		 	case 3:
		 		System.out.print(stack.peek());
		 		break;
		 	case 4:
		 		System.out.print(stack.size());
		 		break;
		 	case 5:
		 		System.out.print(stack.isEmpty());
		 		break;
		 }
		 main(args);
	 }
}
