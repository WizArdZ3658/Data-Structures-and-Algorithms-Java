import java.util.*;

public class QueueExperiment {

    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(11);
        for(int i = 2; i < 9; i++) {
            q.add(i);
        }
//        System.out.println(q.peek());
        while(!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }
}
