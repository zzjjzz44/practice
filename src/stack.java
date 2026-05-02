public class stack {
    int[] s;
    int top;
    int capacity;

    public stack(int capacity) {
        this.capacity = capacity;
        this.s = new int[capacity];
        this.top = -1;
    }

    public void push(int data) {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            return;
        }
        s[++top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return s[top--];
    }

    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return -1;
        }
        return s[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}
