package question1;

import java.util.Scanner;



public class contacts {
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[])
    {
        int n;
        contact ob=new contact();
        char c='y';
        do
        {
            System.out.println("1 give misscall\n2 show misscalls\nSELECT your choice:");
            n=sc.nextInt();
            switch(n)
            {
            case 1:ob.give_misscall();
                break;
            case 2: if(ob.check())
                    System.out.println("no misscalls.");
                    else    
                    {    int i=0,f;
                        char choice='y';
                        do
                        {
                            if(ob.check())
                                System.out.println("no misscalls.");
                            else
                            {
                                ob.show(i);
                                System.out.println("1.delete call 2.next misscall 3.show details \n select your choice:");
                                f=sc.nextInt();
                                switch(f)
                                {
                                case 1:ob.delete(i);
                                    break;
                                case 2:i+=1;
                                    ob.show(i);
                                    break;
                                case 3:ob.showall(i);
                                    break;
                                default:System.out.println("wrong choice.");
                                }
                            }
                            System.out.println("try again [y/n]:");
                            choice=sc.next().charAt(0);
                        }while(choice=='Y' || choice=='y');
                    }
                break;
            default:System.out.println("wrong choice.");
                break;
            }
            System.out.println("TRY again [y/n]:");
            c=sc.next().charAt(0);
        }while(c=='y' || c=='Y');
    }
}
