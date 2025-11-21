package com.dekstra;

class Edge {
    int targetNode;
    int weight;

    Edge(int targetNode, int weight) {
        this.targetNode = targetNode;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + targetNode + ", " + weight + ")";
    }
}
