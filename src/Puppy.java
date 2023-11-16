
public class Puppy extends NPC{
	
	private int counter = 0;
	
	public Puppy() {
		super("puppy","A hideous puppy wags his tail at you.");
	}
	
	@Override
	public void talk() {
		if(counter == 0) {
			say("Hi! I'm an adorable puppy!");
			String[] options = {
					"Yes you are! Who's a good boy?",
					"Ew, no. You're actually kinda hideous."
			};
			getResponse(options);
		} else if(counter == 1) {
			say("Hey! Wanna play fetch? Say yes! Say yes!");
			String[] options = {
					"Yes! I love fetch!",
					"No. I am a horrible person and don't like playing with puppies."
			};
			getResponse(options);
		} else if(counter > 1) {
			say("Yip!");
		}
		counter += 1;
	}
	
	@Override
	public void response(int choice) {
		if(counter == 0) {
			switch(choice) {
			case 1:
				say("I am! I'm a good boy!");
				break;
			case 2:
				say("I am to adorable! Why are you so mean?");
				Game.print("The puppy bites you. You deserve it.");
				break;
			}
		} else if(counter == 1) {
			switch(choice) {
			case 1:
				say("Yay! Fetch!");
				Game.print("The dog runs off and returns with a ball.");
				Item ball = new Item("ball");
				ball.setDesc("Ball");
				Game.inventory.add(ball);
				break;
			case 2:
				say("You're a bad person! I don't like you!");
				// Finish removing the puppy from the room
				// Room.getCurrentRoom().removeNPC("puppy");
				break;
			}
		}
	}
	
}
