import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
	
	private static Room currentRoom;
	public static ArrayList<Item> inventory = new ArrayList<Item>();
	
	public static HashMap<String, String> roomDescs = new HashMap<String, String>();
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void populateMap(File rooms) {
		try {
			Scanner scan = new Scanner(new File("rooms"));
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String[] words = line.split("#");
				roomDescs.put(words[0], words[1]);
			}
		} catch(FileNotFoundException ex) {
			print("File "+rooms+" not found");
		}
	}
	
	public static void setCurrentRoom(Room r) {
		currentRoom = r;
	}
	
	public static Room getCurrentRoom() {
		return currentRoom;
	}
	
	public static void print(String message) {
		System.out.println(message+"\n");
	}
	
	public static void saveGame() {
		File saveFile = new File("save");
		try {
			saveFile.createNewFile();
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(saveFile));
			stream.writeObject(currentRoom);
			stream.writeObject(inventory);
			stream.writeObject(World.rooms);
			stream.close();
			Game.print("Game Saved.");
		} catch (IOException e) {
			print("ERROR: Cannot save file.");
			e.printStackTrace();
		}
	}
	
	public static void move(String direction) {
		Room nextRoom = currentRoom.getExit(direction.charAt(0));
		if(nextRoom != null) {
			if(nextRoom.isLocked()) {
				System.out.println("The room is locked");
			} else {
				currentRoom = nextRoom;
				System.out.println(currentRoom);
			}
		} else {
			System.out.println("You can't go that way!");
		}
	}
	
	public static void addToInventory(Item item) {
		inventory.add(item);
	}
	
	public static boolean removeFromInventory(String itemName) {
	    for (Item item : inventory) {
	        if (item.getName().equals(itemName)) {
	            inventory.remove(item);
	            return true;
	        }
	    }
	    return false;
	}
	
	public static boolean checkInventory(String itemName) {
		for(Item item : inventory) {
			if (item.getName().equals(itemName)) {
	            return true;
	        }
		}
		return false;
	}
	
	public static void main(String[] args) {
		String playerCommand;
		String[] itemName;
		NPC npc;
		currentRoom = World.buildWorld();
		System.out.println(currentRoom);
		do {
			System.out.print("What do you want to do? ");
			playerCommand = scan.nextLine();
			itemName = playerCommand.split(" ");
			if(playerCommand.equals("i")) {
				if(inventory.isEmpty()) {
					System.out.println("You are carrying nothing.");
				} else {
					for(Item i : inventory) {
						System.out.println(i);
					}
				}
			} else if (playerCommand.equals("e")) {
				move(playerCommand);
			} else if (playerCommand.equals("w")) {
				move(playerCommand);
			} else if (playerCommand.equals("n")) {
				move(playerCommand);
			} else if (playerCommand.equals("s")) {
				move(playerCommand);
			} else if (playerCommand.equals("u")) {
				move(playerCommand);
			} else if (playerCommand.equals("d")) {
				move(playerCommand);
			} else if (playerCommand.equals("x")) {
				System.out.println("Okay. Bye!");
			} else if(itemName[0].equals("take")) {
				if(itemName.length >= 2) {
					if(currentRoom.hasItem(itemName[1])) {
						Item item = currentRoom.getItem(itemName[1]);
						item.take();
					} else {
						System.out.println("There is no "+itemName[1]+"!");
					}
				} else {
					System.out.println("No item given to take");
				}
			} else if(itemName[0].equals("look")) {
				if (itemName.length >= 2) {
			        String itemToLookName = itemName[1];
			        boolean itemFoundInInventory = false;
			        // Check if NPC or Item
			        
			        if(currentRoom.isNPC(itemToLookName)) {
			        	
			        }
			        
			        if (currentRoom.hasNPC(itemToLookName)) {
				        currentRoom.getNPC(itemToLookName).look();
			        } else {
			        	// Search the inventory for the item
				        for (Item item : inventory) {
				            if (item.getName().equals(itemToLookName)) {
				                item.look();
				                itemFoundInInventory = true;
				                break;
				            }
				        }
				        
				        // If not found in inventory, check the current room
				        if (!itemFoundInInventory && currentRoom.hasItem(itemToLookName)) {
				            currentRoom.getItem(itemToLookName).look();
				        } else if (!itemFoundInInventory) {
				            System.out.println("There is no " + itemToLookName);
				        }
			        }
				} else {
					System.out.println("Nothing given to look at");
				}
			} else if(itemName[0].equals("use")) {
				if (itemName.length >= 2) {
					String itemToUseName = itemName[1];
					boolean itemFoundInInventory = false;
					// Search the inventory for the item
					for (Item item : inventory) {
						if (item.getName().equals(itemToUseName)) {
							item.use();
							itemFoundInInventory = true;
							break;
						}
					}
					// Search the room for the item
					if(!itemFoundInInventory) {
						if(currentRoom.hasItem(itemToUseName)) {
							if(itemToUseName.equals("chain") || itemToUseName.equals("shower")) {
								currentRoom.getItem(itemToUseName).use();
							}
						} else {
							System.out.println("There is no "+itemToUseName+" to use.");
						}
					}
				} else {
					System.out.println("No item given to use.");
				}
			} else if(itemName[0].equals("talk")) {
				if (itemName.length >= 2) {
					if(currentRoom.hasNPC(itemName[1])) {
						npc = currentRoom.getNPC(itemName[1]);
						npc.talk();
					} else {
						print("There is no "+itemName[1]+" to talk to here.");
					}
				} else {
					print("Nothing given to talk to.");
				}
			} else if(playerCommand.equals("save")) {
				saveGame();
			} else {
				System.out.println("Invalid command.");
			}
		} while(!playerCommand.equals("x"));
		scan.close();
	}
	
}
