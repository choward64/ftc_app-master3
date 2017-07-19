//<<<<<<< Updated upstream
package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

/**
 * Created by Aeites on 12/7/2016.
 */
public class EncDrive {
    private Telemetry telemetry;
    private DcMotor left_back_drive;
    private DcMotor left_front_drive;
    private DcMotor right_back_drive;
    private DcMotor right_front_drive;
    private final double WHEEL_DIAMETER = 4;
    private final double PI = 3.1415926535897;
    private final int TICKS_PER_ROT = 1120;
    private BNO055IMU imu;

    public float heading;
    public float roll;

    public Orientation angles;

    public EncDrive(HardwareMap hardwareMap, Telemetry telemetry) {

        // Set up the parameters with which we will use our IMU. Note that integration
        // algorithm here just reports accelerations to the logcat log; it doesn't actually
        // provide positional information.
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit           = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit           = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "AdafruitIMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled      = true;
        parameters.loggingTag          = "IMU";


        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu.initialize(parameters);

        angles = imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);

        heading = angles.firstAngle;



        left_back_drive = hardwareMap.dcMotor.get("1");  // give left_back_drive the name 1
        left_front_drive = hardwareMap.dcMotor.get("2");  // give left_front_drive the name 2
        right_back_drive = hardwareMap.dcMotor.get("3");  // you probably know what we do here by now
        right_front_drive = hardwareMap.dcMotor.get("4");  // and here

        this.telemetry = telemetry;

        right_back_drive.setDirection(DcMotor.Direction.FORWARD);  // here we just tell the motors listed to go forward and not reversed
        right_front_drive.setDirection(DcMotor.Direction.FORWARD);
        left_back_drive.setDirection(DcMotor.Direction.REVERSE);  // reverse the left_back_drive
        left_front_drive.setDirection(DcMotor.Direction.REVERSE);  // reverse the left_front_drive

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);// run to position
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    // Function to move the robot forward the given amount of inches
    public void forward(double inches, double lspeed, double rspeed) {
        // Calculate how much the motor must rotate
        double numRot = inches / (WHEEL_DIAMETER*PI);
        int position = (int) (numRot * TICKS_PER_ROT);

        // Set the motors to move to the position accordingly
        setEncPosition(position, position, lspeed, rspeed);
    }


    // Function to rotate the robot the given amount of degrees
    public void rotate(double degrees, double lspeed, double rspeed) {
        double targetRot = heading + degrees;
        double TOLERANCE = 2;
        int encPosition = 0;
        int ENC_POS_INCRE = 100;


        while (Math.abs(targetRot - heading) > TOLERANCE) {
            angles = imu.getAngularOrientation().toAxesReference(AxesReference.INTRINSIC).toAxesOrder(AxesOrder.ZYX);
            heading = angles.firstAngle;
            encPosition += ENC_POS_INCRE;
            setEncPosition(encPosition, -encPosition, lspeed, -rspeed);
        }

    }


    public void showEncPosition() {
        telemetry.addData("Encoder Drive left current:", left_back_drive.getCurrentPosition());
        telemetry.addData("Encoder Drive left target :", left_back_drive.getTargetPosition());

        telemetry.addData("Encoder Drive right current:", right_back_drive.getCurrentPosition());
        telemetry.addData("Encoder Drive right target :", right_back_drive.getTargetPosition());

    }

    // Function to reset all drive motor encoders
    public void resetEncoders() {
        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// reset encoders
        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        right_back_drive.setTargetPosition(0);
        right_front_drive.setTargetPosition(0);
        left_back_drive.setTargetPosition(0);
        left_front_drive.setTargetPosition(0);

        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);// run to position
        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    // Function to set the target position of the drive motors
    private void setEncPosition(int left, int right, double lpower, double rpower) {
        while(left_back_drive.getCurrentPosition() < left && right_back_drive.getCurrentPosition() < right) {
            right_back_drive.setTargetPosition(right);
            right_front_drive.setTargetPosition(right);
            left_back_drive.setTargetPosition(left);
            left_front_drive.setTargetPosition(left);

            left_back_drive.setPower(lpower);
            left_front_drive.setPower(lpower);
            right_back_drive.setPower(rpower);
            right_front_drive.setPower(rpower);
        }
    }

}

