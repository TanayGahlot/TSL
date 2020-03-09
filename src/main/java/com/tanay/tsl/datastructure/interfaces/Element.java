//oggpnosn
//hkhr
package com.tanay.tsl.datastructure.interfaces;

public interface Element<T>{
  public Element<T> getNextElement();
  public void setNextElement(Element<T> nextElement);

  public Set<T> getParentSet();
  public void setParentSet(Set<T> set);
}
