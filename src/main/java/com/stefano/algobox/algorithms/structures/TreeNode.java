package com.stefano.algobox.algorithms.structures;

/**
 * Immutable binary tree node using Java 25 records.
 *
 * @param value integer value
 * @param left  left child (nullable)
 * @param right right child (nullable)
 */
public record TreeNode(int value, TreeNode left, TreeNode right) {}
