package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.subsystems.BallManagementSystem;


/**
 * Created by seancardosi on 1/7/17.
 */
@TeleOp(name = "button new", group = "Rise Robot")
@Disabled
public class New_Button extends LinearOpMode {

    DcMotor shooter1;
    DcMotor shooter2;
    boolean shooter_off = true;
    BallManagementSystem bms;
    boolean true_boo = true;


    public void runOpMode() throws InterruptedException{

        bms = new BallManagementSystem(hardwareMap, telemetry);
        shooter1 = hardwareMap.dcMotor.get("5");
        shooter2 = hardwareMap.dcMotor.get("6");
        shooter2.setDirection(DcMotor.Direction.REVERSE);
        shooter1.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();

        while (true_boo) {

        bms.update();

        if (shooter_off) {// if shooter_off = true
            bms.setShooterTarget(0);
            bms.setShooterActive(false);
        }

        if (!shooter_off) {// if shooter_off = false
            bms.setShooterTarget(1);
            bms.setShooterActive(true);
        }

        if (gamepad1.a) {// make shooter_off the opposite of what it currently is i think if button a is pressed
            shooter_off = !shooter_off;
            sleep(300);
        }

        }
    }
}