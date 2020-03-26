//ALEN PAUL SONI
//CS A 14

import java.io.*;

class stack
{
	int size;
	int top;
	char [] a;
	stack(int n)
	{
		top=-1;
		size=n;
		a=new char[size];
	}
	public boolean push(char x)
	{
		if(top>=size)
		{
			System.out.println("Stack Overflow");
			return false;
		}
		else
		{
			a[++top]=x;
			return true;
		}
	}
	public char pop()
	{
		if(top<0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		else
		{
			char x=a[top--];
			return x;
		}
	}
}

class reverse
{
	public static void main(String args[])throws IOException
	{
		String s;
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the string:");
		s=br.readLine();
		n=s.length();
		stack st=new stack(n);
		for(int i=0;i<n;i++)
		{
			st.push(s.charAt(i));
		}
		System.out.println("Reversed string is:");
		for(int i=0;i<n;i++)
		{
			System.out.print(st.pop());
		}
		System.out.print("\n");
	}
}

/*
OUTPUT
Enter the string:
alen paul
Reversed string is:
luap nela
*/










	
	
	
	
