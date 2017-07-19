package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

;import static com.google.blocks.ftcrobotcontroller.util.HardwareType.BNO055IMU;

/**
 * Created by Aeites on 1/12/2017.
 */

@TeleOp(name = "IMU Test", group = "Gyro Test")
@Disabled
public class GyroTestEric extends OpMode {

    BNO055IMU gyro;
    Orientation angle;


    public void init(){
//        gyro = hardwareMap.get(BNO055IMU.class, "imu");
//
//        BNO055IMU.Parameters param = new BNO055IMU.Parameters();
//        param.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
//        param.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
//        param.calibrationDataFile = "AdafruitIMUCalibration.json"; // see the calibration sample opmode
//        param.loggingEnabled      = true;
//        param.loggingTag          = "IMU";
//        param.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
//
//        gyro.initialize(param);


    }

    public void loop(){
            telemetry.addData("Gyro is ", "calibrated");
            angle = gyro.getAngularOrientation();
            angle.toAngleUnit(AngleUnit.DEGREES);
            telemetry.addData("First angle: ", angle.firstAngle);
            telemetry.addData("Second angle: ", angle.secondAngle);
            telemetry.addData("Third angle: ", angle.thirdAngle);
    }
}
