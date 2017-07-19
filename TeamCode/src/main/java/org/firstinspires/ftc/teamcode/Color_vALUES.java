package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;

//@TeleOp(name = "Color_Finding", group = "Rise Robot")

/**
 * Created by rpcardosimd on 11/8/16.
 */

public class Color_vALUES extends OpMode {

    ColorSensor left_color;
    ColorSensor right_color;
    ColorSensor lcb;
    ColorSensor rcb;


    public void init() {

        left_color = hardwareMap.colorSensor.get("lc");
        right_color = hardwareMap.colorSensor.get("rc");

        lcb = hardwareMap.colorSensor.get("lbc");
        rcb = hardwareMap.colorSensor.get("rbc");

        left_color.enableLed(false);
        right_color.enableLed(false);
        lcb.enableLed(true);
        rcb.enableLed(true);

        lcb.setI2cAddress(I2cAddr.create8bit(0x2c));
        rcb.setI2cAddress(I2cAddr.create8bit(0x5c));
        left_color.setI2cAddress(I2cAddr.create8bit(0x4c));//
        right_color.setI2cAddress(I2cAddr.create8bit(0x3c));//
    }

    public void loop() {
        telemetry.addData("L red", left_color.red());
        telemetry.addData("L blue", left_color.blue());

        telemetry.addData("R red", right_color.red());
        telemetry.addData("R blue", right_color.blue());

        telemetry.addData("Left Bottom alpha", lcb.alpha());
        telemetry.addData("Right Bottom alpha", rcb.alpha());
        telemetry.update();
        updateTelemetry(telemetry);
    }
}
