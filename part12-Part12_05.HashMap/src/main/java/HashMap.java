

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class HashMap<K, V> {

    private List<Pair<K, V>>[] values;
    private int entryCount;


    public HashMap() {

        this.values = new ArrayList[5];
        this.entryCount = 0;

    }

    public void add(K key, V value) {

        List<Pair<K, V>> list = getOrCreateBucket(key);
        int indexOfKey = findKeyIndex(list, key);

        if (indexOfKey < 0) {

            list.add(new Pair<>(key, value));
            this.entryCount++;

        } else {

            list.get(indexOfKey).setValue(value);
        }

        if (1.0 * this.entryCount / this.values.length > 0.75) {
            grow();
        }

    }

    private List<Pair<K, V>> getOrCreateBucket(K key) {

        int hashValue = hashIndex(key, this.values.length);

        if (this.values[hashValue] == null) {

            this.values[hashValue] = new ArrayList<>();
        }

        return this.values[hashValue];

    }

    private int findKeyIndex(List<Pair<K, V>> list, K key) {

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).getKey().equals(key)) {

                return i;
            }
        }

        return -1;

    }

    private void grow() {

        List<Pair<K, V>>[] newArray = new List[this.values.length * 2];

        for (int i = 0; i < this.values.length; i++) {

            rehashBucket(newArray, i);

        }

        this.values = newArray;

    }

    private void rehashBucket(List<Pair<K, V>>[] newArray, int index) {

        if (this.values[index] == null) {

            return;
        }

        for (int i = 0; i < this.values[index].size(); i++) {

            Pair<K, V> value = this.values[index].get(i);
            int hashValue = hashIndex(value.getKey(), newArray.length);
            if (newArray[hashValue] == null) {

                newArray[hashValue] = new ArrayList<>();
            }
            newArray[hashValue].add(value);
        }

    }

    public V get(K key) {

        int hashValue = hashIndex(key, this.values.length);
        List<Pair<K, V>> list = this.values[hashValue];

        if (list == null) {

            return null;
        }

        for (Pair<K, V> kvPair : list) {

            if (kvPair.getKey().equals(key)) {

                return kvPair.getValue();
            }
        }
        return null;
    }

    public V remove(K key) {

        int hashValue = hashIndex(key, this.values.length);
        List<Pair<K, V>> list = this.values[hashValue];

        if (list == null) {
            return null;
        }

        int indexOfKey = findKeyIndex(list, key);
        if (indexOfKey < 0) {
            return null;
        }

        Pair<K, V> pair = list.remove(indexOfKey);
        this.entryCount--;
        return pair.getValue();

    }

    private int hashIndex(K key, int length) {
        return (key.hashCode() & 0x7fffffff) % length;
    }

}
