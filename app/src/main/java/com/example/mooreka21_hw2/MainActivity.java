package com.example.mooreka21_hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.SeekBar;

/**
 * <!-- class ActivityMain -->
 *
 * Main Activity class launches the app through the
 * onCreate method. All necessary views are initialized.
 *
 * @author Kayla Moore
 * @version Spring 2019
 *
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing required views
        TextView currentText = findViewById(R.id.currentText);
        SeekBar seekRed = findViewById(R.id.seekBarRed);
            TextView redValueText = findViewById(R.id.redValueText);
        SeekBar seekGreen = findViewById(R.id.seekBarGreen);
            TextView greenValueText = findViewById(R.id.greenValueText);
        SeekBar seekBlue = findViewById(R.id.seekBarBlue);
            TextView blueValueText = findViewById(R.id.blueValueText);
        MySurfaceView drawing = findViewById(R.id.surfaceView);

        //declaring new controller object
        Controller control = new Controller(currentText, seekRed, redValueText, seekGreen,
                greenValueText, seekBlue, blueValueText, drawing);
        //telling the controller class any time something happens
        seekRed.setOnSeekBarChangeListener(control);
        seekGreen.setOnSeekBarChangeListener(control);
        seekBlue.setOnSeekBarChangeListener(control);
    }
} //end of MainActivity
