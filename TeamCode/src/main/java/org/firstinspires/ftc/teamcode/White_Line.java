package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by seancardosi on 1/10/17.
 */
@Autonomous(name = "Color Bottom Test", group = "Rise Robot")
@Disabled
public class White_Line extends LinearOpMode {

    ColorSensor lbc;
    ColorSensor rbc;
    ColorSensor lc;
    ColorSensor rc;
    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;
    DcMotor shooter1;
    DcMotor shooter2;
    DcMotor conveyor_belt;
    Servo right_pusher;
    Servo left_pusher;
    boolean true_boo = true;
    Servo ball_servo;

    public void stop_all_motors() {
        left_back_drive.setPower(0);
        right_back_drive.setPower(0);
        left_front_drive.setPower(0);
        right_front_drive.setPower(0);
    }

    public void run_encoders_2(int distance, double power) {

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
    public void turn_encoders_1_left(int distance, double power) {

        if (power > 0) {
            int left_target = left_back_drive.getCurrentPosition() + distance;
            int right_target = right_back_drive.getCurrentPosition() + distance;

            while (left_back_drive.getCurrentPosition() < left_target) {
                left_back_drive.setPower(power);
                left_front_drive.setPower(power);
                telemetry.addData("encoder 1", left_back_drive.getCurrentPosition());
                telemetry.addData("encoder 2", left_front_drive.getCurrentPosition());
                updateTelemetry(telemetry);
            }
        } else {
            int left_target = left_back_drive.getCurrentPosition() - distance;
            int right_target = right_back_drive.getCurrentPosition() - distance;

            while (left_back_drive.getCurrentPosition() > left_target ) {
                left_back_drive.setPower(power);
                left_front_drive.setPower(power);
                telemetry.addData("encoder 1", left_back_drive.getCurrentPosition());
                telemetry.addData("encoder 2", left_front_drive.getCurrentPosition());
                updateTelemetry(telemetry);
            }

            left_back_drive.setPower(0);
            right_back_drive.setPower(0);
            left_front_drive.setPower(0);
            right_front_drive.setPower(0);
            sleep(1000);
        }
    }
    public void turn_encoders_1_right(int distance, double power) {

        if (power > 0) {
            int left_target = left_back_drive.getCurrentPosition() + distance;
            int right_target = right_back_drive.getCurrentPosition() + distance;

            while (right_back_drive.getCurrentPosition() < right_target) {
                right_back_drive.setPower(power);
                right_front_drive.setPower(power);
                telemetry.addData("encoder 3", right_back_drive.getCurrentPosition());
                telemetry.addData("encoder 4", right_front_drive.getCurrentPosition());
                updateTelemetry(telemetry);
            }
        } else {
            int left_target = left_back_drive.getCurrentPosition() - distance;
            int right_target = right_back_drive.getCurrentPosition() - distance;

            while (right_back_drive.getCurrentPosition() > right_target) {
                right_back_drive.setPower(power);
                right_front_drive.setPower(power);
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

    public void turn_encoders_2(int distance, double power) {
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


        lbc = hardwareMap.colorSensor.get("lbc");
        rbc = hardwareMap.colorSensor.get("rbc");
        left_back_drive = hardwareMap.dcMotor.get("1");
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_back_drive.setDirection(DcMotor.Direction.REVERSE);
        left_front_drive.setDirection(DcMotor.Direction.REVERSE);


        right_back_drive = hardwareMap.dcMotor.get("3");
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.FORWARD);
        right_front_drive.setDirection(DcMotor.Direction.FORWARD);

        shooter1 = hardwareMap.dcMotor.get("5");
        shooter2 = hardwareMap.dcMotor.get("6");
        shooter1.setDirection(DcMotor.Direction.REVERSE);


        ball_servo = hardwareMap.servo.get("bs");

        conveyor_belt = hardwareMap.dcMotor.get("cb");
        conveyor_belt.setDirection(DcMotor.Direction.REVERSE);

        lc = hardwareMap.colorSensor.get("lc");
        rc = hardwareMap.colorSensor.get("rc");

        left_pusher = hardwareMap.servo.get("left_pusher");
        left_pusher.setDirection(Servo.Direction.FORWARD);
        right_pusher = hardwareMap.servo.get("right_pusher");
        right_pusher.setDirection(Servo.Direction.FORWARD);

        waitForStart();

        rbc.enableLed(true);
        lbc.enableLed(true);
        rc.enableLed(false);
        lc.enableLed(false);

        lbc.setI2cAddress(I2cAddr.create8bit(0x2c));
        rbc.setI2cAddress(I2cAddr.create8bit(0x3c));
        lc.setI2cAddress(I2cAddr.create8bit(0x4c));//
        rc.setI2cAddress(I2cAddr.create8bit(0x1c));//

        //shooter1.setPower(1);


        turn_encoders_1_right(2400, -1);

        stop_all_motors();

        run_encoders_2(3900, -1);

        stop_all_motors();

        turn_encoders_1_left(1550, -1);

        stop_all_motors();

        while (true_boo) {
            left_front_drive.setPower(-0.1);
            left_back_drive.setPower(-0.1);
            right_back_drive.setPower(-0.1);
            right_front_drive.setPower(-0.1);

            telemetry.addData("Left Bottom hue", lbc.argb());
            telemetry.addData("Right Bottom hue", rbc.argb());
            telemetry.addData("Right Color hue", rc.argb());
            telemetry.addData("Left Color hue",lc.argb());
            telemetry.update();
            updateTelemetry(telemetry);
            if (lbc.argb() >= 6000 || rbc.argb() >= 6000) {
                true_boo = false;
            }
        }
        stop_all_motors();
        while (!true_boo) {

            telemetry.addData("Right Color red", rc.red());
            telemetry.addData("Left Color red",lc.red());
            telemetry.update();
            updateTelemetry(telemetry);
        }
    }
}

