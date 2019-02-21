package com.example.mooreka21_hw2;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * <!-- class MySurfaceView -->
 *
 * MySurfaceView is a subclass of SurfaceView. All
 * elements displayed on the surface view are declared and
 * initialized in this class. It contains elements
 * derived from CustomRect and CustomCircle. All elements
 * are drawn in the onDraw method.
 *
 * @author Kayla Moore
 * @version Spring 2019
 *
 */

public class MySurfaceView extends SurfaceView {

    //declaring protected custom elements and initializing them
    protected CustomRect sky = new CustomRect("SKY", 0xFF64A0B9,
            0, 0, 90000, 750);
    protected CustomRect grass = new CustomRect("GRASS", 0xFF328C0F,
            0, 650, 90000, 90000);
    protected CustomRect pHouse = new CustomRect("PILOT HOUSE", 0xFF6419C8,
            200,300,800,700);
    protected CustomRect roof = new CustomRect("PILOT HOUSE ROOF", 0xFF4B4641,
            180, 250, 820, 300);
    protected CustomRect doors = new CustomRect("PILOT HOUSE DOORS", 0xFF4B4641,
            400, 500, 600, 700);
    protected CustomRect treeTrunk = new CustomRect("TREE TRUNK", 0XFF6F4B2F,
            1150, 400, 1250, 700);
    protected CustomCircle treeLeaves = new CustomCircle("TREE LEAVES", 0xFF5D6F16,
            1200, 350, 150);
    protected CustomCircle sun = new CustomCircle("SUN", 0xFFF5D241,
            1700, 125, 100);

    /* The constructors for MySurfaceView and the init method were
    written based off of what we did in BeefJerky.java during lecture. */
    //1st constructor
    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    //2nd constructor
    public MySurfaceView(Context context, AttributeSet attrs){
        super(context,attrs);
        init();
    }

    //3rd constructor
    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    //init method
    private void init() {
        setWillNotDraw(false);
    }

    //overridden onDraw method
    @Override
    protected void onDraw(Canvas canvas) {
        /* drawing each of my elements on the canvas by calling the drawMe method
        from the CustomElement class */
        sky.drawMe(canvas);
        grass.drawMe(canvas);
        pHouse.drawMe(canvas);
        roof.drawMe(canvas);
        doors.drawMe(canvas);
        treeTrunk.drawMe(canvas);
        treeLeaves.drawMe(canvas);
        sun.drawMe(canvas);
    }
} //end of MySurfaceView
