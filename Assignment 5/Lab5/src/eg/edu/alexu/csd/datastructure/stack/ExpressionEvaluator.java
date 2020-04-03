package eg.edu.alexu.csd.datastructure.stack;
import java.util.*;
import java.util.regex.Pattern;


public class ExpressionEvaluator implements IExpressionEvaluator {

	@Override
	public String infixToPostfix(String expression) {
		expression=expression.replaceAll(" ", "");
		String postfix = new String();
		for(int i=0; i<expression.length();i++) {
			 if (expression.charAt(i)=='-'&&Character.isLetterOrDigit(expression.charAt(i+1))&&(i==0||expression.charAt(i-1)=='*'||expression.charAt(i-1)=='/'||expression.charAt(i-1)=='-'||expression.charAt(i-1)=='+')) {
				String neg = new String (Character.toString(expression.charAt(i)));
				int j=i+1;
				while (j<expression.length()&&Character.isLetterOrDigit(expression.charAt(j))) {
					neg+=expression.charAt(j);
					j++;
				}
				expression=expression.replaceAll(neg,"(0-" +neg.substring(1,neg.length()) + ")");
			}
			}
		Stack ops = new Stack();
		for (int i=0;i<expression.length();i++) {
			boolean flag=false;
			while(i<expression.length()&&Character.isDigit(expression.charAt(i))) {
				flag=true;
				postfix+=expression.charAt(i);
				i++;
			}
			if(flag==true)
				postfix+=" ";
			if (i<expression.length()&&Character.isLetter(expression.charAt(i)))
				postfix+=(expression.charAt(i) + " ");
			else if (i<expression.length()&&expression.charAt(i)=='(')
				ops.push(expression.charAt(i));
			else if (i<expression.length()&&expression.charAt(i)==')') {
				while(!ops.isEmpty()&&(char)ops.peek()!='(')
					postfix += (ops.pop()+ " ");
				ops.pop();
			}
			else if (i<expression.length()) {
				if((ops.isEmpty()||precedence(expression.charAt(i))>precedence((char)ops.peek())))
					ops.push(expression.charAt(i));
				else {
					while(i<expression.length()&&!ops.isEmpty()&&precedence(expression.charAt(i))<=precedence((char)ops.peek())&&(char)ops.peek()!='(') 
						postfix += (ops.pop() + " ");
					ops.push(expression.charAt(i));
				}
			}
				
		}
		while(!ops.isEmpty()) {
			if((char)ops.peek()!='(')
				postfix += (ops.pop() + " ");
			else 
				ops.pop();
		}
		
		
		return postfix;
	}

	@Override
	public int evaluate(String expression) {
		for (int i=0;i<expression.length();i++) {
			if(Character.isLetter(expression.charAt(i))) {
				Scanner chars;
				do {
				System.out.print("Please enter value for " + expression.charAt(i) + ":\n");
				chars = new Scanner (System.in);
				}while(!chars.hasNextInt());
				expression=expression.replaceAll(Character.toString(expression.charAt(i)), String.valueOf(chars.nextInt()));
			}
		}
		Stack postfix = new Stack();
		Scanner exp = new Scanner (expression);
		while(exp.hasNext()) {
			if(exp.hasNextInt())
				postfix.push((float)exp.nextInt());
			else {
				char op = exp.next().charAt(0);
				float op2 =  (float) postfix.pop();
				float op1 =  (float) postfix.pop();
				
				switch(op) {
				case '+':
					postfix.push(op1+op2);
					break;
				case '-':
					postfix.push(op1-op2);
					break;
				case '/':
					if(op2==0)
						throw new RuntimeException("Cannot divide by zero");
					postfix.push(op1/op2);
					break;
				case '*':
					postfix.push(op1*op2);
					break;
				}
				
			}
		}
		float result = (float)postfix.pop();
		if(postfix.isEmpty())
			return (int)result;
		else {
			System.out.print("Invalid Expression");
			return 0;
		}
	}

	
	public boolean validateinput(String expression) {
		boolean chars=true;
		expression=expression.replaceAll(" ", "");
		for(int i=0 ; i<expression.length();i++) {
			if(!Character.isLetterOrDigit(expression.charAt(i))&&expression.charAt(i)!='('&&expression.charAt(i)!=')'&&expression.charAt(i)!='-'&&expression.charAt(i)!='+'&&expression.charAt(i)!='/'&&expression.charAt(i)!='*'){
				chars=false;
			}
		}
		if(!chars)
			return false;
		boolean operators=false;
		Stack paren = new Stack();
		for (int i=0; i<expression.length();i++) {
			if (!Character.isLetterOrDigit(expression.charAt(i))){
				if(expression.charAt(i)=='(') {
					operators=false;
					paren.push(expression.charAt(i));
				}
				else if (expression.charAt(i)==')') {
					if(paren.isEmpty())
						return false;
					paren.pop();
				}
				else {
					if((expression.charAt(i)!='-'&&operators==false))
						return false;
					operators=false;
				}
			}
			else {
				if(i!=(expression.length()-1)&&Character.isLetter(expression.charAt(i))&&Character.isLetter(expression.charAt(i+1)))
					return false;
				operators=true;
			}
		}
		if(!paren.isEmpty())
			return false;
		return chars&operators;
	}
	
	public static int precedence(char op) { 
        if(op=='*'||op=='/')
        	return 2;
        if(op=='+'||op=='-')
        	return 1;
        return 0;
    }
	

}
