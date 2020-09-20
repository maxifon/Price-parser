package monakhov.maxim.core;


import monakhov.maxim.core.exceptions.InvalidMaxSizeException;

import java.util.HashMap;
import java.util.Stack;


/**
 * The class {@code FixedStack} represents the {@code Stack} of the fixed maximum size.
 *
 * @param <T> Type of an object stored in {@code FixedStack}.
 */
public class FixedStack<T> extends Stack<T> {


    private int maxSize;

    private static final HashMap<String, String> fieldsDescription
            = new HashMap<>();

    static {
        fieldsDescription.put(
                "maxSize",
                "maxSize must be >= 1.");
    }

    /**
     * Constructs the {@code FixedStack} of the specified maximum size.
     *
     * @param maxSize Maximum size of the {@code FixedStack}.
     */
    public FixedStack(int maxSize) {
        super();
        this.maxSize = maxSize;
    }


    /**
     * Pushes the {@code object} to the fixedStack. If the fixedStack size already equals the maxSize, the lowest element in the stack is removed.
     *
     * @param object The object to be pushed to the fixedStack. If the fixedStack size already equals the maxSize, the lowest element in the stack is removed.
     * @return The pushed object.
     */
    @Override
    public T push(T object) {
        //If the stack is too big, remove elements until it's the right size.
        while (this.size() >= maxSize) {
            this.remove(0);
        }
        return super.push(object);
    }


    /**
     * Resizes the fixedStack to the new maximum size. If the new maximum size is lower than the current one, all the lowest elements in the fixedStack are removed.
     *
     * @param newMaxSize New maximum size of hte stack.
     */
    public void resize(int newMaxSize) {

        int maxSizeOld = this.maxSize;

        setMaxSize(newMaxSize);

        if (newMaxSize < maxSizeOld) {
            if (maxSizeOld - newMaxSize > 0) {
                this.subList(0, maxSizeOld - newMaxSize).clear();
            }
        }
    }


    /**
     * Checks whether the {@code maxSize} is valid.
     *
     * @param maxSize A maxSize.
     * @return True if the specified maxSize is valid.
     */
    private boolean isValidMaxSize(int maxSize) {
        return
                maxSize >= 1;
    }


    /**
     * Returns the maximum size.
     *
     * @return The maximum size.
     */
    public int getMaxSize() {
        return maxSize;
    }


    /**
     * Sets a maximum size.
     *
     * @param maxSize Maximum size.
     * @throws InvalidMaxSizeException If the maxSize is not >= 1
     */
    private void setMaxSize(int maxSize) {
        if ( ! isValidMaxSize(maxSize)) throw new InvalidMaxSizeException(fieldsDescription.get("maxSize"));

        this.maxSize = maxSize;
    }
}
