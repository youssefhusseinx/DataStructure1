package eg.edu.alexu.csd.datastructure.linkedList.cs;
import java.util.*; 

public class Psolver implements IPolynomialSolver {
	
	Singly polyA = new Singly() ;
	Singly polyB = new Singly() ;
	Singly polyC = new Singly() ;
	Singly polyR = new Singly() ;
	int maxA=0 , maxB=0 , maxC=0 ,maxR=0;
	int minA=0,minB=0,minC=0,minR=0;
	boolean negA=false,negB=false,negC=false,negR=false;
	int min1=0,min2=0,max1=0,max2=0;

	@Override
	public void setPolynomial(char poly, int[][] terms) {
		
		Singly list = new Singly ();
		list.clear();
		
		if (terms.length > 0 )
		{
			sortbyColumn(terms,1);
			int max = terms [0][1];
			int exp = max;
			
			boolean neg = false;
			if ( terms [terms.length-1][1] < 0 )
				neg = true;
			
			for (int i=0 ; i< terms.length ; i++)
			{
				if (terms[i][1] == exp)
				{
					list.add(terms[i][0]);
					exp--;
				}
				else 
				{
					list.add(0);
					exp--;
					i--;
				}
			}
			
			switch (poly) 
			{
				case 'A' :
					polyA=list;
					maxA=max;
					negA=neg;
					break;
				case 'B' :
					polyB=list;
					maxB=max;
					negB=neg;
					break;
				case 'C' :
					polyC=list;
					maxC=max;
					negC=neg;
					break;
				case 'R' :
					polyR=list;
					maxR=max;
					negR=neg;
					break;	
				default :
					break;
			}
		}
		switch (poly) 
		{
			case 'A' :
				polyA=list;
				break;
			case 'B' :
				polyB=list;
				break;
			case 'C' :
				polyC=list;
				break;
			case 'R' :
				polyR=list;
				break;	
			default :
				break;
		}
		
	}

	@Override
	public String print(char poly) {
		Singly list = new Singly ();
		String sPoly =new String ();
		int max=0;
		
		switch (poly) 
		{
			case 'A' :
				list=polyA;
				max=maxA;
				System.out.print("A = ");
				break;
			case 'B' :
				list=polyB;
				max=maxB;
				System.out.print("B = ");
				break;
			case 'C' :
				list=polyC;
				max=maxC;
				System.out.print("C = ");
				break;
			case 'R' :
				list=polyR;
				max=maxR;
				System.out.print("R = ");
				break;
			default :
				return null;
		}
		
		if (list.isEmpty())
			return sPoly="Empty";
		else
		{
			if((int)list.get(1)!=0) {
			if(max!=0&&(int)list.get(1)!=1&&max!=1)
			sPoly =  ( String.valueOf(list.get(1)) + "x^" + max ) ;
			else if (max==0)
				sPoly = (String.valueOf(list.get(1)));
			else if (max==1) {
				if((int)(list.get(1))!=1)
				sPoly = (String.valueOf(list.get(1)) + "x");
				else
					sPoly="x";
			}
			else 
				sPoly = ("x^" + max );
			}
			for (int i=2 ; i<= list.size() ; i++)
				
			{
				if ( (int) list.get(i) == 0)
					continue;
				else 
				{
					if((int)list.get(i)>=0&&!sPoly.isEmpty()) 
						sPoly +=("+");
					if((max-i+1)!=0&&(int)list.get(i)!=1&&(max-i+1)!=1)
						sPoly +=  (String.valueOf(list.get(i)) + "x^" + (max-i+1) ) ;
						else if (max-i+1==0)
							sPoly += (String.valueOf(list.get(i))) ;
						else if (max-i+1==1)
							sPoly += (String.valueOf(list.get(i)) + "x") ;
						else 
							sPoly += ("x^" + (max-i+1) );
				}
			}
		}
		return sPoly;
	}

	@Override
	public void clearPolynomial(char poly) {
		switch (poly) 
		{
			case 'A' :
				polyA.clear();
				break;
			case 'B' :
				polyB.clear();
				break;
			case 'C' :
				polyC.clear();
				break;
			default :
				break;
		}
	}

