package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

/**
 * Created by Administrator on 6/24/2017.
 */
@TeleOp(name= "IMU Test", group = "Testing")
public class IMUTest extends OpMode {

    BNO055IMU imu;
    DcMotor left, right;

    @Override
    public void init() {
       imu = hardwareMap.get(BNO055IMU.class, "imu");
//        imu = hardwareMap.accelerationSensor.get("imu");
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit        = BNO055IMU.AngleUnit.DEGREES;
        left.setDirection(DcMotorSimple.Direction.REVERSE);
        imu.initialize(parameters);
    }

    @Override
    public void loop() {

        Orientation angles = imu.getAngularOrientation();

        telemetry.addData("Heading", angles.firstAngle);

        left.setPower(gamepad1.left_stick_y);
        right.setPower(gamepad1.right_stick_y);
    }
}
