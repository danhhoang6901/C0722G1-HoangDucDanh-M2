package ss10_dsa.exercise;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("Capacity: " + capacity);
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        size = 0;
        Arrays.fill(elements, null);
    }

    public void add(E element) {
        if (size == elements.length) {
            this.ensureCapacity(3);
        }
        elements[size] = element;
        size++;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    public void add(int index, E element) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (size == elements.length) {
            this.ensureCapacity(3);

        }
        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(element)) {
                return i;
            }
        }
        return index;
    }

    public boolean contains(E element) {
        return this.indexOf(element) >= 0;
    }

    public MyList<E> clone() {
        MyList<E> v = new MyList<>();
        v.elements = Arrays.copyOf(this.elements, this.size);
        v.size = this.size;
        return v;
    }

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new IllegalArgumentException("Error index: " + index);
        }
        E element = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return element;
    }
}
