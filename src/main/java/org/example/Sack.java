package org.example;

public class Sack<T> implements ListInterface<T> {
    private static final int DEFAULT_SIZE = 2;

    private int size;

    private int lastIndex = -1;

    private T[] storage;

    public Sack(int size) {
        this.storage = (T[]) new Object[size];
    }

    public Sack() {
        this(DEFAULT_SIZE);
    }

    public void add(T item) {
        if (this.isStorageFull()) {
            this.expandStorage();
        }
        this.lastIndex++;
        this.storage[lastIndex] = item;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        return this.storage[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        T[] newStorage = (T[]) new Object[this.size];
        for (int i = 0; i < index; i++) {
            newStorage[i] = this.storage[i];
        }
        for (int i = index; i < this.lastIndex; i++) {
            newStorage[i] = this.storage[i + 1];
        }
        this.storage = newStorage;
        this.lastIndex--;
    }

    public void removeLast() {
        T[] newStorage = (T[]) new Object[this.size];
        for (int i = 0; i < this.size - 1; i++) {
            newStorage[i] = this.storage[i];
        }
        this.storage = newStorage;
        this.lastIndex--;
    }

    private void expandStorage() {
        int newSize = this.size == 0 ? 1 : this.size * 2;
        T[] newStorage = (T[]) new Object[newSize];
        System.arraycopy(this.storage, 0, newStorage, 0, this.size);
        this.storage = newStorage;
        this.size = newSize;
    }

    public int size() {
        return this.lastIndex + 1;
    }

    private boolean isStorageFull() {
        return this.size == lastIndex + 1;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Sack [");
        for (int i = 0; i < this.lastIndex + 1; i++) {
            builder.append(this.storage[i].toString());
            if (i != this.lastIndex) {
                builder.append(", ");
            }
        }
        builder.append("]");

        return builder.toString();
    }
}
