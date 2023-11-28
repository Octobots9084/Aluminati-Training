package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class FlySwatterInstant extends InstantCommand{
    private FlySwatter flySwatter;
    private double angle;

    public FlySwatterInstant(double Angle) {
       flySwatter = FlySwatter.getInstance();
       this.angle = Angle;
    }
    
    @Override
    public void initialize() {
        this.flySwatter.setAngle(angle);
    }
}