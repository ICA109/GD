public class LFUCacheSimp {

    class Element {
        int aKey;
        String aValue;

        public Element(int aKey, String aValue) {
            this.aKey = aKey;
            this.aValue = aValue;
        }
    }

    int size;
    Element[] cache;

    LFUCacheSimp(int size) {
        this.size = size;
        cache = new Element[size];
    }

    public void set(int key, String value) {
        int index = key % size;

        if (index == key - 1) {
            cache[index] = new Element(key, value);
        }
        else {
            cache[index] = new Element(key, value);
        }

    }

    public String get(int key) {
        int index = key % size;
        Element extracted;

        try {
            extracted = cache[index];
        }
        catch (NullPointerException ex) {
            System.out.println("Error invalid key provided.");
            return "";
        }

        if (index != 0) {
            Element tmp = cache[index];
            cache[index] = cache[index-1];
            cache[index-1] = tmp;
        }
        return extracted.aValue;
    }

    public static void main(String[] args) {
        LFUCacheSimp testCache = new LFUCacheSimp(3);
        testCache.set(1, "a");
        testCache.set(2, "b");
        testCache.set(3, "c");
        //Expected output: c, a, b, c, b, a
        //But now reordered -> key != index location
        System.out.println(testCache.get(3));
        System.out.println(testCache.get(1));
        System.out.println(testCache.get(2));
        System.out.println(testCache.get(3));
        System.out.println(testCache.get(2));
        System.out.println(testCache.get(1));

    }


}
