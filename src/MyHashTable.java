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
