package ex0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
 
public class Graph {
 
    public LinkedList<Vertex> vertices = new LinkedList<>();
    public LinkedList<Integer> blackList = new LinkedList<Integer>();
    public int numberOfNodes;
    public int numberOfEdeges;
 
    public Graph(String path) {
        readGraph(path);
    }
   
    public void addVertex(int id) {
        Vertex temp = new Vertex(id);
        temp.adjacencies = new LinkedList<>();
        vertices.add(temp);
    }
 
    public void printGraph() {
        for (Vertex vertice : vertices) {
            System.out.println(vertice);
            for (int i = 0; i < vertice.adjacencies.size(); i++) {
                System.out.println(vertice.adjacencies.get(i));
            }
        }
    }
 
    public void addEdge(int fromID, int toID, double weight) {
        vertices.get(fromID).adjacencies.add(new Edge(vertices.get(toID), weight));
        vertices.get(toID).adjacencies.add(new Edge(vertices.get(fromID), weight));
    }
 
    public void readGraph(String path) {
        try {
            File fopen = new File(path);
            BufferedReader br = new BufferedReader(new FileReader(fopen));
            String x = br.readLine();
            numberOfNodes = Integer.parseInt(x);
            for (int i = 0; i < numberOfNodes; i++) {
                addVertex(i);
            }
            x = br.readLine();
            numberOfEdeges = Integer.parseInt(x);
            while ((x = br.readLine()) != null) {
                String[] spliterX = x.split(" ");
                addEdge(Integer.parseInt(spliterX[0]), Integer.parseInt(spliterX[1]), Double.parseDouble(spliterX[2]));
            }
        } catch (Exception ex) {
            System.out.println(ex);
 
        }
    }
 
    public void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
        vertexQueue.add(source);
 
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();
 
            for (Edge e : u.adjacencies) {
                if (!blackList.contains(e.target.id)) {
                    Vertex v = e.target;
                    double weight = e.weight;
                    double distanceThroughU = u.minDistance + weight;
                    if (distanceThroughU < v.minDistance) {
                        vertexQueue.remove(v);
                        v.minDistance = distanceThroughU;
                        v.previous = u;
                        vertexQueue.add(v);
                    }
                }
            }
        }
    }
 
    public List<Vertex> getShortestPathTo(Vertex target) {
        List<Vertex> path = new ArrayList<Vertex>();
        for (Vertex vertex = target; vertex != null; vertex = vertex.previous) {
            path.add(vertex);
        }
        return path;
    }
    
    private void foo1(){};
 
    public static void main(String[] args) {
        Graph g = new Graph("C:\\Users\\Tomer\\Desktop\\TotoTest.txt");
        g.printGraph();
 
    }
}
 
/*
Comments!
 
//        blackList.add(1);
//        computePaths(vertices.get(0));
//        for (Vertex v : vertices) {
//            System.out.println("Distance to " + v + ": " + v.minDistance);
//            System.out.println(getShortestPathTo(v));
//        }
 
        addVertex(0);
        addVertex(1);
        addVertex(2);
        addVertex(3);
        addEdge(0, 1, 10);
        addEdge(0, 2, 5);
        addEdge(1, 3, 2);
        addEdge(2, 3, 2);
 
System.out.println("");
        removeEdge(1, 3);
        removeEdge(2, 3);
        for (int i = 0; i < vertices.size(); i++) {
            vertices.get(i).previous = null;
            vertices.get(i).minDistance = Double.POSITIVE_INFINITY;
        }
        computePaths(vertices.get(1));
        for (Vertex v : vertices) {
            System.out.println("Distance to " + v + ": " + v.minDistance);
            System.out.println(getShortestPathTo(v));
        }
 
public static void removeEdge(int fromID, int toID) {
        for (int i = 0; i < vertices.get(fromID).adjacencies.size(); i++) {
            if (vertices.get(fromID).adjacencies.get(i).target.id == toID) {
                Edge temp = vertices.get(fromID).adjacencies.get(i);
                vertices.get(fromID).adjacencies.remove(temp);
            }
        }
        for (int i = 0; i < vertices.get(toID).adjacencies.size(); i++) {
            if (vertices.get(toID).adjacencies.get(i).target.id == fromID) {
                Edge temp = vertices.get(toID).adjacencies.get(i);
                vertices.get(toID).adjacencies.remove(temp);
            }
        }
    }
 
    public static void removeVertex() {
 
    }
 
*/