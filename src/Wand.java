
public class Wand extends Item {
	
	public Wand() {
		super("wand");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("livingRoom")) {
			System.out.println("You wave the wand around and the closet magically unlocks!");
			Room closet = Game.getCurrentRoom().getExit('s');
			closet.setLocked(false);
		} else {
			System.out.println("You wave the wand around.");
		}
	}
	
}
