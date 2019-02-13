package agh.edu.pl.computervisionimu;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DummyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);
        DummyWorker dummyWorker = new DummyWorker((SensorManager) getSystemService(Context.SENSOR_SERVICE));
    }
}
