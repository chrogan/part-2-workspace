package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class HourlyEmployeeTest {

  private HourlyEmployee hourEmp;

  @Before
  public void testSetUp() throws Exception {
    hourEmp = new HourlyEmployee("testName", new Date(0), 20.00, 20.0);
  }

  @Test
  public void testPay() {
    assertEquals(400.0, hourEmp.getRate() * hourEmp.getHours(), .005);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(400.0 * TaxPayer.HOURLY_TAX_RATE, hourEmp.payTaxes(), .005);
  }
}