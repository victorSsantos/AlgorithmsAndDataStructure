package com.leetcode.algorithms;

import com.leetcode.datastructures.Graph;
import com.leetcode.datastructures.Queue;
import com.leetcode.datastructures.WeightedGraph;

import java.util.*;

public class Search {

    //<editor-fold desc="LinearSearch">
    public int LinearSearch(int[] arr, int target){

        for(var index = 0; index <= arr.length - 1 ; index++){
            if(target == arr[index])
                return index;
        }
        return -1;
    }
    //</editor-fold>

    //<editor-fold desc="BinarySeach">
    public int BinarySeach(int[] arr,  int target){
        return BinarySeach(arr, target, 0, arr.length - 1 );
    }

    public int BinarySeach(int[] arr,  int target, int init, int end){

        while(init <= end){
            int middle = end/2;

            if(arr[middle] == target)
                return middle;

            if(arr[middle] < target)
                BinarySeach(arr, target, init = middle + 1 , end);
            else if(arr[middle] > target)
                BinarySeach(arr, target, init, end = middle - 1);
        }
        return -1;
    }
    //</editor-fold>

    //<editor-fold desc="BreathFirstSearch (BFS)">
    public void breathFirstSearch(int source, Graph graph){

        Queue queue = new Queue();
        queue.enqueue(source);

        Map<Integer,Integer> visitedNodes = new TreeMap<>() ;
        visitedNodes.put(source,0);

        System.out.println("vertice: " + source + " | " + 0 + ", " + null);

        while(!queue.isEmpty()){
            int previousNode = queue.dequeue();
            List<Integer> nextNodes = graph.getEdges().get(previousNode);

            if(!nextNodes.isEmpty()){
                int distance = visitedNodes.get(previousNode) + 1;

                for(int node: nextNodes){

                    if (!visitedNodes.containsKey(node) && !queue.getValues().contains(node)){

                        queue.enqueue(node);
                        visitedNodes.put(node,distance);

                        System.out.println("vertice: " + node + " | " + distance + ", " +  previousNode);
                    }
                }
            }
        }
    }
    //</editor-fold>

    //<editor-fold desc="DepthFirstSearch (DFS)">
    public List<Integer> depthFirstSearch(int source, Graph graph){

        var vertices = graph.getVertices();

        List<Integer> result = new ArrayList<>();
        boolean[] visiteds = new boolean[vertices];

        depthFirstSearch(source, graph, visiteds, result);

        return result;
    }

    public void depthFirstSearch(int actual, Graph graph, boolean[] visiteds, List<Integer> result) {

        visiteds[actual] = true;
        result.add(actual);
        List<Integer> nextNodes = graph.getEdges().get(actual);

        for(var node : nextNodes){
            if(!visiteds[node]) depthFirstSearch(node, graph, visiteds, result);
        }
    }
    //</editor-fold>

    //<editor-fold desc="Dijkstra Search">
    public Map<String,Object[]> dijkstraSearch(String source, WeightedGraph graph){

        Map<String, Object[]> result = new TreeMap<>();
        Set<String> visiteds = new HashSet<>();

        result.put(source, new Object[]{ 0, null });
        visiteds.add(source);
        var neighboors = graph.getEdges().get(source);

        for(var neightboor : neighboors.entrySet()) {
            result.put(neightboor.getKey(), new Object[]{ neightboor.getValue() , source });
            dijkstraSearch(neightboor.getKey(), graph, visiteds, result);
        }

        return result;
    }

    public void dijkstraSearch(String actual, WeightedGraph graph, Set<String> visiteds, Map<String,Object[]> result) {

        visiteds.add(actual);
        var neighboors = graph.getEdges().get(actual);

        for(var edge : neighboors.entrySet()){
            var neightboor = edge.getKey();

            if(!visiteds.contains(neightboor)){
                var cost = edge.getValue() + (int)result.get(actual)[0];

                if(result.containsKey(neightboor)) {
                    if ((int)result.get(neightboor)[0] > cost)
                        result.put(neightboor, new Object[]{cost, actual});
                }
                else result.put(neightboor, new Object[]{cost,actual});

                dijkstraSearch(neightboor, graph, visiteds, result);
            }
        }
    }
    //</editor-fold>

}


