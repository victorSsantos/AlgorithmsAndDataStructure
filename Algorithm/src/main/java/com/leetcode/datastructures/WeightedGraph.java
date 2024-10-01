package com.leetcode.datastructures;

import java.util.HashMap;
import java.util.Map;

public class WeightedGraph {

    private final String[] vertices;
    private final Map<String, Map<String, Integer>> edges;

    public WeightedGraph(String[] vertices) {

        this.vertices = vertices;
        this.edges = new HashMap<>();

        for(String vertex : vertices)
            edges.put(vertex, new HashMap<>());
    }

    public  void addEdge(String from, String to, int cost){
        addEdge(from, to, cost, false );
    }

    public void addEdge(String from, String to, int cost, boolean isUndirected ){

        edges.get(from).put(to, cost);

        if(isUndirected)
            edges.get(to).put(from, cost);
    }

    public String[] getVertices() {
        return vertices;
    }

    public Map<String,Map<String,Integer>> getEdges() {
        return edges;
    }

    public void print() {
        for (String vertex : vertices) {
            System.out.println("vertice: " + vertex);
            var edge = edges.get(vertex);
            edge.forEach((neightboor,cost) ->{
                System.out.println("  " + neightboor + " - " + cost);
            });
        }
    }
}
