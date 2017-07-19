package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Administrator on 6/10/2017.
 */
@Autonomous(name = "MotorMove", group = "Testing")
public class MotorMove extends OpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor motor;

    @Override
    public void init() {
        telemetry.addData("Status", "Intialized");
        motor = hardwareMap.dcMotor.get("motor1");
    }

    @Override
    public void init_loop() {
    }

    @Override
    public void start() {
        runtime.reset();
        //motor.setPower(1.0);
        //motor.setpower(0.5);
        motor.setPower(0.0);
    }

    @Override
    public void loop() {
        telemetry.addData("Status", "Run time: " + runtime.toString());
        telemetry.addData("Position", motor.getCurrentPosition());

        motor.setPower(gamepad1.left_stick_y);
    }
}


