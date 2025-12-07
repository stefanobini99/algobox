package com.stefano.algobox.algorithms.structures;

/**
 * Immutable stack (LIFO) implementation using linked nodes.
 *
 * @param <T> type of element stored
 */
public final class ImmutableStack<T> {
    private final T head;
    private final ImmutableStack<T> tail;
    private final int size;

    private static final ImmutableStack<?> EMPTY = new ImmutableStack<>(null, null, 0);


    /**
     * Creates an empty stack.
     *
     * @param <T> element type
     * @return empty stack
     */
    @SuppressWarnings("unchecked")
    public static <T> ImmutableStack<T> empty() {
        return (ImmutableStack<T>) EMPTY;
    }

    private ImmutableStack(T head, ImmutableStack<T> tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    /** Push element onto the stack */
    public ImmutableStack<T> push(T value) {
        return new ImmutableStack<>(value, this, size + 1);
    }

    /** Pop element from the stack */
    public ImmutableStack<T> pop() {
        if (isEmpty()) throw new IllegalStateException("Cannot pop empty stack");
        return tail;
    }

    /** Peek at the top element */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Cannot peek empty stack");
        return head;
    }

    /** Check if stack is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns number of elements */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder("[");
        ImmutableStack<T> current = this;
        boolean first = true;
        while (!current.isEmpty()) {
            if (!first) sb.append(", ");
            sb.append(current.head);
            first = false;
            current = current.tail;
        }
        sb.append("]");
        return sb.toString();
    }
}