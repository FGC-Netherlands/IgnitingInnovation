package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;

import kotlin.jvm.functions.Function1;

public class Passthrough extends Subsystem {

    public static final Passthrough INSTANCE = new Passthrough();

    private Passthrough() { }

    // USER CODE
    public DcMotor passThrough_Motor;

    private boolean toggle = false;

    public String pmotorName = "passTrough_motor";


    @Override
    public void initialize() {
        passThrough_Motor  = hardwareMap.get(DcMotor.class, pmotorName);
        passThrough_Motor.setDirection(DcMotorSimple.Direction.REVERSE);

    }

    public Command passTroughOn() {
        return new InstantCommand(() -> motorToPower(0.8));
    }

    public Command passThroughOff() {
        return new InstantCommand(() -> motorToPower(0));
    }

    public Command passTroughReverse() {
        return new InstantCommand(() -> motorToPower(-0.8));
    }

    public Command commandToPower(double power) {
        return new InstantCommand(() -> motorToPower(power));
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
}
