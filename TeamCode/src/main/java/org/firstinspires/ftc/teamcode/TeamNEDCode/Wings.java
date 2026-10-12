package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;

public class Wings extends Subsystem {

    public static final Wings INSTANCE = new Wings();
    private Wings() { }

    // USER CODE
    public Servo left, right;

    public String motor1Name = "servoLeft";
    public String motor2Name = "servoRight";

    private boolean toggle = false;
    private double multiplier = 0.8;

    @Override
    public void initialize() {
        left  = hardwareMap.get(Servo.class, motor1Name);
        right  = hardwareMap.get(Servo.class, motor2Name);

        left.setPosition(0);
        left.setPosition(1);
    }

    private Command flip() {
        return new InstantCommand(() -> {
            right.setPosition(0);
            left.setPosition(0.4);
        });
    }
    private Command flop() {
        return new InstantCommand(() -> {
            right.setPosition(1);
            left.setPosition(0.6);
        });
    }

    public Command flap() {
        toggle ^= true;
        if (toggle) {
            return flip();
        } else {
            return flop();
        }
    }
}