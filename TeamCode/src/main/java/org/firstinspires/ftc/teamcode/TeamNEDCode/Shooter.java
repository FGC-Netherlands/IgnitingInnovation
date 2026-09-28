package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorGroup;

public class Shooter extends Subsystem {

    public static final Shooter INSTANCE = new Shooter();
    private Shooter() { }

    // USER CODE
    public MotorEx shooter_Motor1;
    public MotorEx shooter_Motor2;
    public MotorGroup shooterMotors;

    public String motor1Name = "shooter_motor1";
    public String motor2Name = "shooter_motor2";

    @Override
    public void initialize() {
        shooter_Motor1 = new MotorEx(motor1Name);
        shooter_Motor2 = new MotorEx(motor2Name);
        shooter_Motor1  = hardwareMap.get(MotorEx.class, motor1Name);
        shooter_Motor2  = hardwareMap.get(MotorEx.class, motor2Name);
        shooterMotors = new MotorGroup(shooter_Motor1, shooter_Motor2);
    }

    public Command shooter_On() {
        return new InstantCommand(() -> shooterMotors.setPower(1));
    }

    public Command shooter_Off() {
        return new InstantCommand(() -> shooterMotors.setPower(0));
    }
}