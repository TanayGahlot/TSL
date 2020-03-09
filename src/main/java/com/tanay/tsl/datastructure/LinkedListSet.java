//oggpnosn
//hkhr
package com.tanay.tsl.datastructure;

import com.tanay.tsl.datastructure.interfaces.Set;
import com.tanay.tsl.datastructure.interfaces.Element;

public class LinkedListSet<T> implements Set<T>{
  private Element<T> head;
  private Element<T> tail;

  public LinkedListSet(final Element<T> element){
    head = element;
    tail = element;
  }

  public Element<T> getHead(){
    return head;
  }

  public Element<T> getTail(){
    return tail;
  }

  public void setTail(Element<T> newTail){
    tail = newTail;
  }
}
