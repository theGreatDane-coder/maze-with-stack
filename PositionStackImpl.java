import java.io.*;
import java.util.*;

public class PositionStackImpl {
    private int n;      // size of the stack
    private Node first;     // top of stack

    private class Node {
        private positions p;
        private Node next;

        public Node(int x, int y, Node next){
            p = new positions(x, y);
            this.next = next;
        }
    }

    public PositionStackImpl() { //Initializes an empty stack
        first = null;
        n = 0;
    }

    public boolean isEmpty() { //return true if the stack is empty
        return first == null;
    }

    public void push(int x, int y ) { //insert a position item to the stack
        Node t = first;
        first = new Node(x,y, t);
        n++;
    }

    public positions pop() throws NoSuchElementException{ //remove and return the item on the top of the stack
        if (isEmpty()) throw new NoSuchElementException("Empty Stack");
        positions p =  new positions(first.p.x, first.p.y);        // save item to return
        first = first.next;            // delete first node
        n--;
        return p;
    }

    public positions peek() throws NoSuchElementException{ //return without removing the item on the top of the stack
        if (isEmpty()) throw new NoSuchElementException("Empty Stack");
        return first.p;
    }

    public void printStack(PrintStream stream){ // print the elements of the stack, starting from the item

        for (Node f=first; f!=null; f=f.next)
            System.out.println(f.p);
    }

    public int size() { //return the size of the stack, 0 if it is empty
        return n;
    }

}
