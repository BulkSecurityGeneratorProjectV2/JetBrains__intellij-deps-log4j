/*
 * Copyright 1999,2005 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.log4j.helpers;

import org.apache.log4j.Layout;
import org.apache.log4j.LayoutTest;
import org.apache.log4j.spi.LoggingEvent;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.TimeZone;


/**
 * Tests for DateLayout.
 * @deprecated since DateLayout is deprecated.
 */
public class DateLayoutTest extends LayoutTest {
  /**
   * Construct a new instance of LayoutTest.
   * @param testName test name.
   */
  public DateLayoutTest(final String testName) {
    super(testName);
  }

  /**
   * Constructor for use by derived tests.
   * @param testName name of test.
   * @param expectedContentType expected value for getContentType().
   * @param expectedIgnoresThrowable expected value for ignoresThrowable().
   * @param expectedHeader expected value for getHeader().
   * @param expectedFooter expected value for getFooter().
   */
  protected DateLayoutTest(
    final String testName, final String expectedContentType,
    final boolean expectedIgnoresThrowable, final String expectedHeader,
    final String expectedFooter) {
    super(
      testName, expectedContentType, expectedIgnoresThrowable, expectedHeader,
      expectedFooter);
  }

  /**
   * @{inheritDoc}
   */
  protected Layout createLayout() {
    return new MockLayout();
  }

  /**
   * Tests DateLayout.NULL_DATE_FORMAT constant.
   * @deprecated since DateLayout is deprecated.
   */
  public void testNullDateFormat() {
    assertEquals("NULL", DateLayout.NULL_DATE_FORMAT);
  }

  /**
   * Tests DateLayout.RELATIVE constant.
   * @deprecated since DateLayout is deprecated.
   */
  public void testRelativeTimeDateFormat() {
    assertEquals("RELATIVE", DateLayout.RELATIVE_TIME_DATE_FORMAT);
  }

  /**
   * Tests DateLayout.DATE_FORMAT_OPTION constant.
   * @deprecated since constant is deprecated
   */
  public void testDateFormatOption() {
    assertEquals("DateFormat", DateLayout.DATE_FORMAT_OPTION);
  }

  /**
   * Tests DateLayout.TIMEZONE_OPTION constant.
   * @deprecated since constant is deprecated
   */
  public void testTimeZoneOption() {
    assertEquals("TimeZone", DateLayout.TIMEZONE_OPTION);
  }

  /**
   * Tests getOptionStrings().
   * @deprecated since getOptionStrings is deprecated.
   *
   */
  public void testGetOptionStrings() {
    String[] options = ((DateLayout) createLayout()).getOptionStrings();
    assertEquals(2, options.length);
  }

  /**
   * Tests setting DateFormat through setOption method.
   * @deprecated since setOption is deprecated.
   */
  public void testSetOptionDateFormat() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setOption("dAtefOrmat", "foobar");
    assertEquals("FOOBAR", layout.getDateFormat());
  }

  /**
   * Tests setting TimeZone through setOption method.
   * @deprecated since setOption is deprecated.
   */
  public void testSetOptionTimeZone() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setOption("tImezOne", "+05:00");
    assertEquals("+05:00", layout.getTimeZone());
  }

  /**
   * Tests setDateFormat.
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormat() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat("ABSOLUTE");
    assertEquals("ABSOLUTE", layout.getDateFormat());
  }

  /**
   * Tests setTimeZone.
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetTimeZone() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setTimeZone("+05:00");
    assertEquals("+05:00", layout.getTimeZone());
  }

  /**
   * Tests 2 parameter setDateFormat with null.
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormatNull() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat((String) null, null);
  }

  /**
   * Tests 2 parameter setDateFormat with "NULL".
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormatNullString() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat("NuLL", null);
  }

  /**
   * Tests 2 parameter setDateFormat with "RELATIVE".
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormatRelative() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat("rElatIve", TimeZone.getDefault());
  }

  /**
   * Tests 2 parameter setDateFormat with "ABSOLUTE".
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormatAbsolute() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat("aBsolUte", TimeZone.getDefault());
  }

  /**
   * Tests 2 parameter setDateFormat with "DATETIME".
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormatDateTime() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat("dAte", TimeZone.getDefault());
  }

  /**
   * Tests 2 parameter setDateFormat with "ISO8601".
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormatISO8601() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat("iSo8601", TimeZone.getDefault());
  }

  /**
   * Tests 2 parameter setDateFormat with "HH:mm:ss".
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormatSimple() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat("HH:mm:ss", TimeZone.getDefault());
  }

  /**
   * Tests activateOptions.
   * @deprecated since DateLayout is deprecated.
   */
  public void testActivateOptions() {
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat("HH:mm:ss");
    layout.setTimeZone("+05:00");
    layout.activateOptions();
  }

  /**
   * Tests setDateFormat(DateFormat, TimeZone).
   * @deprecated since DateLayout is deprecated.
   */
  public void testSetDateFormatWithFormat() {
    DateFormat format = new SimpleDateFormat("HH:mm");
    DateLayout layout = (DateLayout) createLayout();
    layout.setDateFormat(format, TimeZone.getDefault());
  }

  /**
   * Concrete Layout class for tests.
   * @deprecated
   */
  private static final class MockLayout extends DateLayout {
    /**
     * Create new instance of MockLayout.
     */
    public MockLayout() {
      //
      //  checks that protected fields are properly initialized
      assertNotNull(pos);
      assertNotNull(date);
      assertNull(dateFormat);
    }

    /**
     * @{inheritDoc}
     */
    public String format(final LoggingEvent event) {
      return "Mock";
    }

    /**
     * @{inheritDoc}
     */
    public void activateOptions() {
    }

    /**
     * @{inheritDoc}
     */
    public boolean ignoresThrowable() {
      return true;
    }
  }
}
