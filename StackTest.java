import java.util.Stack;
public class StackTest {
    public static void main(String[] args) {
        Stack a = new Stack();
        // Queue q = new LinkedList();
        a.push('R');
        a.push('a');
        a.push('c');
        a.push('e');
        a.push('c');
        a.push('a');
        a.push('r');
        System.out.println("Size : " + a.size());
        while(!a.isEmpty()) {
            System.out.println(a.pop());
        }
    }
}
