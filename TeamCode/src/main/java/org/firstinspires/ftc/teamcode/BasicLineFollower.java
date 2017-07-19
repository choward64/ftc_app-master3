package org.firstinspires.ftc.teamcode;
//"0.0 is a doble" AJ-Foster 2k17
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Administrator on 6/17/2017.
 */
@Autonomous (name = "BasicLineFollower", group = "Testing")
public class BasicLineFollower extends OpMode {

    DcMotor right;
    DcMotor left;
    ColorSensor color;

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        color = hardwareMap.colorSensor.get("color");

        left.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        int light = color.alpha();
        //color value on white
       /* if(light > 20);{
            //turn left
            right.setPower(0.4);
            left.setPower(0.0);
    }
        else {
            //turn right
            right.setPower(0.0);
            left.setPower(0.4);
        }*/
    }
}
