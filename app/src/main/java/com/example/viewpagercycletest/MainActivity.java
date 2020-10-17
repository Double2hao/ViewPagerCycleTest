package com.example.viewpagercycletest;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

  //constants
  private final static int DELAY_CYCLE = 2000;
  //ui
  private ViewPager vpMain;
  //data
  private Timer cycleTimer;
  private volatile boolean isTouching = false;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    initViews();
    initTimer();
  }

  private void initTimer() {
    cycleTimer = new Timer();
    cycleTimer.schedule(new TimerTask() {
      @Override public void run() {
        runOnUiThread(new Runnable() {
          @Override public void run() {
            if (vpMain != null && !isTouching) {
              vpMain.setCurrentItem(vpMain.getCurrentItem() + 1);
            }
          }
        });
      }
    }, DELAY_CYCLE, DELAY_CYCLE);
  }

  private void initViews() {
    vpMain = findViewById(R.id.vp_main);
    vpMain.setOffscreenPageLimit(0);//设置不缓存
    vpMain.setAdapter(new TestPagerAdapter(getSupportFragmentManager(),
        FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT));

    vpMain.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
          case MotionEvent.ACTION_DOWN:
          case MotionEvent.ACTION_MOVE:
            isTouching = true;
            break;
          case MotionEvent.ACTION_UP:
          case MotionEvent.ACTION_CANCEL:
          default:
            isTouching = false;
            break;
        }
        return false;
      }
    });
  }
}