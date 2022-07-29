public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return  numChildren(p) > 0;
    }
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }
    public boolean isEmpty() {
        return size() == 0;
    }
    public int depth(Position<E> p) throws IllegalArgumentException {
        if (isRoot(p)) {
            return 0;
        }
        return 1 + depth(parent(p));
    }

    public int heightBad() {
        int h = 0;
        for (Position<E> p : positions()) {
            if (isExternal(p)) {
                h = Math.max(h, depth(p));
            }
        }
        return h;
    }

    public int height(Position<E> p) {
        int h = 0; // Default height of a leaf is 0
        // leaf nodes will skip the loop for no children
        for (Position<E> c : children(p)) {
            h = 1 + Math.max(h, height(c));
        }
        return h;
    }
}
