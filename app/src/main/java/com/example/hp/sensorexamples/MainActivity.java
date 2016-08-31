package com.example.hp.sensorexamples;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
  TextView tv1,tv2;
    SensorManager sManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)findViewById(R.id.textView);
        tv2=(TextView)findViewById(R.id.textView2);
        sManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sManager.registerListener(new SensorListener() {
            @Override
            public void onSensorChanged(int sensor, float[] values) {
                tv1.setText("X Value:"+values[0]);
                tv2.setText("Y Value:"+values[1]);

            }

            @Override
            public void onAccuracyChanged(int sensor, int accuracy) {

            }
        },SensorManager.SENSOR_ACCELEROMETER);
    }
}
