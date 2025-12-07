package com.stefano.algobox.algorithms.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {

    @Test
    void testCreateTreeNode() {
        TreeNode root = new TreeNode(1, null, null);
        assertEquals(1, root.value(), "Node value should be 1");
    }

    @Test
    void testTreeTraversal() {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        assertNotNull(root.left(), "Left child should not be null");
        assertNotNull(root.right(), "Right child should not be null");
    }
}
