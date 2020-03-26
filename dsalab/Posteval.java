//Abraham George Thankachan
//CS A
//Roll No 6

import java.io.*;
import java.util.*;
class Stack{
    int top;
    int size;
    int a[];
    Stack(int n)
    {
        top=-1;
        size=n;
        a=new int [size];
    }
    boolean isEmpty()
    {
        if(top==-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    boolean isFull()
    {
        if(top==size-1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    void push(int x)
    {
        if(!isFull())
        {
            top++;
            a[top]=x;
        }
        else
        {
            System.out.println("stack is full");
        }
    }
    int pop()
    {
        int m;
        m=a[top];
        top--;
        return m;
    }
    int peek()
    {
        return a[top];
    }
    void eval(char z)
    {
        int h;
        int l;
         h=pop();
         l=pop();
        if(z=='+')
        {
         
           push(h+l);
         
        }
        else if(z=='-')
        {
           
            push(l-h);
        }
        else if(z=='/')
        {
           
            push(l/h);
        }
        else push(l*h);
       
    }
   
}
class Posteval{
    public static void main(String [] args)
    {
       System.out.println("Enter the expression");
        Stack s=new Stack(40);
        Scanner input=new Scanner(System.in);
        String b;
        String d="";
        char p;
        b=input.nextLine();
        int i;
        char g;
        int j;
        int k;
     
       
        for( i=0;i<b.length();i++)
        {
            g=b.charAt(i);
            if(Character.isDigit(g))
            {
                s.push(g-'0');
            }
        else
            {
            s.eval(g);
             
             
            }
        }
        System.out.println("OUTPUT:");
        while(!s.isEmpty())
        {
        System.out.print(s.pop());
        }
       
       
    }
   
}
/*Enter the expression
231*+9-
OUTPUT :
-4*/
	

