package subsequence;
//index of first element smaller than ai and ai>aj
public class Stack_Classwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {3,6,8,7,5,2,9,10};
		int i=0;
		int s[]=new int[8];
		s[0]=0;
		int b[]=new int[8];
		for(int j=1;j<8;j++) {
//			if(a[j]>a[s[i]])
//				s[++i]=j;
//			else {
			if(a[j]<a[s[i]]) {
				while(i>=0 && a[j]<a[s[i]]) {
					
					b[s[i--]]=j;
				}
				System.out.println(i+" "+j);
				
				
			}
			s[++i]=j;
		}
		while(i>=0)
			b[s[i--]]=0;
		for(int x:b) {
			System.out.println(x);
		}
		
	}

}
