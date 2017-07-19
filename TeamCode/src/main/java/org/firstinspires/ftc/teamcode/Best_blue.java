package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**Sean Cardosi
 * Created by rpcardosimd on 12/17/16.
 * Team Rise 7719
 */
@Disabled
@Autonomous(name = "Sparky blue", group = "Sparky")

public class Best_blue extends LinearOpMode {

    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;
    DcMotor catapult;




    public void runOpMode() throws InterruptedException {

        left_back_drive = hardwareMap.dcMotor.get("1");
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_back_drive.setDirection(DcMotor.Direction.REVERSE);
        left_front_drive.setDirection(DcMotor.Direction.REVERSE);


        right_back_drive = hardwareMap.dcMotor.get("3");
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.FORWARD);
        right_front_drive.setDirection(DcMotor.Direction.FORWARD);


        catapult = hardwareMap.dcMotor.get("catapult");




        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        left_back_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.RUN_USING_ENCODER);


        waitForStart();



        catapult.setPower(1);
        Thread.sleep(2500);
        catapult.setPower(0);


        // turn towards the center vortex
        left_back_drive.setTargetPosition(-350);
        left_front_drive.setTargetPosition(-350);
        right_back_drive.setTargetPosition(2350);
        right_front_drive.setTargetPosition(2350);

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back_drive.setPower(0.5);
        left_front_drive.setPower(0.5);
        right_back_drive.setPower(0.5);
        right_front_drive.setPower(0.5);
        Thread.sleep(3000);



        // go forward and knock the cap ball off the center vortex
        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left_back_drive.setTargetPosition(2650);
        left_front_drive.setTargetPosition(2650);
        right_back_drive.setTargetPosition(2650);
        right_front_drive.setTargetPosition(2650);

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back_drive.setPower(0.5);
        left_front_drive.setPower(0.5);
        right_back_drive.setPower(0.5);
        right_front_drive.setPower(0.5);
        Thread.sleep(5500);



        // turn towards the corner vortex
        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left_back_drive.setTargetPosition(1200);
        left_front_drive.setTargetPosition(1200);
        right_back_drive.setTargetPosition(-1200);
        right_front_drive.setTargetPosition(-1200);

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back_drive.setPower(0.5);
        left_front_drive.setPower(0.5);
        right_back_drive.setPower(0.5);
        right_front_drive.setPower(0.5);
        Thread.sleep(1000);



        //go forward and park on the corner vortex
        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left_back_drive.setTargetPosition(4400);
        left_front_drive.setTargetPosition(4400);
        right_back_drive.setTargetPosition(4400);
        right_front_drive.setTargetPosition(4400);

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back_drive.setPower(0.5);
        left_front_drive.setPower(0.5);
        right_back_drive.setPower(0.5);
        right_front_drive.setPower(0.5);
        Thread.sleep(4000);
    }
}
