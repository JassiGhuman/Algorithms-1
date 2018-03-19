package classwork;
import java.util.*;
public class Q3 {

  public static char arr[];

  public static void main(String[] args) {
    if((34^2147483645)==((34&(~2147483645))|(2147483645&(~34))))
    	System.out.println("1");
    
    int x=(~18)|(~2)|(~11);
    System.out.println(Integer.toBinaryString(x));
    System.out.println(18&2&13);
//  
    
  }
}