package com.example.mooreka21_hw2;

import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import static android.graphics.Color.red;
import static android.graphics.Color.green;
import static android.graphics.Color.blue;
import static android.graphics.Color.rgb;

/**
 * <!-- class Controller -->
 *
 * Controller implements View.OnTouchListener and SeekBar.OnSeekBarChangeListener.
 * This class deals with event handling and is used to determine if the user has
 * touched a custom element or adjusted the values of the seekBars, then handles
 * each event accordingly.
 *
 * @author Kayla Moore
 * @version Spring 2019
 *
 */

public class Controller implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    //declaring all private variables and views that are needed
    private TextView currentText;
    private SeekBar seekRed;
    private TextView redValueText;
    private SeekBar seekGreen;
    private TextView greenValueText;
    private SeekBar seekBlue;
    private TextView blueValueText;
    private MySurfaceView drawing;
    private int red, green, blue;
    private CustomElement element;

    /* Constructor for the Controller class initializes our variables and sets
    listeners to the seekBars and surfaceView */
    public Controller(TextView currTxt, SeekBar red, TextView redVal, SeekBar green,
                      TextView greenVal, SeekBar blue, TextView blueVal, MySurfaceView mySV) {
        currentText = currTxt;
        seekRed = red;
            seekRed.setOnSeekBarChangeListener(this);
            redValueText = redVal;
        seekGreen = green;
            seekGreen.setOnSeekBarChangeListener(this);
            greenValueText = greenVal;
        seekBlue = blue;
            seekBlue.setOnSeekBarChangeListener(this);
            blueValueText = blueVal;
        drawing = mySV;
            drawing.setOnTouchListener(this);
    }

    //OnTouch method is called when the user touches the screen
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        //setting the x and y locations that the user touched
        int xTouch = (int)event.getX();
        int yTouch = (int)event.getY();

        /* These if statements check if the user touched a custom element.
        If so, element is set to the custom element touched, and currentText is updated */
        if(drawing.roof.containsPoint(xTouch, yTouch)) {
            element = drawing.roof;
            currentText.setText("PILOT HOUSE ROOF");
        }
        else if(drawing.doors.containsPoint(xTouch, yTouch)) {
            element = drawing.doors;
            currentText.setText("PILOT HOUSE DOORS");
        }
        else if(drawing.pHouse.containsPoint(xTouch, yTouch)) {
            element = drawing.pHouse;
            currentText.setText("PILOT HOUSE");
        }
        else if(drawing.treeLeaves.containsPoint(xTouch, yTouch)) {
            element = drawing.treeLeaves;
            currentText.setText("TREE LEAVES");
        }
        else if(drawing.treeTrunk.containsPoint(xTouch, yTouch)) {
            element = drawing.treeTrunk;
            currentText.setText("TREE TRUNK");
        }
        else if(drawing.grass.containsPoint(xTouch, yTouch)) {
            element = drawing.grass;
            currentText.setText("GRASS");
        }
        else if(drawing.sun.containsPoint(xTouch, yTouch)) {
            element = drawing.sun;
            currentText.setText("SUN");
        }
        else if(drawing.sky.containsPoint(xTouch, yTouch)) {
            element = drawing.sky;
            currentText.setText("SKY");
        }

        //assigns red to the red value of element and updates seekRed's progress
        red = red(element.getColor());
        seekRed.setProgress(red);
        //assigns green to the green value of element and updates seekGreen's progress
        green = green(element.getColor());
        seekGreen.setProgress(green);
        //assigns blue to the blue value of element and updates seekBlue's progress
        blue = blue(element.getColor());
        seekBlue.setProgress(blue);

        return true;
    }

    //onProgressChanged method tracks and adjusts the progress for each seekBar
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        //updates seekRed as the user adjusts the progress
        if(seekBar == seekRed) {
            red = progress;
            redValueText.setText("" + progress);
        }
        //updates seekGreen as the user adjusts the progress
        if(seekBar == seekGreen) {
            green = progress;
            greenValueText.setText("" + progress);
        }
        //updates seekBlue as the user adjusts the progress
        if(seekBar == seekBlue) {
            blue = progress;
            blueValueText.setText("" + progress);
        }
        /* if fromUser is true, then the current element's color will be updated
        according to the values indicated on each seekBar */
        if(fromUser) {
            element.setColor(rgb(red, green, blue));
            drawing.invalidate(); //learned from an example in lecture
        }
    }

    //unneeded methods
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { /*ignore*/}

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { /*ignore*/ }

} //end of Controller
