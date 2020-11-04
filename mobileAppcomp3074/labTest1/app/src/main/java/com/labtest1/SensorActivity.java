package com.labtest1;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SensorActivity extends Activity implements SensorEventListener {

    TextView textView;
    private SensorManager sensorManager;
    private Sensor lightSensor;
    private Sensor tempSensor;

    @Override
    protected void onCreate( Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        textView = (TextView) findViewById(R.id.lbl_light_value);

        //instance of sensor service and get light sensor
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        tempSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, lightSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == Sensor.TYPE_LIGHT) {
            textView.setText("" + event.values[0]);
        }
        if(event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE){

        }
    }
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy){
        //not used
    }
}
