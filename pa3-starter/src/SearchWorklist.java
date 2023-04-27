/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */
import java.util.*;

class StackWorklist implements SearchWorklist {
	// Stack class for stack worklist 
	Stack<Square> squareStack = new Stack<Square>();
	
	public void add(Square c) {
		squareStack.push(c);
	}

	public Square remove() {
		return squareStack.pop();
	}

	public boolean isEmpty() {
		return squareStack.isEmpty();
	}
}

class QueueWorklist implements SearchWorklist {
	// Linked list for queue
	LinkedList<Square> squareList = new LinkedList<Square>();

	public void add (Square c) {
		squareList.add(c);
	}

	//Since add appends items to list, removeFirst gets rid of items on opposite end like a queue
	public Square remove() {
		return squareList.removeFirst();
	}

	public boolean isEmpty() {
		return squareList.isEmpty();
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
