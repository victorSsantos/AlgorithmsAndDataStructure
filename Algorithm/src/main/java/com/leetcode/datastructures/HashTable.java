package com.leetcode.datastructures;

import java.util.LinkedList;

public class HashTable<K, V> {

    private int size;
    private final LinkedList<HashNode<K, V>>[] table;

    public HashTable(int size){
        this.size = size;
        table = new LinkedList[this.size];
        for(var i = 0 ; i < this.size ; i++)
            table[i] = new LinkedList<>();
    }

    private static class HashNode<K, V> {
        K key;
        V value;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getHash(K key) {
        return Math.abs(key.hashCode()) % size;
    }

    public void put(K key, V value){
        int index = getHash(key);
        LinkedList<HashNode<K,V>> chain = table[index];

        for(var node: chain)
            if(node.key.equals(key)){
                node.value = value;
                return;
            }

        chain.add(new HashNode<>(key, value));
    }

    public V get(K key){
        int index = getHash(key);
        LinkedList<HashNode<K,V>> chain = table[index];

        for(var node: chain)
            if(node.key.equals(key)) return node.value;

        return null;
    }

    public void remove(K key){
        int index = getHash(key);
        LinkedList<HashNode<K,V>> chain = table[index];

        HashNode<K,V> nodeToRemove = null;
        for(var node: chain)
            if(node.key.equals(key)){
                nodeToRemove = node;
                break;
            }

        if(nodeToRemove!=null)
            chain.remove(nodeToRemove);
    }
}
