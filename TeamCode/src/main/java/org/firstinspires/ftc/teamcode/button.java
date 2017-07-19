package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by rpcardosimd on 11/29/16.
 */
@Disabled
@TeleOp(name = "button(even or odd?)", group = "Rise Robot")

public class button extends LinearOpMode {
    int x = 0;


    public void runOpMode() throws InterruptedException {


        waitForStart();
while (opModeIsActive()) {

    if (gamepad1.a) {
        x++;
        sleep(100);
    }

    if (x % 2 == 0) {// if it is even
        telemetry.addData("even", x);
    } else { // if it is odd
        telemetry.addData("odd", x);
    }

}
        requestOpModeStop();
    }
}