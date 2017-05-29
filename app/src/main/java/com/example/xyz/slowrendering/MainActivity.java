package com.example.xyz.slowrendering;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int count;
    SeekBar seekBar;
    TextView textView;

    Runnable runnable =
            new Runnable() {
                @Override
                public void run() {
                    textView.setText(Integer.toString(count));
                    seekBar.setProgress(count);
                    ++count;
                    seekBar.postDelayed(runnable, 250);
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = (SeekBar) findViewById(R.id.seek);
        textView = (TextView) findViewById(R.id.text);
        seekBar.post(runnable);
    }
}
