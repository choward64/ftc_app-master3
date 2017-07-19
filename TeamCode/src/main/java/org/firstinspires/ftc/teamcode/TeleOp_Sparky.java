package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.subsystems.ServoManagement;

/** Sean Cardosi
 * Team Rise 7719
 * Created by rpcardosimd on 10/25/16.
 */
@TeleOp(name = "TeleOp Sparky", group = "Sparky")
@Disabled
public class TeleOp_Sparky extends OpMode {


    DcMotor left_back_drive;
    DcMotor left_front_drive;
    DcMotor right_back_drive;
    DcMotor right_front_drive;
    DcMotor catapult;
    //    EncDriveTrain edt;
    Servo rcbl;
    Servo lcbl;
    DcMotor Up_Down;
    ServoManagement srvo;

    boolean move_srvos = true;

    public void init() {
        //edt = new EncDriveTrain(hardwareMap);

        left_back_drive = hardwareMap.dcMotor.get("1");
        left_front_drive = hardwareMap.dcMotor.get("2");
        left_back_drive.setDirection(DcMotor.Direction.FORWARD);
        left_front_drive.setDirection(DcMotor.Direction.FORWARD);


        right_back_drive = hardwareMap.dcMotor.get("3");
        right_front_drive = hardwareMap.dcMotor.get("4");
        right_back_drive.setDirection(DcMotor.Direction.REVERSE);
        right_front_drive.setDirection(DcMotor.Direction.REVERSE);
        catapult = hardwareMap.dcMotor.get("catapult");
        Up_Down = hardwareMap.dcMotor.get("UD");
        rcbl = hardwareMap.servo.get("rcbl");
        lcbl = hardwareMap.servo.get("lcbl");
        lcbl.setDirection(Servo.Direction.REVERSE);


//        left_pusher = hardwareMap.servo.get("left_pusher");
//        right_pusher = hardwareMap.servo.get("right_pusher");

        srvo = new ServoManagement(hardwareMap, telemetry);

    }

    public void loop() {
        if (move_srvos) {
            rcbl.setPosition(0.0);
            lcbl.setPosition(0.0);
            move_srvos = false;
        }

        float throttle_left = gamepad1.left_stick_y;// create a varible that is the left gamepad1's stick
        float throttle_right = gamepad1.right_stick_y;// create varible that is the right gamepad1's stick

        float UD = -gamepad2.right_stick_y;//create a varible that is the gamepad2's right stick


        throttle_left = Range.clip(throttle_left, -1, 1);// we clip the motor values so that the motor does not stop while
        throttle_right = Range.clip(throttle_right, -1, 1);
        //trying to run at 101% speed
        UD = Range.clip(UD, -1, 1);


       //l  Up_Down.setPower(UD);// tell the up_down or the "foot" to do what the right joystick does
       // le_left);//tell the motors to do what the gamesticks do
        left_front_drive.setPower(throttle_left);left_back_drive.setPower(throttle_right);
        right_front_drive.setPower(throttle_right);


        //right_back_drive.setPower(thr

        // toggle pushers using bumpers on the 2nd gamepad
        if (gamepad2.left_bumper) {
            if (!srvo.leftpush) {
                srvo.leftPusher(1);
            }
        } else if (!gamepad2.left_bumper) {
            if (srvo.leftpush) {
                srvo.leftPusher(0);
            }
        }
        if (gamepad2.right_bumper) {
            if (!srvo.rightpush) {
                srvo.rightPusher(1);
            }
        } else if (!gamepad2.right_bumper) {
            if (srvo.rightpush) {
                srvo.rightPusher(0);
            }
        }


        if (gamepad2.dpad_up) {// if gamepad2's dpad is pushed up, set the cap bal lifters to 1.0
            rcbl.setPosition(1.0);
            lcbl.setPosition(1.0);
        }
        if (gamepad2.dpad_down) {// if dpad is pressed down, set the cap ball lifters to 0.0
            rcbl.setPosition(0.0);
            lcbl.setPosition(0.0);
        }


        float current = right_front_drive.getCurrentPosition();// get the encoders for right_front_drive

        telemetry.addData("t1", throttle_left);
        telemetry.addData("t2", throttle_right);
        telemetry.addData("UD", UD);
        telemetry.addData("ENCODERS", current);// show encoder ticks right front motor

         if (gamepad2.a) {//if button a is pressed launch catapult until button b is pressed

            catapult.setPower(1.0);//if the gamepad button a is pressed then set the catapult motor to the speed 1
        }
        if (gamepad2.b) {
            catapult.setPower(0.0);//if button b is pressed set the catapult power to 0.0
        }
    }
}
