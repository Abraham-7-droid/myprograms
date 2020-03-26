import java.io.*;
class Link//SINGLE NODE
{
	public int data;
	public Link next;
	public Link(int d)
	{
		data=d;
		next=null;
	}
	public void display()//DISPLAY VALUE
	{
		System.out.print(data+" ");
	}
}
class Linklist//LINKED LIST
{
	private Link last;
	public Linklist()//constructor
	{
		last=null;
	}
	public void insertQ(int d)//insert at last
	{
		Link newlink = new Link(d);
		if(last==null)//no queue
		{
			newlink.next=newlink;
			last=newlink;
		}
		else//elements exists
		{
			newlink.next=last.next;
			last.next=newlink;
			last=newlink;
		}
	}
	public void deleteQ()
	{
		if(last==null)//no list
		{
			System.out.println("Underflow...");
			return ;
		}
		else if(last.next==last)//1 element left
		{
			System.out.println("Deleted element is ");
			last.display();
			last.next=null;
			last=null;
			return ;
		}			
		else//elements exist
		{
			System.out.println("Deleted element is ");
			last.next.display();
			last.next=last.next.next;
			return ;
		}
		
	}
	public void displayQ()
	{
		if(last==null)
		{
			System.out.println("No elements in queue");
			return ;
		}
		else
		{
			Link current=last.next;
			while(current!=last)
			{
				current.display();
				current=current.next;
			}
			if(current==last)
			{
				current.display();
			}
			return ;
		}
	}
}
class cq
{
	public static void main(String args[])throws IOException
	{
		int option,v,flag=-1;
		Linklist ls = new Linklist();//CREATED A LINKED LIST
		
		while(flag!=0)
		{
			System.out.println("\nEnter any option given below...");
			System.out.println("1.Insert\n2.Delete\n3.Display list\n4.Exit");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			option=Integer.parseInt( br.readLine() );
			
			switch(option)
			{
				case 1	:	System.out.println("Enter the value to be inserted...");
						v=Integer.parseInt( br.readLine() );
						ls.insertQ(v);
						break;
				case 2	:	ls.deleteQ();
						break;
				case 3	:	ls.displayQ();
						break;
				case 4	:	flag=0;
						System.out.println("Exiting...");
						break;
				default	:	System.out.println("INVALID ENTRY...");
						break;
			}
		}
	}
}







