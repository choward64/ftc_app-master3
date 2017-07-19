package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**Sean Cardosi
 * Created by rpcardosimd on 12/17/16.
 * Team Rise 7719
 */
@Autonomous(name = "Sparky Red", group = "Sparky")
@Disabled
public class Catapult_For_Competition extends LinearOpMode {

    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;
//    DcMotor shooter1;
//    DcMotor shooter2;
//    Servo ball_servo;
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


//        shooter1 = hardwareMap.dcMotor.get("5");
//        shooter2 = hardwareMap.dcMotor.get("6");
//        shooter1.setDirection(DcMotor.Direction.REVERSE);


//        ball_servo = hardwareMap.servo.get("bs");

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


        left_back_drive.setTargetPosition(-750);
        left_front_drive.setTargetPosition(-750);
        right_back_drive.setTargetPosition(2750);
        right_front_drive.setTargetPosition(2750);

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back_drive.setPower(0.5);
        left_front_drive.setPower(0.5);
        right_back_drive.setPower(0.5);
        right_front_drive.setPower(0.5);
        Thread.sleep(5000);


        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left_back_drive.setTargetPosition(2500);
        left_front_drive.setTargetPosition(2500);
        right_back_drive.setTargetPosition(2500);
        right_front_drive.setTargetPosition(2500);

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back_drive.setPower(1.0);
        left_front_drive.setPower(1.0);
        right_back_drive.setPower(1.0);
        right_front_drive.setPower(1.0);
Thread.sleep(5500);






        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        left_back_drive.setTargetPosition(-1200);
        left_front_drive.setTargetPosition(-1200);
        right_back_drive.setTargetPosition(1200);
        right_front_drive.setTargetPosition(1200);

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left_back_drive.setPower(0.5);
        left_front_drive.setPower(0.5);
        right_back_drive.setPower(0.5);
        right_front_drive.setPower(0.5);
        Thread.sleep(1000);




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

        left_back_drive.setPower(1.0);
        left_front_drive.setPower(1.0);
        right_back_drive.setPower(1.0);
        right_front_drive.setPower(1.0);
        Thread.sleep(4000);
    }
}
