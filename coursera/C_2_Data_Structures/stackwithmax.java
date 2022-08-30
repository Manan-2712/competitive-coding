package coursera.C_2_Data_Structures;
import java.util.*;
import java.io.*;
class pair{
    int n ;
    int max ;
  
}
public class stackwithmax{
static Stack<pair>stack= new Stack<>();
public static void  push(int n ){

if(stack.isEmpty()){
    pair p = new pair();

p.n=n;
p.max=n;
//System.out.println("max when is empty "+ p.max);
stack.push(p);
//System.out.println("top is "+ p.max);
}else{
    pair p = new pair();

    p.n=n;
    p.max= Math.max(stack.peek().max,n);
   // System.out.println("max when not empty "+ p.max);
    stack.push(p);
   // System.out.println("top is "+p.max);
}
}
public static void  pop(){
    if(stack.isEmpty()){
      return; 
    }
//    int n = stack.peek().n;    
 stack.pop();


}
public static int max(){
    if(stack.isEmpty()){
        return -1;
    }
return stack.peek().max;
}
public static void main(String []args){
    Scanner sc = new Scanner(System.in);
    int queries = sc.nextInt();
    for(int i=0;i<queries;i++){
       // System.out.println("value of i "+i);
        String query= sc.next();
        if("push".equals(query)){
          int n = sc.nextInt();
          push(n);
        }
       else if("pop".equals(query)){
           pop();
        }
        else if("max".equals(query)){
         System.out.println(max());
        }
        
    }
}
}
