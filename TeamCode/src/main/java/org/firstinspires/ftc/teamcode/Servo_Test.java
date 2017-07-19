package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by rpcardosimd on 12/28/16.
 */
@TeleOp(name = "pusher test", group = "Rise Robot")
@Disabled
public class Servo_Test extends OpMode {

    Servo left_pusher;
    Servo right_pusher;

    public void init() {

        left_pusher = hardwareMap.servo.get("left_pusher");
        right_pusher = hardwareMap.servo.get("right_pusher");
        left_pusher.setDirection(Servo.Direction.FORWARD);
        right_pusher.setDirection(Servo.Direction.REVERSE);
    }

    public void loop() {


        if (gamepad1.a) {
            left_pusher.setPosition(1.0);
            right_pusher.setPosition(1.0);
        }
        if (gamepad1.b) {
            left_pusher.setPosition(0.0);
            right_pusher.setPosition(0.0);
        }
    }
}
