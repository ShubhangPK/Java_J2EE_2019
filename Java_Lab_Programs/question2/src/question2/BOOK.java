package question2;

import java.util.Scanner;


public class BOOK {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[])
    {
        int n;
        library l=new library();
        System.out.println("enter no of books to be inserted:");
        n=sc.nextInt();
        for(int i=1;i<=n;i++)
            l.add();
        l.sort();
    }
}