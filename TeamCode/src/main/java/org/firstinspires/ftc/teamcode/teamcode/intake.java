package org.firstinspires.ftc.teamcode.teamcode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;
import com.rowanmcalpin.nextftc.ftc.OpModeData;
import com.rowanmcalpin.nextftc.ftc.hardware.ServoToPosition;

public class intake extends Subsystem {

    public static final Intake INSTANCE = new Inake();
    private Intake() { }

    // USER CODE
    public DcMotor Intake_Motor;

    public String name = "Intake_Motor";

    public Command On() {
        return new InstantCommand(() -> Intake_Motor.setPower(1));
    }

    public Command Off() {
        return new InstantCommand(() -> Intake_Motor.setPower(0));
    }

    public Command reverse() {
        return new InstantCommand(() -> Intake_Motor.setPower(-1));
    }

    @Override
    public void initialize() {
        Intake_Motor  = hardwareMap.get(DcMotor.class, "Intake_Motor");
    }


}
