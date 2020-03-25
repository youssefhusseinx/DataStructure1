package eg.edu.alexu.csd.datastructure.linkedList.cs;

public class Doubly implements ILinkedList {
	
	private class Node {
		Object data ;
		Node next ;
		Node prev;
	}
	
	int listCount;
	Node header ;
	
	public Doubly ()
	{
		header = new Node() ;
		header.next=null;
		header.prev=null;
		this.listCount=0;
	}

	@Override
	public void add(int index, Object element) {
		if (valid(index))
		{
			Node added = new Node () ;
			added.data=element;
			Node i = header;
			for (int j=1; j<index ;i=i.next) j++;
			added.next= i.next;
			i.next = added ;
			Node t = i.next;
			added.prev=i;
			t.prev=added;
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
		added.prev=i;
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
			
			if (i.next.next==null)
			{
				i.next=null;
			}
			else if (i==header)
			{
				Node sec = new Node();
				sec=i.next.next;
				sec.prev=i;
				i.next=sec;
			}
			else
			{
				Node t =i.next;
				Node g =t.next;
				i.next=g;
				g.prev=i;		
			}
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
			
			Doubly subList = new Doubly ();
			
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
	
	public void print (Doubly list) {
		if (listCount != 0)
		{
			Node i = header.next;
			for (; i!=null ;i=i.next)
				System.out.println(i.data);
		}
	}
	
	public void printRev (Doubly list) {
		if (listCount != 0)
		{
			Node i = header;
			for (; i.next!=null ;i=i.next);
			
			for (;i.prev!=null ;i=i.prev)
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
