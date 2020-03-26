//Abraham George Thankachan
//CS A
//Roll No 6

import java.io.*;
import java.lang.*;

class Stack
{	char []arr;
	int size;
	int  top;
	Stack(int n)
	{

size=n;
top=-1;
arr= new char [size];


    }
public void push (char a)
{
	if(top >=size-1)
	{
		System.out.println("Stack overflow");
	
	}
	else
	{
		arr[++top]=a;
	}
}	
		

public char pop()
{
	if(top<=-1)
	{
	System.out.println("Stack overflow");
	return '0';
    }
	else
	{
	return arr[top--];
	}

}	


}

class Reverse
{
	public static void main(String args[])throws IOException
{	String s;
    int l;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	System.out.println("Enter the string");
	s=br.readLine();
	System.out.println(" The entered string is:\n" +s);

	l=s.length();
	//System.out.println("Length of the string is ="+l);

	Stack  st=new Stack(l);
	for(int k=0;k<l;k++)
	{	
	st.push(s.charAt(k));
	}
	System.out.println("\n\n Reversed string is : \n");
	for(int k=0;k<l;k++)
	{
	System.out.println(st.pop());
	}

System.out.println("\n");

}
}

/*
Enter the string
Abraham
 The entered string is:
	Abraham
 Reversed string is : 
m
a
h
a
r
b
A

*/	







