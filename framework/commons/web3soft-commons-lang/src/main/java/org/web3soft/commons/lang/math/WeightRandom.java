package org.web3soft.commons.lang.math;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 生成权重随机数
 *
 * @param <K>
 * @param <V>
 * @author web3soft-team
 */
public class WeightRandom<K, V extends Number> {
    private final TreeMap<Double, K> weightMap = new TreeMap<>();

    public WeightRandom(final List<Pair<K, V>> list) {
        Preconditions.checkNotNull(list, "list can NOT be null!");
        for (final Pair<K, V> pair : list) {
            final double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey();
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());
        }
    }

    public static void main(final String... args) {
        final int maxTimes = 10000;

        final WeightRandom<String, Integer> weightRandom = new WeightRandom<>(Lists.newArrayList(
                new MutablePair<>("A", 1),
                new MutablePair<>("B", 2),
                new MutablePair<>("C", 3),
                new MutablePair<>("D", 4)
        ));

        final Map<String, Integer> map = Maps.newHashMapWithExpectedSize(maxTimes);
        for (int i = 0; i < maxTimes; i++) {
            final String key = weightRandom.random();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }

        for (final String key1 : map.keySet()) {
            System.out.println(key1 + " " + map.get(key1));
        }
    }

    public K random() {
        final double randomWeight = this.weightMap.lastKey() * Math.random();
        final SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, false);
        return this.weightMap.get(tailMap.firstKey());
    }
}
