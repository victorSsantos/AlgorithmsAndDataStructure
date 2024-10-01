package com.leetcode.datastructures;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Graph {

    private int vertices;
    private final List<List<Integer>> edges;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.edges = new LinkedList<>();

        for(var i = 0; i < vertices ; i++)
            this.edges.add(new LinkedList<>());
    }

    public  void addEdge(int from, int to){
        addEdge(from, to, false );
    }

    public void addEdge(int from, int to, boolean isUndirected ){
        edges.get(from).add(to);
        if(isUndirected) edges.get(to).add(from);
    }

    public int getVertices() {
        return vertices;
    }

    public void setVertices(int vertices) {
        this.vertices = vertices;
    }

    public List<List<Integer>> getEdges() {
        return edges;
    }

    public void print() {
        for(var i = 0 ; i < vertices ; i++ ) {
            System.out.println("vertice: " + i);
            var vertice = edges.get(i);
            if(vertice!=null)
                System.out.println(vertice.stream().map((Object::toString)).collect(Collectors.joining(",")));
            System.out.println();
        }
    }
}
