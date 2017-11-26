package a10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Queue <T>{
	
	static int max;
    private int front;
    private int rear;
    public List<T> queue=new LinkedList<T>();
    
    public Queue(int size){
        front=0;
        rear=0;
        max=size;
    }
    public boolean isEmpty() {
        if (queue.isEmpty())
            return true;
        return false;
    }
    public boolean isFull() {
        if (rear==max-1)
            return true;
        return false;
    }
    public Integer enqueue(T t) {
    	if(isFull()) {
    		return -1;
    	}
    	else {
    		queue.add(t);
    		rear++;
    		return (Integer)t;
    	}
    	
    }
    public Integer dequeue() {
    	if(isEmpty()) {
    		return -1;
    	}
    	else {
    		return (Integer)queue.remove(front);
    	}
    }

    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new Queue<>(10);
		q.enqueue(1);
		q.enqueue(2);
		while(!q.isEmpty()) {
			System.out.println(q.dequeue());
		}
		q.enqueue(2);
		q.enqueue(4);
		System.out.println(q.dequeue() +" " +q.dequeue());
	}

}
