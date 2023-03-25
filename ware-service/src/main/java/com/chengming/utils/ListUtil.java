package com.chengming.utils;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: yichengming
 * @Date: 2021/11/06/10:53
 * @Description:
 */
public class ListUtil<T> implements Iterator<List<T>> {

    private final List<T> ts;


    private int size;

    private int currIndex;


    public ListUtil(List<T> ts, int size) {
        this.size = size;
        this.ts = ts;
    }

    @Override
    public boolean hasNext() {
        return currIndex < ts.size();
    }

    @Override
    public List<T> next() {
        int nextIndex = currIndex;
        int totalSize = 0;
        for (; nextIndex < ts.size(); nextIndex++) {
            T t = ts.get(nextIndex);
            totalSize = totalSize + t.toString().length();
            if (totalSize > size) {
                break;
            }
        }
        List<T> subList = ts.subList(currIndex, nextIndex);
        currIndex = nextIndex;
        return subList;
    }
}
