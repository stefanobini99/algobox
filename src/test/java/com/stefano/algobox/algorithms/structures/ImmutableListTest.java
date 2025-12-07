package com.stefano.algobox.algorithms.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImmutableListTest {

    @Test
    void testAdd() {
        ImmutableList<Integer> list = ImmutableList.empty();
        list = list.add(1);
        assertEquals(1, list.head(), "Head should be 1 after adding it");
        assertEquals(1, list.size(), "Size should be 1 after adding one element");

        list = list.add(2);
        assertEquals(2, list.head(), "Head should be 2 after adding it");
        assertEquals(2, list.size(), "Size should be 2 after adding another element");
    }

    @Test
    void testIsEmpty() {
        ImmutableList<Integer> list = ImmutableList.empty();
        assertTrue(list.isEmpty(), "List should be empty initially");

        list = list.add(1);
        assertFalse(list.isEmpty(), "List should not be empty after adding an element");
    }

    @Test
    void testHeadAndTail() {
        ImmutableList<Integer> list = ImmutableList.empty();
        list = list.add(1).add(2);
        assertEquals(2, list.head(), "Head should be 2");
        assertEquals(1, list.tail().head(), "Tail head should be 1");
    }
}
