package org.example;

import java.util.*;

public class MDecisionColoring {
    public static boolean canColorGraph(Graph graph, int m) {
        int V = graph.getVertexCount();
        int[] colors = new int[V]; // Array to store colors assigned to vertices

        // Initialize all vertices with no color assigned
        Arrays.fill(colors, -1);

        // Function to check if a color can be assigned to a vertex
        // without violating the m-coloring constraint
        // Returns true if a color can be assigned, false otherwise
        // (Backtracking)
        boolean isSafe = (v, c) -> {
            for (int neighbor : graph.getAdjacentVertices(v)) {
                if (colors[neighbor] == c) {
                    return false;
                }
            }
            return true;
        };

        // Recursive function to assign colors to vertices
        boolean graphColoring(int v) {
            // Base case: If all vertices are colored, return true
            if (v == V) {
                return true;
            }

            // Try all available colors for vertex v
            for (int c = 0; c < m; c++) {
                if (isSafe.test(v, c)) {
                    colors[v] = c;

                    // Recur to assign colors to the rest of the vertices
                    if (graphColoring(v + 1)) {
                        return true;
                    }

                    // If assigning color c doesn't lead to a solution,
                    // backtrack and try the next color
                    colors[v] = -1;
                }
            }

            // If no color can be assigned to this vertex, return false
            return false;
        }

        // Start from the first vertex (vertex 0)
        return graphColoring(0);
    }
}
