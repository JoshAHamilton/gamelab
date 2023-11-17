
public class Butler extends NPC{
	
	public Butler() {
		super("butler","Just a butler cleaning the room");
	}
	
	@Override
	public void talk() {
		say("Hello, may I help you?");
		String[] options = {
				"What is this place?",
				"Who are you?"
		};
		getResponse(options);
	}
	
	@Override
	public void response(int choice) {
		switch(choice) {
		case 1:
			say("No clue, I just get paid to clean around here.");
			break;
		case 2:
			say("My name's William. I work here as a butler.");
			break;
		}
	}
	
}
