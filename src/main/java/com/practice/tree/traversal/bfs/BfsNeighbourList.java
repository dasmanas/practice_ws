package com.practice.tree.traversal.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 40 -> 20 -> 50 -> 70
 * |    / | \        ^
 * |  /   |  \      /
 * v v    v   v    /
 * 10 -> 30-> 60 -
 */

/**
 * Output
 * 40, 10, 20, 30, 60, 50, 70
 */

public class BfsNeighbourList {
    private Queue<Node> queue;

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

    public BfsNeighbourList(){
        queue = new LinkedList<Node>();
    }

    public void bfs(Node node){
        queue.offer(node);
        while (!queue.isEmpty()){
            Node n = queue.poll();
            if(!n.visited){
                n.visited = true;
                System.out.println(n.data);
                for(Node childNode : n.getNeighbours()){
                    if(!childNode.visited){
                        queue.offer(childNode);
                    }
                }
            }


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
        System.out.println("The BFS traversal of the graph is ");
        BfsNeighbourList bfsTraversal = new BfsNeighbourList();
        bfsTraversal.bfs(node40);

    }
}
