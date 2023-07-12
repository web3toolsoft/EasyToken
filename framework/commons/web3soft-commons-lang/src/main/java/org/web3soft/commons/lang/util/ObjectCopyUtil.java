package org.web3soft.commons.lang.util;

import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

/**
 * @author web3soft-team
 */
public class ObjectCopyUtil {
    private final static ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        MODEL_MAPPER.getConfiguration().setFullTypeMatchingRequired(true);
        MODEL_MAPPER.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * 简单的复制出新对象ArrayList
     */
    public static <S, D> List<D> mapList(final Iterable<S> sourceList, final Class<D> destinationClass) {
        final List<D> destionationList = new ArrayList<>();
        if (IterableUtils.isEmpty(sourceList)) {
            return destionationList;
        }
        for (final S source : sourceList) {
            if (source != null) {
                destionationList.add(MODEL_MAPPER.map(source, destinationClass));
            }
        }
        return destionationList;
    }

    /**
     * 简单的复制出新类型对象.
     */
    public static <S, D> D map(final S source, final Class<D> destinationClass) {
        if (source == null) {
            return null;
        }
        return MODEL_MAPPER.map(source, destinationClass);
    }
}
