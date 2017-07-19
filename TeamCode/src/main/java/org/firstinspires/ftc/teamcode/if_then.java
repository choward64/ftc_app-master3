package org.firstinspires.ftc.teamcode;
/* Importing all of the devices*/

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.IrSeekerSensor;
import com.qualcomm.robotcore.hardware.TouchSensor;


/**
 * Created by Administrator on 6/10/2017.
 */

public class if_then extends OpMode {
   TouchSensor Front_touch;
   ColorSensor Bottom_color;
   ColorSensor Bc;
    IrSeekerSensor ir;
   // IrSeekerSensor irSeekerSensor;

    public void init(){
        Bc = Bottom_color;
        //ir= irSeekerSensor

    }
    public void loop (){

    }
}
