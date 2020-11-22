package ua.edu.ucu.collections.immutable;


public final class ImmutableArrayList implements ImmutableList {
    private final int size;
    private final Object[] container;

    public ImmutableArrayList(){
        this.size = 0;
        container = new Object[0];
    }

    public ImmutableArrayList(Object[] elements) {
        container = new Object[elements.length];
        System.arraycopy(elements, 0, container, 0, elements.length);
        size = elements.length;
    }


    @Override
    public ImmutableList add(Object e) {
        return addAll(new Object[]{e});
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }
        Object[] newContainer = new Object[size + c.length];
        System.arraycopy(container, 0, newContainer, 0, index);
        System.arraycopy(c, 0, newContainer, index, c.length);
        System.arraycopy(container, index, newContainer, index+c.length, size-index);
        return new ImmutableArrayList(newContainer);
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return container[index];
    }

    @Override
    public ImmutableList remove(int index) {
        checkIndex(index);

        Object[] newContainer = new Object[size-1];
        System.arraycopy(container, 0, newContainer, 0, index);
        System.arraycopy(container, index+1, newContainer, index, size-index-1);
        return new ImmutableArrayList(newContainer);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        checkIndex(index);
        Object[] newContainer = new Object[size];
        System.arraycopy(container, 0, newContainer, 0, size);
        newContainer[index] = e;
        return new ImmutableArrayList(newContainer);
    }

    @Override
    public int indexOf(Object e) {
        for (int idx = 0; idx < size; idx++) {
            if (container[idx].equals(e)) {
                return idx;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public ImmutableList clear() {
        Object[] newContainer = new Object[0];
        return new ImmutableArrayList(newContainer);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        System.arraycopy(container, 0, arr, 0, size);
        return arr;
    }

    /*
    Additional methods
     */
    private void checkIndex(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
    }
}
