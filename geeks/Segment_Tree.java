package geeks;

import java.awt.print.Printable;
import java.util.Scanner;

public class Segment_Tree {

	public int seg_tree[];
	public Segment_Tree(int a[]) {
		// TODO Auto-generated constructor stub
		int n=a.length;
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
		 
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
 
        seg_tree = new int[max_size]; // Memory allocation
        construct_segment_tree(a, 0, n-1,0);	//method(array,start,end,current index)
        	
	}
	public void construct_segment_tree(int []a,int start,int end,int current) {
		if(start==end) {
			seg_tree[current]=a[start];
			return;
		}
		int mid=start+(end-start)/2;
		construct_segment_tree(a, start, mid, current*2+1);
		construct_segment_tree(a, mid+1, end, current*2+2);
		
	}	
	//increase value from index x to y in Array a by k 
	public void update_query(int start,int end,int x,int y,int a[],int k,int current) {
		int mid=start+(end-start)/2;
		if(start==x && end ==y) {
			seg_tree[current]+=k;
			return;
		}
		else if(start<=x && x<=mid) {
			if(y>mid) {
				update_query(start, mid, x, mid, a, k, current*2+1);
				update_query(mid+1, end, mid+1, y, a, k, current*2+2);
			}
			else {
				update_query(start, mid, x, y, a, k, current*2+1);
			}
		}
		else if(x>mid){
			update_query(mid+1, end, x, y, a, k, current*2+2);
		}
	}
	public int max_value(int current,int start,int end) {
		if(start==end) {
			return seg_tree[current];
		}
		int mid=start+(end-start)/2;
		int x=max_value(current*2+1, start, mid);
		int y=0;
		if(mid!=end) {
			y=max_value(current*2+2, mid+1, end);
		}
		return seg_tree[current]+Math.max(x, y);
	}	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scr =new Scanner(System.in);
		int t=scr.nextInt();
		for(int ti=0;ti<t;ti++){
			int n=scr.nextInt();
			int a[]=new int [n];
			long sum[]=new long[n];
			for(int i=0;i<n;i++){
				a[i]=scr.nextInt();
				sum[i]=a[i];
				if(i!=0)
					sum[i]+=sum[i-1];
			}
			int result[]=new int [n];
			for(int i=0;i<n;i++){
				if(i!=n-1){
					int r=search(sum,a,i+1,n-1,i);
					//System.out.println("r:"+r+" i:"+i);
					result[i+1]+=1;
					if(r!=n-1){
						result[r+1]-=1;
					}
				}
				if(i!=0){
					int r=search(sum,a,0,i-1,i);
					//System.out.println("r:"+r+" "+i);
					result[r]+=1;
					if(r!=n-1){
						result[i]-=1;
					}
				}
			}
			for(int i=1;i<n;i++){
				result[i]+=result[i-1];
			}
			for(int x:result)
				System.out.print(x+" ");
			System.out.println();
		}
		
	}

}