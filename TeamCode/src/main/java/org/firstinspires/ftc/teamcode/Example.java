package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;

/**
 * Created by Administrator on 6/10/2017.
 */
/*Code NEEDS comments ALWAYS comment code*/
 public class Example extends OpMode {

    int a_number = 10; //Creates the integer "a_number" and gives it the value 10

    public void say_somehing() {
        System.out.println("something");//prints something to the screen
    }

    public int what_hour_is_it() {
        System.out.println("Someone asked for the hour!");
        return a_number;//returns the int. a_number
    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {

    }
}
   /* public class Car{

        public String vin = "";
        public String license_plate;
        public String color;
        public void start(){
            // ...
        }
        public int speed(){
            //...
        }

        private void rust(){ // only the code can do this

        }
    }
*/
