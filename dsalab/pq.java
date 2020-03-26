import java.io.*;
class Link
{
    public int data;
    public Link next;
    public Link(int d)
    {
        data=d;
        next=null;
    }
    public void display()
    {
        System.out.println(data+" ");
    }

}

class LinkList
{
    private Link first;
    public LinkList()
    {
        first=null;
    }
    public void insert(int d)
    {
        Link newlink=new Link(d);
        Link curr=first;
        System.out.println("AAA");
        if(curr!=null)
        {
            while(curr.next!=null)
            {
                curr=curr.next;
            }
            curr.next=newlink;
        }
        else//NO ELEMENTS
        {
            first=newlink;
        }
    }
    public void display()
    {
        Link curr=first;
        if(curr!=null)
        {
            while (curr!=null)
            {
               curr.display();
               curr=curr.next;
            }
            return ;
        }
        else
        {
            System.out.println("No queue");
            return ;
        }
    }
    public void delete()
    {
        if(first!=null)
        {
            System.out.println("Deleted element is ");
            first.display();
            first=first.next;
        }
        else
        {
            System.out.println("No queue");
            return ;
        }
    }
}

class pq
{
    public static void main(String args[])throws IOException
    {
        LinkList pq =new LinkList();
        int v,o,flag=-1;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(flag!=0)
        {
            System.out.println("1.Insert\n2.Delete\n3.Display\n4.Exit");
            o=Integer.parseInt(br.readLine());
            switch(o)
            {
                case 1  :   System.out.println("Insert the value : ");
                            v=Integer.parseInt(br.readLine());
                            pq.insert(v);
                            break;
                case 2  :   pq.delete();
                            break;
                case 3  :   pq.display();
                            break;
                case 4  :   System.out.println("EXITING...");
                            flag=0;
                            break;
                default :   System.out.println("INVALID ENTRY");
                            break;
            }
        }
    }
}
