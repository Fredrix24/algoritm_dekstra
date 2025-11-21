package com.dekstra;
import java.util.*;


abstract class Graph {
    public abstract int getNumVertices();

    public abstract List<Edge> getNeighbors(int vertex);

    public abstract void addEdge(int source, int destination, int weight);
}
