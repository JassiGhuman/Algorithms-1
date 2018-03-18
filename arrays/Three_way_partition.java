package arrays;

public class Three_way_partition {
	public static void partition(int a[],int low,int high){
		// Partitions arr[0..n-1] around [lowVal..highVal]
		int n=a.length;
		int start=0;
		int end=n-1;
		for(int i=0;i<end;){
			//if current element less than lowVal
			if(a[i]<low){
				int temp=a[i];
				a[i]=a[start];
				a[start]=temp;
				start++;
				i++;
			}
			//if current element greater than highVal
			else if(a[i]>high){
				int temp=a[i];
				a[i]=a[end];
				a[end]=temp;
				end--;
			}
			else
				i++;
		}
		//print array	
		for(int x:a)
			System.out.print(x+" ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
		 partition(arr, 10, 20);
	}

}
