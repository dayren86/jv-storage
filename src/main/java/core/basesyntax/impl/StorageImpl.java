package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;
    private int index = 0;

    public StorageImpl() {
        keys = (K[]) new Object[10];
        values = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        boolean sameKey = true;

        for (int i = 0; i < index; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                values[i] = value;
                sameKey = false;
            }
        }

        if (sameKey) {
            keys[index] = key;
            values[index] = value;
            index++;
        }

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keys.length; i++) {
            if ((keys[i] == null && key == null) || (keys[i] != null && keys[i].equals(key))) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
