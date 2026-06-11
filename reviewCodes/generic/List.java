package com.yday72__7.reviewCodes.generic;

import java.util.Arrays;
import java.util.Comparator;

// T extends Comparable<T>：上限通配符，T为可比较类型Comparable或其子类
public class List<T extends Comparable<T>> {
    T[] list;

    public List(T[] list) {
        this.list = list;
    }

    public T[] getList() {
        return list;
    }

    public void setList(T[] list) {
        this.list = list;
    }

    public T findMax() {
        if (list == null || list.length == 0) {
            return null;
        }

        return Arrays.stream(list)
                .max(Comparator.naturalOrder())
                .orElse(null);
    }
}