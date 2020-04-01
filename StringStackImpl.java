import java.io.*;
import java.util.*;

public class StringStackImpl implements StringStack {
    private int n;      // size of the stack
    private Node first;     // top of stack

    private class Node {  
        private String s;
        private Node next;

        public Node(String s, Node next){
            this.s = s;
            this.next = next;
        }
    }

    public StringStackImpl() { //Initializes an empty stack
        first = null;
        n = 0;
    }

	public boolean isEmpty() { //return true if the stack is empty
        return first == null;
    }

	public void push(String s) { //insert a String item to the stack
        Node t = first;
        first = new Node(s, t);
        n++;
    }

	public String pop() throws NoSuchElementException{ //remove and return the item on the top of the stack
		if (isEmpty()) throw new NoSuchElementException("Empty Stack");
        String s = first.s;        // save item to return
        first = first.next;            // delete first node
        n--;
        return s;
	}

	public String peek() throws NoSuchElementException{ //return without removing the item on the top of the stack
		if (isEmpty()) throw new NoSuchElementException("Empty Stack");
		return first.s;
	}

	public void printStack(PrintStream stream){ // print the elements of the stack, starting from the item

		for (Node f=first; f!=null; f=f.next)
			System.out.println(f.s);
	}

	public int size() { //return the size of the stack, 0 if it is empty
        return n;
    }
}
