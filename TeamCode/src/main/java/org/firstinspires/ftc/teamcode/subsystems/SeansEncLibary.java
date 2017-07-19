package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by seancardosi on 1/3/17.
 */

public class SeansEncLibary {
    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;
    final int FORWARD = 1;
    final int BACKWARD = -1;
    final int RIGHT = -1;
    final int LEFT = 1;


    Telemetry telemetry;

    public SeansEncLibary(HardwareMap hardwareMap, Telemetry telemetry) {

        left_back_drive = hardwareMap.dcMotor.get("1");
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_back_drive.setDirection(DcMotor.Direction.REVERSE);
        left_front_drive.setDirection(DcMotor.Direction.REVERSE);


        right_back_drive = hardwareMap.dcMotor.get("3");
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.FORWARD);
        right_front_drive.setDirection(DcMotor.Direction.FORWARD);
    }
    public void stop_all_motors(){
        left_back_drive.setPower(0);
        right_back_drive.setPower(0);
        left_front_drive.setPower(0);
        right_front_drive.setPower(0);
    }

    public void run_encoders(int distance, double power){

        if (power > 0) {
            int left_target = left_back_drive.getCurrentPosition() + distance;
            int right_target = left_back_drive.getCurrentPosition() + distance;

            while (left_back_drive.getCurrentPosition() < left_target || right_back_drive.getCurrentPosition() < right_target) {
                left_back_drive.setPower(power);
                right_back_drive.setPower(power);
                left_front_drive.setPower(power);
                right_front_drive.setPower(power);
                telemetry.addData("encoder 1", left_back_drive.getCurrentPosition());
                telemetry.addData("encoder 2", left_front_drive.getCurrentPosition());
                telemetry.addData("encoder 3", right_back_drive.getCurrentPosition());
                telemetry.addData("encoder 4", right_front_drive.getCurrentPosition());
                telemetry.update();
            }
        } else {
            int left_target = left_back_drive.getCurrentPosition() - distance;
            int right_target = left_back_drive.getCurrentPosition() - distance;

            while (left_back_drive.getCurrentPosition() > left_target || right_back_drive.getCurrentPosition() > right_target) {
                left_back_drive.setPower(power);
                right_back_drive.setPower(power);
                left_front_drive.setPower(power);
                right_front_drive.setPower(power);
                telemetry.addData("encoder 1", left_back_drive.getCurrentPosition());
                telemetry.addData("encoder 2", left_front_drive.getCurrentPosition());
                telemetry.addData("encoder 3", right_back_drive.getCurrentPosition());
                telemetry.addData("encoder 4", right_front_drive.getCurrentPosition());
                telemetry.update();
            }

            left_back_drive.setPower(0);
            right_back_drive.setPower(0);
            left_front_drive.setPower(0);
            right_front_drive.setPower(0);
        }
    }

    public void turn_encoders(int distance, double power) {
        if (power > 0) {
            int left_target = left_back_drive.getCurrentPosition() - distance;

            while (left_back_drive.getCurrentPosition() > left_target) {
                left_back_drive.setPower(-power);
                left_front_drive.setPower(-power);
                right_back_drive.setPower(power);
                right_front_drive.setPower(power);
                telemetry.addData("encoder 1", left_back_drive.getCurrentPosition());
                telemetry.addData("encoder 2", left_front_drive.getCurrentPosition());
                telemetry.addData("encoder 3", right_back_drive.getCurrentPosition());
                telemetry.addData("encoder 4", right_front_drive.getCurrentPosition());
                telemetry.update();
            }
        } else {
            int left_target = left_back_drive.getCurrentPosition() + distance;

            while (left_back_drive.getCurrentPosition() < left_target) {
                left_back_drive.setPower(-power);
                left_front_drive.setPower(-power);
                right_back_drive.setPower(power);
                right_front_drive.setPower(power);
                telemetry.addData("encoder 1", left_back_drive.getCurrentPosition());
                telemetry.addData("encoder 2", left_front_drive.getCurrentPosition());
                telemetry.addData("encoder 3", right_back_drive.getCurrentPosition());
                telemetry.addData("encoder 4", right_front_drive.getCurrentPosition());
                telemetry.update();
            }

            left_back_drive.setPower(0);
            right_back_drive.setPower(0);
            left_front_drive.setPower(0);
            right_front_drive.setPower(0);
        }
    }
    // stop motors    stop_all_motors
    //stop all motors after every function
    //go forward   run_encoders(1600, 1); or run_encoders(1600, FORWARD);
    //go backwards    run_encoders(1600, -1); or run_encoders(1600, BACKWARDS);
    //turn right     turn_encoders(1700, -1); or turn_encoders(1700, RIGHT);
    //turn left     turn_encoders(1700, 1); or turn_encoders(1700, LEFT);
}