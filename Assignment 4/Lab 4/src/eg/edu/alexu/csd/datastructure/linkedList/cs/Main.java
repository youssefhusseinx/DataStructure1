package eg.edu.alexu.csd.datastructure.linkedList.cs;
import java.util.*;

public class Main {
	static Psolver obj = new Psolver();
	public static void main(String[] args) {
		System.out.print("Please choose an action\n-----------------------\n1- Set a polynomial variable\n2- Print the value of a polynomial variable\n3- Add two polynomials\n4- Subtract two polynomials\n5- Multiply two polynomials\n6- Evaluate a polynomial at some point\n7- Clear a polynomial variable\n");
		Scanner mainc = new Scanner(System.in); 
        int c = mainc.nextInt();
        mainc.nextLine();
        char v1,v2;
        switch (c) {
        case 1:
        	do {
        		System.out.print("Insert the variable name: A, B or C\n");
        		v1= mainc.next().charAt(0);
        	}while(v1!='A'&&v1!='B'&&v1!='C');
        	mainc.nextLine();
        	System.out.print("Insert the polynomial terms in the form:(coeff1, exponent1), (coeff2, exponent2), ..\n");
        	String polystring = mainc.nextLine();
        	polystring = polystring.replaceAll("[^\\d-]", " ");
        	Scanner pstring = new Scanner(polystring).useDelimiter(" ");
        	//pstring.tokens();
        	int count = 0;
            boolean lasti = false;

            for (int i = 0; i < polystring.length(); i++) {
                if (Character.isDigit(polystring.charAt(i))) {
                    if (!lasti) {
                        count++;
                        lasti = true;
                    }
                } else {
                    lasti = false;
                }
            }
            
            int terms=count/2;
            int [][] polyarray = new int [terms][2];
            int i=0;
            while (pstring.hasNext()) { 
                if (pstring.hasNextInt()) { 
                    if(i%2==0) {
                    	polyarray[i/2][0]=pstring.nextInt();
                    	i++;
                    }
                    else {
                    	polyarray[i/2][1]=pstring.nextInt();
                    	i++;
                    }
                } 
                else { 
                    pstring.next(); 
                } 
            } 
            pstring.close(); 
            obj.setPolynomial(v1, polyarray);
            break;
        case 2:
        	do {
        		System.out.print("Insert the variable name: A, B C or R\n");
        		v1= mainc.next().charAt(0);
        	}while(v1!='A'&&v1!='B'&&v1!='C'&&v1!='R');
        	mainc.nextLine();
        	System.out.println(obj.print(v1)+"\n");
        	break;
        case 3: 
        	do {
            	System.out.print("Insert the first operand variable name: A, B or C\n");
        		v1= mainc.next().charAt(0);
        	}while(v1!='A'&&v1!='B'&&v1!='C');
        	mainc.nextLine();
        	do {
        		System.out.print("Insert the second operand variable name: A, B or C\n");
        		v2= mainc.next().charAt(0);
        	}while(v2!='A'&&v2!='B'&&v2!='C');
        	mainc.nextLine();
        	obj.setPolynomial('R', obj.add(v1, v2));
        	break;
        case 4:
        	do {
            	System.out.print("Insert the first operand variable name: A, B or C\n");
            	v1= mainc.next().charAt(0);
        	}while(v1!='A'&&v1!='B'&&v1!='C');
        	mainc.nextLine();
        	do {
        		System.out.print("Insert the second operand variable name: A, B or C\n");
        		v2= mainc.next().charAt(0);
        	}while(v2!='A'&&v2!='B'&&v2!='C');
        	mainc.nextLine();
        	obj.setPolynomial('R', obj.subtract(v1, v2));
        	break;
        case 5: 
        	do {
            	System.out.print("Insert the first operand variable name: A, B or C\n");
            	v1= mainc.next().charAt(0);
        	}while(v1!='A'&&v1!='B'&&v1!='C');
        	mainc.nextLine();
        	do {
        		System.out.print("Insert the second operand variable name: A, B or C\n");
        		v2= mainc.next().charAt(0);
        	}while(v2!='A'&&v2!='B'&&v2!='C');
        	mainc.nextLine();
        	obj.setPolynomial('R', obj.multiply(v1, v2));
        	break;
        case 6:
        	do {
        		System.out.print("Insert the variable name: A, B C or R\n");
        		v1= mainc.next().charAt(0);
        	}while(v1!='A'&&v1!='B'&&v1!='C');
        	mainc.nextLine();
        	System.out.print("Insert the value of X\n");
        	int eval = mainc.nextInt();
        	float ans=obj.evaluatePolynomial(v1, eval);
        	System.out.println("Expressrion evaluation =" + ans);
        	break;
        case 7:
        	do {
        		System.out.print("Insert the variable name: A, B C or R\n");
        		v1= mainc.next().charAt(0);
        	}while(v1!='A'&&v1!='B'&&v1!='C');
        	mainc.nextLine();
        	obj.clearPolynomial(v1);
        	System.out.println("Variable" + v1 + "is cleared.");
        	break;
        	
	}
		main(args);
	}
}
