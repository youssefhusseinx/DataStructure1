package eg.edu.alexu.csd.datastructure.linkedList.cs;
/**
 * This class implements the LinkedList interface using these methods to create Singly linked list object.
 * The class have two member variables:
 * listcount that shows number of nodes in list.
 * header which points to a dummy node at the head of the list.
 * @author Youssef Hussein
 */
public class Singly implements ILinkedList{
	/**
	 * This is the node private class which contains both data (as object) and next node.
	 * @author Youssef Hussein
	 *
	 */
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
		if (valid(index-1)||index==1)
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
	/**
	 * This method prints the data of the linked list nodes.
	 * @param list The list required to be printed
	 */
	public void print (Singly list) {
		if (listCount != 0) 
		{
			Node i = header.next;
			for (; i!=null ;i=i.next)
				System.out.println(i.data);
		}
	}
	/**
	 * This method checks the validity of the given index.
	 * @param index The index to operate on.
	 * @return True if this index points to a node and false if it is out of range.
	 */
	public boolean valid(int index) {
		boolean valid = false;
		if (index >0 && index <= listCount)
			valid=true;
		return valid;
	}

}
