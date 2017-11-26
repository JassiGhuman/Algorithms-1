public class IterativeSumFor{
public static void main(String [] args){
	int i=6;
	System.out.println(iterativeSumFor(i)); 
}

public static int iterativeSumFor(int i) {
	int sum=0;
	for(;i>0;i--)
		sum+=i;
	return sum;

}
}
