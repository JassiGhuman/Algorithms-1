package arrays;

public class Min_swap_array {
	public int min_swaps(int a[],int pairs[],int index) {
		if(index>a.length-1) {
			return 0;
		}
		int pair_num=pairs.length;
		boolean couple=false;
		for(int i=0;i<pair_num;i++) {
			if(a[index]==pairs[i]) {
				if(index<a.length-1 && i%2==0 && a[index+1]==pairs[i+1]) {
					couple=true;
				}
				else if(i%2!=0 && a[index+1]==pairs[i-1]){
					couple=true;
				}
				break;
			}
		}
		if(couple) {
			int duplicate[]=a.clone();
			return min_swaps(duplicate, pairs, index+2);
		}
		else {
			int index1=0;
			for(int i=0;i<pair_num;i++) {
				if(index<a.length-1 && a[index]==pairs[i]) {
					if(i%2==0 ) {
						index1=i+1;
					}
					else if(i%2!=0){
						index1=i-1;
					}
					break;
				}
			}
			int duplicate[]=a.clone();
			//swap pair of first index
			int temp = duplicate[];
			int index2=0;
			for(int i=0;i<pair_num;i++) {
				if(a[index]==pairs[i]) {
					if(i%2==0 ) {
						index2=i+1;
					}
					else if(i%2!=0){
						index1=i-1;
					}
					break;
				}
			}
			
			//int a=min_swaps(, pairs, index)	
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
