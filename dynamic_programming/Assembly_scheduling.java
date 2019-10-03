package dynamic_programming;

public class Assembly_scheduling {
	public static int assembly(int a[][],int t[][],int start[],int end[]) {
		int n=a[0].length;
		//System.out.println(n);
		int time1[]=new int [n];
		int time2[]=new int [n];
		time1[0]=start[0]+a[0][0];
		time2[0]=start[1]+a[1][0];
		for(int i=1;i<n;i++) {
			time1[i]=Math.min(time1[i-1]+a[0][i] ,time2[i-1]+a[0][i]+ t[1][i]);
			time2[i]=Math.min(time2[i-1]+a[1][i] ,time1[i-1]+a[1][i]+ t[0][i]);
		}
		return Math.min(time1[n-1]+end[0],time2[n-1]+end[1] );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
		int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
		int e[] = {10, 12}, x[] = {18, 7};
		System.out.println(assembly(a, t, e, x));



	}

}
