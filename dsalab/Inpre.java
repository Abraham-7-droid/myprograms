//Abraham George Thankachan
//CS A
//Roll No 6

import java.io.*;
import java.lang.String;
class Inpre
{
 char []a;
 int top;
 Inpre(int len)
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
  Inpre st=new Inpre(len);


String x="";
char ch;
// reversin expression
Inpre  sp=new Inpre(len);
	for(int k=0;k<len;k++)
	{	
	sp.push(s.charAt(k));
	}
	
	for(int k=0;k<len;k++)
	{
	x=x+sp.pop();
	}
//System.out.println(x);

//postfix of the reversed expression
String exp="";
  for(int i=0;i<len;i++)
  {
   char c;
   c=x.charAt(i);
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
//System.out.println(exp);
//reverse of the postfix
String a = "";
Inpre  wt=new Inpre(exp.length());
	for(int k=0;k<exp.length();k++)
	{	
	wt.push(exp.charAt(k));
	}
	
	for(int k=0;k<exp.length();k++)
	{
	 a=a+wt.pop();
	}
System.out.println(a);

}
}
/*Enter the expression for conversion:
a*b+c/d
+*ab/cd*/
