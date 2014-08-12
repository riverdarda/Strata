/**
 * Copyright (C) 2009 - present by OpenGamma Inc. and the OpenGamma group of companies
 * 
 * Please see distribution for license.
 */
package com.opengamma.basics.date;

import static org.testng.Assert.assertEquals;

import org.joda.beans.ser.JodaBeanSer;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * Test serialization.
 */
@Test
public class SerializeTest {

  public void test_serialize() {
    MockSerBean bean = new MockSerBean();
    bean.setBdConvention(BusinessDayConventions.MODIFIED_FOLLOWING);
    bean.setBdCalendar(BusinessDayCalendar.ALL);
    bean.setDayCount(DayCounts.DC_ACT_360);
    bean.setObjects(ImmutableList.of(
        BusinessDayConventions.MODIFIED_FOLLOWING, BusinessDayCalendar.ALL, DayCounts.DC_ACT_360));
    
    String xml = JodaBeanSer.PRETTY.xmlWriter().write(bean);
    MockSerBean test = JodaBeanSer.COMPACT.xmlReader().read(xml, MockSerBean.class);
    assertEquals(test, bean);
  }

}
