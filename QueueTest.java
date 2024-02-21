import java.util.LinkedList;
import java.util.Queue;
public class QueueTest {
    public static void main(String[] args) {
        // Stack a = new Stack();
         Queue q = new LinkedList();
        q.add('R');
        q.add('a');
        q.add('c');
        q.add('e');
        q.add('c');
        q.add('a');
        q.add('r');
        System.out.println("Size : " + q.size());
        while(!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}
