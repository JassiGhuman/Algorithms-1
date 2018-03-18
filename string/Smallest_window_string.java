package string;

public class Smallest_window_string {
	public static void smallest_window(String s,String pattern) {
		int n=s.length();
		int occur[]=new int [26];
		for(int i=0;i<pattern.length();i++) {
			occur[pattern.charAt(i)-97]++;
		}
		int left=0;
		int window[]=new int[26];
		boolean found=false;
		String result="";
		int min=Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			if(s.charAt(i)==' ')
				continue;
			window[s.charAt(i)-97]++;
			while(occur[s.charAt(left)-97]==0 || window[s.charAt(left)-97]>occur[s.charAt(left)-97]) {
				window[s.charAt(left)-97]--;
				left++;
				if(s.charAt(left)==' ')
					left++;
			}
			if(check(window, occur)) {
				System.out.println("1");
				if(found) {
					System.out.println("2");
					while(occur[s.charAt(left)-97]==0 || window[s.charAt(left)-97]>occur[s.charAt(left)-97]) {
						window[s.charAt(left)-97]--;
						left++;
						if(s.charAt(left)==' ')
							left++;
					}
				
				//min=Math.min(min, i-left+1);
				}
				found=true;
				if(min>i-left+1)
				{
					min=i-left+1;
					result=s.substring(left, i+1);
				}
			}
		}
		System.out.println(min);
	}
	public static boolean check(int current[],int actual[]) {
		for(int i=0;i<26;i++) {
			if(current[i]<actual[i])
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "this is a test string";
        String pat = "at";
        smallest_window(str, pat); 
	}

}
