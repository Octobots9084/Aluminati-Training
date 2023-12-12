package frc.robot.subsystems.Arms;

public class CalculateReverseKinematics {
    private static double pivotHeight = 0.8382;
    private static double minExtension = 0.6604;
    private static double wristLength = 0.135255;
    
    private static double targetX;
    private static double targetY;
    private static double absWristAngle;
    
    // absWristAngle should be given in radians, output will also be in radians
    public static void setVariables(double awa, double tX, double tY) {
        targetY = tY;
        absWristAngle = awa;
        targetX = tX;
    }
    
    public static double calcPivotAngle() {
        
        // I'm pretty sure this is good
        return (2*Math.atan(
            (
                1 / 
                (targetY - pivotHeight - (wristLength*Math.sin(absWristAngle)))
            ) * 
            (
                Math.sqrt(
                    (targetY*targetY) - 
                    (2*targetY*pivotHeight) - 
                    (2*targetY*wristLength*Math.sin(absWristAngle)) + 
                    (pivotHeight*pivotHeight) + 
                    (2*pivotHeight*wristLength*Math.sin(absWristAngle)) + 
                    (wristLength*wristLength*Math.sin(absWristAngle)*Math.sin(absWristAngle)) + 
                    (wristLength*wristLength*Math.cos(absWristAngle)*Math.cos(absWristAngle)) - 
                    (2*wristLength*targetX*Math.cos(absWristAngle)) + 
                    (targetX*targetX)
                ) + 
                (wristLength*Math.cos(absWristAngle)) - targetX
            )
        ));
    }

    public static double convertRad2Motor(double angle) {
        return (0.75 + 
                (angle / (2*Math.PI)
            )
        );
    }

    public static double calcWristPivotAngle() {
        return 0.62 - ((absWristAngle - calcPivotAngle()) / (2*Math.PI));
    }
    
    public static double calcExtensionDistance() {
        double pivotAngle = calcPivotAngle();
        
        return ((
            targetY - 
                (minExtension * Math.sin(pivotAngle)) -
                pivotHeight -
                (wristLength * Math.sin(absWristAngle))
            ) / 
            (Math.sin(pivotAngle))
        );
    }
}