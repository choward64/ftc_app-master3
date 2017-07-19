
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.subsystems.EncDrive;

/**
 * Created by Aeites on 12/7/2016.
 */
@TeleOp(name = "Encoder Test", group = "Rise Robot")
@Disabled
public class EncoderTest extends OpMode {
    EncDrive ed;
    boolean moving;

    public void init() {
        ed = new EncDrive(hardwareMap, telemetry);
        moving = false;
    }

    public void loop() {
        ed.showEncPosition();
        if (!moving) {
            if (gamepad1.y) {
                ed.forward(12, .75,.75);
                moving = true;
            }
            if (gamepad1.a) {
                ed.resetEncoders();
            }
        } else {
            if(!gamepad1.y){
                ed.forward(0,0,0);
                moving = false;
            }


        }
    }
}
