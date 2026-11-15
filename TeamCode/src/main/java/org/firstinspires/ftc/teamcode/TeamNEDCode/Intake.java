package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;

public class Intake extends Subsystem {

    public static final Intake INSTANCE = new Intake();
    private Intake() { }

    // USER CODE
    public DcMotor Intake_Motor;

    public String name = "Intake_Motor";

    private boolean toggle = false;

    public Command toggle() {
        toggle ^= true;
        if (toggle) {
            return intake_On();
        } else {
            return intake_Off();
        }
    }

    public Command intake_On() {
        return new InstantCommand(() -> motorToPower(0.8));
    }

    public Command intake_Off() {
        return new InstantCommand(() -> motorToPower(0));
    }

    public Command intake_reverse() {
        return new InstantCommand(() -> motorToPower(-0.8));
    }

    public Command commandToPower(double power) {
        return new InstantCommand(() -> motorToPower(power));
    }

    private void motorToPower(double power) {
        Intake_Motor.setPower(power);
    }

    @Override
    public void initialize() {
        Intake_Motor  = hardwareMap.get(DcMotor.class, "Intake_Motor");
        Intake_Motor.setDirection(DcMotorSimple.Direction.FORWARD);
    }


}
