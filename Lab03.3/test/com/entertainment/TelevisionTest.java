package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {


  public static final int INITIAL_VOLUME = 50;

  private Television tv;
  private Television tv2;

  @Before
  public void setUp() throws Exception {
    tv = new Television("Sony", INITIAL_VOLUME, DisplayType.PLASMA);
    tv.changeChannel(400);

    tv2 = new Television("Toshiba", INITIAL_VOLUME, DisplayType.LED);

  }

  @Test
  public void getBrand() {
  }

  @Test
  public void setBrand() {
  }

  @Test
  public void getVolume() {
    assertEquals(INITIAL_VOLUME, tv.getVolume());
  }

  @Test
  public void setVolume() {
    tv.setVolume(Television.MIN_VOLUME + 1);
    assertEquals(Television.MIN_VOLUME + 1, tv.getVolume());
  }

  @Test(expected = IllegalArgumentException.class)
  public void setVolume_invalid() {
    tv.setVolume(Television.MIN_VOLUME - 1);
  }

  @Test
  public void getCurrentChannel() {
    assertEquals(400, tv.getCurrentChannel());
  }

  @Test
  public void changeChannel() throws InvalidChannelException {
    tv.changeChannel(Television.MAX_CHANNEL - 1);
    assertEquals(Television.MAX_CHANNEL - 1, tv.getCurrentChannel());
  }

  @Test(expected = InvalidChannelException.class)
  public void changeChannel_invalid() throws InvalidChannelException {
    tv.changeChannel(Television.MAX_CHANNEL + 1);
  }

  @Test
  public void getDisplay() {
  }

  @Test
  public void setDisplay() {
  }

  @Test
  public void compareTo() {
  }

  @Test
  public void testHashCode() {
  }

  @Test
  public void testEquals() {
  }
}