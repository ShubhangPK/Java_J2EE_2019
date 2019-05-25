package question2;

class book implements Comparable<book>
{
    String title,author,publisher;
    Integer price;
    public int compareTo(book o)
    {
        return price.compareTo(o.price);
    }
    public String toString()
    {
        return("title:"+title+" author:"+author+" publisher:"+publisher+" price:"+price+"\n");
    }
}