package com.triton;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * The Class MapWithStat.
 * 
 * MapWithStat uses a wrapped java.util.Map to listen how many times methods get() & put() are called.
 * 
 * @param <K>
 *            the key type
 * @param <V>
 *            the value type
 * 
 * @author Stephane
 * @since 2013
 */
public final class MapWithStat<K, V> {

    /** The wrapped map to listen events on. */
    private Map<K, V> map;

    /** The number of times method put() was called. */
    private int nbPut;

    /** The number of times method get() was called. */
    private int nbGet;

    /**
     * Instantiates a new MapWithStat with a wrapped map to listen events on.
     * 
     * @param mapToStat
     *            the wrapped map to listen events on
     */
    public MapWithStat(final Map<K, V> mapToStat) {
        super();
        this.map = mapToStat;
    }

    /**
     * Gets the number of times method put() was called
     * 
     * @return the number of times method put() was called
     */
    public int getNbPut() {
        return nbPut;
    }

    /**
     * Gets the number of times method get() was called
     * 
     * @return the number of times method get() was called
     */
    public int getNbGet() {
        return nbGet;
    }

    /**
     * Wraps all java.util.Map methods
     */

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#clear()
     */
    public void clear() {
        map.clear();

        nbPut = 0;
        nbGet = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    public boolean containsKey(final Object key) {
        return map.containsKey(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#containsValue(java.lang.Object)
     */
    public boolean containsValue(final Object value) {
        return map.containsValue(value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#entrySet()
     */
    public Set<Entry<K, V>> entrySet() {
        return map.entrySet();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(final Object o) {
        return map.equals(o);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#get(java.lang.Object)
     */
    public V get(final Object key) {
        nbGet++;

        return map.get(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode() {
        return map.hashCode();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#isEmpty()
     */
    public boolean isEmpty() {
        return map.isEmpty();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#keySet()
     */
    public Set<K> keySet() {
        return map.keySet();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#put(java.lang.Object, java.lang.Object)
     */
    public V put(final K key, final V value) {
        nbPut++;

        return map.put(key, value);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#putAll(java.util.Map)
     */
    public void putAll(final Map<? extends K, ? extends V> m) {
        map.putAll(m);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#remove(java.lang.Object)
     */
    public V remove(final Object key) {
        return map.remove(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#size()
     */
    public int size() {
        return map.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.util.Map#values()
     */
    public Collection<V> values() {
        return map.values();
    }
}
