package question1;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class contact{
    Scanner sc=new Scanner(System.in);
    
    private HashMap<Integer,String>hm=new HashMap<Integer,String>();
    private LinkedList<misscall>call=new LinkedList<misscall>();
    private int count=0;
    private misscall ob;
    
    
    contact()
    {   hm.put(99003178,"Shubhang");
        hm.put(81045290,"Abhishek");
        hm.put(81045291,"Mandal");
        hm.put(81045214,"Ashmit");
        hm.put(81045215,"Anand");
        hm.put(81045216,"Sunny");
        hm.put(81045217,"Sahil");
        hm.put(81045218,"Rohan");
        hm.put(81045219,"Vikash");
    }
    
    void give_misscall()
    {
        Integer n;
        Calendar c=Calendar.getInstance();
        System.out.println("enter number to give misscall:");
        n=sc.nextInt();
        Date d = c.getTime();
        if(hm.containsKey(n))
            ob=new misscall(d,n,hm.get(n));
        else
            ob=new misscall(d,n,"PRIVATE NUMBER");
        
        if(count<10)
            call.add(count,ob);
        else
            call.set(count%10,ob);
        count+=1;
    }
    void show(int i)
    {
        if(call.size()<i+1)
            System.out.println("no further misscalls");
        else
        {
            misscall a=call.get(i);
            System.out.println(a.no+" gave you a misscall");
        }
    }
    void showall(int i)
    {
        //ListIterator<misscall> l =call.listIterator();
        //while(l.hasNext())
        //{
            misscall a=call.get(i);
            if(a.name!="PRIVATE NUMBER")
                System.out.println(a.name+" has called at "+a.time);
            else
                System.out.println("PRIVATE NUMBER"+" "+a.no+" has called at "+a.time);
            //System.out.println();
            
        //}
    }
    
    void delete(int i)
    {
        //int i=call.indexOf(ob);
        if(call.size()==0)
            System.out.println("no miscalls");
        else
        {
            call.remove(i);
            count-=1;
            System.out.println("deleted successfully.");
        }
    }
    
    void delete_no(Integer n)
    {
        int i;
        for(i=0;i<call.size();i++)
        {
            misscall ob=call.get(i);
            if(ob.no==n)
                break;
        }
        call.remove(i);
    }
    
    boolean check()
    {
        if(call.size()==0)
            return true;
        else
            return false;
    }
}