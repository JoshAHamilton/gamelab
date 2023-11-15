
public class Puppy extends NPC{
	
	public Puppy() {
		super("puppy","A hideous pupper wags his tail stupidly at you.");
	}
	
	public void talk() {
		say("Hi! I'm an adorable puppy!");
		String[] options = {
				"Yes you are! Who's a good boy?",
				"Uh, no. You're hideous."
		};
		getResponse(options);
	}

	public void response(int choice) {
		switch(choice) {
		case 1:
			say("I am! I'm a good boy!");
			break;
		case 2:
			say("Why are you so mean?");
			Game.print("");
			break;
		}
	}
	
}
