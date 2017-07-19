package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by Administrator on 2/6/2017.
 */
@TeleOp(name = "The Black Knight", group = "Rise Robot")

public class The_Black_Knight extends OpMode {

    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;

    public void init() {

        left_back_drive = hardwareMap.dcMotor.get("1");
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_back_drive.setDirection(DcMotor.Direction.FORWARD);
        left_front_drive.setDirection(DcMotor.Direction.FORWARD);


        right_back_drive = hardwareMap.dcMotor.get("3");
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.REVERSE);
        right_front_drive.setDirection(DcMotor.Direction.REVERSE);
    }

    public void loop() {

        float throttle_left = -gamepad1.left_stick_y;
        float throttle_right = -gamepad1.right_stick_y;


        throttle_left = Range.clip(throttle_left, -1, 1);
        throttle_right = Range.clip(throttle_right, -1, 1);


        left_back_drive.setPower(throttle_right);
        left_front_drive.setPower(throttle_right);
        right_back_drive.setPower(throttle_left);
        right_front_drive.setPower(throttle_left);
    }
}
