package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Administrator on 6/9/2017.
 */
/*Code needs comments ALWAYS comment code*/

@Autonomous(name = "NullOp", group = "Testing")
public class NullOp extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    BNO055IMU imu;
@Override
public void init_loop(){
    imu.isGyroCalibrated();
}
    @Override
    public void init() {//runs once
        telemetry.addData("Status", "Initialized");
    }

    /*This method will be called ONCE when start is pressed */
    @Override
    public void start(){ //runs once after start button is pressed
        runtime.reset();
    }

    /*This method will be called repeatedly in a loop */
    @Override
    public void loop() { //runs exacty 22ms after
        telemetry.addData("Status", "Run Time: " + runtime.toString());

    }

}
