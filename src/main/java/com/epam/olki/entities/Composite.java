package com.epam.olki.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by olki on 6/3/15.
 */
public class Composite implements BaseComponent{

    private List<BaseComponent> partList;

    public Composite() {
        partList = new ArrayList<BaseComponent>();
    }

    public void addElement(BaseComponent part) {
        partList.add(part);
    }

    public void removeElement(BaseComponent part) {
        partList.remove(part);
    }

    public int getSize() {
        return partList.size();
    }

    public BaseComponent getElement(int index) {
        if(index >= getSize()); //throws exception
        return partList.get(index);
    }

    public Iterator<BaseComponent> getIterator() {
        return partList.iterator();
    }

    @Override
    public String toString() {

        String out = "";

        for (Iterator<BaseComponent>  partListIterator = getIterator();
             partListIterator.hasNext(); ) {

            BaseComponent baseComponent = partListIterator.next();
            out += baseComponent.toString();
        }
        return out;
    }
}
