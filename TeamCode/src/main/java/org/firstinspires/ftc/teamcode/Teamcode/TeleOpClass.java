package org.firstinspires.ftc.teamcode.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.ftc.NextFTCOpMode;
import com.rowanmcalpin.nextftc.ftc.driving.DifferentialArcadeDriverControlled;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorEx;
import com.rowanmcalpin.nextftc.ftc.hardware.controllables.MotorGroup;

@TeleOp(name = "NextFTC TeleOp Program Java")
public class TeleOpClass extends NextFTCOpMode {

    public TeleOpClass() {
        super(Intake.INSTANCE);
    }

    public String frontLeftName = "front_left";
    public String frontRightName = "front_right";
    public String backLeftName = "back_left";
    public String backRightName = "back_right";

    public int shooteron = 0;

    public MotorEx frontLeftMotor;
    public MotorEx frontRightMotor;
    public MotorEx backLeftMotor;
    public MotorEx backRightMotor;

    public MotorGroup leftMotors;
    public MotorGroup rightMotors;

    public Command driverControlled;

    @Override
    public void onInit() {
        frontLeftMotor = new MotorEx(frontLeftName);
        backLeftMotor = new MotorEx(backLeftName);
        backRightMotor = new MotorEx(backRightName);
        frontRightMotor = new MotorEx(frontRightName);

        // Change your motor directions to suit your robot.
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        leftMotors = new MotorGroup(frontLeftMotor, backLeftMotor);
        rightMotors = new MotorGroup(frontRightMotor, backRightMotor);
    }
    @Override
    public void onStartButtonPressed() {
        driverControlled = new DifferentialArcadeDriverControlled(leftMotors, rightMotors, gamepadManager.getGamepad1());
        driverControlled.invoke();

        gamepadManager.getGamepad1().getTriangle().setPressedCommand(Intake.INSTANCE::intake_On);
        gamepadManager.getGamepad1().getSquare().setPressedCommand(Intake.INSTANCE::intake_Off);
        gamepadManager.getGamepad1().getCross().setPressedCommand(Intake.INSTANCE::intake_reverse);

        gamepadManager.getGamepad1().getDpadUp().setPressedCommand(shooter.INSTANCE::shooter_On);
        gamepadManager.getGamepad1().getDpadDown().setPressedCommand(shooter.INSTANCE::shooter_Off);
    }
}
