import java.awt.Color;
import java.util.Scanner;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class ExampleShip extends BasicSpaceship {
    static ObjectStatus myShip;
    Point center = new Point(670,365);
    public static void main(String[] args)
    {
		String ip;
		if (args.length > 0) {
			ip = args[0];
		}
		else {
			System.out.print("enter ip: ");
			ip = new Scanner(System.in).nextLine();
		}
        TextClient.run(ip, new ExampleShip());
    }

    @Override
    public RegistrationData registerShip(int numImages, int worldWidth, int worldHeight)
    {
        return new RegistrationData("Example Ship", new Color(255, 255, 255), 0);
    }
    @Override
    public ShipCommand getNextCommand(BasicEnvironment env)
    {
	myShip = env.getShipStatus();
	if(myShip.getPosition().getDistanceTo(center) <= 75) return new BrakeCommand(0.0);
	if(Math.abs(degToCenter()) > 5)
	return new RotateCommand(degToCenter());
	if(myShip.getSpeed() <= 1)
	return new ThrustCommand('F', 5, 1.0);
	return new IdleCommand(0.1);
    }
    private int degToCenter(){
	int destAngle = myShip.getPosition().getAngleTo(center)+180-(int)myShip.getOrientation();
	if(destAngle > 180) destAngle -= 360;
	return destAngle;
    }

    //further optimization below
    private double timeToCenter(){
	
    }
    private int brakeDistance(){
	
    }

}
