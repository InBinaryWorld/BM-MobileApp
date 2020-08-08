package dev.szafraniak.bm_mobileapp.business.utils;

import java.util.Arrays;
import java.util.List;

import io.reactivex.functions.Function;

public class RxUtils {

    public static class ObservableZipCollector<T> implements Function<Object[], List<T>> {
        @Override
        public List<T> apply(Object[] objects) {
            return Arrays.asList((T[]) objects);
        }
    }
}
