package ru.kpfu.itis.isangulov.collection;

public class HashMap<K,V> implements Map{
    private Node[] hashmap = new Node[10];

    public void add(Node node) {
        int buf=0;
        buf=Math.abs(node.getKey().hashCode()%10);
        if(hashmap[buf]==null) {
            hashmap[buf] = node;
        }
        else {
            hashmap[buf].setNext(node);
        }
    }
    public Node get(K key) {
        /*for(int i=0; i<hashmap.length; i++) {

        }*/
        Node node = hashmap[key.hashCode()%10];
        if(node.getNext()==null) {
            return node;
        }
        else {
            //node.getNext()!=null || !
            while(!node.getKey().equals(key)) {
                node=node.getNext();
            }
            return node;
        }
    }
}
