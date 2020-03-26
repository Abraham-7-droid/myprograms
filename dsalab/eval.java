//ALEN PAUL SONI
//CS A 14

import java.io.*;

class stack
{
	int size;
	int top;
	int [] a;
	public	boolean empty()
	{
		if(top==-1)
			return true;
		else
			return false;
	}
	stack(int n)
	{
		top=-1;
		size=n;
		a=new int[size];
	}
	public boolean push(int x)
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
	public int pop()
	{
		if(top<0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		else
		{
			int x=a[top--];
			return x;
		}
	}
}

class eval
{
	public static boolean isoprtr(int c)
	{
		if(c=='+'||c=='/'||c=='-'||c=='*')
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static void main(String args[])throws IOException
	{
		System.out.println("Enter the postfix expression to be evaluated : ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String post;
		post=br.readLine();
		int n;
		n=post.length();
		stack st=new stack(n);
		int value=0;
		for(int i=0;i<n;i++)
		{
			char c=post.charAt(i);
			if(isoprtr(c))
			{
				int x=st.pop();
				int y=st.pop();
				if(c=='+')
					st.push(y+x);
				else if(c=='-')
					st.push(y-x);
				else if(c=='*')
					st.push(y*x);
				else
					st.push(y/x);
			}
			else
			{
				int z=Character.getNumericValue(c);//Integer.parseInt(String.valueOf(c))
				st.push(z);
			}
		}
		value=st.pop();
		System.out.println("Postfix value is "+value);
	}
}

/*
OUTPUT
Enter the postfix expression to be evaluated : 
345*+
Postfix value is 23
*/













	
	
	
	
