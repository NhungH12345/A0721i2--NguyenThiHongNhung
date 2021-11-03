package bai10_Danh_Sach.bai_tap.ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] elements;

    public MyList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];//ép kiểu
    }
    public MyList(int capacity){
        elements = (E[]) new Object[capacity];
    }
    public void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E element) {
        if (size == elements.length) {
            ensureCapacity();
            elements[size] = element;
            // Tăng độ dài của danh sách lên 1;
            size++;
        }
    }
    public boolean add (E element ,int index){
            if (index >= 0 && index <= size) {
                size++;
               ensureCapacity();
                for (int i = size - 2; i >= index; i--) {
                    elements[i + 1] = elements[i];
                }
                elements[index] = element;
                return true;
            }
            return false;
        }
    public E get(int i) {
        if (i >= 0 && i <= size) {
            return elements[i];
        }
        return null;
    }
    public int size() {
        return this.size;
    }
    public boolean remove(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size = size - 1;
            return true;
        }
        return false;
    }
    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }
    public int indexOf(E element) {
            int index = -1;
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(element)) {
                    return i;
                }
            }
            return index;
        }
    public boolean contains(E  element) {
        for (E x : elements) {
            if (element.equals(x)) {
                return true;
            }
        }
        return false;
    }
}
