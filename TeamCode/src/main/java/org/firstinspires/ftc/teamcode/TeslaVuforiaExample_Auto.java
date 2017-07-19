package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/** ================================================================================================
 * TeslaVuforiaExample_Auto.java
 *  ( see also TeslaVuforiaExample.java )
 *  Example to reference Vuforia information in an Autonomous Mode condition
 *  Created for Tesla's Summer Programming Class 2017 - Week 5
 *  ================================================================================================
 */


@Autonomous(name="Example: Tesla Auto", group="Vuforia")
//@Disabled

public class TeslaVuforiaExample_Auto extends LinearOpMode {
    //Connect to TestVuforiaExample class as "cam", see Constructor
    TeslaVuforiaExample cam = new TeslaVuforiaExample();

    //----------------------------------------------------------------------------------------------
    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Motor setup
        DcMotor leftMotor   = hardwareMap.dcMotor.get("left_drive");
        DcMotor rightMotor  = hardwareMap.dcMotor.get("right_drive");
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
//        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        double powerToTarget = 0.1;         // Default power / speed to target
        double powerFactor   = 0.05;        // Factor to adjust power based on angle
        double defaultDist   = 250;         // Default stopping distance to target (mm)
        double defaultPower  = 0.1;         // Default power until target is found

        // Setup the Vuforia on the camera
        cam.initCamera(this);
        // Start looking for images on phone's camera
        cam.activateTracking();
        idle();
        cam.findImages();
        //------------------------------------------------------------------------------------------
        // Wait for the game to start (driver press PLAY)
        waitForStart();
            boolean stoppedAtTarget = false;

        //------------------------------------------------------------------------------------------
        // run until the end of the match (driver press STOP)
        while (opModeIsActive() && !stoppedAtTarget) {
            //Variables
            double powerL = 0.0;
            double powerR = 0.0;

            // Check for image, if found, auto run to image,
            //      else drive in direction of target
            if (cam.foundImage) {
                // Switch to help from camera-Vuforia, adjust speed for directions
                telemetry.addData("Status", "Running Auto Mode: " + cam.cImageAngle);
                powerL = powerToTarget + powerFactor*(cam.cImageAngle/cam.angLimit);
                powerR = powerToTarget - powerFactor*(cam.cImageAngle/cam.angLimit);

                //Check if within default distance, then stop
                if(cam.cImageDist > defaultDist) {
                    leftMotor.setPower(-powerL);
                    rightMotor.setPower(-powerR);
                }else {
                    telemetry.addData("Status", "Stopping - at Target: " + cam.cImageDist);
                    leftMotor.setPower(0.0);
                    rightMotor.setPower(0.0);
                    stoppedAtTarget = true;
                }
            }else {
                //Tabk mode operation with default power, ( not camera help )
                    telemetry.addData("Status", "Running Default Mode: ");
                leftMotor.setPower(-defaultPower);
                rightMotor.setPower(-defaultPower);
            }
            // Use the camera to find images, display findings on screen
            cam.findImages();
        }
    }
} // End class TeslaVuforiaExample_Linear
