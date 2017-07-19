package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.vuforia.HINT;
import com.vuforia.Vuforia;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

import java.util.Locale;

/**
 * Created by Administrator on 7/19/2017.
 */

public class TeslaVuforiaExample  {

    private OpMode myOpMode;                    // Access to the OpMode Subject
    private VuforiaTrackables beacons;          // Reference to the beacon images
    VuforiaTrackableDefaultListener imageType;
    public boolean foundImage;                  // Tracking an image
    public String cImageName;                   // Name of the image closes to center
    public float cImageAngle;                   // Angle of the image closes to center
    public float cImageDist;                    // Distance to image closes to center
    public float angLimit;                      // Angle limit on identifying of target

    //----------------------------------------------------------------------------------------------
    /* Constructor */
    public TeslaVuforiaExample() {
        foundImage  = false;
        cImageName  = "unknown";
        cImageAngle = 0.0f;
        cImageDist  = 0.0f;
        angLimit   = 200.0f;
    }
    //----------------------------------------------------------------------------------------------
    // Setup for the Camera, send in reference to the OpMode
    public void initCamera (OpMode opMode) {

        // Get reference to main opMode in ViewOne_Camera class
        myOpMode = opMode;

        // Set up Vuforia's parameters
        // Show image on camera, (not to show, leave out "R.id.cameraMonitorViewId")
        VuforiaLocalizer.Parameters params = new
        VuforiaLocalizer.Parameters(R.id.cameraMonitorViewId);
        // Setup phones BACK camera selection as a parameter
        params.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        // Setup license key parameter
        params.vuforiaLicenseKey =
        "ATIv+Pr/////AAAAGRbSNomRsUOwjl5ps1NItDFY7QxXxyKNhDjmtAj4Nj72eHYDJAwL+FXAMsdmengTAQndU8WfFLA" +
                "mEa/Rbs3hQ/3up1Bu20JrhkFBEPbWqIz4M/P8S8rF2An6S7xXPItEyFGYvKST61q3QI9tk63BOGuYVAE8GH" +
                "k8Ik5rXW1I1WrBRvmZuaZYpAPUXPh8wbGJTGXUPXX1VcJw/eAK9rACq27zpxavTw+/9J+qlBopbPBPu1pd5" +
                "6/GKvi48fThEgeLWdoMGdNna6UpikqujVrvA9Pp5P20q/6JGoQrCS8heRwEyIBdNJ9O5Wf9P+8EdZhsWNKw" +
                "bOlNdt3voM6/0FeFehBzVP0J9PgIPJ3SNKjZ4yd/";
        // Optional : Set display on screen of target
        params.cameraMonitorFeedback = VuforiaLocalizer.Parameters.CameraMonitorFeedback.AXES;

        // Create an instance of Vuforia, adding the above parameters
        VuforiaLocalizer vuforia = ClassFactory.createVuforiaLocalizer(params) ;

        // Setup Vuforia to display / track all four targets if visible, default is only on target
        Vuforia.setHint(HINT.HINT_MAX_SIMULTANEOUS_IMAGE_TARGETS, 4) ;

        // Load the teackable images information from FTC's assets folder
        beacons = vuforia.loadTrackablesFromAsset("FTC_2016-17") ;
        // Found at Project: FtcRobotController > src > main > assects> ... .dat & .xml
        // Set names in array for each image
        beacons.get(0).setName("Wheels");
        beacons.get(1).setName("Tools");
        beacons.get(2).setName("Lego");
        beacons.get(3).setName("Gears");
    }
    //----------------------------------------------------------------------------------------------
    //Start tracking Vuforia images
    public void activateTracking() {
        // Start Vuforia looking for images
        beacons.activate();
    }
    //----------------------------------------------------------------------------------------------
    // Find images, look one at a time
    public void findImages() {
        // Variables with defaults
        foundImage  = false;
        cImageName  = "unknown";
        cImageAngle = 1000.0f;
        cImageDist  = 0.0f;
        // Check for each image, note the closes to the image's center
        try {
            for (int i = 0; i < beacons.size(); i++) {
                VuforiaTrackable beac = beacons.get(i);
                // Setup all the info in OpenGLMatrix
                // (Get the location of the trackable in the phone's coordinate system )
                OpenGLMatrix pose = ((VuforiaTrackableDefaultListener)
                        beac.getListener()).getPose();

                // Check if the pose is null, i.e., no image is found for that target
                if (pose != null) {
                    imageType = (VuforiaTrackableDefaultListener)
                            beacons.get(i).getListener();

                    String nam = beac.getName();                // For target's name

                    VectorF trans = pose.getTranslation();
                    // float ang = trans.get(0);                 // For angle with phone in portrait

                    float ang = trans.get(1);                   // For angle with phone in landscape

                    float distMM = (float) Math.hypot(trans.get(0), trans.get(2)); // Distance in MM
                    float distIN = distMM / 25.4f;                                  // Distance in INCHES
                    String sDistIN = String.format(java.util.Locale.US, "%.2f", distIN);

                    // If angle is <angLimit, target is good for tracking
                    if (Math.abs(ang) < angLimit) {
                        myOpMode.telemetry.addData("Angle to " + nam + ": ", (int) ang);
                        myOpMode.telemetry.addData("Dist. to " + nam + ": ",
                                (int) distMM + " mm,  " + sDistIN + " in");

                        // Note: data for the closes image to center, i.e., smallest angle
                        if (Math.abs(ang) < Math.abs(cImageAngle)) {
                            foundImage = true;
                            cImageName = nam;
                            cImageAngle = ang;
                            cImageDist = distMM;
                        }
                    }
                }
            }
            // Update display (may not be needed now)
            myOpMode.telemetry.update();
        }catch (NullPointerException e) {
            System.err.println("*** NullPointerException Catch *** findImages");
        }
    }
} // End Class
