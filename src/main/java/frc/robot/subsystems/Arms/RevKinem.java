package frc.robot.subsystems.Arms;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class RevKinem extends InstantCommand {

    public RevKinem (double wristAngle, double targetX, double targetY) { 
        
        // CalculateReverseKinematics.setVariables(wristAngle, targetX, targetY);
        // Pivoter.getInstance().rotate(CalculateReverseKinematics.calcPivotAngle());
        // Wrist.getInstance().rotate(wristAngle);
        // Extender.getInstance().extend(CalculateReverseKinematics.calcExtensionDistance());
        
    }

    public static void main(String[] args)
    {
        CalculateReverseKinematics.setVariables(0, 1, 2);
        System.out.println(CalculateReverseKinematics.convertRad2Motor(CalculateReverseKinematics.calcPivotAngle()));
        System.out.println(CalculateReverseKinematics.calcExtensionDistance());
        System.out.println(CalculateReverseKinematics.calcWristPivotAngle());
    }
}
