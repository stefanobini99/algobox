package com.stefano.algobox.algorithms.structures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Immutable FIFO queue using two lists (front/back) for efficiency.
 *
 * @param <T> element type
 */
public final class ImmutableQueue<T> {
    private final List<T> front;
    private final List<T> back;

    private static final ImmutableQueue<?> EMPTY = new ImmutableQueue<>(Collections.emptyList(), Collections.emptyList());

    /** Returns an empty queue */
    @SuppressWarnings("unchecked")
    public static <T> ImmutableQueue<T> empty() {
        return (ImmutableQueue<T>) EMPTY;
    }

    private ImmutableQueue(List<T> front, List<T> back) {
        this.front = front;
        this.back = back;
    }

    /** Add element to queue */
    public ImmutableQueue<T> enqueue(T value) {
        if (front.isEmpty()) {
            // If front is empty, place the element in front to maintain correct order
            return new ImmutableQueue<>(Collections.singletonList(value), back);
        } else {
            List<T> newBack = new ArrayList<>(back);
            newBack.add(value);
            return new ImmutableQueue<>(front, Collections.unmodifiableList(newBack));
        }
    }

    /** Remove element from front of queue */
    public ImmutableQueue<T> dequeue() {
        if (isEmpty()) throw new IllegalStateException("Cannot dequeue empty queue");

        List<T> newFront = new ArrayList<>(front);
        newFront.remove(0);

        if (!newFront.isEmpty()) {
            return new ImmutableQueue<>(Collections.unmodifiableList(newFront), back);
        } else if (!back.isEmpty()) {
            // Move back to front in reversed order
            List<T> reversedBack = new ArrayList<>(back);
            Collections.reverse(reversedBack);
            return new ImmutableQueue<>(Collections.unmodifiableList(reversedBack), Collections.emptyList());
        } else {
            return empty();
        }
    }

    /** Peek at front element */
    public T peek() {
        if (isEmpty()) throw new IllegalStateException("Cannot peek empty queue");
        if (!front.isEmpty()) return front.get(0);
        List<T> reversedBack = new ArrayList<>(back);
        Collections.reverse(reversedBack);
        return reversedBack.get(0);
    }

    /** True if queue is empty */
    public boolean isEmpty() {
        return front.isEmpty() && back.isEmpty();
    }

    @Override
    public String toString() {
        List<T> combined = new ArrayList<>(front);
        List<T> reversedBack = new ArrayList<>(back);
        Collections.reverse(reversedBack);
        combined.addAll(reversedBack);
        return combined.toString();
    }
}