////package org.firstinspires.ftc.teamcode.subsystems;
////
////import com.qualcomm.robotcore.hardware.DcMotor;
////import com.qualcomm.robotcore.hardware.DcMotorSimple;
////import com.qualcomm.robotcore.hardware.GyroSensor;
////import com.qualcomm.robotcore.hardware.HardwareMap;
////
////import org.firstinspires.ftc.robotcore.external.Telemetry;
////
/////**
//// * Created by Aeites on 12/7/2016.
//// */
////public class EncDrive {
////    GyroSensor sensorGyro;
////    private Telemetry telemetry;
////    private DcMotor left_back_drive;
////    private DcMotor left_front_drive;
////    private DcMotor right_back_drive;
////    private DcMotor right_front_drive;
////    private final double WHEEL_DIAMETER = 4;
////    private final double PI = 3.1415926535897;
////    private final int TICKS_PER_ROT = 1220;
////    private int xVal, yVal, zVal = 0;
////    private int heading = 0;
////    public boolean moving = false;
////    private double targetDegree = 0;
////
////    public EncDrive(HardwareMap hardwareMap, Telemetry telemetry) {
////        sensorGyro = hardwareMap.gyroSensor.get("gyro");
////        left_back_drive = hardwareMap.dcMotor.get("1");  // give left_back_drive the name 1
////        left_front_drive = hardwareMap.dcMotor.get("2");  // give left_front_drive the name 2
////        left_back_drive.setDirection(DcMotor.Direction.REVERSE);  // reverse the left_back_drive
////        left_front_drive.setDirection(DcMotor.Direction.REVERSE);  // reverse the left_front_drive
////
////        this.telemetry = telemetry;
////
////        right_back_drive = hardwareMap.dcMotor.get("3");  // you probably know what we do here by now
////        right_front_drive = hardwareMap.dcMotor.get("4");  // and here
////        right_back_drive.setDirection(DcMotor.Direction.FORWARD);  // here we just tell the motors listed to go forward and not reversed
////        right_front_drive.setDirection(DcMotor.Direction.FORWARD);
////
////
////        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);// run to position
////        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////
////        moving = false;
////
////        // calibrate the gyro.
////        xVal = 0;
////        yVal = 0;
////        zVal = 0;
////        heading = 0;
////        sensorGyro.calibrate();
////    }
////
////    // Function to move the robot forward the given amount of inches
////    public void forward(double inches, double lspeed, double rspeed) {
////        // Calculate how much the motor must rotate
////        double numRot = inches / (WHEEL_DIAMETER*PI);
////        int position = (int) (numRot * TICKS_PER_ROT);
////
////        // Set the motors to move to the position accordingly
////        setEncPosition(position, position, lspeed, rspeed);
////    }
////
////
////    // Function to rotate the robot the given amount of degrees
////    public void rotate(double degrees, double speed) {
////        final double DIST_FROM_CENTER = 7.75; // Distance from center of robot to center wheels
////        double radians = degrees / 360 * PI;  // Get the rotation in radians
////        double arcLength = DIST_FROM_CENTER*radians;    // Distance the wheels need to travel
////        double numRot = arcLength/(PI*WHEEL_DIAMETER);  // Get the number of times the wheel rotates
////        int position = (int) (TICKS_PER_ROT * numRot);   // Get the position
////        // Set the motors move to the position accordingly
////        setEncPosition(position, -position, speed);
////    }
////
////    public void showEncPosition() {
////        telemetry.addData("Encoder Drive left current:", left_back_drive.getCurrentPosition());
////        telemetry.addData("Encoder Drive left target :", left_back_drive.getTargetPosition());
////
////        telemetry.addData("Encoder Drive right current:", right_back_drive.getCurrentPosition());
////        telemetry.addData("Encoder Drive right target :", right_back_drive.getTargetPosition());
////
////    }
////
////    // Function to reset all drive motor encoders
////    public void resetEncoders() {
////        left_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////        left_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);// reset encoders
////        right_back_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////        right_front_drive.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
////
////        right_back_drive.setTargetPosition(0);
////        right_front_drive.setTargetPosition(0);
////        left_back_drive.setTargetPosition(0);
////        left_front_drive.setTargetPosition(0);
////
////        left_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        left_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);// run to position
////        right_back_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////        right_front_drive.setMode(DcMotor.RunMode.RUN_TO_POSITION);
////    }
////
////    // Function to set the target position of the drive motors
////    private void setEncPosition(int left, int right, double lpower, double rpower) {
////        right_back_drive.setTargetPosition(right);
////        right_front_drive.setTargetPosition(right);
////        left_back_drive.setTargetPosition(left);
////        left_front_drive.setTargetPosition(left);
////
////        left_back_drive.setPower(lpower);
////        left_front_drive.setPower(lpower);
////        right_back_drive.setPower(rpower);
////        right_front_drive.setPower(rpower);
////    }
////
////}
////
////
////
//>>>>>>> Stashed changes
