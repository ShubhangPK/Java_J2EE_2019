package question9;
import java.util.Scanner;

public class GetNumberThread extends Thread {

public String number;
private static String[] digit = new String[] {"zero","one","two","three","four","five","six","seven","eight","nine"};
public void run() {
Scanner s = new Scanner(System.in);
System.out.println("Enter number with more than 4 digits: ");
number = s.next();
for(char c : number.toCharArray()) {
if(c<48||c>57) {
System.out.println("Invalid inputs");
break;
}
System.out.print(digit[((int)c-48)]+" ");
}
System.out.print("\n");
s.close();
}
}
