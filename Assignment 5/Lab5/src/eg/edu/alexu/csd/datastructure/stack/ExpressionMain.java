package eg.edu.alexu.csd.datastructure.stack;
import java.util.*;
/**
 * Main method for ExpressionEvaluator.
 * @author Youssef Hussein
 *
 */
public class ExpressionMain {
	static ExpressionEvaluator evaluator = new ExpressionEvaluator();
	 public static void main(String[] args) {
		 System.out.print("Please enter your infix expression:\n");
		 Scanner expin = new Scanner (System.in);
		 String expression = expin.nextLine();
		 String postfixexp = new String();
		 int value;
		 if(evaluator.validateinput(expression)) {
			 postfixexp=evaluator.infixToPostfix(expression);
			 System.out.print("\nPostfix Expression : " + postfixexp + "\n");
			 value=evaluator.evaluate(postfixexp);
			 System.out.print("\nExpression Value = " + value + "\n");
		 }
		 else
			 System.out.print("Invalid Expression.\n");
		 main(args);
	 }
}
