package question2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class library
{
    Scanner sc=new Scanner(System.in);
    ArrayList<book>l=new ArrayList<book>();
    ArrayList<book>l1=new ArrayList<book>();
    void add()
    {
        book ob=new book();
        System.out.println("enter title,author,publisher,price");
        ob.title = sc.nextLine();
        ob.author = sc.nextLine();
        ob.publisher = sc.nextLine();
        ob.price = Integer.parseInt(sc.nextLine());
        l.add(ob);
    }
    void sort()
    {
        System.out.println("before sorting:");
        for(book b:l)
        {
            System.out.println(b);
        }
        l1=l;
        Collections.sort(l1);
        System.out.println("after sorting:");
        for(book b:l1)
        {
            System.out.println(b);
        }
    }
}