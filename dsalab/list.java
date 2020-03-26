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
		System.out.print(data);
	}
}
class Linklist//LINKED LIST
{
	private Link first;
	public Linklist()
	{
		first=null;
	}
	public boolean isempty()
	{
		if(first==null)
			return true;
		else
			return false;
	}
	public void insertbeg(int d)//INSERT NEW NODE AT FIRST
	{
		Link newlink = new Link(d);
		newlink.next=first;
		first=newlink;
	}
	public void insertend(int d)//INSERT NEW NODE AT LAST
	{
		Link newlink = new Link(d);
		Link cur=first;
		while(cur.next!=null)
		{
			cur=cur.next;
		}
		cur.next=newlink;
	}
	public void deletekey(int key)//DELETE NODE WITH KEY
	{
		Link current=first;
		Link prev=first;
		while(current.data!=key)
		{
			if(current.next==null)
			{
			}
			else
			{
				prev=current;
				current=current.next;
			}
		}
		System.out.println("Data in the deleted node is ");
		current.display();
		if(current==first)
			first=first.next;
		else
			prev.next=current.next;	
	}
	public void deletepos(int pos)// DELETE NODE AT POSITION
	{
		Link ptr=first;
		Link prev=first;
		int count=1;
		while(count!=pos)
		{
			count++;
			prev=ptr;
			ptr=ptr.next;
		}
		if(count!=1)
			prev.next=ptr.next;
		else
			first=first.next;
	}
	public void displaylist()//DISPLAY FULL LIST
	{
		Link cur=first;
		while(cur!=null)
		{
			cur.display();
			System.out.print(" ");
			cur=cur.next;
		}
		System.out.print("\n");
	}
}
class list
{
	public static void main(String args[])throws IOException
	{
		int n,x,flag=-1;
		Linklist ls = new Linklist();//CREATED A LINKED LIST
		
		while(flag!=0)
		{
			System.out.println("\n"+"Enter any option given below..."+"\n"+"---");
			System.out.println("1.Insert beginning");
			System.out.println("2.Insert end");
			System.out.println("3.Delete with key");
			System.out.println("4.Delete with position");
			System.out.println("5.Display full list");
			System.out.println("6.Exit"+"\n"+"---");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			n=Integer.parseInt( br.readLine() );
			System.out.println("---");
			switch(n)
			{
				case 1:	System.out.println("->Enter the data : ");
					x=Integer.parseInt( br.readLine() );
					ls.insertbeg(x);
					break;
					
				case 2:	System.out.println("->Enter the data : ");
					x=Integer.parseInt( br.readLine() );
					ls.insertend(x);
					break;
					
				case 3:	if(!ls.isempty())
					{		
						System.out.println("->Enter the key : ");
						x=Integer.parseInt( br.readLine() );
						ls.deletekey(x);
						break;
					}
					else
					{
						System.out.println("NO ELEMENT TO DELETE...");
						break;
					}
				
				case 4:	System.out.println("->Enter the position: ");
					x=Integer.parseInt( br.readLine() );
					ls.deletepos(x);
					break;
					
				case 5:	System.out.println("->Displaying the full list...");
					ls.displaylist();
					break;
					
				case 6: System.out.println("->Exiting...");
					flag=0;
					break;
					
				default:System.out.println("->INVALID ENTRY");
					break;
			}
		}
	}
}











