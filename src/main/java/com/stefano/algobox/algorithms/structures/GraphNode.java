package com.stefano.algobox.algorithms.structures;

import java.util.List;

/**
 * Immutable graph node using adjacency list.
 *
 * @param <T> element type
 * @param value value of the node
 * @param neighbors list of adjacent nodes
 */
public record GraphNode<T>(T value, List<GraphNode<T>> neighbors) {}

