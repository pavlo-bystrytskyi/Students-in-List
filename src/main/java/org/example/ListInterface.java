package org.example;

public interface ListInterface<T> {
    public void add(T item);

    public T get(int index);

    public void remove(int index);

    public void removeLast();

    public int size();
}
