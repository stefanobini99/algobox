package com.stefano.algobox.algorithms.structures;

/**
 * Persistent immutable singly-linked list.
 * Supports add, head, tail, size, and empty operations.
 *
 * @param <T> type of element stored
 */
public final class ImmutableList<T> {
    private final T head;
    private final ImmutableList<T> tail;
    private final int size;

    private static final ImmutableList<?> EMPTY = new ImmutableList<>(null, null, 0);

    /**
     * Creates an empty ImmutableList.
     *
     * @param <T> type of element
     * @return empty ImmutableList
     */
    @SuppressWarnings("unchecked")
    public static <T> ImmutableList<T> empty() {
        return (ImmutableList<T>) EMPTY;
    }

    private ImmutableList(T head, ImmutableList<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    /**
     * Adds an element at the head of the list.
     *
     * @param value element to add
     * @return new ImmutableList with the element added
     */
    public ImmutableList<T> add(T value) {
        return new ImmutableList<>(value, this, size + 1);
    }

    /** Returns true if list is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Retrieves the head of the list.
     *
     * @return the first element
     * @throws IllegalStateException if list is empty
     */
    public T head() {
        if (isEmpty()) throw new IllegalStateException("Cannot get head of empty list");
        return head;
    }

    /** Returns the tail of the list (all elements except head) */
    public ImmutableList<T> tail() {
        if (isEmpty()) throw new IllegalStateException("Cannot get tail of empty list");
        return tail;
    }

    /** Returns the number of elements */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";

        StringBuilder sb = new StringBuilder("[");
        ImmutableList<T> current = this;
        boolean first = true;

        while (!current.isEmpty()) {
            if (!first) sb.append(", ");
            sb.append(current.head); // just append head directly
            first = false;
            current = current.tail;
        }

        sb.append("]");
        return sb.toString();
    }
}
