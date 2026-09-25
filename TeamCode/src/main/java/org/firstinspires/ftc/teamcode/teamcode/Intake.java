package org.firstinspires.ftc.teamcode.teamcode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;

public class Intake extends Subsystem {

    public static final Intake INSTANCE = new Intake();
    private Intake() { }

    // USER CODE
    public DcMotor Intake_Motor;

    public String name = "Intake_Motor";

    public Command intake_On() {
        return new InstantCommand(() -> Intake_Motor.setPower(0.75));
    }

    public Command intake_Off() {
        return new InstantCommand(() -> Intake_Motor.setPower(0));
    }

    public Command intake_reverse() {
        return new InstantCommand(() -> Intake_Motor.setPower(-0.75));
    }

    @Override
    public void initialize() {
        Intake_Motor  = hardwareMap.get(DcMotor.class, "Intake_Motor");
    }


}
