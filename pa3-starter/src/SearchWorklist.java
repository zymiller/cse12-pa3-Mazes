/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */
import java.io.*;
import java.util.*;

class StackWorklist implements SearchWorklist {
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
	LinkedList<Square> squareList = new LinkedList<Square>();

	public void add (Square c) {
		squareList.add(c);
	}

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
