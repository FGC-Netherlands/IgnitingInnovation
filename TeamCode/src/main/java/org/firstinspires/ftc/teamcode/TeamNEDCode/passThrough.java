package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;

public class passThrough extends Subsystem {

    public static final passThrough INSTANCE = new passThrough();

    private passThrough() { }

    // USER CODE
    private DcMotor passThrough_Motor;
    private Servo servo;


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
            passThrough_Motor.setPower(1);
            servo.setPosition(1);
        });
    }

    public Command passTroughOff() {
        return new InstantCommand(() -> {
            passThrough_Motor.setPower(0);
            servo.setPosition(0);
        });
    }
}
