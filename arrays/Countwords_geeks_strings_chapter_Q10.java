package arrays;
//Count of words whose i-th letter is either (i-1)-th, i-th, or (i+1)-th letter of given word
public class Countwords_geeks_strings_chapter_Q10 {
	public static void count_words(String s) {
		int result=1;
		if(s.charAt(0)!=s.charAt(1)) {
			result*=2;
		}
		int n=s.length();
		for(int i=1;i<n-1;i++) {
			int count=1;
			if(s.charAt(i)!=s.charAt(i-1)) {
				count++;
			}
			if(s.charAt(i)!=s.charAt(i+1)) {
				count++;
			}
			result*=count;
		}
		if(n!=1) {
			if(s.charAt(n-1)!=s.charAt(n-2)) {
				result*=2;
			}
		}
		System.out.println(result);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abc";
		count_words(s);
	}

}
