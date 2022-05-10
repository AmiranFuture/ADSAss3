public class MyHashTable<K,V> {
    private class HashNode<K,V>{
        private K key;
        private V value;
        public K payload;
        private HashNode<K,V> next;

        private HashNode(K key, V value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K,V>[] chainArray;
    private int M = 11;
    private int R = 7;
    private int size;

    public MyHashTable(){
        this(M);
    }

    public MyHashTable(int M){
        chainArray = new HashNode[M];
    }

    private int hash(K key){
        int HashValue = key%chainArray.length;
        return HashValue;
    }

    private int probing(int key)
    {
        int hashValue = R - (key % R);
        System.out.println("Probing: " + hashValue);
        return hashValue;
    }

    public void insertNode(HashNode y){
        size++;
        int hashValue = hash(y.key);
        HashNode HashBusket = chainArray[hashValue];

        if(HashBusket == null){
            chainArray[hashValue] = y;
        } else {
            HashNode newNode = new HashNode(probing(y.key));
            K payload = (K) x.payload;
        }
    }

    public void put (K key, V value){
        HashNode newNode = new HashNode(value);
        newNode.key = key;
        insertNode(newNode);

    }


    public V get(K key){
        int HashValue = hash(key);
        HashNode hashBusket = chainArray[HashValue];

        while(hashBusket != null && hashBusket.key != key) {
            hashBusket = hashBusket.next;
        }
    }

    public V remove(K key){
        size--;
        HashNode curNode = V get(key);
        curNode.delete();
    }

    public boolean contains(V value){
        size=0;
        for(int i=0; i<chainArray.length; i++){
            chainArray[i] = null;
        }
    }

    public K getKey(V value){
        int HashValue = hash(value);
        HashNode hashBusket = chainArray[HashValue];
        while(hashBusket !=null && hashBusket.value != value){
            hashBusket = hashBusket.next;
        }
        return hashBusket;
    }

    public void delete(int key){
        V remove(key);
    }

}

public class BST<K extends Comparable <K>, V>{
    private Node root;
    private class Node{
        private K key;
        private V val;
        private int N;
        public Node left, right;
        public Node(K key, V val){
            this.key=key;
            this.val=val;
            this.N=N;
        }
    }
    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    public boolean contains(K key) {
        return get(key) != null;
    }


    public V get(K key) {
        return get(root, key);
    }

    private V get(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    public void put(K key, V val) {
        if (val == null){
            delete(key);
            return;
        }
        root = put(root, key, val);

    }

    private Node put(Node x, K key, V val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin() {
        if (isEmpty()) throw new RuntimeException("Symbol table underflow");
        root = deleteMin(root);

    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax() {
        if (isEmpty()) throw new RuntimeException("Symbol table underflow");
        root = deleteMax(root);

    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(K key) {
        root = delete(root, key);

    }
    public K min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    private Node delete(Node x, K key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = delete(x.left,  key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left  == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}
