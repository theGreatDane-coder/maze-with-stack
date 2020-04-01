import java.io.*;
import java.util.*;

public class StringQueueImpl implements StringQueue  {
    private int n;         // number of elements on queue
    private Node first;    // beginning of queue
    private Node last;     // end of queue

    public class Node {
        private String val;
        private Node next;

        public Node(String val, Node next){
            this.val = val;
            this.next = next;
        }

    }

    public StringQueueImpl() { //Initializes an empty queue.
        first = null;
        last = null;
        n = 0;
    }

    public boolean isEmpty(){ //return true if the stack is empty
        return first == null;
    }

    public void put(String val){ //insert an String to the queue
        Node t = last;
        last = new Node(val, null);

        if (isEmpty()){
            first = last;
        }else
            t.next = last;
        n++;
    }

    public String get() throws NoSuchElementException{ //remove and return the oldest item of the queue
        if (isEmpty()) throw new NoSuchElementException("Empty queue");
        String val = first.val;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return val;
    }

    public String peek() throws NoSuchElementException{ // return without removing the oldest item of the queue
        if (isEmpty()) throw new NoSuchElementException("Empty queue");
        return first.val;
    }

    public void printQueue(PrintStream stream){ //print the elements of the queue, starting from the oldest

        for (Node f=first; f!=null; f=f.next)
            System.out.println(f.val);

    }

    public int size(){ //return the size of the queue, 0 if it is empty
        return n;
    }
}

