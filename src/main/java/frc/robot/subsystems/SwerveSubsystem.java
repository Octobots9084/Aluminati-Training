package frc.robot.subsystems;

import com.pathplanner.lib.PathConstraints;
import com.pathplanner.lib.PathPlanner;
import com.pathplanner.lib.PathPlannerTrajectory;
import com.pathplanner.lib.auto.PIDConstants;
import com.pathplanner.lib.auto.SwerveAutoBuilder;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.io.File;
import java.util.List;
import java.util.Map;
import swervelib.SwerveController;
import swervelib.SwerveDrive;
import swervelib.math.SwerveMath;
import swervelib.parser.SwerveControllerConfiguration;
import swervelib.parser.SwerveDriveConfiguration;
import swervelib.parser.SwerveParser;
import swervelib.telemetry.SwerveDriveTelemetry;
import swervelib.telemetry.SwerveDriveTelemetry.TelemetryVerbosity;

public class SwerveSubsystem extends SubsystemBase{

    //Variables
    private final SwerveDrive swerveDrive;
    public double maxSpeed = Units.feetToMeters(5);
    public SwerveSubsystem(File directory){
        SwerveDriveTelemetry.verbosity = TelemetryVerbosity.HIGH;
        try
        {
        swerveDrive = new SwerveParser(directory).createSwerveDrive(maxSpeed);
        } catch (Exception e)
        {
        throw new RuntimeException(e);
        }
        swerveDrive.setHeadingCorrection(false);
    }

    public SwerveSubsystem(SwerveDriveConfiguration driveCfg, SwerveControllerConfiguration controllerCfg){
        swerveDrive = new SwerveDrive(driveCfg, controllerCfg, maxSpeed);
    }

    public void drive(Translation2d translation, double rot, boolean fieldrelative){
        swerveDrive.drive(translation, rot, fieldrelative, false);
    }

    public SwerveController getSwerveController()
    {
        return swerveDrive.swerveController;
    }

}
