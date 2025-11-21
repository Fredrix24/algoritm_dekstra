package com.dekstra;

class Node implements Comparable<Node> {
    int vertex;
    int distance;

    Node(int vertex, int distance) {
        this.vertex = vertex;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.distance, other.distance);
    }

    @Override
    public String toString() {
        return "Node{" +
                "vertex=" + vertex +
                ", distance=" + distance +
                '}';
    }
}
