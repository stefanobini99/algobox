package com.stefano.algobox.algorithms.graphs;

import com.stefano.algobox.algorithms.structures.GraphNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class GraphAlgorithmsTest {

    @Test
    void testDFSRecursive() {
        // Create nodes
        GraphNode<Integer> node1 = new GraphNode<>(1, List.of());
        GraphNode<Integer> node2 = new GraphNode<>(2, List.of());
        GraphNode<Integer> node3 = new GraphNode<>(3, List.of(node2));
        GraphNode<Integer> node4 = new GraphNode<>(4, List.of(node1, node3));

        // Connect nodes
        node1 = new GraphNode<>(1, List.of(node4));
        node2 = new GraphNode<>(2, List.of(node4));
        node3 = new GraphNode<>(3, List.of(node4));

        // DFS Recursive should visit nodes in the correct order
        List<Integer> visited = GraphAlgorithms.dfsRecursive(node4);
        assertEquals(List.of(4, 1, 3, 2), visited, "DFS Recursive traversal order is incorrect");

        // Edge case: single node graph
        GraphNode<Integer> singleNode = new GraphNode<>(42, List.of());
        List<Integer> singleVisit = GraphAlgorithms.dfsRecursive(singleNode);
        assertEquals(List.of(42), singleVisit, "DFS Recursive should visit single node correctly");
    }

    @Test
    void testDFSIterative() {
        // Create nodes
        GraphNode<Integer> node1 = new GraphNode<>(1, List.of());
        GraphNode<Integer> node2 = new GraphNode<>(2, List.of());
        GraphNode<Integer> node3 = new GraphNode<>(3, List.of(node2));
        GraphNode<Integer> node4 = new GraphNode<>(4, List.of(node1, node3));

        // Connect nodes
        node1 = new GraphNode<>(1, List.of(node4));
        node2 = new GraphNode<>(2, List.of(node4));
        node3 = new GraphNode<>(3, List.of(node4));

        // DFS Iterative should visit nodes in the correct order
        List<Integer> visited = GraphAlgorithms.dfsIterative(node4);
        assertEquals(List.of(4, 3, 2, 1), visited, "DFS Iterative traversal order is incorrect");

        // Edge case: single node graph
        GraphNode<Integer> singleNode = new GraphNode<>(42, List.of());
        List<Integer> singleVisit = GraphAlgorithms.dfsIterative(singleNode);
        assertEquals(List.of(42), singleVisit, "DFS Iterative should visit single node correctly");
    }

    @Test
    void testBFS() {
        // Create nodes
        GraphNode<Integer> node1 = new GraphNode<>(1, List.of());
        GraphNode<Integer> node2 = new GraphNode<>(2, List.of());
        GraphNode<Integer> node3 = new GraphNode<>(3, List.of(node2));
        GraphNode<Integer> node4 = new GraphNode<>(4, List.of(node1, node3));

        // Connect nodes
        node1 = new GraphNode<>(1, List.of(node4));
        node2 = new GraphNode<>(2, List.of(node4));
        node3 = new GraphNode<>(3, List.of(node4));

        // BFS should visit nodes level by level
        List<Integer> visited = GraphAlgorithms.bfs(node4);
        assertEquals(List.of(4, 1, 3, 2), visited, "BFS traversal order is incorrect");

        // Edge cases
        GraphNode<Integer> singleNode = new GraphNode<>(42, List.of());
        List<Integer> singleVisit = GraphAlgorithms.bfs(singleNode);
        assertEquals(List.of(42), singleVisit, "BFS should visit single node correctly");
    }

    @Test
    void testDijkstra() {
        // Create nodes
        GraphNode<Integer> node1 = new GraphNode<>(1, List.of());
        GraphNode<Integer> node2 = new GraphNode<>(2, List.of());
        GraphNode<Integer> node3 = new GraphNode<>(3, List.of());
        GraphNode<Integer> node4 = new GraphNode<>(4, List.of());

        // Manually set up distances
        // Connect them in a way that we can test Dijkstra's shortest path
        node2 = new GraphNode<>(2, List.of(node4));
        node3 = new GraphNode<>(3, List.of(node4));
        node1 = new GraphNode<>(1, List.of(node2, node3));

        // Use Dijkstra's to get the shortest path (ignoring actual weights for now)
        var result = GraphAlgorithms.dijkstra(node1);

        // Asserting the correct shortest path distances for each node
        assertEquals(0, result.get(node1), "Distance to node1 should be 0");
        assertEquals(1, result.get(node2), "Distance to node2 should be 1");
        assertEquals(1, result.get(node3), "Distance to node3 should be 1");
        assertEquals(2, result.get(node4), "Distance to node4 should be 2");

        // Edge case: single node graph
        GraphNode<Integer> singleNode = new GraphNode<>(42, List.of());
        var singleResult = GraphAlgorithms.dijkstra(singleNode);
        assertEquals(0, singleResult.get(singleNode), "Distance to single node should be 0");
    }
}
