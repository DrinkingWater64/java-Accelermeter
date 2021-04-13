package example.androidapp.wardboyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private static final String TAG = "MainActivity";

    private SensorManager sensorManager;
    Sensor accelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(MainActivity.this, accelerometer, sensorManager.SENSOR_DELAY_NORMAL);
//            TextView textView = (TextView) findViewById(R.id.data);
//            textView.setText("golmal");

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        TextView textView = (TextView) findViewById(R.id.data1);
        textView.setText("x:"+event.values[0]);
        TextView textView2 = (TextView) findViewById(R.id.data2);
        textView2.setText("y:"+event.values[1]);
        TextView textView3 = (TextView) findViewById(R.id.data3);
        textView3.setText("z:"+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}