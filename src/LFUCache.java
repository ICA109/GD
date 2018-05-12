public class LFUCache {

    class Element {
        int aKey;
        Object aValue;
    }

    int size;
    Element[] cache;

    LFUCache(int size) {
        this.size = size;
        cache = new Element[size];
    }

    public void set(int key, Object value) {

    }

    public void get(int key) {

    }

}
