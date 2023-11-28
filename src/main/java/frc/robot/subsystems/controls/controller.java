package frc.robot.subsystems.controls;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.robot.ControlMap;
import frc.robot.subsystems.Arms.FlySwatterInstant;
import frc.robot.subsystems.Arms.MainRollerIntake;
import frc.robot.subsystems.Arms.ArmExtension;
import frc.robot.subsystems.Arms.ArmPivot;
import frc.robot.subsystems.Arms.RollerIntake;
import frc.robot.subsystems.Arms.WristPivot;

public class controller {
    public static void initTeleop() {
        new JoystickButton(ControlMap.DRIVER_BUTTONS, 1).onTrue(new RollerIntake(0.2));
        new JoystickButton(ControlMap.DRIVER_BUTTONS, 1).onFalse(new RollerIntake(0));
       // new JoystickButton(ControlMap.DRIVER_BUTTONS, 6).onTrue(new FlySwatterInstant(0.17));
       // new JoystickButton(ControlMap.DRIVER_BUTTONS, 3).onTrue(new FlySwatterInstant(0.41));
        new JoystickButton(ControlMap.DRIVER_BUTTONS, 4).onTrue(new RollerIntake(-0.2));
        new JoystickButton(ControlMap.DRIVER_BUTTONS, 4).onFalse(new RollerIntake(0));

        new JoystickButton(ControlMap.DRIVER_BUTTONS, 7).onTrue(new ArmExtension(0.2));

        new JoystickButton(ControlMap.DRIVER_BUTTONS, 2).onTrue(new ArmPivot(0.7));

        new JoystickButton(ControlMap.DRIVER_BUTTONS, 6).onTrue(new WristPivot(0.6));
        new JoystickButton(ControlMap.DRIVER_BUTTONS, 3).onTrue(new WristPivot(0.25));

        new JoystickButton(ControlMap.DRIVER_BUTTONS, 9).onTrue(new MainRollerIntake(0.2));
        new JoystickButton(ControlMap.DRIVER_BUTTONS, 10).onTrue(new MainRollerIntake(-0.2));
    }
}
