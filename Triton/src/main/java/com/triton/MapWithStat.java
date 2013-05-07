package com.triton;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapWithStat<K, V> {
    private Map<K, V> map;

    private int nbPut;
    private int nbGet;

    public MapWithStat(final Map<K, V> mapToStat) {
        super();
        this.map = mapToStat;
    }

    public int getNbPut() {
        return nbPut;
    }

    public int getNbGet() {
        return nbGet;
    }

    /*
    *
    */

    public void clear() {
        map.clear();

        nbPut = 0;
        nbGet = 0;
    }

    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    public boolean containsValue(final Object value) {
        return map.containsValue(value);
    }

    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    public boolean equals(final Object o) {
        return map.equals(o);
    }

    public V get(final Object key) {
        nbGet++;

        return map.get(key);
    }

    public int hashCode() {
        return map.hashCode();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public Set<K> keySet() {
        return map.keySet();
    }

    public V put(final K key, final V value) {
        nbPut++;

        return map.put(key, value);
    }

    public void putAll(final Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    public V remove(final Object key) {
        return map.remove(key);
    }

    public int size() {
        return map.size();
    }

    public Collection<V> values() {
        return map.values();
    }
}
