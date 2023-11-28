package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class MainRollerIntake extends InstantCommand {
    private MainRoller roller;
    private double speed;

    public MainRollerIntake(double speed) {
        roller = MainRoller.getInstance();
        this.speed = speed;
    }

    @Override
    public void initialize() {
        roller.rotate(this.speed);
    }
}