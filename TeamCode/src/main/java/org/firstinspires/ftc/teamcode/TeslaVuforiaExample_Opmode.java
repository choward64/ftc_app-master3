package org.firstinspires.ftc.teamcode;

/** ================================================================================================
 * TeslaVuforiaExample_Opmode.java
 *  ( see also TeslaVuforiaExample.java )
 *  Example to reference Vuforia information in an Opmode condition
 *  Created for Tesla's Summer Programming Class 2017 - Week 5
 *  ================================================================================================
 */
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Example: Tesla OpMode", group="Vuforia")
//@Disabled

// -------------------------------------------------------------------------------------------------
public class TeslaVuforiaExample_Opmode extends OpMode {
    //Variables
    private DcMotor     leftMotor   = null;
    private DcMotor     rightMotor  = null;
    private double      powerToTarget;
    private double      powerFactor;
    private double      defaultDist;

    // Connect to TeslaVuforiaExample class as "cam", see Constructor
    TeslaVuforiaExample cam = new TeslaVuforiaExample();

    //----------------------------------------------------------------------------------------------
    // Constructor
    public TeslaVuforiaExample_Opmode(){
    }
    //----------------------------------------------------------------------------------------------
    // Initialize standard Hardware interfaces
    public void init(){
        // Motor setup
        leftMotor  = hardwareMap.dcMotor.get("left_drive");
        rightMotor = hardwareMap.dcMotor.get("right_drive");
        leftMotor.setDirection(DcMotor.Direction.FORWARD);
        rightMotor.setDirection(DcMotor.Direction.REVERSE);
//        leftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        rightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        powerToTarget = 0.2;        // Default power / speed to target
        powerFactor   = 0.05;       // Factor to adjust power based on angle
        defaultDist   = 250;        // Default stopping distance to target (mm)\

        // Setup the Vuforia on the camera
        cam.initCamera(this);
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public void start() {
        // Start looking for images on phone's camera
        cam.activateTracking();
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public void loop() {
        double powerL = 0.0;
        double powerR = 0.0;

        // Check for image, hold left bumper button to auto run to image,
        //  else drive in TeleOp mode
        if(cam.foundImage && gamepad1.left_bumper) {
            // Switch to help from camera-Vuforia, adjust speed for directions
            telemetry.addData("Status", "Running Auto Mode: " + cam.cImageAngle);
            powerL = powerToTarget + powerFactor*(cam.cImageAngle/cam.angLimit);
            powerR = powerToTarget - powerFactor*(cam.cImageAngle/cam.angLimit);

            // Check if within default distance, then stop
            if(cam.cImageDist > defaultDist) {
                leftMotor.setPower(-powerL);
                rightMotor.setPower(-powerR);
            }else {
                leftMotor.setPower(0.0);
                rightMotor.setPower(0.0);
            }
        }else {
            // Tank mode operations, ( not camera help )
            telemetry.addData("Status", "Running TeleOp Mode: ");
            leftMotor.setPower(gamepad1.left_stick_y);
            rightMotor.setPower(gamepad1.right_stick_y);
        }
        // Use the camera to find images, display findings on screen
        cam.findImages();
    }
    //----------------------------------------------------------------------------------------------
    @Override
    public void stop(){

    }
}   // End class TeslaVuforiaExample_Opmode
