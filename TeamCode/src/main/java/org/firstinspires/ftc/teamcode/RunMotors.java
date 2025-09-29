package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="RunMotors", group="TeleOp")
public class RunMotors extends OpMode {

    private DcMotor launcher1;
    private DcMotor launcher2;

    @Override
    public void init() {
        // Map motors from the configuration
        launcher1 = hardwareMap.get(DcMotor.class, "launcher1");
        launcher2 = hardwareMap.get(DcMotor.class, "launcher2");

        // Adjust direction if needed
        launcher1.setDirection(DcMotor.Direction.FORWARD);
        launcher2.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {
        // Right trigger on gamepad1 goes from 0.0 to 1.0
        double triggerPower = gamepad1.right_trigger;

        if (gamepad1.a) {
            triggerPower = 0.8;
        }

        if (gamepad1.b) {
            triggerPower = 1.0;
        }

        if (gamepad1.x) {
            triggerPower = 0.7;
        }

        if (gamepad1.y) {
            triggerPower = 0.75;
        }

        // Set both launchers to that power
        launcher1.setPower(triggerPower);
        launcher2.setPower(triggerPower);

        telemetry.addData("Trigger", triggerPower);
        telemetry.addData("Launcher1 Power", launcher1.getPower());
        telemetry.addData("Launcher2 Power", launcher2.getPower());
    }

    @Override
    public void stop() {
        // Stop motors when TeleOp ends
        launcher1.setPower(0.0);
        launcher2.setPower(0.0);
    }
}
