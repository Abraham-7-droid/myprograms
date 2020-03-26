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
       System.out.println(data +"is me");
}
}
class llist
{
public static void main (String args[]) throws Exception
{

 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 int s;
System.out.println("Enter the data");

s=Integer.parseInt(br.readLine());
node obj =new node(s);
System.out.println(s +"is");
//obj.node(s);
//obj.node();
obj.display();
}

}