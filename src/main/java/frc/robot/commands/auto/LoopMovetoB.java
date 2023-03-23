package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.geometry.Transform2d;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Globals;
import frc.robot.RobotContainer;

public class LoopMovetoB extends SequentialCommandGroup{
  public LoopMovetoB(){
    super(
      
      new MovetoBWaypoint(),
      new InstantCommand(() -> Globals.cvMode = 4), 
      new WaitCommand(8), // Might have to change it to be faster
      // CP5 might be affected 
      new InstantCommand(() -> RobotContainer.m_points.updateAllPoints()),
      new InstantCommand(() -> Globals.cvMode = -1),
      new CheckTrolleyinWaypoint()
    );
  }
}
