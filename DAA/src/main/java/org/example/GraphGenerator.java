package org.example;
import java.util.Random;

public class GraphGenerator {
    public static Graph1 generateGraph(int vertexCount, int edgeCount) {
        Graph1 graph = new Graph1(vertexCount);
        Random rand = new Random();

        for (int i = 0; i < edgeCount; i++) {
            int v = rand.nextInt(vertexCount);
            int w = rand.nextInt(vertexCount);

            if (v != w) {
                graph.addEdge(v, w);
            } else {
                i--;
            }
        }

        return graph;
    }
}
