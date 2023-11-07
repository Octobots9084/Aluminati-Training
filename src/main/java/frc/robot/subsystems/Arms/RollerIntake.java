package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RollerIntake extends InstantCommand {
    private Roller roller;
    private double speed;

    public RollerIntake(double speed) {
        roller = Roller.getInstance();
        this.speed = speed;
    }

    @Override
    public void initialize() {
        roller.rotate(this.speed);
    }
}
