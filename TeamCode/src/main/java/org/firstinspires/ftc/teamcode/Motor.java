package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by Administrator on 6/10/2017.
 */

@Autonomous(name = "Motor", group = "Testing")
public class Motor extends OpMode{

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor;

    @Override
    public void init() {
        telemetry.addData("Status", "Initialized");
        motor = hardwareMap.dcMotor.get("motor1");
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
    //Code to run when the op mode is first enabled goes here
    @Override
    public void init_loop(){}
    //This method will be called ONCE when start is pressed
    @Override
    public void start() {
        runtime.reset();
        motor.setTargetPosition(1000);
        motor.setPower(0.5);

    }
    //This method will be called repeatedly in a loop
    @Override
    public void loop() {
        telemetry.addData("Status", "Run Time: " + runtime .toString());
       /* motor.getCurrentPosition(int motor_pos)
            if (motor_pos = 1000;){
             motor.setPower(0.00);*/



    }
}
