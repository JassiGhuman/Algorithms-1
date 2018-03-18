package arrays;

public class Alternate_pos_neg {
	public static void alternate(int a[]){
		int n=a.length;
		int result[]=new int[n];
		int pos_counter=0;
		int neg_counter=0;
		
		for(int i=0;i<n;i++){
			if(a[i]<0){
				neg_counter++;
			}
			else{
				pos_counter++;
			}
		}
	
		
		int pos_idx=0;
		int neg_idx=1;
		int pos_count=0;
		int neg_count=0;
		if(pos_counter==0)
			neg_idx=0;
		for(int i=0;i<n;i++){
			if(a[i]>=0){
				result[pos_idx]=a[i];
				pos_count++;
				if(pos_count>neg_counter){
					pos_idx++;
				}
				else{
					pos_idx+=2;
				}
			}
			else{
				result[neg_idx]=a[i];
				neg_count++;
				if(neg_count>pos_counter){
					neg_idx++;
				}
				else{
					neg_idx+=2;
				}
			}
		}
		//print result
		
		for(int x:result){
			System.out.print(x+" ");
		}
		System.out.println();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {9,5,-4,3,2,-2,1,-3,-4};
		alternate(arr);
	}

}
