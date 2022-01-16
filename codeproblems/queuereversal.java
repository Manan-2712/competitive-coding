package codeproblems;
import java.util.Queue;
public class queuereversal {
  //  import java.util.Queue;

    public static void reverse(Queue < Integer > q) {
        if(q.isEmpty()){
            return;
        }
        //  Queue<Integer>q = new LinkedList<>();
          int n = q.size();
    //    for(int i=0;i<n;i++){
           int temp = q.peek();
            q.remove();
            reverse(q);
            q.add(temp);
       // }
    }
}
