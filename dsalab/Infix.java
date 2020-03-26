/*
Abraham George Thankachan
CS A
Roll No 6 
*/
import java.io.*;
import java.lang.String;
class Infix
{
 char []a;
 int top;
 Infix(int len)
 	{ 
 	 a=new char[len];
 	 top=-1;
 	}
 
 void push(char c)
 {
    top++;
    a[top]=c;
 }
 
 char pop()
 {
  if(top>-1)
 	 {
	return(a[top--]);
  	 }
  else
   return ' ';
 }
 
 char topp()
 {
  return a[top];
 }
 
 boolean isempty()
 	{
  	if(top==-1)
  	return true;
  	else
  	return false;
 	}
 
 public static int priority(char c)
 {
  switch(c)
  {
    case '+':return 1;
    case '-':return 1;
    case '*':return 2;
   	case '/':return 2;
    case '$':return 3;
  }
  return 0;
 }
 
 public static void main(String args[]) throws IOException
 {
  String s;
  System.out.println("Enter the expression for conversion:");
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  s=br.readLine();
  int len;
  len=s.length();
  Infix st=new Infix(len);
  
  String exp=" ";
  for(int i=0;i<len;i++)
  {
   char c;
   c=s.charAt(i);
   if(c=='(')
   	 {
   	 st.push(c);
  	 }
   else if(c=='+'||c=='-'||c=='*'||c=='/'||c=='$')
 {
    if(st.isempty())
    {
	st.push(c);
    }
    else if(priority(c)<=priority(st.topp()))
    {
	 exp=exp+st.pop();
     st.push(c);
    }
    else
    {
     st.push(c);
    }
 } 
 else if(c==')')
   {
    while(st.topp()!='(')
    {
     exp=exp+st.pop();
    }
    st.pop();
   }
 else
   {
	exp=exp+c;
   }
  }
 while(!st.isempty())
 	 {
   	exp=exp+st.pop();
  	}
 	 System.out.println(exp);
 }
}
/*Enter the expression for conversion:
a*b+c/d
 ab*cd/+

*/
