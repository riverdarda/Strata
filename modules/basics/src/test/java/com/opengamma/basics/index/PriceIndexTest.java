/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.basics.index;

import static com.opengamma.collect.TestHelper.assertJodaConvert;
import static com.opengamma.collect.TestHelper.assertSerialization;
import static com.opengamma.collect.TestHelper.assertThrows;
import static com.opengamma.collect.TestHelper.coverBeanEquals;
import static com.opengamma.collect.TestHelper.coverImmutableBean;
import static com.opengamma.collect.TestHelper.coverPrivateConstructor;
import static org.testng.Assert.assertEquals;

import org.joda.beans.ImmutableBean;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import com.opengamma.basics.currency.Currency;
import com.opengamma.basics.location.Country;
import com.opengamma.basics.schedule.Frequency;

/**
 * Test {@link PriceIndex}.
 */
@Test
public class PriceIndexTest {

  //-------------------------------------------------------------------------
  @DataProvider(name = "name")
  static Object[][] data_name() {
    return new Object[][] {
        {PriceIndices.GB_HICP, "GB-HICP"},
        {PriceIndices.GB_RPI, "GB-RPI"},
        {PriceIndices.GB_RPIX, "GB-RPIX"},
        {PriceIndices.CH_CPI, "CH-CPI"},
        {PriceIndices.EU_HICP_AI, "EU-HICP-AI"},
        {PriceIndices.JP_CPI_EXF, "JP-CPI-EXF"},
        {PriceIndices.US_CPI_U, "US-CPI-U"},
    };
  }

  @Test(dataProvider = "name")
  public void test_name(PriceIndex convention, String name) {
    assertEquals(convention.getName(), name);
  }

  @Test(dataProvider = "name")
  public void test_toString(PriceIndex convention, String name) {
    assertEquals(convention.toString(), name);
  }

  @Test(dataProvider = "name")
  public void test_of_lookup(PriceIndex convention, String name) {
    assertEquals(PriceIndex.of(name), convention);
  }

  @Test(dataProvider = "name")
  public void test_extendedEnum(PriceIndex convention, String name) {
    ImmutableMap<String, PriceIndex> map = PriceIndex.extendedEnum().lookupAll();
    assertEquals(map.get(name), convention);
  }

  public void test_of_lookup_notFound() {
    assertThrows(() -> PriceIndex.of("Rubbish"), IllegalArgumentException.class);
  }

  public void test_of_lookup_null() {
    assertThrows(() -> PriceIndex.of((String) null), IllegalArgumentException.class);
  }

  //-------------------------------------------------------------------------
  public void coverage() {
    coverPrivateConstructor(PriceIndices.class);
    coverPrivateConstructor(StandardPriceIndices.class);
    coverImmutableBean((ImmutableBean) PriceIndices.US_CPI_U);
    coverBeanEquals((ImmutableBean) PriceIndices.US_CPI_U, (ImmutableBean) ImmutablePriceIndex.builder()
        .name("Test")
        .region(Country.AR)
        .currency(Currency.ARS)
        .publicationFrequency(Frequency.P6M)
        .build());
  }

  public void test_jodaConvert() {
    assertJodaConvert(PriceIndex.class, PriceIndices.US_CPI_U);
  }

  public void test_serialization() {
    assertSerialization(PriceIndices.US_CPI_U);
  }

}