package deque;

import java.util.ArrayList;
import java.util.List;

public class ArrayDeque<T> implements Deque<T> {
    private T[] list = (T[]) new Object[8];
    private int first;
    private int last;
    private int size;

    public static void main(String[] args) {

    }

    public ArrayDeque() {
        first = 0;
        last = 0;
        size = 0;
    }

    public void resize(int cap) {

        T[] nArr = (T[]) new Object[cap];
        for (int x = 0; x < this.size; x++) {
            nArr[x] = list[(first + x) % list.length];
        }

        first = 0;
        last = size;
        list = nArr;
    }

    @Override
    public void addFirst(T x) {
        if (size == list.length) {
            resize(size * 2);
        }
        first = (first - 1 + list.length) % list.length;
        list[first] = x;
        size++;
    }
    @Override
    public void addLast(T x) {
        if (size == list.length) {
            resize(size * 2);
        }

        list[last] = x;
        last = (last + 1) % list.length;
        size++;
    }


    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        T item = list[first];
        list[first] = null;
        first = (first + 1) % list.length;
        size--;

        if (size > 0 && size == list.length / 4) {
            resize(list.length / 2);
        }

        return item;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }

        last = (last - 1 + list.length) % list.length;
        T item = list[last];
        list[last] = null;
        size--;

        if (size > 0 && size == list.length / 4) {
            resize(list.length / 2);
        }

        return item;
    }
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        return list[(first + index) % list.length];
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public List<T> toList() {
        List<T> listArr = new ArrayList<>(size);

        for (int x = 0; x < this.size; x++) {
            listArr.add(list[(first + x) % list.length]);
        }
        return listArr;
    }

    @Override
    public T getRecursive(int Index){
        return null;
    }

}
