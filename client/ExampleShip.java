import java.awt.Color;
import java.util.Scanner;

import ihs.apcs.spacebattle.*;
import ihs.apcs.spacebattle.commands.*;

public class ExampleShip extends BasicSpaceship {
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
        return new IdleCommand(0.1);
    }
}