package dynamic_programming;

public class Word_Break {
	public static boolean word_break(String find,String dict[]) {
		int n=find.length();
		boolean result[][]=new boolean[n][n];
		int difference=0;
		while(difference<n) {
			for(int i=0;i<n-difference;i++) {
				int j=i+difference;
				if(i==j)
					result[i][j]=find_word(find.substring(i, i+1), dict);
				else if(find_word(find.substring(i, j+1), dict)){
					result[i][j]=true;
				}
				else {
					for(int split=i;split<j;split++) {
						if(result[i][split] && result[split+1][j]) {
							result[i][j]=true;
							break;
						}
					}
					
				}
			}
			difference++;
		}
		print_words(find, dict, result, 0, n-1, "");
		System.out.println();
		return result[0][n-1];
	}
	public static void print_words(String s,String dict[],boolean result[][],int r,int c,String res) {
		if(result[r][c]) {
			if( find_word(s.substring(r,c+1), dict)) {
				System.out.print(res+s.substring(r,c+1)+" ");
			}
			else{
				for(int split=r;split<c;split++) {
					if(result[r][split] && result[split+1][c]) {
						print_words(s, dict,result, r, split, res);
						//if(s.substring(r,split+1).length()!=1)
						//System.out.println(s.substring(r,split+1));
						print_words(s,dict, result, split+1, c, res);
						//System.out.println();
						break;
					}
					
				}
			}
		}
	}
	public static boolean find_word(String find,String dict[]) {
		for(int i=0;i<dict.length;i++) {
			if(dict[i].equals(find))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String dictionary[] = {"mobile","samsung","sam","sung","man","mango",
                 "icecream","and","go","i","like","ice","cream"};
		 System.out.println(word_break("ilikeicecreamandmango", dictionary));
	}

}
