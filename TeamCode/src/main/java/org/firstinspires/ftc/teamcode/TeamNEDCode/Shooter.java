package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;

public class Shooter extends Subsystem {

    public static final Shooter INSTANCE = new Shooter();
    private Shooter() { }

    // USER CODE
    public DcMotor shooter_Motor1;
    public DcMotor shooter_Motor2;

    public String motor1Name = "shooter_motor1";
    public String motor2Name = "shooter_motor2";

    private boolean toggle = false;
    private double multiplier = 0.8;

    @Override
    public void initialize() {
        shooter_Motor1  = hardwareMap.get(DcMotor.class, motor1Name);
        shooter_Motor2  = hardwareMap.get(DcMotor.class, motor2Name);
        shooter_Motor2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public Command shooterOn() {
        return new InstantCommand(() -> motorToPower(1));
    }

    public Command shooterOff() {
        return new InstantCommand(() -> motorToPower(0));
    }

    public Command shooterBackwards() {return new InstantCommand(() -> motorToPower(-0.5));}

    public Command shooterOff2() {
        return new InstantCommand(() -> {
            shooter_Motor1.setPower(0);
            shooter_Motor2.setPower(0);
        });
    }

    public Command commandToPower(double power) {
        return new InstantCommand(() -> motorToPower(power));
    }

    public Command toggle() {
        toggle ^= true;
        if (toggle) {
            return shooterOn();
        } else {
            return shooterOff();
        }
    }

    private void motorToPower(double power) {
        shooter_Motor1.setPower(power * multiplier);
        shooter_Motor2.setPower(power * multiplier);
    }

    public Command moreMultiplier() {
        return new InstantCommand(() -> multiplier = Math.min(multiplier * 1.1, 1));
    }

    public Command lessMultiplier() {
        return new InstantCommand(() -> multiplier *= 0.9);
    }
}