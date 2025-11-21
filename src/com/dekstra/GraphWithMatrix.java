package com.dekstra;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class GraphWithMatrix extends Graph {
    private int numVertices;
    private int[][] adjacencyMatrix;

    private final int NO_EDGE = Integer.MAX_VALUE;

    public GraphWithMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; i++) {
            Arrays.fill(adjacencyMatrix[i], NO_EDGE);
            adjacencyMatrix[i][i] = 0;
        }
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }


    @Override
    public void addEdge(int source, int destination, int weight) {
        if (source < 0 || source >= numVertices || destination < 0 || destination >= numVertices) {
            throw new IllegalArgumentException("Вершины вне диапазона.");
        }
        if (weight < 0) {
            throw new IllegalArgumentException("Вес ребра не может быть отрицательным для алгоритма Дейкстры.");
        }
        adjacencyMatrix[source][destination] = weight;
        adjacencyMatrix[destination][source] = weight;
    }

    public int getEdgeWeight(int source, int destination) {
        if (source < 0 || source >= numVertices || destination < 0 || destination >= numVertices) {
            return NO_EDGE;
        }
        return adjacencyMatrix[source][destination];
    }

    @Override
    public List<Edge> getNeighbors(int vertex) {
        List<Edge> neighbors = new ArrayList<>();
        if (vertex < 0 || vertex >= numVertices) {
            return neighbors;
        }
        for (int i = 0; i < numVertices; i++) {
            if (adjacencyMatrix[vertex][i] != NO_EDGE) {
                neighbors.add(new Edge(i, adjacencyMatrix[vertex][i]));
            }
        }
        return neighbors;
    }

    public void printMatrix() {
        System.out.println("Матрица смежности:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                if (adjacencyMatrix[i][j] == NO_EDGE) {
                    System.out.printf("%4s", "INF");
                } else {
                    System.out.printf("%4d", adjacencyMatrix[i][j]);
                }
            }
            System.out.println();
        }
    }
}
