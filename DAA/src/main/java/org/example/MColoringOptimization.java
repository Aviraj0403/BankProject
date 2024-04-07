package org.example;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;


import java.util.HashMap;
import java.util.Map;

public class MColoringOptimization {
    public static Map<Integer, Integer> solveMColoring(Graph1 graph, int m) {
        Map<Integer, Integer> coloring = new HashMap<>();
        // Create a HashMap to store the final coloring result

        int V = graph.getVertexCount(); // Get the number of vertices in the graph

        // Initialize all vertices with no color assigned (-1 indicates no color)
        int[] colors = new int[V];
        for (int i = 0; i < V; i++) {
            colors[i] = -1;
        }

        // Function to check if a color can be assigned to a vertex
        // without violating the m-coloring constraint
        boolean isSafe = (v, c) -> {
            for (int neighbor : graph.getAdjacentVertices(v)) {
                if (colors[neighbor] == c) {
                    return false; // The color 'c' is already used by a neighbor
                }
            }
            return true; // It's safe to assign color 'c' to vertex 'v'
        };

        // Recursive function to assign colors to vertices using backtracking
        boolean graphColoring(int v) {
            // Base case: If all vertices are colored, return true
            if (v == V) {
                return true;
            }

            // Try all available colors for vertex 'v'
            for (int c = 0; c < m; c++) {
                if (isSafe.test(v, c)) {
                    colors[v] = c; // Assign color 'c' to vertex 'v'

                    // Recur to assign colors to the rest of the vertices
                    if (graphColoring(v + 1)) {
                        return true; // If a valid coloring is found, return true
                    }

                    colors[v] = -1; // Backtrack by resetting the color for vertex 'v'
                }
            }

            return false; // If no valid coloring is found for vertex 'v', return false
        }

        // Start from the first vertex (vertex 0)
        if (graphColoring(0)) {
            // If a valid coloring is found, populate the 'coloring' map
            for (int i = 0; i < V; i++) {
                coloring.put(i, colors[i]);
            }
        }

        return coloring; // Return the final coloring result (empty map if no valid coloring exists)
    }
}

