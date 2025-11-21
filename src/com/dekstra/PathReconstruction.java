package com.dekstra;

import java.util.*;

class PathReconstruction {

    public static List<Integer> getShortestPath(int target, int[] predecessors, int startNode) {
        List<Integer> path = new LinkedList<>();
        if (predecessors[target] == -1 && target != startNode) {
            return path;
        }

        int currentNode = target;
        while (currentNode != -1) {
            path.add(0, currentNode);
            currentNode = predecessors[currentNode];
        }
        if (!path.isEmpty() && path.get(0) == startNode) {
            return path;
        } else {
            return new LinkedList<>();
        }
    }
}