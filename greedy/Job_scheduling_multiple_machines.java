package greedy;

import java.util.Arrays;

import classwork.Min_heap;

public class Job_scheduling_multiple_machines {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start[]= {3,3,5,5};
		int end []= {6,6,7,9};
		Min_heap heap=new Min_heap(10);
		Arrays.sort(start);
		heap.build_heap(end);
		int machines=0;
		int n=start.length;
		for(int i=0;i<n;i++) {
			if(heap.get_min()>start[i]) {
				machines++;
			}
			else {
				heap.delete_min();
			}
		}
		System.out.println(machines);
	}

}
