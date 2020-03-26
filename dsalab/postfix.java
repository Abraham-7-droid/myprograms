//ALEN PAUL SONI
//CS A 14

import java.io.*;

class stack
{
	int size;
	int top;
	char [] a;
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
	public void delete()
	{
		top=top-1;
	}
	
	public char peek()
	{
		if(top<0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		else
		{
			char x=a[top];
			return x;
		}
	}
}

class postfix
{
	public static int prio(char c)
	{
		switch(c)
		{
			case '+':case'-':
			return 1;
			case '*':case '/':
			return 2;
			case '$':
			return 3;
			default:return -1;
		}
	}
	public static boolean isoprtr(char c)
	{
		if(c=='+'||c=='/'||c=='-'||c=='*'||c=='$')
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
		String s,postfix;
		postfix="";
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the infix expression:");
		s=br.readLine();
		n=s.length();
		stack op=new stack(n);
		for(int i=0;i<n;i++)
		{
			char l=s.charAt(i);
			if(l=='+'||l=='/'||l=='*'||l=='-'||l=='('||l==')')
			{
				if(op.empty())
					op.push(l);
				else
				{
					if(l=='(')
						op.push(l);
					else if(l=='+'||l=='-'||l=='*'||l=='/')
					{
						if(op.peek()=='(')
							op.push(l);
						else
						{
							if(prio(l) > prio(op.peek()))
								op.push(l);
							else
							{
								postfix=postfix+op.pop();
								op.push(l);
							}
							
						}
					}
					else
					{
						while(op.peek()!='(')
							postfix=postfix+op.pop();
						op.pop();
					}
				}
			}
			else
				postfix=postfix+l;
		}
		while(!op.empty())
		{
			postfix=postfix+op.pop();
		}
		System.out.println("Postfix Expression : "+postfix+"\n");
	}
}

/*
OUTPUT
Enter the infix expression:
a*(b+c)
Postfix Expression : abc+*
*/











	
	
	
	
