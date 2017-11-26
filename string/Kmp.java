package string;

public class Kmp {
	public static void search(String p,String s){
		int pi[]=pi(p);
		int j=0;
		int i=0;
		while(i<s.length()){
			if(s.charAt(i)==p.charAt(j)){
				i++;
				j++;
				if(j==pi.length){
					System.out.println("Pattern found at "+(i-j));
					j=pi[j-1];
				}
			}

			else{
				System.out.println(i+" "+j);
				if(j!=0)
					j=pi[j-1];
				else{
					i++;
				}
			}
			
			
		}
	}
	public static int[] pi(String s){
		int a[]=new int[s.length()];
		int i=0;
		a[i++]=0;
		int len=0;				//length of already matched pattern
		while(i<a.length){
			if(s.charAt(i)==s.charAt(len)){
				a[i]=++len;
				 i++;
			}
			else{			//mismatch
				if(len==0)
				{
					i++;
				}
				else
					len=a[len-1];				//we go back until we find a matched pattern			
			} 
			
		}
		return a;
	}
	public static void main(String[] args) {
		String p="b";
		//int a[]=pi(p);
		String s="caaab";
		search(p,s);
		
	}
}
