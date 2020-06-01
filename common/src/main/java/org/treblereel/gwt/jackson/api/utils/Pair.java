package org.treblereel.gwt.jackson.api.utils;

/**
 * @author Dmitrii Tikhomirov
 * Created by treblereel 4/2/20
 */
public class Pair<K, V> {

    public final K key;
    public final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
