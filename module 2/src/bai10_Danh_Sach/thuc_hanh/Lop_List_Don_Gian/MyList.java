package bai10_Danh_Sach.thuc_hanh.Lop_List_Don_Gian;

import java.util.Arrays;

public class MyList<T> {
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private T[] elements;

    public MyList() {
        elements = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(T element) {
        if (size == elements.length) {
            ensureCapacity();
        }
        // Thêm phần tử element vào cuối danh sách (mảng)
        elements[size] = element;
        // Tăng độ dài của danh sách lên 1;
        size++;
    }

    public T get(int i) {
        if (i >= 0 && i <= size) {
            return elements[i];
        }
        throw new IndexOutOfBoundsException("Index: " + i + ", Size " + (size - 1));
    }

    public int size() {
        return size;
    }
}
