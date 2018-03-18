package arrays;
//Block swap algorithm for array rotation
public class Array_left_rotation_v3 {
	public static void rotate(int a[],int d){
		 /* Return If number of elements to be rotated is 
	    zero or equal to array size */ 
	  int n=a.length;
	  if(d == 0 || d == n)
	    return;
	  int i=d;
	  int j=n-d;
	  while(i!=j){
		  if(i<j){
			  swap(a,d-i,d-j+i,i);
			  j-=i;
		  }
		  else  {
			  swap(a,d-i,d,j);
			  i-=j;
		  }
		  
	  }
	  swap(a,d-i,d,i);
	  for(int x:a){
		  System.out.println(x);
	  }
	}
	/*This function swaps d elements starting at index fi
	  with d elements starting at index si */
	static void swap(int arr[], int fi, int si, int d)
	{
	   int i, temp;
	   for(i = 0; i<d; i++)   
	   {
	     temp = arr[fi + i];
	     arr[fi + i] = arr[si + i];
	     arr[si + i] = temp;
	   }     
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 2, 3, 4, 5, 6, 7};
		 rotate(arr, 2);
	}

}
