/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;
import org.junit.runners.Parameterized.Parameter;

public class CatalogTest {

  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */


  // TESTS FOR findByBrand
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertEquals(7, tvs.size());

    for (Television tv : tvs) {
      assertEquals("Sony", tv.getBrand());
    }
  }

  @Test
  public void testFindByBrandWrongMatch() {
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);

    for (Television tv : tvs) {
      assertNotEquals("RCA", tv.getBrand());
      assertNotEquals("Hitachi", tv.getBrand());
      assertNotEquals("Zenith", tv.getBrand());
    }
  }

  //TESTS FOR findByBrands
  @Test
  public void testFindByBrandsNoMatches() {
    Map<String, Collection<Television>> brandmap = Catalog.findByBrands("NO-MATCHES","NOT A MATCH");
    assertNotNull(brandmap);
    assertTrue(brandmap.isEmpty());
  }

  @Test
  public void testFindByBrandsWithMatches() {
    Map<String, Collection<Television>> brandmap = Catalog.findByBrands("Sony");
    assertNotNull(brandmap);
    assertEquals(6, brandmap.size());

  }

}