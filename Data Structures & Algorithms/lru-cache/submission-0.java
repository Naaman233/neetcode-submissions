class LRUCache {
private int capacity;
private Map<Integer,Bloc> cache;
private Bloc leftDummy;
private Bloc rightDummy;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.leftDummy = new Bloc(0,0);
        this.rightDummy = new Bloc(0,0);
        this.leftDummy.next = rightDummy;
        this.rightDummy.prev = leftDummy;
    }

    private void insert(Bloc bloc) {
        Bloc prev = this.rightDummy.prev;
        //In this case the previous node will be the leftdummy which will point to the current 
        // node being inserted
        prev.next = bloc;
        // The current node being inserted will point to the current bloc being inserted
        // which is the current bloc being inserted
        bloc.prev = prev;
        // The current node being inserted will point to the right dummy bloc being inserted
        bloc.next = this.rightDummy;
        // The right dummy will point to the current node as the most recently used
        this.rightDummy.prev = bloc;
    }

    private void remove(Bloc bloc) {
        Bloc prev = bloc.prev;
        Bloc nextP = bloc.next;
        prev.next = nextP;
        nextP.prev = prev;
    }

    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Bloc selectedBloc = cache.get(key);
            remove(selectedBloc);
            insert(selectedBloc);
            return selectedBloc.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }

        Bloc newBloc = new Bloc(key,value);
        cache.put(key, newBloc);
        insert(newBloc);

        if (cache.size() > capacity) {
            Bloc lru = this.leftDummy.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}

class Bloc {
    int key;
    int value;
    Bloc prev;
    Bloc next;

    public Bloc(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;

    }
}
