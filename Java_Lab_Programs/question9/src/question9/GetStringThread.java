package question9;

import java.util.Scanner;

public class GetStringThread extends Thread {

public String string;
public static String vowels = "aeiou";

public void run() {
Scanner s = new Scanner(System.in);
System.out.println("Enter a string: ");
string = s.next();
int x = 0;
for(char c : string.toCharArray())
for(char ch : vowels.toCharArray())
if(c==ch) x++;
System.out.print(x+" vowels present\n");
s.close();
}
}
