package dynamic_programming;

import java.util.HashMap;
import java.util.Stack;

public class Histogram {
	
	public static int maxArea(int row []) {
		int top_val=0;
		int i=0,max=0,area=0;
		int c=row.length;
		Stack<Integer> s = new Stack<>();
		while(i<c) {
			if(s.isEmpty() || row[s.peek()]<row[i])
				s.push(i++);
			else {
				top_val=row[s.pop()];
				area=i*top_val;
				if(!s.isEmpty()) {
					area=top_val*(i-s.peek()-1);
				
				}
				max=Math.max(max, area);
			}
		}
		while(!s.isEmpty()) {
			top_val=row[s.pop()];
			area=i*top_val;
			if(!s.isEmpty()) {
				area=top_val*(i-s.peek()-1);
			
			}
			max=Math.max(max, area);
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]={2,3,3,2};
		System.out.println(maxArea(a));
	}

}
