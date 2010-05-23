package com.techtangents.licensecop.alien.array;

public class ArrayContains {
    public boolean contains(Object[] a, Object x) {
        for (Object o : a) if (o.equals(x)) return true;
        return false;
    }
}