package subsequence;
//max(aj-ai)   j>i && j>=i+l
public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {21,15,1,34,324,7,60};
		int l=2;
		int max=a[l]-a[0];
		int aj=a[l];
		int ai=a[0];
		for(int j=l;j<a.length;j++) {
			if(a[j-l]<ai) {
				ai=a[j-l];
			}
			if(a[j]-ai>max) {
				aj=a[j];
				max=a[j]-ai;
			}
		}
		System.out.println(max+" "+ai+" "+aj);
	}

}
