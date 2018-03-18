package arrays;
//Count number of substrings with exactly k distinct characters
public class Count_substrings {
	public static void find_substrings(String s,int k) {
		int n=s.length();
		int result=0;		//nos of substrings with exactly k distinct characters
		for(int i=0;i<n;i++)
		{	
			int count=0;
			int a[]=new int [26];
			for(int j=i;j<n;j++) {
				if(a[s.charAt(j)-97]==0)
				{
					count++;
				}
				if(count==k) {
					result++;
				}
				if(count>k)
					break;
				a[s.charAt(j)-97]++;
			}
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aa";
		int k=1;
		find_substrings(s, k);
	}

}
