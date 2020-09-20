import java.util.Stack;

public class FixedStack<T> extends Stack<T> {

    private final int maxSize;

    public FixedStack(int maxSize) {
        super();
        this.maxSize = maxSize;
    }

    @Override
    public T push(T object) {
        //If the stack is too big, remove elements until it's the right size.
        while (this.size() >= maxSize) {
            this.remove(0);
        }
        return super.push(object);
    }


    public static void main(String[] args) {
        FixedStack<Integer> stack = new FixedStack<>(2);
        System.out.println(stack);
    }
}

