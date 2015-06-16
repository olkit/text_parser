package com.epam.olki.entities;

import java.util.Iterator;

/**
 * Created by olki on 6/3/15.
 */
public interface BaseComponent {

    public void addElement(BaseComponent part);

    public void removeElement(BaseComponent part);

    public BaseComponent getElement(int index);

    public int getSize();

    public Iterator<BaseComponent> getIterator();

    public String toString();
}
