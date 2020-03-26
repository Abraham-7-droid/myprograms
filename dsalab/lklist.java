import java.io.*;
class node
{
 int data;
 node next;
 
 node(int d)
 {
  data=d;
  next=null;
 }
 
 public void display()
 {
  System.out.println(data);
 }
/*public void display()
{
       System.out.println(data);
}
*/
}









class linkedlist
{ 
 public node first;
 public node current;
 public node prev;
 
 linkedlist()
 {
  first=null;
  current=null;
  prev=null;
 }
 
 public void insertfirst(int d)
 {
  node newnode=new node(d);
  if(first==null)
  {first=newnode;
  }
  else
  {newnode.next=first;
   first=newnode;
  }
 }
 
 public void insertlast(int d)
 {current=first;
  node newnode=new node(d);
  if(first==null)
  {first=newnode;
  }
  else
  {
   while(current.next!=null)
   {current=current.next;
   }
   current.next=newnode;
  }
 }
 
 
 public void deletekey(int key)
 {prev=null;
  current=first;
  while(current!=null)
  {
   if(current.data==key)
   {break;
   }
   prev=current;
   current=current.next;
  }
  
  if((current==null)||(current.data!=key))
  {System.out.println("node not found");
  }
  else if((prev==null))
  {
   first=first.next;
  }
  else
  {
   prev.next=current.next;
  }
 }

 public void deletepos(int p)
 {current=first;
  prev=null;
  for(int i=1;i<p;i++)
  {prev=current;
   current=current.next;
   if(current==null)
   {return;
   }
  }
  if(current==first)
  {
   first=first.next;
  }
  else
  {prev.next=current.next;
  }
 }

 public void displaylist()
 {current=first;
  while(current!=null)
  {
   current.display();
   current=current.next;
  }
 }

}










class lklist
{
 public static void main(String args[]) throws IOException
 {linkedlist obj = new linkedlist();
 int s;
 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  obj.first=null;
  int cont=0;
  
  do
  {
  
  System.out.println("\n Enter which operation to perform:\n 1.Insert at first\n 2.Insert at last\n 3.Delete using key\n 4.Delete using position\n 5.Display the list");
  int choice;
  choice=Integer.parseInt(br.readLine());
  switch(choice)
  { case 1:
	  System.out.println("\n Enter data:");
	  s=Integer.parseInt(br.readLine());
	  obj.insertfirst(s);
	  break;
	  
	  
    case 2:
           System.out.println("\n Enter data:");
	  s=Integer.parseInt(br.readLine());
	  obj.insertlast(s);
	  break;
	  
    case 3:
            System.out.println("\n Enter key:");
	  s=Integer.parseInt(br.readLine());
	  obj.deletekey(s);
	  break;
	  
    case 4:
            System.out.println("\n Enter positon:");
	  s=Integer.parseInt(br.readLine());
	  obj.deletepos(s);
	  break;
	  
    case 5:
           System.out.println("\n list");
           obj.displaylist();
           break;
    
    default:System.out.println("\n Wrong input!!");
  }
  System.out.println("\n Do you want to continue?");
  cont=Integer.parseInt(br.readLine());
  
  }while(cont==1);
  System.out.println("\n list");
  obj.displaylist();
  
 }
}
