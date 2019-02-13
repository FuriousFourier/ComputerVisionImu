package agh.edu.pl.computervisionimu;

import android.hardware.SensorManager;
import android.util.Log;

public class DummyWorker implements Runnable {

    private SensorManager sensorManager;

    public static final String TAG = "ComputerVisionImu";

    public DummyWorker(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
    }

    @Override
    public void run() {
        Log.i(TAG, "Siema");

    }
}
