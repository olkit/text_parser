package com.epam.olki.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by olki on 6/3/15.
 */
public class Composite implements BaseComponent{

    private List<BaseComponent> partList = new ArrayList<BaseComponent>();

    public Composite() {
    }

    public void addElement(BaseComponent part) {
        partList.add(part);

    }

    public void removeElement(BaseComponent part) {
        partList.remove(part);
    }

    public BaseComponent getElement(int index) {
        return partList.get(index);
    }

    public void parse() {

    }

    public Iterator<BaseComponent> getIterator() {
        return partList.iterator();
    }
}
