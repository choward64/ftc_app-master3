package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.TouchSensor;


/**
 * Created by Administrator on 6/17/2017.
 */

public class TouchSensorDemo extends OpMode {

    //Declare our touch sensor!
    TouchSensor touch;

    @Override
    public void init() {
        //Initialize touch sensor from hardware map
        touch = hardwareMap.touchSensor.get("touch");

    }

    @Override
    public void loop() {

        //Print touch sensor value to the screen
        telemetry.addData("Pressed", touch.isPressed());
    }
}