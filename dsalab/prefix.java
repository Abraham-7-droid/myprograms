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

class prefix
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
		String s,postfix,reverse;
		postfix="";
		reverse="";
		int n;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the infix expression:");
		s=br.readLine();
		n=s.length();
		stack temp=new stack(n);//TEMPORARY STACK FOR REVERSING
		
		
		for(int i=0;i<n;i++)//PUSHING TO STACK 
		{
			temp.push(s.charAt(i));
		}
		int x;
		
		for(int i=0;i<n;i++)//REVERSING BY POPPING
		{
			if(temp.peek()=='(')
			{	
				x=temp.pop();
				reverse=reverse+')';
			}
			else if(temp.peek()==')')
			{
				x=temp.pop();
				reverse=reverse+'(';
			}
			else
			{
				reverse=reverse+temp.pop();	
			}
		}
		System.out.println("Reverse string : "+reverse);
		stack op=new stack(n);//STACK TO MAKE PREFIX

		for(int i=0;i<n;i++)
		{
			char l=reverse.charAt(i);
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
		String prefix;
		prefix="";
		n=postfix.length();
		for(int i=0;i<n;i++)//PUSHING TO STACK 
		{
			temp.push(postfix.charAt(i));
		}
		
		for(int i=0;i<n;i++)//REVERSING BY POPPING (post->pre)
		{
			prefix=prefix+temp.pop();
		}
		
		System.out.println("Prefix Expression : "+prefix+"\n");
	}
}

/*
OUTPUT
Enter the infix expression:
a*(b+c)
Reverse string : (c+b)*a
Prefix Expression : *a+bc
*/



