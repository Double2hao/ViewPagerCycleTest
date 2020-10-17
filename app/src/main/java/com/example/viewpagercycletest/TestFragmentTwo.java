package com.example.viewpagercycletest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * author: xujiajia
 * created on: 2020/9/14 6:20 PM
 * description:
 */
public class TestFragmentTwo extends Fragment {
  @Nullable @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    TextView textView = (TextView) inflater.inflate(R.layout.fragment_test, container, false);
    textView.setText("Two");
    return textView;
  }
}
