//oggpnosn
//hkhr
package com.tanay.tsl.datastructure;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import com.tanay.tsl.datastructure.LinkedListDisjointSet;
import com.tanay.tsl.datastructure.interfaces.Set;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.tanay.tsl.datastructure.exception.ElementNotFoundException;

/*
makeSet
  - insert something of the correct datatype

union
  - both element exist
  - one or more of the element do not exist

findSet
  - element might not exist
*/
public class LinkedListDisjointSetTest{

  @Test
  public void happy_path_test_case_1() {
    LinkedListDisjointSet disjointSet = new LinkedListDisjointSet<Integer>();

    insertElementIntoDisjointSet(disjointSet, ImmutableSet.of(1,2,3,4,5));

    disjointSet.union(1,2);
    disjointSet.union(1,3);
    disjointSet.union(4,5);

    assertElementsAreInSameSet(disjointSet, ImmutableSet.of(1,2,3));
    assertElementsAreInSameSet(disjointSet, ImmutableSet.of(4,5));
  }

  @Test
  public void happy_path_test_case_2() {
    LinkedListDisjointSet disjointSet = new LinkedListDisjointSet<Integer>();

    insertElementIntoDisjointSet(disjointSet, ImmutableSet.of(1,2,3,4,5));

    disjointSet.union(1,2);
    disjointSet.union(1,3);
    disjointSet.union(4,5);
    disjointSet.union(3,4);

    assertElementsAreInSameSet(disjointSet, ImmutableSet.of(1,2,3,4,5));
  }

  @Test
  public void happy_path_test_case_3() {
    LinkedListDisjointSet disjointSet = new LinkedListDisjointSet<Integer>();

    insertElementIntoDisjointSet(disjointSet, ImmutableSet.of(1,2,3,4,5));

    disjointSet.union(1,2);

    assertElementsAreInSameSet(disjointSet, ImmutableSet.of(1,2));
  }

  @Test(expected = ElementNotFoundException.class)
  public void when_the_element_doesnt_exist_in_the_set_1() {
    LinkedListDisjointSet disjointSet = new LinkedListDisjointSet<Integer>();
    insertElementIntoDisjointSet(disjointSet, ImmutableSet.of(1,2,3,4,5));
    disjointSet.union(1,7);
  }

  @Test(expected = ElementNotFoundException.class)
  public void when_the_element_doesnt_exist_in_the_set_2() {
    LinkedListDisjointSet disjointSet = new LinkedListDisjointSet<Integer>();
    insertElementIntoDisjointSet(disjointSet, ImmutableSet.of(1,2,3,4,5));
    disjointSet.union(11,7);
  }

  @Test(expected = ElementNotFoundException.class)
  public void when_the_element_doesnt_exist_in_the_set_3() {
    LinkedListDisjointSet disjointSet = new LinkedListDisjointSet<Integer>();
    insertElementIntoDisjointSet(disjointSet, ImmutableSet.of(1,2,3,4,5));
    disjointSet.union(1, 2);
    assertElementsAreInSameSet(disjointSet, ImmutableSet.of(1,2,11));
  }

  private void insertElementIntoDisjointSet(final LinkedListDisjointSet<Integer> disjointSet, final ImmutableSet<Integer> values){
    values.forEach(value -> disjointSet.makeSet(value));
  }

  private static void assertElementsAreInSameSet(final LinkedListDisjointSet<Integer> disjointSet, final ImmutableSet<Integer> elementValues){
    Sets.combinations(elementValues, 2).forEach(elementPairSet -> {
      final Object[] elementPair = elementPairSet.toArray();
      final Integer element1 = (Integer) elementPair[0];
      final Integer element2 = (Integer) elementPair[1];

      Set<Integer> s1 = disjointSet.findSet(element1);
      Set<Integer> s2 = disjointSet.findSet(element2);

      assertEquals(s1, s2);
      assertEquals(s2, s1);
    });
  }
}
