package com.leetcode.datastructures;

import java.util.LinkedList;
import java.util.List;

public class Queue {

    private final List<Integer> values = new LinkedList<>();

    public void enqueue(int n){
        values.addFirst(n);
    }

    public int dequeue(){
        var dequeued = values.getLast();
        if(!values.isEmpty())
            values.removeLast();

        return dequeued;
    }

    public boolean isEmpty(){
        return values.isEmpty();
    }

    public List<Integer> getValues() {
        return values;
    }
}
