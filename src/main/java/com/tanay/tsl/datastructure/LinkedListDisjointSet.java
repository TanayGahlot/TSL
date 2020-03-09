//oggpnosn
//hkhr
package com.tanay.tsl.datastructure;
import com.tanay.tsl.datastructure.interfaces.DisjointSet;
import com.tanay.tsl.datastructure.interfaces.Set;
import com.tanay.tsl.datastructure.interfaces.Element;
import java.util.Map;
import java.util.HashMap;
import com.tanay.tsl.datastructure.exception.ElementNotFoundException;

public class LinkedListDisjointSet<T> implements DisjointSet<T>{
  private final Map<T, Element<T>> valueToElementMap;

  public LinkedListDisjointSet(){
    valueToElementMap = new HashMap<T, Element<T>>();
  }


  public void makeSet(final T x){
   Element<T> element = new LinkedListElement<T>(x);
   Set<T> set = new LinkedListSet<T>(element);
   element.setParentSet(set);
   valueToElementMap.putIfAbsent(x, element);
  }

  public Set<T> findSet(final T x) {
    if(valueToElementMap.containsKey(x)){
      Element<T> element = valueToElementMap.get(x);
      return element.getParentSet();
    } else{
      throw new ElementNotFoundException("Element: " + x + " doesn't exist in any set");
    }
  }

  public void union(final T x, final T y){
     Set<T> setX = findSet(x);
     Set<T> setY = findSet(y);
     // Point the last element in setX to first element in setY.
     Element<T> lastElementOfX = setX.getTail();
     lastElementOfX.setNextElement(setY.getHead());

     // Point the parent pointer for all the element in setY to setX.
     for(Element<T> currentElement=setY.getHead();currentElement!=null;currentElement=currentElement.getNextElement()){
       currentElement.setParentSet(setX);
     }

     // Point the tail of setX to that of setY.
     setX.setTail(setY.getTail());
  }

  public static void main(String[] args){
    System.out.println("It works fellas!");
  }
}
