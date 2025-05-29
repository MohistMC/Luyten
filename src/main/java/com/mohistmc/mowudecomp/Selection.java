package com.mohistmc.mowudecomp;

public record Selection(Integer from, Integer to) implements Comparable<Selection> {

    @Override
    public int compareTo(Selection o) {
        return from.compareTo(o.from);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Selection other = (Selection) obj;
        if (from == null) {
            return other.from == null;
        } else return from.equals(other.from);
    }
}
