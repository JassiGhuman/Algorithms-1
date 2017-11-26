package graphs;

public class FloydWarshal {
	public static int INF=1000;
	public static void floydwarshal(int graph[][]) {
		int n=graph[0].length;
		int T[][]=graph.clone();	//copies the whole graph
		int N[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
			{
				if(T[i][j]!=0)
					N[i][j]=1;
			}
		}
		int prev[][]=new int [n][n];
		{
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++)
				{
					prev[i][j]=-1;
				}
			}
		}
		for(int k=1;k<n;k++) {
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
				{
					if(T[i][k]+T[k][j]<=T[i][j] && T[i][k]!=0 && T[k][j]!=0 )
					{
						if(T[i][k]+T[k][j]==T[i][j]) {
							N[i][j]=N[i][j]+N[i][k]*N[k][j];
						}
						else
							N[i][j]=N[i][k]*N[k][j];
						T[i][j]=T[i][k]+T[k][j];
						prev[i][j]=k;
					}
					
				}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++)
			{
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
		printShortestPath(0, 1, prev,""+1);
		printShortestPath(0, 2, prev,""+2);
	}
	public static void printShortestPath(int src,int dest,int prev[][],String result) {
		int n=prev[0].length;
		if(prev[src][dest]==-1) {
			System.out.println(src+" --> "+result);
		}
		else {
			printShortestPath(src, prev[src][dest], prev, prev[src][dest]+" --> "+result);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = { {0,   10,  2, 1},
                {0,0,5,0},
                {INF, 2, 0, 0},
                {0,0,2,0}
              };
		floydwarshal(graph);
	}

}
