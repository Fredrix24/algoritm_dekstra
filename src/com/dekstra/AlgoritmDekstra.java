package com.dekstra;

import java.util.*;

class AlgoritmDekstra {

    public static DekstraResult findShortestPaths(Graph graph, int source) {
        int numVertices = graph.getNumVertices();

        int[] dist = new int[numVertices];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        int[] prev = new int[numVertices];
        Arrays.fill(prev, -1);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {

            Node currentNode = pq.poll();
            int u = currentNode.vertex;
            int currentDistance = currentNode.distance;

            if (currentDistance > dist[u]) {
                continue;
            }

            for (Edge edge : graph.getNeighbors(u)) {
                int v = edge.targetNode;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        return new DekstraResult(dist, prev);
    }

    public static class DekstraResult {
        public final int[] distances;
        public final int[] predecessors;

        DekstraResult(int[] distances, int[] predecessors) {
            this.distances = distances;
            this.predecessors = predecessors;
        }
    }
}
