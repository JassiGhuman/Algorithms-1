import java.util.ArrayList;
import java.util.Scanner;

public class Coding_Test2 {
	
	public static int  dp(int a[][],int n,int x) {
		//int result=a.clone();
		int min=Integer.MAX_VALUE;
		ArrayList<Integer>list[]=new ArrayList[3] ;
		list[0]=new ArrayList<>();
		list[1]=new ArrayList<>();
		list[2]=new ArrayList<>();
		for(int i=0;i<n;i++) {
			for(int j=0;j<3;j++) {
				if(i==0) {
					list[j].add(a[i][j]);
					list[j].add(-a[i][j]);
					continue;
				}
				ArrayList<Integer> temp1 =new ArrayList<>();
				ArrayList<Integer> temp2 =new ArrayList<>();
				ArrayList<Integer> temp3 =new ArrayList<>();
				//int size=list[j].size();
					if(j==0) {
						for(int s:list[0]) {
							temp1.add(s+a[i][j]);
							temp1.add(s-a[i][j]);
						}
						for(int s:list[1]) {
							temp1.add(s+a[i][j]);
							temp1.add(s-a[i][j]);
						}
						list[0]=temp1;
					}
					if(j==1) {
						for(int s:list[0]) {
							temp2.add(s+a[i][j]);
							temp2.add(s-a[i][j]);
						}
						for(int s:list[1]) {
							temp2.add(s+a[i][j]);
							temp2.add(s-a[i][j]);
						}
						for(int s:list[2]) {
							temp2.add(s+a[i][j]);
							temp2.add(s-a[i][j]);
						}
						list[1]=temp2;
					}
					if(j==2) {
						for(int s:list[1]) {
							temp3.add(s+a[i][j]);
							temp3.add(s-a[i][j]);
						}
						for(int s:list[2]) {
							temp3.add(s+a[i][j]);
							temp3.add(s-a[i][j]);
						}
						list[2]=temp3;
					}
				
					
					
				
			}
		}
		if(list[2].contains(2) && 2>=x) {
			//System.out.println("2");
			min=2;
			return min; 
		}
		for(int l=0;l<3;l++) {
			for(int i:list[l]) {
				
				if(i>=x && i<min)
					min=i;
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        // sc = new Scanner(new FileInputStream("input.txt"));

        int T = sc.nextInt();
        for (int tc = 0; tc < T; tc++) {

            int N = sc.nextInt();
            int x = sc.nextInt();
            int m[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    m[i][j] = sc.nextInt();
                }
            }
            System.out.println(dp(m, N,x ));
	}

}
}
