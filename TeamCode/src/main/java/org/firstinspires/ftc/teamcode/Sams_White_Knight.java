package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.EncDrive;
import org.firstinspires.ftc.teamcode.subsystems.ServoManagement;

/**
 * Created by seancardosi on 1/10/17.
 */
@Autonomous(name = "Saaaaaammmmm", group = "Rise Robot")
public class Sams_White_Knight extends LinearOpMode {

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
    boolean running = true;
    Servo ball_servo;
    ServoManagement sm;
    EncDrive ed;

    public void stop_all_motors() {
        left_back_drive.setPower(0);
        right_back_drive.setPower(0);
        left_front_drive.setPower(0);
        right_front_drive.setPower(0);
        sleep(100);
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
            sleep(500);
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

            while (left_back_drive.getCurrentPosition() > left_target) {
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
            sleep(500);
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
            sleep(500);
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
            sleep(500);
        }
    }


    public void runOpMode() throws InterruptedException {

        //Initialize
        sm = new ServoManagement(hardwareMap, telemetry);

        lc = hardwareMap.colorSensor.get("lc");
        rc = hardwareMap.colorSensor.get("rc");
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

        rbc.enableLed(true);
        lbc.enableLed(true);
        rc.enableLed(false);
        lc.enableLed(false);

        lbc.setI2cAddress(I2cAddr.create8bit(0x2c));
        rbc.setI2cAddress(I2cAddr.create8bit(0x5c));
        lc.setI2cAddress(I2cAddr.create8bit(0x4c));//
        rc.setI2cAddress(I2cAddr.create8bit(0x3c));//

        while(!opModeIsActive()){
            telemetry.addData("Status", " Ready!");
            telemetry.update();
            updateTelemetry(telemetry);
            idle();
        }

        while(opModeIsActive()) {
            //Start Running
            telemetry.addData("Status", " Running...");
            telemetry.update();
            updateTelemetry(telemetry);

            // Move forward
            run_encoders_2(230, -.50);

            stop_all_motors();

            // Turn to the right
            turn_encoders_1_right(1434, -.75);

            stop_all_motors();

            // Move forward
            run_encoders_2(2000, -.65);

            run_encoders_2(2230, -.30);

            stop_all_motors();

            // Turn to the left
            turn_encoders_1_left(1520, -.75);

            // Goes towards the white line first beacon
            while (running) {
                left_front_drive.setPower(-0.3);
                left_back_drive.setPower(-0.3);
                right_back_drive.setPower(-0.3);
                right_front_drive.setPower(-0.3);

                telemetry.addData("Left Bottom alpha", lbc.alpha());
                telemetry.addData("Right Bottom alpha", rbc.alpha());
                telemetry.addData("Right Color hue", rc.argb());
                telemetry.addData("Left Color hue", lc.argb());
                telemetry.update();
                updateTelemetry(telemetry);
                if (lbc.alpha() > 0 || rbc.alpha() > 0) {
                    stop_all_motors();
                    running = false;
                }

            }

            running = true;
            stop_all_motors();

            // Moves towards the second beacon white line
            run_encoders_2(1500, -0.5);

            // Determines if at the white line second beacon
            while (running) {

                left_front_drive.setPower(-0.2);
                left_back_drive.setPower(-0.2);
                right_back_drive.setPower(-0.2);
                right_front_drive.setPower(-0.2);

                telemetry.addData("Left Bottom alpha", lbc.alpha());
                telemetry.addData("Right Bottom alpha", rbc.alpha());
                telemetry.addData("Right Color hue", rc.argb());
                telemetry.addData("Left Color hue", lc.argb());
                telemetry.update();
                updateTelemetry(telemetry);
                if (lbc.alpha() > 0 || rbc.alpha() > 0) {
                    stop_all_motors();
                    running = false;
                }
            }

            running = true;
            stop_all_motors();

            // Checks beacon color and moves accordingly.
            while (running) {

                if (rc.blue() > rc.red()) {
                    telemetry.addData("Color: ", "BLUE");
                    running = false;
                }
                if (rc.blue() < rc.red()) {
                    telemetry.addData("Color: ", "RED");
                    run_encoders_2(200, 0.5);
                    stop_all_motors();
                    running = false;

                    telemetry.addData("Left Bottom alpha", lbc.alpha());
                    telemetry.addData("Right Bottom alpha", rbc.alpha());
                    telemetry.addData("Right Color hue", rc.argb());
                    telemetry.addData("Left Color hue", lc.argb());
                    telemetry.update();
                    updateTelemetry(telemetry);
                }
                // Sets the pusher in
                stop_all_motors();

                sm.rightPusher(1);
                sleep(500);
                sm.rightPusher(0);

                running = true;
                stop_all_motors();

                run_encoders_2(1500, 0.5);

                while (running) {

                    left_front_drive.setPower(0.2);
                    left_back_drive.setPower(0.2);
                    right_back_drive.setPower(0.2);
                    right_front_drive.setPower(0.2);

                    telemetry.addData("Left Bottom alpha", lbc.alpha());
                    telemetry.addData("Right Bottom alpha", rbc.alpha());
                    telemetry.addData("Right Color hue", rc.argb());
                    telemetry.addData("Left Color hue", lc.argb());
                    telemetry.update();
                    updateTelemetry(telemetry);
                    if (lbc.alpha() > 0 || rbc.alpha() > 0) {
                        stop_all_motors();
                        running = false;
                    }
                }

                running = true;
                stop_all_motors();

                run_encoders_2(200, -0.25);

                stop_all_motors();

                while (running) {

                    if (rc.blue() > rc.red()) {
                        telemetry.addData("Color: ", "BLUE");
                        running = false;
                    }
                    if (rc.blue() < rc.red()) {
                        telemetry.addData("Color: ", "RED");
                        run_encoders_2(200, 0.5);
                        stop_all_motors();
                        running = false;
                    }
                    telemetry.addData("Left Bottom alpha", lbc.alpha());
                    telemetry.addData("Right Bottom alpha", rbc.alpha());
                    telemetry.addData("Right Color hue", rc.argb());
                    telemetry.addData("Left Color hue", lc.argb());
                    telemetry.update();
                    updateTelemetry(telemetry);
                }

                stop_all_motors();
                sm.rightPusher(1);
                sleep(500);
                sm.rightPusher(0);

                running = true;
                stop_all_motors();

                //ALL DONE
                while (running) {
                    telemetry.addData("ALL ", "DONE!");
                    telemetry.update();
                    updateTelemetry(telemetry);
                }
                idle();
            }
        }
    }
}
