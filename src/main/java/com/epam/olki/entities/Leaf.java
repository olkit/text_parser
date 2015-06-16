package com.epam.olki.entities;

import java.util.Iterator;

/**
 * Created by olki on 6/3/15.
 */
public class Leaf implements BaseComponent{

    String str;

    public Leaf(String str) {
        this.str = str;
    }

    public void addElement(BaseComponent part) {
        throw new UnsupportedOperationException();
    }

    public void removeElement(BaseComponent part) {
        throw new UnsupportedOperationException();
    }

    public BaseComponent getElement(int index) {
        return this;
    }

    public int getSize() {
        throw new UnsupportedOperationException();
    }


    public Iterator<BaseComponent> getIterator() {
        throw new UnsupportedOperationException();

    }

    public String toString() {
        return str;
    }
}
