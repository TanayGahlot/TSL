//oggpnosn
//hkhr
package com.tanay.tsl.datastructure.interfaces;

import com.tanay.tsl.datastructure.interfaces.Set;

public interface DisjointSet<T>{

  public void makeSet(final T x);

  public Set<T> findSet(final T x);

  public void union(final T x, final T y);
}
