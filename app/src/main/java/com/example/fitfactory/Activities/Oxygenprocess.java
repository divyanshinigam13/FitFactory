package com.example.fitfactory.Activities;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fitfactory.Activities.MainActivity.MainActivity;
import com.example.fitfactory.R;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

public class Oxygenprocess extends AppCompatActivity {

    private static final String TAG = "OxygenMeasure";
    private static final AtomicBoolean processing = new AtomicBoolean(false);
    private static final double redblueratio = 0;
    private static Camera camera = null;
    private static SurfaceHolder previewholder = null;
    private static PowerManager.WakeLock wakeLock = null;
    private static long startTime = 0;
    public int progP = 0;
    public int inc = 0;
    public int o2;
    public ArrayList<Double> redavglist = new ArrayList<>();
    public ArrayList<Double> blueavglist = new ArrayList<>();
    public int counter = 0;
    double stdr = 0;
    double stdb = 0;
    double sumred = 0;
    double sumblue = 0;
    private SurfaceView preview = null;
    //    private Toast mainToast;
    private ProgressBar progressofo2;
    private double SamplingFreq;
    private final Camera.PreviewCallback previewCallback = new Camera.PreviewCallback() {
        @Override
        public void onPreviewFrame(byte[] data, Camera camera) {
            if (data == null) throw new NullPointerException();
            Camera.Size size = camera.getParameters().getPreviewSize();
            if (size == null) throw new NullPointerException();
            if (!processing.compareAndSet(false, true)) return;

            int width = size.width;
            int height = size.height;
            double RedAvg;
            double BlueAvg;

            RedAvg = imageprocessing.colrodecoderRGB(data.clone(), height, width, 1);
            sumred += RedAvg;
            BlueAvg = imageprocessing.colrodecoderRGB(data.clone(), height, width, 2);
            sumblue += BlueAvg;

            redavglist.add(RedAvg);
            blueavglist.add(BlueAvg);

            ++counter;
            if (RedAvg < 200) {
                inc = 0;
                progP = inc;
                progressofo2.setProgress(progP);
                processing.set(false);
            }
//            Log.d("sumred", " sumred"+sumred);
//            Log.d("sumblue", " sumblue"+sumblue);
            long endTime = System.currentTimeMillis();
            double totaltime = (endTime - startTime) / 1000d;
            if (totaltime >= 30) {
                startTime = System.currentTimeMillis();
                SamplingFreq = (counter / totaltime);
                Double[] red = redavglist.toArray(new Double[redavglist.size()]);
                Double[] Blue = blueavglist.toArray(new Double[blueavglist.size()]);
                double HRfreq = com.example.fitfactory.Activities.Math.Fft.FFT(red, counter, SamplingFreq);
                double bpm = (int) ceil(HRfreq * 60);
                double meanr = sumred / counter;
                double meanb = sumblue / counter;

                for (int i = 0; i < counter - 1; i++) {
                    Double bufferb = Blue[i];

                    stdb += ((bufferb - meanb) * (bufferb - meanb));
//                    Log.d("qwerty", " stdb"+stdb);
                    Double bufferr = red[i];

                    stdr += ((bufferr - meanr) * (bufferr - meanr));
//                    Log.d("qwerty", "stdr "+stdr);
                }

                double varr = sqrt(stdr / (counter - 1));
                double varb = sqrt(stdb / (counter - 1));
                double R = (varr / meanr) / (varb / meanb);
//                Log.d("var", "varr "+varr+" varb"+varb+" R"+R);
                double spo2 = 100 - (15 * R);
                o2 = (int) (spo2);
                if ((o2 < 80 || o2 > 99) || (bpm < 45 || bpm > 200)) {
                    inc = 0;
                    progP = inc;
                    progressofo2.setProgress(progP);
                    Toast.makeText(getApplicationContext(), "Measurement failed", Toast.LENGTH_SHORT).show();
                    startTime = System.currentTimeMillis();
                    counter = 0;
                    processing.set(false);
                }
            }
            if (o2 != 0) {
                Intent i = new Intent(com.example.fitfactory.Activities.Oxygenprocess.this, oxygencalculator.class);
                i.putExtra("o2r", o2);
                startActivity(i);
                finish();
            }
            if (RedAvg != 0) {
                progP = inc++ / 34;
                progressofo2.setProgress(progP);
            }
            processing.set(false);
        }
    };
    public final SurfaceHolder.Callback surfacecallback = new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(@NonNull SurfaceHolder holder) {
            try {
                camera.setPreviewDisplay(previewholder);
                camera.setPreviewCallback(previewCallback);
            } catch (Throwable t) {
                Log.d(TAG, "surfaceCreated: ", t);
            }
        }

        @Override
        public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            Camera.Size size = getsmallestpreviewsize(width, height, parameters);
            if (size != null) {
                parameters.setPreviewSize(size.width, size.height);
            }
            camera.setParameters(parameters);
            camera.startPreview();
        }

        @Override
        public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

        }
    };

    @SuppressLint("InvalidWakeLockTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oxygenprocess);

        preview = findViewById(R.id.preview);
        previewholder = preview.getHolder();
        previewholder.addCallback(surfacecallback);
        previewholder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        progressofo2 = findViewById(R.id.progressofo2);
        progressofo2.setProgress(0);

        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK, "notdimscreen");
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onResume() {
        super.onResume();
        wakeLock.acquire();
        camera = Camera.open();
        camera.setDisplayOrientation(90);
        startTime = System.currentTimeMillis();
    }

    @Override
    protected void onPause() {
        super.onPause();
        wakeLock.release();
        camera.setPreviewCallback(null);
        camera.stopPreview();
        camera.release();
        camera = null;
    }

    private Camera.Size getsmallestpreviewsize(int width, int height, Camera.Parameters parameters) {
        Camera.Size result = null;
        for (Camera.Size size : parameters.getSupportedPreviewSizes()) {
            if (size.width <= width && size.height <= height) {
                if (result == null) {
                    result = size;
                } else {
                    int resultarea = result.width * result.height;
                    int newarea = size.width * size.height;
                    if (newarea < resultarea) result = size;
                }
            }
        }
        return result;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(com.example.fitfactory.Activities.Oxygenprocess.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}