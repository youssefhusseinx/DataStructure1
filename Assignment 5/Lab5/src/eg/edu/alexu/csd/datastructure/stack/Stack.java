package eg.edu.alexu.csd.datastructure.stack;
import eg.edu.alexu.csd.datastructure.linkedList.cs.*;
/**
 * This class implementsthe stack interface which contains methods to create and operate on Stack data structure.
 * @author Youssef Hussein
 *
 */
public class Stack implements IStack {
	
	Singly list = new Singly();

	@Override
	public Object pop() { 
		if(list.isEmpty())
			throw new NullPointerException("Stack is Empty");
		Object x = list.get(1);
		list.remove(1);
		return x;
	}

	@Override
	public Object peek() {
		if(list.isEmpty())
			throw new NullPointerException("Stack is Empty");
		Object x = list.get(1);
		return x;
	}

	@Override
	public void push(Object element) {
		if(list.isEmpty())
			list.add(element);
		else
			list.add(1, element);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public int size() {
		return list.size();
	}

}
