package com.leetcode;

import com.leetcode.datastructures.HashTable;

public class Main {
    public static void main(String[] args) {

        /*
        WeightedGraph g1 = new WeightedGraph(new String[]{"A","B","C","D","E","F"});

        g1.addEdge("A", "B", 5, true);
        g1.addEdge("A", "D", 12, true);
        g1.addEdge("B", "C", 1, true);
        g1.addEdge("B", "E", 3, true);
        g1.addEdge("C", "D", 4, true);
        g1.addEdge("C", "E", 1, true);
        g1.addEdge("C", "F", 2, true);
        g1.addEdge("D", "F", 1, true);
        g1.addEdge("E", "F", 2, true);

        g1.print();

        Search search = new Search();
        var result = search.dijkstraSearch(g1.getVertices()[0],g1);
        */

        HashTable<Integer, String> table = new HashTable<>(6);

        table.put(11, "São Paulo");
        table.put(12, "Ubatuba");
        table.put(13, "Rio de Janeiro");
        table.put(14, "Belo Horizonte");
        table.put(21, "Santa Catarina");
        table.put(22, "Bahia");
    }
}