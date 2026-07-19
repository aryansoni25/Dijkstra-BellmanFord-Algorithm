package org.studyeasy;

import java.util.*;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<WeightedNode>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbor : currentNode.neighbors) {
                if(queue.contains(neighbor)) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = (currentNode.distance + currentNode.weightMap.get(neighbor));
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print(" Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    public static void pathPrint(WeightedNode node) {
        if (node.parent  != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second,d);
    }

    void BellmanFord(WeightedNode node){
        node.distance=0;
        for(int i=0;i<nodeList.size();i++){
            for(WeightedNode current:nodeList){
                for(WeightedNode neighbor: current.neighbors){
                    if(neighbor.distance> current.distance+ current.weightMap.get(neighbor)){
                        neighbor.distance=current.distance+ current.weightMap.get(neighbor);
                        neighbor.parent=current;

                    }
                }
            }
        }
        System.out.println(" Checking for Negative Cycle . . .");
        for(WeightedNode current:nodeList){
            for(WeightedNode neighbor: current.neighbors){
                if(neighbor.distance> current.distance+ current.weightMap.get(neighbor)){
                    System.out.println("There is Negative Cycle ");
                    System.out.println("Vertex name: "+neighbor.name);
                    System.out.println("Old Cost: "+neighbor.distance);
                    int newDistance= current.distance+current.weightMap.get(neighbor);
                    System.out.println(" new cost: "+newDistance);
                    return;
                }
                }
            }
        System.out.println("There is no Negative Cycle . . .");
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print(" Node " +nodeToCheck+", distance: "+nodeToCheck.distance+", Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    void floyddWarshall(){
        int size= nodeList.size();
        int[][] v=new int[size][size];
        for(int i=0;i<size;i++){
            WeightedNode first=nodeList.get(i);
            for(int j=0;j<size;j++){
                WeightedNode second=nodeList.get(j);
                if(i==j){
                    v[i][j]=0;
                } else if (first.weightMap.containsKey(second)) {
                    v[i][j]=first.weightMap.get(second);
                }else{
                    v[i][j]=Integer.MAX_VALUE/10;
                }

            }
        }

        for(int k=0;k< nodeList.size();k++){
            for(int i=0;i< nodeList.size();i++){
                for(int j=0;j< nodeList.size();j++){
                    if(v[i][j]>v[i][k]+v[k][j]){
                        v[i][j]=v[i][k]+v[k][j];
                    }
                }
            }
        }
        for(int i=0;i<size;i++){
            System.out.print("Printing distance list for node "+nodeList. get(i)+ ":");
            for(int j=0;j<size;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }
    }
}
