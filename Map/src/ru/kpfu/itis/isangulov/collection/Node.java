package ru.kpfu.itis.isangulov.collection;

public class Node <K, V> {
    private K key;
    private V value;
    private Node next;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;
        this.next=null;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public K getKey() {

        return key;
    }

    public V getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }
}
