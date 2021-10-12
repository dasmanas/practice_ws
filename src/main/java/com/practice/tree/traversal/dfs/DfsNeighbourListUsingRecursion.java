package com.practice.tree.traversal.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 40 -> 20 -> 50 -> 70
 * |    / | \        ^
 * |  /   |  \      /
 * v v    v   v    /
 * 10 -> 30-> 60 -
 */

public class DfsNeighbourListUsingRecursion {

    static class Node {
        int data;
        boolean visited;
        List<Node> neighbours;

        Node(int data){
            this.data = data;
            this.neighbours = new ArrayList<>();
        }

        public void addNeighbours(Node node){
            getNeighbours().add(node);
        }

        public List<Node> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Node> neighbours) {
            this.neighbours = neighbours;
        }
    }

    public DfsNeighbourListUsingRecursion(){
    }

    public void dfsUsingRecursive(Node node){
        if(!node.visited){
            node.visited = true;
            System.out.println(node.data);
            for (Node childNode : node.getNeighbours()){
                dfsUsingRecursive(childNode);
            }
        }else{
            return;
        }
    }

    public static void main(String arg[])
    {

        Node node40 =new Node(40);
        Node node10 =new Node(10);
        Node node20 =new Node(20);
        Node node30 =new Node(30);
        Node node60 =new Node(60);
        Node node50 =new Node(50);
        Node node70 =new Node(70);

        node40.addNeighbours(node10);
        node40.addNeighbours(node20);
        node10.addNeighbours(node30);
        node20.addNeighbours(node10);
        node20.addNeighbours(node30);
        node20.addNeighbours(node60);
        node20.addNeighbours(node50);
        node30.addNeighbours(node60);
        node60.addNeighbours(node70);
        node50.addNeighbours(node70);
        System.out.println("The DFS traversal of the graph is ");
        DfsNeighbourListUsingRecursion dfsTraversal = new DfsNeighbourListUsingRecursion();
        System.out.println("Using Recursive");
        dfsTraversal.dfsUsingRecursive(node40);
    }
}
