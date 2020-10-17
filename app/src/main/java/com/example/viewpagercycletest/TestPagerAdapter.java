package com.example.viewpagercycletest;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * author: xujiajia
 * created on: 2020/9/14 6:04 PM
 * description:
 */
public class TestPagerAdapter extends FragmentPagerAdapter {

  //constants
  private final static int CYCLE_COUNT = Integer.MAX_VALUE;

  public TestPagerAdapter(@NonNull FragmentManager fm, int behavior) {
    super(fm, behavior);
  }

  @Override public int getCount() {
    return CYCLE_COUNT;
  }

  @NonNull @Override public Object instantiateItem(@NonNull ViewGroup container, int position) {
    return super.instantiateItem(container, position);
  }

  @NonNull @Override public Fragment getItem(int position) {
    int index = position % 3;
    switch (index) {
      case 0:
        return new TestFragmentOne();
      case 1:
        return new TestFragmentTwo();
      case 2:
        return new TestFragmentThree();
    }
    return new TestFragmentOne();
  }
}
