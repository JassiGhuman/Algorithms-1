package dynamic_programming;

import java.text.DecimalFormat;

public class Probabiltiy_of_knight {
	static int dx[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int dy[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	public static boolean check_boundary(int x,int y,int N) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}
	public static double prob_knight(int x,int y,int steps,int N) {
		double prob[][][]=new double[N][N][steps+1];
		 for (int i = 0; i < N; ++i)
		        for (int j = 0; j < N; ++j)
		            prob[i][j][0] = 1;
		 
		for(int s=1;s<=steps;s++) {
			for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						double probabilty=0;
						for(int k=0;k<8;k++) {
							int nx=i+dx[k];
							int ny=j+dy[k];
							if(check_boundary(nx, ny, N))
							{
								probabilty+=prob[nx][ny][s-1]/8.0;
							}
						}
						prob[i][j][s]=probabilty;	
					}
			}
		}
		return prob[x][y][steps];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecimalFormat df = new DecimalFormat("#.######");
		System.out.println(df.format(0.614075 ));
	}

}
