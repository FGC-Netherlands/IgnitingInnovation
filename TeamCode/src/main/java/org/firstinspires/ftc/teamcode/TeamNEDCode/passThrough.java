package org.firstinspires.ftc.teamcode.TeamNEDCode;

import static com.rowanmcalpin.nextftc.ftc.OpModeData.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.rowanmcalpin.nextftc.core.Subsystem;
import com.rowanmcalpin.nextftc.core.command.Command;
import com.rowanmcalpin.nextftc.core.command.utility.InstantCommand;

public class passThrough extends Subsystem {

    public static final passThrough INSTANCE = new passThrough();

    private passThrough() { }

    // USER CODE
    public DcMotor passThrough_Motor;


    public String pmotorName = "passTrough_motor";


    @Override
    public void initialize() {
        passThrough_Motor  = hardwareMap.get(DcMotor.class, pmotorName);

    }

    public Command passTroughOn() {
        return new InstantCommand(() -> passThrough_Motor.setPower(1));
    }

    public Command passTroughOff() {
        return new InstantCommand(() -> passThrough_Motor.setPower(0));
    }
}
