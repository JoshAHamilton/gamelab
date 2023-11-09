import java.util.HashMap;

public class World {
	
	public static HashMap<String, Room> rooms = 
			new HashMap<String, Room>();
	
	
	public static Room buildWorld() {
		// Create Rooms
		Room livingRoom = new Room("livingRoom", "You are in the living room.");
		Room kitchen = new Room("kitchen", "You are in the kitchen.");
		Room diningRoom = new Room("diningRoom", "You are in the dining room.");
		Room closet = new Room("closet", "You are now in the closet. You see a glimmer and notice a key on the ground. There's also a regular broom in here.");
		Room hallway = new Room("hallway", "You are now in the hallway. There is a door to the west and a chain hanging from the ceiling.");
		Room bedRoom = new Room("bedRoom", "You are now in the bedroom.");
		Room bathRoom = new Room("bathRoom", "You are now in the bathroom.");
		
		// Connect Rooms (addExits)
		// Living to kitchen
		livingRoom.addExit(kitchen, 'e');		
		kitchen.addExit(livingRoom, 'w');
		// Living room to dining room
		livingRoom.addExit(diningRoom, 'n');
		diningRoom.addExit(livingRoom, 's');
		// Living room to closet
		livingRoom.addExit(closet, 's');
		closet.addExit(livingRoom, 'n');
		// Living room to hallway
		livingRoom.addExit(hallway, 'u');
		hallway.addExit(livingRoom, 'd');
		// Hallway to bedroom
		hallway.addExit(bedRoom, 'w');
		bedRoom.addExit(hallway, 'e');
		// Hallway to bathRoom
		hallway.addExit(bathRoom, 'e');
		bathRoom.addExit(hallway, 'w');
		
		// Locking rooms
		closet.setLocked(true);
		bedRoom.setLocked(true);
		
		// Add Items to Rooms
		// newspaper in livingRoom
		Item newspaper = new Item("newspaper");
		newspaper.setDesc("This is a standard newspaper");
		livingRoom.addItem(newspaper);
		
		// wand in livingRoom
		Item wand = new Wand();
		wand.setDesc("This is a unknown wand");
		livingRoom.addItem(wand);
		
		// broom in closet
		Item broom = new Item("broom");
		broom.setDesc("This is just a broom");
		closet.addItem(broom);
		
		// key in closet
		Item key = new Item("key");
		key.setDesc("This is a strange key");
		closet.addItem(key);
		
		// notebook in bedRoom
		Item notebook = new Item("notebook");
		notebook.setDesc("This is a blank notebook");
		bedRoom.addItem(notebook);
		
		// chest in bedRoom
		Item chest = new Item("chest");
		chest.setDesc("It is a large, heavy chest.");
		chest.setHeavy(true);
		bedRoom.addItem(chest);
		
		// key to chest in diningRoom
		Item chestKey = new Key();
		chestKey.setDesc("It's an ornate key. Looks old.");
		diningRoom.addItem(chestKey);
		
		// chain in hallway
		Item chain = new Chain();
		chain.setDesc("This is a suspicious chain hanging from the ceiling.");
		chain.setHeavy(true);
		hallway.addItem(chain);
		
		// shower in bathroom
		Item shower = new Shower();
		shower.setDesc("This seems to be a clean and functional shower.");
		shower.setHeavy(true);
		bathRoom.addItem(shower);
		
		return livingRoom;
	}
}
