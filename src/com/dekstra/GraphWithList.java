package com.dekstra;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class GraphWithList extends Graph {
    private int numVertices;
    private List<List<Edge>> adjList;

    public GraphWithList(int numVertices) {
        this.numVertices = numVertices;
        adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
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
        adjList.get(source).add(new Edge(destination, weight));
        adjList.get(destination).add(new Edge(source, weight));
    }

    @Override
    public List<Edge> getNeighbors(int vertex) {
        if (vertex < 0 || vertex >= numVertices) {
            return Collections.emptyList();
        }
        return adjList.get(vertex);
    }

    public void printList() {
        System.out.println("Список смежности:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Вершина " + i + ": ");
            if (adjList.get(i).isEmpty()) {
                System.out.println("нет соседей");
            } else {
                System.out.println(adjList.get(i));
            }
        }
    }
}
