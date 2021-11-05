package bai10_Danh_Sach.bai_tap.LinkedList;

public class MyLinkedList<E> {
    private int numNodes = 0;
    private Node head;
    public MyLinkedList() {
    }
    public MyLinkedList(E element) {
        head = new Node(element);
    }
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return this.data;
        }
    }
    public void add(int index, E element) {
        Node temp = head;

        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        Node after = temp.next;
        temp.next = new Node(element);
        temp.next.next = after;
        numNodes++;
    }
    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }
    public void addLast(E element) {
        //Node temp = head;
        if (head == null)
            addFirst(element);
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = new Node(element);

        }
    }
    public void remove (int index){
        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }
        numNodes--;
    }
    

}
