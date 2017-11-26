package test1;

public class Q6 {
	static String b="0100000";
	public static void main(String[] args) {
		System.out.println(divide(0,6));
		System.out.println(update(3,1,5));
	}
	static int divide(int i,int j) {
		int count0=0;
		int count1=0;
		int k=i;
		while(k<=j) {
			if(b.charAt(i)=='1')
				count1++;
			else
				count0++;
			k++;
		}
		if(count1==count0) {
			return i;
		}
		count0=0;
		count1=0;
		int numOnes[]=new int[j-i+1];
		int numZeroes[]=new int[j-i+1];
		k=i;
		int index=0;
		while(k<=j) {
			
			if(b.charAt(k)=='1')
			{
				numOnes[index]=++count1;
			}
			else{
				numOnes[index]=count1;
			}
			if(b.charAt(j-k)=='0') {
				numZeroes[j-index]=++count0;
			}
			else {
				numZeroes[j-index]=count0;
			}
			index++;
			k++;
		}
		index=0;
		int y=-9;
		while(i<j) {
			if(numOnes[index]==numZeroes[index+1])
			{
				y=i;
				break;
			}
			i++;
			index++;
		}
		return y;
		
	}
	
	static int update(int i,int b,int k) {
		if(b==0) {
			k--;
		}
		else
			k++;
		return k;
	}
	
	
}
