package agh.edu.pl.computervisionimu;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DummyActivity extends AppCompatActivity implements SensorEventListener {
    private SensorManager sensorManager;
    private TextView view;
    private float[] acceleration = new float[]{0,0 ,0};
    private float[] rotation= new float[]{0,0 ,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dummy);
        view = findViewById(R.id.dummyTextView);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
                SensorManager.SENSOR_DELAY_UI);
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR) {
            rotation = event.values;
            updateView();
        } else if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            acceleration = event.values;
            updateView();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        // register this class as a listener for the orientation and
        // accelerometer sensors
        sensorManager.registerListener(this,
                sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        // unregister listener
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    private void updateView(){
        StringBuilder builder = new StringBuilder("Rotation\n");
        builder.append("x: ").append(rotation[0]).append("\n");
        builder.append("y: ").append(rotation[1]).append("\n");
        builder.append("z: ").append(rotation[2]).append("\n");

        builder.append("Acceleration\n");
        builder.append("x: ").append(acceleration[0]).append("\n");
        builder.append("y: ").append(acceleration[1]).append("\n");
        builder.append("z: ").append(acceleration[2]).append("\n");
        view.setText(builder.toString());
    }
}
