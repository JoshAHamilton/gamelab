
public class Wand extends Item {
	
	public Wand() {
		super("wand");
	}
	
	@Override
	public void take() {
		super.take(); // Calls Item's take() method
		Game.getCurrentRoom().setRoomID("LIVINGROOM_A");
	}
	
	@Override
	public void use() {
		if(Game.getCurrentRoom().getName().equals("livingRoom")) {
			Game.print("You wave the wand around and the closet magically unlocks!");
			Room closet = Game.getCurrentRoom().getExit('s');
			closet.setLocked(false);
		} else {
			Game.print("You wave the wand around.");
		}
	}
	
}
