package com.rhtech.java9Features;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CollectionsNewFactoryMethodsTest {
  @Test
  public void verifyListFactoryMethods() {

    // Create a List populate it in subsequent calls
    List<String> java8ListWay = new ArrayList<>();
    java8ListWay.add("User-1");
    java8ListWay.add("User-2");
    java8ListWay.add("User-3");

    // Create a List populate it from an array
    List<String> java8ListWay2 = Arrays.asList("User-1", "User-2", "User-3");

    // Java9 way -- returns an unmodifiable list, its not possible to alter after creation
    List<String> java9ListWay = List.of("User-1", "User-2", "User-3");

    assertThat(java8ListWay).isEqualTo(java8ListWay2);
    assertThat(java8ListWay).isEqualTo(java9ListWay);
  }

  @Test
  public void verifyMapFactoryMethods() {

    // Create a map and populate it
    Map<String, String> java8MapWay = new HashMap<>();
    java8MapWay.put("key-1", "value-1");
    java8MapWay.put("key-2", "value-2");
    java8MapWay.put("key-3", "value-3");

    // Java 9 way -- returns an unmodifiable map, its not possible to alter after creation
    Map<String, String> java9MapWay =
        Map.of("key-1", "value-1", "key-2", "value-2", "key-3", "value-3");

    assertThat(java8MapWay).isEqualTo(java9MapWay);
  }

  @Test
  public void verifySetFactoryMethods() {

    // Create a set and populate it
    Set<String> java8SetWay = new HashSet<>();
    java8SetWay.add("set-1");
    java8SetWay.add("set-2");
    java8SetWay.add("set-3");

    // Create a set and populate it -- returns an unmodifiable set, its not possible to alter
    // after creation
    Set<String> java8SetWay2 = new HashSet<>(Arrays.asList("set-1", "set-2", "set-3"));

    // java 9 way
    Set<String> java9SetWay = Set.of("set-1", "set-2", "set-3");

    assertThat(java8SetWay).isEqualTo(java8SetWay2);
    assertThat(java8SetWay).isEqualTo(java9SetWay);
  }

  @Test
  public void objectReferenceReset() {

    Object testObject = new Object();
    doReset(testObject);
    System.out.println(testObject);
  }

  public void doReset(Object obj) {
    obj = null;
  }

}
