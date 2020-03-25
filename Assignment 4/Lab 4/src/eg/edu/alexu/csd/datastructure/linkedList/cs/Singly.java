package eg.edu.alexu.csd.datastructure.linkedList.cs;

public class Singly implements ILinkedList{
	
	private class Node {
		Object data ;
		Node next ;
	}
	
	int listCount;
	Node header ;
	
	public Singly ()
	{
		header = new Node() ;
		header.next=null;
		this.listCount=0;
	}
	
	@Override
	public void add(int index, Object element)  {
		if (valid(index))
		{
			Node added = new Node () ;
			added.data=element;
			Node i = header;
			for (int j=1 ; j<index ;i=i.next) j++;
			added.next= i.next;
			i.next = added ;
			listCount++;		
		}
		else
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public void add(Object element) {
		
		Node added = new Node () ;
		added.data=element;
		added.next=null;
		Node i= header ;
		for (; i.next!=null ;i=i.next);
		i.next=added;
		listCount++;	
	}

	@Override
	public Object get(int index) {
		if (valid(index))
		{
			Node i = header;
			for (int j=1; j<=index ;i=i.next) j++;
			return i.data;		
		}
		else
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public void set(int index, Object element) {
		if (valid(index))
		{
			Node i = header;
			for (int j=1; j<=index ;i=i.next) j++;
			i.data=element;
		}
		else 
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public void clear() {
		header.next=null;
		listCount=0;	
	}

	@Override
	public boolean isEmpty() {
		boolean empty = true ;
		if ( listCount > 0)
			empty=false;
		return empty;
	}

	@Override
	public void remove(int index) {
		if (valid(index))
		{
			Node i = header;
			for (int j=1; j<index ;i=i.next) j++;
			Node t =i.next;
			i.next=t.next;
			listCount--;	
		}
		else 
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public int size() {
		return listCount;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (valid(fromIndex) && valid(toIndex))
		{
			Node i = header;
			for (int j=1 ; j<=fromIndex ;i=i.next) j++;
			
			Singly subList = new Singly ();
			
			for (int j=fromIndex ;j<=toIndex ; j++) 
			{
				subList.add(i.data);
				i=i.next;
			}
		
			return subList;
		}
		else 
			throw new RuntimeException ("ERROR : Invalid Index") ;
	}

	@Override
	public boolean contains(Object o) {
		boolean found = false ;
		Node i = header;
		for (; i!=null ;i=i.next)
		{
			if (i.data == o)
			{
				found = true ;
				break;
			}
		} 
		return found;
	}
	
	public void print (Singly list) {
		if (listCount != 0) 
		{
			Node i = header.next;
			for (; i!=null ;i=i.next)
				System.out.println(i.data);
		}
	}
	
	public boolean valid(int index) {
		boolean valid = false;
		if (index >0 && index <= listCount)
			valid=true;
		return valid;
	}

}
