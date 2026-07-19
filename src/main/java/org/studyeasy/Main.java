package org.studyeasy;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList=new ArrayList<>();
        nodeList.add(new WeightedNode("A",0));
        nodeList.add(new WeightedNode("B",1));
        nodeList.add(new WeightedNode("C",2));
        nodeList.add(new WeightedNode("D",3));
//        nodeList.add(new WeightedNode("E",4));
//        nodeList.add(new WeightedNode("F",5));
//        nodeList.add(new WeightedNode("G",6));

        WeightedGraph g=new WeightedGraph(nodeList);
        g.addWeightedEdge(0,3,1);
        g.addWeightedEdge(0,1,8);
        g.addWeightedEdge(1,2,1);
        g.addWeightedEdge(2,0,4);
        g.addWeightedEdge(3,1,2);
        g.addWeightedEdge(3,2,9);
//        g.addWeightedEdge(3,4,4);
//        g.addWeightedEdge(4,6,9);
//        g.addWeightedEdge(5,6,7);
        System.out.println("Printing Floydd Warshall");
        g.floyddWarshall();
//        System.out.println("Printing Dijkstra from Source : A");
//        g.dijkstra(nodeList.get(0));
//        System.out.println("Printing Bellman Ford from Source : A");
//        g.BellmanFord(nodeList.get(0));

    }
}