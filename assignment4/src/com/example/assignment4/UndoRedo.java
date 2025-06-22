package com.example.assignment4;

import java.util.LinkedList;

public class UndoRedo<T> {
    private LinkedList<T> stateStack;
    private LinkedList<T> redoStack;

    public UndoRedo() {
        stateStack = new LinkedList<>();
        redoStack = new LinkedList<>();
    }

    public void add(T state) {
        stateStack.push(state);
        redoStack.clear();
    }

    public T undo() {
        if (!stateStack.isEmpty()) {
            T state = stateStack.pop();
            redoStack.push(state);
            return state;
        }
        return null; // No state to undo
    }

    public T redo() {
        if (!redoStack.isEmpty()) {
            T state = redoStack.pop();
            stateStack.push(state);
            return state;
        }
        return null; // No state to redo
    }

    public boolean canUndo() {
        return !stateStack.isEmpty();
    }
    public boolean canRedo() {
        return !redoStack.isEmpty();
    }

    public T current() {
        return stateStack.isEmpty() ? null : stateStack.peek();
    }
}
