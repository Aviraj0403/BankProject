package org.example;

import java.util.ArrayList;
import java.util.List;

public class Graph1 {
    private int V; // Number of vertices
    private List<Integer>[] adjList;

    public Graph1(int V) {
        this.V = V;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v);
    }

    public List<Integer> getAdjacentVertices(int v) {
        return adjList[v];
    }

    public int getVertexCount() {
        return V;
    }
}
