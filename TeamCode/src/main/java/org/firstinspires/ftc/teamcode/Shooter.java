package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by rpcardosimd on 12/21/16.
 */
@TeleOp(name = "Shooter Testing", group = "Rise Robot")
@Disabled
public class Shooter extends OpMode {
    DcMotor shooter1;
    DcMotor shooter2;
    Servo ball_servo;
    double speed;
    @Override
    public void init() {
        shooter1 = hardwareMap.dcMotor.get("5");
        shooter2 = hardwareMap.dcMotor.get("6");
        ball_servo = hardwareMap.servo.get("bs");
        shooter1.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {

        if (gamepad1.start) {
            speed += 0.0005;
        }
        if (gamepad1.back) {
            speed -= 0.0005;
        }

        if (gamepad1.right_trigger > 0.75) {
            shooter1.setPower(speed);
            shooter2.setPower(speed);
        }else{
            shooter1.setPower(0);
            shooter2.setPower(0);
        }
        if (gamepad1.a) {
            ball_servo.setPosition(1);
        }else{
            ball_servo.setPosition(0);
        }
        telemetry.addData("speed", speed);
    }
}
