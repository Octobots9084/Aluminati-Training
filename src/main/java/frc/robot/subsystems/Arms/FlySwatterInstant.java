package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class FlySwatterInstant extends InstantCommand{
    private FlySwatter flySwatter;
    private double speed;

    public FlySwatterInstant(double Speed) {
       flySwatter = FlySwatter.getInstance();
       this.speed = Speed;
    }
    
    @Override
    public void initialize() {
        this.flySwatter.setSpeed(speed);
    }
}