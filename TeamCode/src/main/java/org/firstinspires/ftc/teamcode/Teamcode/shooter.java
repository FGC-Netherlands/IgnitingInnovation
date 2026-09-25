package org.firstinspires.ftc.teamcode.teamcode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorGroup;

public class shooter extends Subsystem {

    public static final shooter INSTANCE = new shooter();
    private shooter() { }

    // USER CODE
    public MotorEx shooter_Motor1;
    public MotorEx shooter_Motor2;
    public MotorGroup shooterMotors;

    public String shooter_motor1 = "Shooter_Motor1";
    public String shooter_motor2 = "Shooter_Motor2";

    @Override
    public void initialize() {
        shooter_Motor1  = hardwareMap.get(MotorEx.class, "shooter_Motor1");
        shooter_Motor2  = hardwareMap.get(MotorEx.class, "shooter_Motor2");
    }

    public Command shooter_On() {
        shooterMotors = new MotorGroup(shooter_Motor1, shooter_Motor2);
        return new InstantCommand(() -> shooterMotors.setPower(1));

    }

    public Command shooter_Off() {
        shooterMotors = new MotorGroup(shooter_Motor1, shooter_Motor2);
        return new InstantCommand(() -> shooterMotors.setPower(0));
    }




}