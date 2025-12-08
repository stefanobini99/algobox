package com.stefano.algobox.algorithms.graphs;

import com.stefano.algobox.algorithms.structures.GraphNode;

import java.util.*;

/**
 * Classic graph algorithms operating on immutable GraphNodes.
 *
 * <p>Includes:
 * <ul>
 *   <li>DFS (recursive and iterative)</li>
 *   <li>BFS (iterative)</li>
 *   <li>Dijkstra's shortest path (unweighted, default weight = 1)</li>
 * </ul>
 */
public final class GraphAlgorithms {

    // ==================== DFS ====================

    /**
     * Recursive Depth-First Search
     */
    public static <T> List<T> dfsRecursive(GraphNode<T> start) {
        List<T> visited = new ArrayList<>();
        Set<GraphNode<T>> seen = new HashSet<>();
        dfsHelper(start, visited, seen);
        return visited;
    }

    private static <T> void dfsHelper(GraphNode<T> node, List<T> visited, Set<GraphNode<T>> seen) {
        if (node == null || seen.contains(node)) return;
        visited.add(node.value());
        seen.add(node);
        for (GraphNode<T> neighbor : node.neighbors()) {
            dfsHelper(neighbor, visited, seen);
        }
    }

    /**
     * Iterative Depth-First Search (stack-based)
     */
    public static <T> List<T> dfsIterative(GraphNode<T> start) {
        List<T> visited = new ArrayList<>();
        Set<GraphNode<T>> seen = new HashSet<>();
        if (start == null) return visited;

        Deque<GraphNode<T>> stack = new ArrayDeque<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            GraphNode<T> node = stack.pop();
            if (seen.contains(node)) continue;
            visited.add(node.value());
            seen.add(node);
            for (GraphNode<T> neighbor : node.neighbors()) {
                stack.push(neighbor);
            }
        }

        return visited;
    }

    // ==================== BFS ====================

    /**
     * Breadth-First Search
     */
    public static <T> List<T> bfs(GraphNode<T> start) {
        List<T> visited = new ArrayList<>();
        Set<GraphNode<T>> seen = new HashSet<>();
        if (start == null) return visited;

        Queue<GraphNode<T>> queue = new LinkedList<>();
        queue.add(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            GraphNode<T> node = queue.poll();
            visited.add(node.value());
            for (GraphNode<T> neighbor : node.neighbors()) {
                if (!seen.contains(neighbor)) {
                    queue.add(neighbor);
                    seen.add(neighbor);
                }
            }
        }
        return visited;
    }

    // ==================== Dijkstra ====================

    /**
     * Dijkstra's shortest path from start node (unweighted, default weight = 1).
     *
     * @param start starting GraphNode<Integer>
     * @return map of nodes to their distance from start
     */
    public static Map<GraphNode<Integer>, Integer> dijkstra(GraphNode<Integer> start) {
        Map<GraphNode<Integer>, Integer> dist = new HashMap<>();
        PriorityQueue<Map.Entry<GraphNode<Integer>, Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        dist.put(start, 0);
        pq.add(Map.entry(start, 0));

        while (!pq.isEmpty()) {
            var entry = pq.poll();
            GraphNode<Integer> node = entry.getKey();
            int distance = entry.getValue();

            if (distance > dist.get(node)) continue;

            for (GraphNode<Integer> neighbor : node.neighbors()) {
                int weight = 1; // TODO: support weighted edges
                int newDist = dist.get(node) + weight;
                if (newDist < dist.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    dist.put(neighbor, newDist);
                    pq.add(Map.entry(neighbor, newDist));
                }
            }
        }

        return dist;
    }
}
