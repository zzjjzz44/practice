public class LinkL {
    Node head;
    Node current;
    public void insert1(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insert2(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            current=newNode;
        } else {
            current.next = newNode;
            current=newNode;}
        }
}

