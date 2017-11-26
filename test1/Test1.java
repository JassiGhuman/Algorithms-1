package test1;

public class Test1 {

	public static String query(String s,int[]occurence,char[]query) {
		int m=query.length;
		int n=s.length();
		int [][]hash=new int [4][n];
		int countA=0;
		int countB=0;
		int countC=0;
		int countD=0;
		for(int i=0;i<n;i++) {
			 if (s.charAt(i) == 'A') {
	                hash[0][countA] = i;
	                countA++;
	            }
	            else if (s.charAt(i) == 'B') {
	                hash[1][countB] = i;
	                countB++;
	            }
	            else if (s.charAt(i) == 'C') {
	                hash[2][countC] = i;
	                countC++;
	            }
	            else if (s.charAt(i) == 'D') {
	                hash[3][countD] = i;
	                countD++;
	            }
		}
		String output = "";
		for(int j=0;j<m;j++) {
			int ascii = (int) query[j] % 65;

	        if (occurence[j] < s.length()) {
	        	if(hash[ascii][occurence[j]-1]!=0 ) {
	        		int index=occurence[j]-1;
	        		while(index<countA-1) {
	        			hash[ascii][index]=hash[ascii][index+1];
	        		}
	        		if(ascii==0) {
	        			countA--;
	        		}
	        		if(ascii==1) {
	        			countB--;
	        		}
	        		if(ascii==2) {
	        			countC--;
	        		}
	        		if(ascii==3) {
	        			countD--;
	        		}
	        	}
	        }
		}
		char[] result=new char[countA+countB+countC+countD];
		for(int i=0;i<countA;i++) {
			result[countA]='A';
		}
        output=new String(result);
        return output;
    }

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int occurence[]= {2,1,1,3,2};
		char[] query= {'A','C','D','B','A'};
		String s="ABCDBCAAB";
		System.out.println(query(s,occurence,query));
	}

}
