package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by seancardosi on 1/13/17.
 */
@Autonomous(name = "Motor_Float", group = "Rise Robot")
@Disabled
public class Motor_Float extends OpMode {

    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;

    public void init() {
        left_back_drive = hardwareMap.dcMotor.get("1");
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_back_drive.setDirection(DcMotor.Direction.REVERSE);
        left_front_drive.setDirection(DcMotor.Direction.REVERSE);
        left_back_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        left_front_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);



        right_back_drive = hardwareMap.dcMotor.get("3");
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.FORWARD);
        right_front_drive.setDirection(DcMotor.Direction.FORWARD);
        right_back_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        right_front_drive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    public void loop() {

        telemetry.addData("encoder 1", left_back_drive.getCurrentPosition());
        telemetry.addData("encoder 2", left_front_drive.getCurrentPosition());
        telemetry.addData("encoder 3", right_back_drive.getCurrentPosition());
        telemetry.addData("encoder 4", right_front_drive.getCurrentPosition());
    }
}
