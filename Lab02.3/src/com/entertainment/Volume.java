/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment;

public interface Volume {
  public void setVolume(int volume);
  public int getVolume();



  default void mute(){
    if (!isMuted()) {           // not currently muted
      setOldVolume(getOldVolume());  // store current volume in oldVolume
      setVolume(0);             // set volume to zero
    }
    else {                      // currently muted
      setOldVolume(getOldVolume());     // restore volume from oldVolume value
    }
    setMuted(!isMuted());
  }

  int getOldVolume();
  void setOldVolume(int volume);

  public boolean isMuted();

  void setMuted(boolean muted);

  default public void silence(){
    setVolume(0);
  }
  public static void silenceAll(Volume... vols){
    for(Volume vol :vols){
      vol.silence();
    }
  }

}