	@Override
	public float evaluatePolynomial(char poly, float value) {
		Singly list = new Singly ();
		boolean neg = false;
		float ans=0;
		int max;
		
		switch (poly) 
		{
			case 'A' :
				list=polyA;
				max=maxA;
				neg=negA;
				System.out.print("A = ");
				break;
			case 'B' :
				list=polyB;
				max=maxB;
				neg=negB;
				System.out.print("B = ");
				break;
			case 'C' :
				list=polyC;
				max=maxC;
				neg=negC;
				System.out.print("C = ");
				break;
			default :
				return ans;
		}
		
		if (neg) 
		{
			throw new RuntimeException ("ERROR : Division by ZERO") ;
		}
		
		if (list.isEmpty())		
		return ans;
		
		for (int i = 1 ; i<=list.size() ; i++)
		{
			ans += (int) list.get(i) * ( Math.pow(value,max) );
			max--;
		}
		return ans;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		Singly list1 = new Singly ();
		Singly list2= new Singly ();
		minA=maxA-polyA.size()+1;
		minB=maxB-polyB.size()+1;
		minC=maxC-polyC.size()+1;
		
		switch (poly1) 
		{
			case 'A' :
				list1=polyA;
				max1=maxA;
				min1=minA;
				break;
			case 'B' :
				list1=polyB;
				max1=maxB;
				min1=minB;
				break;
			case 'C' :
				list1=polyC;
				max1=maxC;
				min1=minC;
				break;
			default :
				return null;
		}
		
		switch (poly2) 
		{
			case 'A' :
				list2=polyA;
				max2=maxA;
				min2=minA;
				break;
			case 'B' :
				list2=polyB;
				max2=maxB;
				min2=minB;
				break;
			case 'C' :
				list2=polyC;
				max2=maxC;
				min2=minC;
				break;
			default :
			return null;
		}
		
		int c1=1 , c2=1;
		minR=Math.min(min1, min2);
		maxR= Math.max(max1, max2);
		int [][] ans = new int [maxR-minR+1][2];
		
		for (int i= 0 ; i<ans.length  ; i++)
		{
			ans [i][1]=maxR-i;
		}
		
		for (int i= 0 ; i<ans.length  ; i++)
		{
			if (ans [i][1] == max1 && max1 >= min1)
			{
				ans [i][0] += (int) list1.get(c1++);
				max1--;
			}
		}
		
		for (int i= 0 ; i<ans.length  ; i++)
		{
			if (ans [i][1] == max2 && max2 >= min2)
			{
				ans [i][0] += (int) list2.get(c2++);
				max2--;
			}
		}
		
		return ans;
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		Singly list1 = new Singly ();
		Singly list2= new Singly ();
		minA=maxA-polyA.size()+1;
		minB=maxB-polyB.size()+1;
		minC=maxC-polyC.size()+1;
		
		switch (poly1) 
		{
			case 'A' :
				list1=polyA;
				max1=maxA;
				min1=minA;
				break;
			case 'B' :
				list1=polyB;
				max1=maxB;
				min1=minB;
				break;
			case 'C' :
				list1=polyC;
				max1=maxC;
				min1=minC;
				break;
			default :
				return null;
		}
		
		switch (poly2) 
		{
			case 'A' :
				list2=polyA;
				max2=maxA;
				min2=minA;
				break;
			case 'B' :
				list2=polyB;
				max2=maxB;
				min2=minB;
				break;
			case 'C' :
				list2=polyC;
				max2=maxC;
				min2=minC;
				break;
			default :
			return null;
		}
		
		int c1=1 , c2=1;
		minR=Math.min(min1, min2);
		maxR= Math.max(max1, max2);
		int [][] ans = new int [maxR-minR+1][2];
		
		for (int i= 0 ; i<ans.length  ; i++)
		{
			ans [i][1]=maxR-i;
		}
		
		for (int i= 0 ; i<ans.length  ; i++)
		{
			if (ans [i][1] == max1 && max1 >= min1)
			{
				ans [i][0] += (int) list1.get(c1++);
				max1--;
			}
		}
		
		for (int i= 0 ; i<ans.length  ; i++)
		{
			if (ans [i][1] == max2 && max2 >= min2)
			{
				ans [i][0] -= (int) list2.get(c2++);
				max2--;
			}
		}
		
		return ans;
	}

	@Override
	public int[][] multiply(char poly1, char poly2) {
		Singly list1 = new Singly ();
		Singly list2= new Singly ();
		minA=maxA-polyA.size()+1;
		minB=maxB-polyB.size()+1;
		minC=maxC-polyC.size()+1;
		
		switch (poly1) 
		{
			case 'A' :
				list1=polyA;
				max1=maxA;
				min1=minA;
				break;
			case 'B' :
				list1=polyB;
				max1=maxB;
				min1=minB;
				break;
			case 'C' :
				list1=polyC;
				max1=maxC;
				min1=minC;
				break;
			default :
				return null;
		}
		
		switch (poly2) 
		{
			case 'A' :
				list2=polyA;
				max2=maxA;
				min2=minA;
				break;
			case 'B' :
				list2=polyB;
				max2=maxB;
				min2=minB;
				break;
			case 'C' :
				list2=polyC;
				max2=maxC;
				min2=minC;
				break;
			default :
			return null;
		}
		
		minR=min1 + min2;
		maxR=max1 + max2;
		int [][] ans = new int [maxR-minR+1][2];
		
		for (int i =0 ;i<list1.size() ; i++)
		{
			for (int j=0 ;j<list2.size() ; j++)
			{
				ans [i+j][1] = maxR-i-j;
				ans [i+j][0] += (int) list1.get(i+1) * (int) list2.get(j+1); 
			}
		}
		return ans;
	}
	
	public void sortbyColumn(int arr[][], int col) 
	
    { 
          Arrays.sort(arr, new Comparator<int[]>()
          { 
          public int compare(final int[] entry1,  
                             final int[] entry2) 
          { 
            if (entry1[col] < entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });
    } 

}
