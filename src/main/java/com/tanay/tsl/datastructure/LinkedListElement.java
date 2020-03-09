//oggpnosn
//hkhr
package com.tanay.tsl.datastructure;

import com.tanay.tsl.datastructure.interfaces.Element;
import com.tanay.tsl.datastructure.interfaces.Set;


public class LinkedListElement<T> implements Element<T>{
  private T value;
  private Element<T> nextElement;
  private Set<T> parentSet;

  public LinkedListElement(T x){
    value = x;
    nextElement = null;
    parentSet = null;
  }

  public Element<T> getNextElement(){
    return nextElement;
  }
  public void setNextElement(Element<T> nextElement){
    this.nextElement = nextElement;
  }

  public Set<T> getParentSet(){
    return parentSet;
  }

  public void setParentSet(Set<T> set){
    this.parentSet = set;
  }
}
