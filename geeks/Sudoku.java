package geeks;

public class Sudoku {
	
	public static boolean solve_sudoku(int grid[][]) {
		int n=grid[0].length;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(grid[i][j]==0) {
					boolean filled=false;
					for(int k=1;k<=n;k++) {
						//System.out.println(check(grid,i,j,k));
						
						if(check(grid,i,j,k)) {
							grid[i][j]=k;
							filled = solve_sudoku(grid);
							if(filled) {
								return true;
							}
							else {
								grid[i][j]=0;
							}
						}
					}
					if(filled==false)
						return false;
				}
			}
		}
		return true;
	}
	public static boolean check(int grid[][],int r,int c,int k) {
		//check row
		int n=grid[0].length;
		int sqrt=(int)Math.sqrt(n);
		for(int col=0;col<n;col++) {
			if(grid[r][col]==k) {
				return false;
			}
		}
		
		//check column
		for(int row=0;row<n;row++) {
			if(grid[row][c]==k) {
				return false;
			}
		}
		//check 3*3 column
		int row=(r/sqrt)*sqrt;
		int col=(c/sqrt)*sqrt;
		for(int i=row;i<row+sqrt;i++) {
			for(int j=col;j<col+sqrt;j++) {
				if(grid[i][j]==k)
					return false;
			}
		}
		return true;
	}
	public static void printSudoku(int grid[][]) {
		for(int r=0;r<grid[0].length;r++) {
			for(int c=0;c<grid[0].length;c++)
				System.out.print(grid[r][c]+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {
				{1, 2, 3, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 1, 2, 3},
				{0, 0, 0, 1, 2, 3, 0, 0, 0},
				{2, 3, 1, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 2, 3, 1},
				{0, 0, 0, 2, 3, 1, 0, 0, 0},
				{3, 1, 2, 0, 0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0, 0, 3, 1, 2},
				{0, 0, 0, 3, 1, 2, 0, 0, 0}};
		int grid1[][]=new int[16][16];
		
		if(solve_sudoku(grid1))
			printSudoku(grid1);
		else {
			System.out.println("No solution");
		}
				
	}

}
