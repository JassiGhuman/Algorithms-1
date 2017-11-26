package a8;

import java.util.*;

public class Q2
{
	public static void main(String[] args)
	{	
		int[] a=new int[5];
		a[0]=1;
		a[1]=2;
		a[2]=3;
		a[3]=4;
		a[4]=5;
		abc q=new dbl();
		new Mymap().map(new dbl(){	
			public int excute(int n)
			{
				return 2*n;
			}
			},a);
		new Myfilter().filter(new dbl(){	
			public int excute(int n)
			{
				return 2*n;
			}
			},a);
		ced c=new average();
		new Reduce().reduce(c,a);
}
}

interface ced
{
public int avg(int []a);
}


interface abc
	{
		public int excute(int x);	
	}

class average implements ced{
int sum=0;
public int avg(int []a)
{
for(int i=0;i<5;i++)
sum=sum+a[i];


sum=sum/5;
return sum;
}}	

class dbl implements abc
	{	
	public int excute(int n)
	{
		return 2*n;
	}
	}
class Mymap 
{

public int[] map(abc p , int []y)
{

int[] b=new int[5];
for(int i=0;i<5;i++)
{
 b[i]=p.excute(y[i]);
System.out.println(b[i]);
}
return b;
}
}

class Myfilter
{

public int[] filter(abc p, int []y)
{
int[] b=new int[5];
for(int i=0;i<5;i++)
{
if(y[i]>2)
{
 b[i]=p.excute(y[i]);
System.out.println(b[i]);
}}
return b;
}
}

class Reduce
{
int sum=0;
public int reduce(ced p,int []y)
{

sum=p.avg(y);

System.out.println(sum);
return sum;
}

}




