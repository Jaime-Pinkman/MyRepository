package ru.kpfu.itis.isangulov.collection;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashMap <String, Integer>  hashMap = new HashMap<>();
        hashMap.add(new Node("Marsel", 24));
        hashMap.add(new Node("Maxim", 19));
        hashMap.add(new Node("Guzel", 19));
        hashMap.add(new Node("Ilnur", 18));
        hashMap.add(new Node("Azat", 18));
        hashMap.add(new Node("Marat", 18));
        hashMap.add(new Node("Samat", 17));
        Node node = hashMap.get("Samat");
        System.out.println("fefw".hashCode());
    }
}
