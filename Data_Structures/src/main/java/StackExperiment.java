import java.util.Stack;

public class StackExperiment {

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        for(int i = 2; i < 9; i++) {
            st.push(i);
        }

        System.out.println(st.peek());
        System.out.println(st.pop());

        System.out.println(st.peek());
        while(!st.empty()) {
            System.out.println(st.pop());
        }

//        System.out.println(st.peek());
    }
}
