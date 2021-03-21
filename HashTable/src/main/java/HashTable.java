public class HashTable<T> {
    Entry[] arrayHash;
    int size;

    public HashTable(int size) {
        this.size = size;
        arrayHash = new Entry[size];
        for (int i = 0; i < size; i++) {
            arrayHash[i] = new Entry();
        }
    }

    int getHash(int key) {
        return key % size;
    }

    public void put(int key, Object value) {
        int hashIndex = getHash(key);
        Entry arrayValue = arrayHash[hashIndex];
        Entry nexItem = new Entry(key, value);
        nexItem.next = arrayValue.next;
        arrayValue.next = nexItem;
    }

    public T get(int key) {
        T value = null;
        int hashIndex = getHash(key);
        Entry arrayValue = arrayHash[hashIndex];
        while (arrayValue != null) {
            if (arrayValue.getKey() == key) {
                value = (T) arrayValue.getValue();
                break;
            }
            arrayValue = arrayValue.next;
        }
        return value;
    }
}
