package bai10_Danh_Sach.thuc_hanh.Lop_List_Don_Gian;

public class Node {
    private Object data;
    private Node next;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }
}
