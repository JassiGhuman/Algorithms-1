	import java.io.*;
	import java.util.*;
	public class Solution {
		
		public static long  triangle(int query,int arr[],int p,int q)
		{
			
			if(query==2) {
				int a[]=new int[q-p+1];
				//System.out.println(a.length);
				if(a.length<3)
					return 0;
				for(int i=0;i<a.length;i++) {
					a[i]=arr[i+p];
				}
				
				return find_perimeter(a);
			}
			return 0;
		}
		public static void update(int arr[],int p,int val)
		{
				arr[p]=val;		
		}
		public static long find_perimeter(int a[]) {
			Arrays.sort(a);
			int n=a.length;
			int a1=a[n-1];
			int a2=a[n-2];
			int a3=a[n-3];
			
			long sum2=a1+a2+a3;
			if(a1+a2>a3 && a2+a3>a1 && a3+a1>a2)
				return a1+a2+a3;
			else {
				for(int i=n-4;i>=0;i--) {
					
					int temp1=a2;
					a1=temp1;
					temp1=a3;
					a2=temp1;
					a3=a[i];
					sum2=a1+a2+a3;
					if(a1+a2>a3 && a2+a3>a1 && a3+a1>a2)
						return (a1+a2+a3);
				}
			}
			return 0;
		}
	    public static void main(String[] args) {
	        Scanner scr = new Scanner(System.in);
	        int n = scr.nextInt();
	        int q=	scr.nextInt();
	        int arr[] = new int[n];
	        
	        for(int i  = 0; i < n; i++){
	            arr[i] = scr.nextInt();
	        }
	        ArrayList<Integer>result=new ArrayList<>();
	        for(int i=0;i<q;i++) {
	        	int no=scr.nextInt();
	        	int l=scr.nextInt();
	        	int r=scr.nextInt();
	        	if(no==2)
	        		result.add((int)triangle(no, arr, l-1, r-1));
	        	else if(no==1)
	        		update(arr,l-1,r);
	        }
	        for(int x:result) {
	        	System.out.println(x);
	        }
	    }
	}
