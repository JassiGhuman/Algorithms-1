package arrays;
//Java program to find Index of 0 to be replaced with 1 to get
//longest continuous sequence of 1s in a binary array

public class Longest_Continuous_1 {
	public static void longest_subsequence(int a[]){
		int n=a.length;
		int max=0;
		int count=0;
		boolean zero=false;
		int left[]=new int [n];		//left consecutive one's
		for(int i=0;i<n;i++){
			if(a[i]==1){
				count++;
			}
			else{
				left[i]=count;
				count=0;
			}
		}
		int right[]=new int[n];
		count=0;
		for(int i=n-1;i>=0;i--){
			if(a[i]==1){
				count++;
			}
			else{
				right[i]=count;
				count=0;
			}
		}
		int sequence=0;
		int index=-1;
		for(int i=0;i<n;i++){
			if(a[i]==0){
				sequence=left[i]+right[i]+1;
				if(max<sequence){
					max=sequence;
					index=i;
				}
			}
		}
		System.out.println(index);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  int arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		  longest_subsequence(arr);
		  
	}

}
