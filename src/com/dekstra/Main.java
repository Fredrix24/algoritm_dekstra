package com.dekstra;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int numVertices = 5;

        Graph graph = new GraphWithList(numVertices);

        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 2);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 5);
        graph.addEdge(2, 3, 8);
        graph.addEdge(2, 4, 10);
        graph.addEdge(3, 4, 2);

        if (graph instanceof GraphWithList) {
            ((GraphWithList) graph).printList();
        } else if (graph instanceof GraphWithMatrix) {
            ((GraphWithMatrix) graph).printMatrix();
        }
        System.out.println("----------------------------");

        int sourceVertex = 0;
        AlgoritmDekstra.DekstraResult result = AlgoritmDekstra.findShortestPaths(graph, sourceVertex);

        System.out.println("Результаты алгоритма Дейкстры от вершины " + sourceVertex + ":");

        for (int i = 0; i < numVertices; i++) {
            System.out.print("До вершины " + i + ": ");
            if (result.distances[i] == Integer.MAX_VALUE) {
                System.out.println("Недостижимо");
            } else {
                System.out.print("Длина пути: " + result.distances[i] + ", Маршрут: ");
                List<Integer> path = PathReconstruction.getShortestPath(i, result.predecessors, sourceVertex);

                if (!path.isEmpty()) {
                    System.out.println(path);
                } else {
                    System.out.println("Нет пути (или некорректный результат)");
                }
            }
        }

        System.out.println("----------------------------");

        int targetVertex = 4;
        if (result.distances[targetVertex] != Integer.MAX_VALUE) {
            System.out.println("Ожидаемый вывод для вершины " + targetVertex + ":");
            System.out.println("Длина пути: " + result.distances[targetVertex]);
            List<Integer> pathFor4 = PathReconstruction.getShortestPath(targetVertex, result.predecessors, sourceVertex);
            System.out.println("Маршрут: " + pathFor4);
        } else {
            System.out.println("Вершина " + targetVertex + " недостижима.");
        }
    }
}