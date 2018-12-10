import java.util.ArrayList;

/**
 * Linked List implementation, to support chaining
 * for collision detection
 */
class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

public HashNode(K k, V v) {
        this.key = k;
        this.value = v;
    }
}

/**
 * HashTable implementation.
 */
class HashTable<K, V> {
    private ArrayList<HashNode<K, V>> bucketArray;

    private int totalBuckets;

    // current array size
    private int size;

    public HashTable() {
        this.bucketArray = new ArrayList<>();
        this.totalBuckets = 10;
        this.size = 0;
        // Create empty chains
        for (int i = 0; i < totalBuckets; i++)
            bucketArray.add(null);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void add(K key, V value) {
        // get bucket index
        size++;
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        // Check key of present and update value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        head = bucketArray.get(bucketIndex);
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);
        // check bucket size
        // if above threshod rehash
        if (size / totalBuckets >= 0.7) {
            adjustBucketSize();
        }
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        // Search for key in its chain
        HashNode<K, V> prev = null;
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArray.set(bucketIndex, head.next);
        }
        return head.value;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);

        while (head !=null) {
            if (head.key.equals(key)) {
                return head.value;
            }

            head = head.next;
        }

        return null;
    }

    private int getBucketIndex (K key) {
        int hashCode = key.hashCode();
        int index = hashCode % this.totalBuckets;
        return index;
    }

    private void adjustBucketSize() {
        ArrayList<HashNode<K, V>> temp = bucketArray;
        bucketArray = new ArrayList<>();
        totalBuckets = 2 * totalBuckets;
        size = 0;
        for (int i = 0; i < totalBuckets; i++) {
            bucketArray.add(null);
        }

        for(HashNode<K, V> headNode : temp) {
            while (headNode != null)
            {
                add(headNode.key, headNode.value);
                headNode = headNode.next;
            }
        }
    }

    public static void main(String[] args) {
        HashTable<String, String> ht = new HashTable<>();
        ht.add("key1", "value1");
        System.out.println("Key1 : " + ht.get("key1"));
        ht.add("key2", "value2");
        ht.add("key3", "value3");
        ht.add("key3", "value3");
        ht.add("key3", "value3");
        ht.add("key3", "value3");
        ht.add("key3", "value3");
        ht.add("key3", "value3");
        System.out.println("Table Size: " + ht.size());
        ht.remove("key3");
        System.out.println("Table Size: " + ht.size());
    }
}
