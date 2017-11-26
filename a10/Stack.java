package a10;

import java.util.ArrayList;

public class Stack <T>{
	static int max;
    private int top;
    private ArrayList<T> stack=new ArrayList<T>();
    
    public Stack(int size){
        top=0;
        max=size;
    }
    public boolean isEmpty() {
        if (top<=0)
            return true;
        return false;
    }
    public boolean isFull() {
        if (top==max-1)
            return true;
        return false;
    }
    public Integer push(T t){
        if(isFull())
            return -1;
        else {
            stack.add(t);
            top++;
            return top;
        }
    }
    public Integer pop() {
    	if(isEmpty()) {
    		return -1;
    	}
    	else {
    		top--;
    		return (Integer)stack.remove(top);
    		
    	}
    }
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Stack<Integer> s = new Stack<Integer> (10);
	s.push(1);
	s.push(2);
	while(!s.isEmpty()) {
		System.out.println(s.pop());
	}
	
	}

}
