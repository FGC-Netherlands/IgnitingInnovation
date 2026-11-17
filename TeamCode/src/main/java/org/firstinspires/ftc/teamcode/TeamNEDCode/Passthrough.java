package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;

public class Passthrough extends Subsystem {

    public static final Passthrough INSTANCE = new Passthrough();

    private Passthrough() { }

    // USER CODE
    public DcMotor passThrough_Motor;
    Servo servo;

    private boolean toggle = false;

    public String pmotorName = "passTrough_motor";
    private String servoName = "passTrough_servo";


    @Override
    public void initialize() {
        passThrough_Motor  = hardwareMap.get(DcMotor.class, pmotorName);
        passThrough_Motor.setDirection(DcMotorSimple.Direction.REVERSE);
        servo = hardwareMap.get(Servo.class, servoName);
    }

    public Command passTroughOn() {
        return new InstantCommand(() -> {
            motorToPower(0.8);
            servoToPower(0.8);
        });
    }

    public Command passThroughOff() {
        return new InstantCommand(() -> {
            motorToPower(0);
            servoToPower(0.5);
        });
    }

    public Command passTroughReverse() {
        return new InstantCommand(() -> {
            motorToPower(-0.8);
            servoToPower(0);
        });
    }

    public Command commandToPower(double power) {
        return new InstantCommand(() -> {
            motorToPower(power);
            servoToPower(1.0);
        });
    }

    public Command toggle() {
        toggle ^= true;
        if (toggle) {
            return passTroughOn();
        } else {
            return passThroughOff();
        }
    }

    private void motorToPower(double power) {
        passThrough_Motor.setPower(power);
    }

    private void servoToPower(double power) {
        servo.setPosition(power);
    }
}
