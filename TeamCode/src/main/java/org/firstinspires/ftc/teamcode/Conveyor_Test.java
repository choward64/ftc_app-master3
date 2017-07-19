package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by rpcardosimd on 12/29/16.
 */
@TeleOp(name = "Conveyor_Test", group = "Rise Robot")
@Disabled
public class Conveyor_Test extends OpMode {

    DcMotor conveyor_belt;

    @Override
    public void init() {
        conveyor_belt = hardwareMap.dcMotor.get("cb");
        conveyor_belt.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {

        if (gamepad1.dpad_up) {
            conveyor_belt.setPower(1.0);
        } else if (!gamepad1.dpad_up) {
            conveyor_belt.setPower(0.0);
        }
        if (gamepad1.dpad_down) {
            conveyor_belt.setPower(-1.0);
        } else if (!gamepad1.dpad_down) {
            conveyor_belt.setPower(0.0);
        }
    }
}
