public class IterativeSumWhile{
public static void main(String[] args){
	int a=7;	
	System.out.println(iterativeSumWhile(a));
}	
public static int iterativeSumWhile(int a)
{
	int sum=0;
	while(a>0)
	{
		sum+=a;
		a--;
	}
	return sum;
}

}
