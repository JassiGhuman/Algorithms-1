package dynamic_programming;

public class Egg_dropping {

	public static int egg_dropping(int eggs,int floors) {
		int trials[][]=new int [eggs+1][floors+1];
		
		for(int i=0;i<=eggs;i++) {
			trials[i][0]=0;
			trials[i][1]=1;
		}
		for(int j=0;j<=floors;j++) {
			trials[1][j]=j;
		}
		
		for(int i=2;i<=eggs;i++) {
			for(int j=2;j<=floors;j++) {
				trials[i][j]=Integer.MAX_VALUE;
				for(int k=1;k<=j;k++) {
					int result=1+Math.max(trials[i-1][k-1], trials[i][j-k]);
					trials[i][j]=Math.min(trials[i][j] ,result );
				}
			}
		}
		for(int i=0;i<eggs+1;i++) {
			for(int j=0;j<floors+1;j++) {
				System.out.print(trials[i][j]+" ");
			}
			System.out.println();
		}
		
		print_floors(floors, eggs, trials[eggs][floors], trials);
		
		return trials[eggs][floors];
	
	}
	public static void print_floors(int floors,int eggs,int trial,int trials[][]) {
		int current=0;
		for(int i=floors;;i--) {
			if(trials[eggs-1][i]==trial-1) {
				current+=i+1;
				if(current>=floors) {
					System.out.print(floors);
					break;
				}
				System.out.print(current+" ");
				trial--;
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(egg_dropping(4,56));
	}

}
