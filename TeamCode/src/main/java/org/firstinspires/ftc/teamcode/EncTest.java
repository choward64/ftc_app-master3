package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by seancardosi on 1/3/17.
 */
//@Autonomous(name = "Blue 2 ball", group = "The White Night")

public class EncTest extends LinearOpMode {


    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;
    DcMotor conveyor_belt;
    DcMotor shooter1;
    DcMotor shooter2;
    Servo ball_servo;
    Servo right_pusher;
    Servo left_pusher;

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
                updateTelemetry(telemetry);
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
                updateTelemetry(telemetry);
            }

            left_back_drive.setPower(0);
            right_back_drive.setPower(0);
            left_front_drive.setPower(0);
            right_front_drive.setPower(0);
            sleep(1000);
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
                updateTelemetry(telemetry);
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
                updateTelemetry(telemetry);
            }

            left_back_drive.setPower(0);
            right_back_drive.setPower(0);
            left_front_drive.setPower(0);
            right_front_drive.setPower(0);
            sleep(1000);
        }
    }

    public void runOpMode() throws InterruptedException{
        left_back_drive = hardwareMap.dcMotor.get("1");
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_back_drive.setDirection(DcMotor.Direction.REVERSE);
        left_front_drive.setDirection(DcMotor.Direction.REVERSE);


        right_back_drive = hardwareMap.dcMotor.get("3");
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.FORWARD);
        right_front_drive.setDirection(DcMotor.Direction.FORWARD);


        left_pusher = hardwareMap.servo.get("left_pusher");
        left_pusher.setDirection(Servo.Direction.FORWARD);
        right_pusher = hardwareMap.servo.get("right_pusher");
        right_pusher.setDirection(Servo.Direction.REVERSE);



        shooter1 = hardwareMap.dcMotor.get("5");
        shooter2 = hardwareMap.dcMotor.get("6");
        shooter1.setDirection(DcMotor.Direction.REVERSE);


        ball_servo = hardwareMap.servo.get("bs");

        conveyor_belt = hardwareMap.dcMotor.get("cb");
        conveyor_belt.setDirection(DcMotor.Direction.REVERSE);


        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        left_back_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();

        left_pusher.setPosition(0);
        right_pusher.setPosition(0);
        ball_servo.setPosition(0);

        //go forward is positive 1
        run_encoders(1550, -1);

        stop_all_motors();

        shooter1.setPower(.67);
        shooter2.setPower(.67);
        Thread.sleep(3000);

        shooter1.setPower(.67);
        shooter2.setPower(.67);
        ball_servo.setPosition(1);
        Thread.sleep(3000);

        ball_servo.setPosition(0.0);

//        shooter1.setPower(0);
//        shooter2.setPower(0);

        conveyor_belt.setPower(1);
        Thread.sleep(2500);
        conveyor_belt.setPower(0.0);

        shooter1.setPower(.67);
        shooter2.setPower(.67);
        Thread.sleep(3000);

        shooter1.setPower(.67);
        shooter2.setPower(.67);
        ball_servo.setPosition(1);
        Thread.sleep(3000);

        shooter1.setPower(0);
        shooter2.setPower(0);
        ball_servo.setPosition(0);

        //go backward
        run_encoders(800, -1);

        stop_all_motors();

        //turn right
        turn_encoders(1700, -1);

        stop_all_motors();

        run_encoders(3600, -1);


//          //turn left
//        turn_encoders(2200, 1);
//
//        stop_all_motors();
//
//          //turn right
//        turn_encoders(2200, -1);
//
//        stop_all_motors();
//
//        run_encoders(2200, 1);
//
//        stop_all_motors();
//
//        sleep(1000);
//        run_encoders(2000, -1);
//
//          stop_all_motors();

    }
}