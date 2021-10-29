package bai11_DSA_Stack_queue.thuc_hanh.Trien_Kai_Stack_Su_Dung_Lop_LinkedList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.LinkedList;
    public class MyGenericStack<T> {
        private LinkedList<T> stack;

        public MyGenericStack() {
            stack = new LinkedList();
        }
        public void push(T element) {
            stack.addFirst(element);
        }
        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return stack.removeFirst();
        }
        public int size() {
            return stack.size();
        }
        public boolean isEmpty() {
            if (stack.size() == 0) {
                return true;
            }
            return false;
        }
    }
