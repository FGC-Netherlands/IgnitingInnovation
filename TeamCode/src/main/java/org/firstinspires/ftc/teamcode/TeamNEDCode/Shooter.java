package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorGroup;

public class Shooter extends Subsystem {

    public static final Shooter INSTANCE = new Shooter();
    private Shooter() { }

    // USER CODE
    public DcMotor shooter_Motor1;
    public DcMotor shooter_Motor2;

    public String motor1Name = "shooter_motor1";
    public String motor2Name = "shooter_motor2";

    @Override
    public void initialize() {
        shooter_Motor1  = hardwareMap.get(DcMotor.class, motor1Name);
        shooter_Motor2  = hardwareMap.get(DcMotor.class, motor2Name);
    }

    public Command shooter_On() {
        return new InstantCommand(() -> motorToPower(1));
    }

    public Command shooter_Off() {
        return new InstantCommand(() -> motorToPower(0));
    }

    public Command shooterOff2() {
        return new InstantCommand(() -> {
            shooter_Motor1.setPower(0);
            shooter_Motor2.setPower(0);
        });
    }

    public void motorToPower(double power) {
        shooter_Motor1.setPower(power);
        shooter_Motor2.setPower(power);
    }
}