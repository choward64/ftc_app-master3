package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;


/**
 * Created by Administrator on 6/12/2017.
 */
        /*@TeleOp (name = "Joystick_Drive", group = "Testing")
public class Joystick_Drive extends OpMode{
    public void init(){


        ColorSensor Bottom_color;
        Bottom_color = hardwareMap.get("b_color");
        DcMotor front_left_drive;
        DcMotor front_right_drive;
        DcMotor arm;
        Servo left_arm_servo;
        Servo right_arm_servo;

        front_left_drive = hardwareMap.get("1");//Naming the motors and setting their directions
        front_right_drive = hardwareMap.get("2");
        arm = hardwareMap.get("3");
        front_left_drive.setDirection(DcMotor.Direction.FORWARD);
        front_right_drive.setDirection(DcMotor.Direction.FORWARD);
        arm.setDirection(DcMotor.Direction.FORWARD);

        left_arm_servo = hardwareMap.servo.get("left_s");//Naming the servos and setting their direction
        right_arm_servo = hardwareMap.servo.get("right_s");
        left_arm_servo.setDirection(Servo.Direction.FORWARD);
        right_arm_servo.setDirection(Servo.Direction.REVERSE);

    }
    public void loop(){
        float throttle_left = gamepad1.left_stick_y; //assigning the throttle to the gamepad stick
        float throttle_right = gamepad1.left_stick_y;

        throttle_left = Range.clip(throttle_left, -1, 1); //clipping the output of the sticks so the program does not crash
        throttle_right = Range.clip(throttle_right, -1, 1);


        front_left_drive.setPower(throttle_left);
        front_right_drive.setPower(throttle_right);

        if (gamepad1.a) {
            front_left_drive.setPower(0.3;
            front_right_drive.setPower(0.3);

        }
        float right_arm_servo = gamepad1.right_trigger;
        float left_arm_servo = gamepad1.right_trigger;

       if (gamepad1.right_bumper) {
           if ()
       }
    }
}
*/