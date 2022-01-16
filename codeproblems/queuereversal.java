package codeproblems;

import java.util.Queue;

public class queuereversal {

  public static void reverse(Queue<Integer> q) {
    if (q.isEmpty()) {
      return;
    }

    int n = q.size();

    int temp = q.peek();
    q.remove();
    reverse(q);
    q.add(temp);

  }
}
