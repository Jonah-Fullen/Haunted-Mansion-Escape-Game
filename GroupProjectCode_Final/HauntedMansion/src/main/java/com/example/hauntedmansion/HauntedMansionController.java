/**
 * HAUNTED MANSION ESCAPE
 * BY: Jonah Fullen, Rachel Keiter, Courtney Rogers, Hannah Vuncannon, and Audrey Warrene
 *
 * Main HauntedMansion FXML Controller
 * Breaks down into 2 main sections.
 * 1. Initialization of created Objects (Rooms and SearchableObjects) instances. One for every Room and one for
 * each SearchableObject in the game.
 * 2. Controller section. Aside from the start and end screens, the controller is based on 2 options: a) going from
 * one room to a new room (See line 306), or b) searching an object in the current room (See line 331).
 *
 * NOTE: You can change the number of keys hidden in the game by changing the value on line 274.
 */

package com.example.hauntedmansion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class HauntedMansionController {

    // Initialize all Rooms
    Room Foyer = new Room("Foyer", null, null);
    Room Kitchen = new Room("Kitchen", null, null);
    Room LivingRoom = new Room("Living Room", null, null);
    Room Bedroom = new Room("Bedroom", null, null);
    Room Hallway = new Room("Hallway", null, null);
    Room DiningRoom = new Room("Dining Room", null, null);
    Room BackPorch = new Room("Back Porch", null, null);

    // Initialize all Searchable Objects
    // From here you can hard code key locations.
    // Locations are actually set randomly at game startup.
    // Go to beginning of FXML controller to change the number of keys hidden in the game.
    SearchableObject GrandfatherClock =
            new SearchableObject(
                    "Grandfather Clock",
                    Foyer,
                    false,
                    "A large grandfather clock that has stopped ticking. The time reads '11:58'."
                            + System.lineSeparator()
                            + "“Strange… everything in this room is so well-tended to, but the clock seems to be " +
                            "completely broken.”");
    SearchableObject FoyerPlant =
            new SearchableObject(
                    "Fern",
                    Foyer,
                    false,
                    "A fern in a gold-painted pot. It seems well tended to."
                            + System.lineSeparator()
                            + "”This plant looks very healthy. I wonder if there’s anything hiding in this pot…”");
    SearchableObject FoyerPlant2 =
            new SearchableObject(
                    "Planter",
                    Foyer,
                    false,
                    "A fern in a gold-painted pot. It seems well tended to."
                            + System.lineSeparator()
                            + "”This plant looks very healthy. I wonder if there’s anything hiding in this pot…”");
    SearchableObject BreakfastBar =
            new SearchableObject(
                    "Breakfast Bar",
                    LivingRoom,
                    false,
                    "A small bar with a number of bar stools lining the front. The counter top of the bar is " +
                            "empty, but it is not dusty."
                            + System.lineSeparator()
                            + "“This looks like it was recently cleaned, or at least more recently used than some of" +
                            " the other things here…”");
    SearchableObject LRCouch =
            new SearchableObject(
                    "Couch",
                    LivingRoom,
                    false,
                    "A fancy leather couch on top of a fur rug, sitting across from a large TV. The front of " +
                            "the cushions are stained with blood, and in front of the couch blood has matted down the " +
                            "fur rug."
                            + System.lineSeparator()
                            + "“The blood looks wet, and it looks like it’s smeared on the couch, as if someone was" +
                            " trying to grab onto it… or maybe they were dragged off of it.”");
    SearchableObject Bookshelf =
            new SearchableObject(
                    "Bookshelf",
                    LivingRoom,
                    false,
                    "A dusty bookshelf with old books and loose papers hastily thrown in there. Some books look" +
                            " more dusty than others, and fresh fingerprints line some of the edges."
                            + System.lineSeparator()
                            + "“It looks like somebody has been here… maybe they hid something in one of these books…”");
    SearchableObject Clothes =
            new SearchableObject(
                    "Clothes",
                    Bedroom,
                    false,
                    "Hastily scattered clothes on the floor. They are covered in a small layer of dust."
                            + System.lineSeparator()
                            + "“These don’t look like they were tossed on the ground recently, they’re all dusty… but " +
                            "the handle to the dresser drawer isn’t dusty at all.”");
    SearchableObject Desk =
            new SearchableObject(
                    "Desk",
                    Bedroom,
                    false,
                    "A dusty desk with two small drawers and a high-end leather chair. Atop it is blank paper" +
                            " in a neat stack, a fountain pen and a cup of coffee in a fine china cup."
                            + System.lineSeparator()
                            + "“This desk looks completely untouched, unlike everything else in the room… it’s" +
                            " covered in dust, save for the cold cup of coffee. Even inside the drawers everything " +
                            "is organized.”");
    SearchableObject Bed =
            new SearchableObject(
                    "Bed",
                    Bedroom,
                    false,
                    "A king-sized bed with large silk covers and gold-stitched pillows. The covers are" +
                            " scattered with blood."
                            + System.lineSeparator()
                            + "“The blood is dry, but I can still smell it in the room, so it can’t be that old. It " +
                            "looks like somebody attempted to make the bed back up after the blood spill…”");
    SearchableObject Bar =
            new SearchableObject(
                    "Bar",
                    Kitchen,
                    false,
                    "A dusty bar with some bar stools neatly placed around the outside. The countertop is " +
                            "barren. There are some drawers and overhead cabinets inside the bar filled with dishes, " +
                            "cups, silverware, and cooking equipment. In the silverware drawer, there is not a single" +
                            " knife to be seen."
                            + System.lineSeparator()
                            + "“There has to be something useful in one of these things, right…? Anything other than " +
                            "old plates or some forks and spoons? Not even a knife?”");
    SearchableObject Oven =
            new SearchableObject(
                    "Oven",
                    Kitchen,
                    false,
                    "An old oven without power. The top and handle are dusty."
                            + System.lineSeparator()
                            + "“I wonder why this doesn't have any power… it doesn't seem like anyone has used it in" +
                            " quite some time.”");
    SearchableObject Cabinets =
            new SearchableObject(
                    "Cabinets",
                    Kitchen,
                    false,
                    "Cabinets filled with spare dishes and glassware."
                            + System.lineSeparator()
                            + "“This doesn't look like it’s been touched in a while… but it might be worth looking " +
                            "through these cabinets either way.”");
    SearchableObject ChinaCabinet =
            new SearchableObject(
                    "China Cabinet",
                    DiningRoom,
                    false,
                    "A cabinet full of fine china with dried blood splattered on it’s side and back. The " +
                            "glass door to the cabinet is ajar. Every piece of china is in there, save for one cup."
                            + System.lineSeparator()
                            + "“This blood is very old… I barely would have noticed it if I didn't come over and see" +
                            " it myself. Strange, looking in the cabinet, it looks like there’s a cup missing…”");
    SearchableObject Table =
            new SearchableObject(
                    "Table",
                    DiningRoom,
                    false,
                    "A long stretched wooden dining table meticulously decorated with fine plates and " +
                            "silverware. The wooden chairs are perfectly straight, and everything has a thick layer " +
                            "of dust."
                            + System.lineSeparator()
                            + " “Just stepping close to this table is making me want to cough… the dust is making my " +
                            "eyes water.”");
    SearchableObject Counter =
            new SearchableObject(
                    "Counter",
                    DiningRoom,
                    false,
                    "A long counter with a small landline phone sitting at the back towards the wall. The " +
                            "line has been cut haphazardly, and the back of the counter is dripping with blood."
                            + System.lineSeparator()
                            + "“A phone would be nice, too bad it’s cut… but this blood on the counter looks fresh, " +
                            "maybe it was cut recently. I shouldn’t stick around.”\n");
    SearchableObject LCouch =
            new SearchableObject(
                    "Couch",
                    BackPorch,
                    false,
                    "An old but durable looking couch, one made to be used outdoors."
                            + System.lineSeparator()
                            + "“What an old looking couch… the broken window must not be doing it any favors either.”");
    SearchableObject RCouch =
            new SearchableObject(
                    "Sofa",
                    BackPorch,
                    false,
                    "An old but durable looking couch, one made to be used outdoors. Small shards of glass " +
                            "and drops of blood have scattered onto it."
                            + System.lineSeparator()
                            + "“This doesn't look like the most comfortable couch in the world, and the pieces of" +
                            " glass don’t make it any more inviting…”");
    SearchableObject Glass =
            new SearchableObject(
                    "Broken Glass",
                    BackPorch,
                    false,
                    "Bloody shattered glass laying in front of a boarded up window."
                            + System.lineSeparator()
                            + "“I better watch my step… whoever boarded up this window didn't want to bother cleaning" +
                            " up any of this glass. Maybe it was done in a hurry, this blood looks… fresh.”");
    SearchableObject Mirror =
            new SearchableObject(
                    "Broken Mirror",
                    Hallway,
                    false,
                    "Dirty broken shards of mirror. A few pieces are dotted with blood."
                            + System.lineSeparator()
                            + "“It looks like someone cut themselves breaking this mirror. There’s hardly any pieces" +
                            " of mirror left on the wall, but the pieces that are left are foggy and unclean… it " +
                            "looks like it was dirty prior to it being broken.”");
    SearchableObject HPlant =
            new SearchableObject(
                    "Planter",
                    Hallway,
                    false,
                    "A potted plant. The gold paint on the pot looks chipped, and a few of the leaves are" +
                            " dead, but the plant is still green and growing."
                            + System.lineSeparator()
                            + "“This plant look older and less cared for than the plants in the foyer… I wonder if " +
                            "theres anything hiding in the pot?”");
    SearchableObject HPlant2 =
            new SearchableObject(
                    "Flowerpot",
                    Hallway,
                    false,
                    "A small plant in a gold-painted pot. It looks dry and not well watered. A good number " +
                            "of leaves have fallen onto the floor."
                            + System.lineSeparator()
                            + "“It doesn't look like anyone has cared for these plants nearly as well as the ones in " +
                            "the foyer…”");

    // Create All Searchable Objects List. Used to randomly place keys
    ArrayList<SearchableObject> MapObjects =
            new ArrayList<>(
                    Arrays.asList(
                            GrandfatherClock,
                            FoyerPlant,
                            FoyerPlant2,
                            BreakfastBar,
                            LRCouch,
                            Bookshelf,
                            Clothes,
                            Desk,
                            Bed,
                            Bar,
                            Oven,
                            Cabinets,
                            ChinaCabinet,
                            Table,
                            Counter,
                            LCouch,
                            RCouch,
                            Glass,
                            Mirror,
                            HPlant,
                            HPlant2));

    // Begin FXML Controller
    public int numKeysFound = 0;
    public int keysNeeded = 3; // Set Number of keys hidden in game

    @FXML private Pane BedroomPane;

    @FXML private Pane FoyerPane;

    @FXML private TextArea KeysText;

    @FXML private TextArea DialogueText;

    @FXML private Pane HallwayPane;

    @FXML private Pane LivingRoomPane;

    @FXML private Pane BackPorchPane;

    @FXML private Pane DiningRoomPane;

    @FXML private Button ExitButton;

    @FXML private Pane KitchenPane;

    @FXML private Pane StartPane;

    @FXML private Pane EndPane;

    @FXML private Button ReplayButton;


    // All Button Controls

    @FXML
    void FoyerToKitchenClicked(ActionEvent event) {
        // Replicate this code for going through every doorway
        FoyerPane.setVisible(false); // Set the previous room pane to invisible
        KitchenPane.setVisible(true); // Set the new room pane to visible
        // Generate dialogue for entering the new room
        DialogueText.setText(
                "You left the Foyer and entered the Kitchen....\n\n"
                        + "You enter a large kitchen with a bar counter in the bottom right corner and a table in the top "
                        + "right. There are cabinets sitting in the top left, and a large plant in the bottom left. The back"
                        + " of the kitchen has some appliances by the counter. The table corner is splattered with blood, "
                        + "and directly beside it rests a pool of blood.");
    }

    @FXML
    void KitchenToFoyerClicked(ActionEvent event) {
        KitchenPane.setVisible(false);
        FoyerPane.setVisible(true);
        DialogueText.setText(
                "You left the Kitchen and entered the Foyer....\n\n"
                        + "You find yourself in a foyer dimly lit by the windows in the front. Three doorways connect to "
                        + "different rooms, and each doorway is flanked with two ferns in gilded pots. A grandfather clock sits"
                        + " on the left wall towards the entrance.");
    }

    @FXML
    void SearchFernClicked(ActionEvent event) {
        // Replicate this code for searching each object
        SearchableObject Searched = FoyerPlant; // Set the object being searched
        if (Searched.getHoldsKey()) { // Determine if it holds a key
            Searched.setHoldsKey(false); // Remove the key so that they cannot find the same key twice
            numKeysFound += 1; // Increment the number of keys found
            KeysText.setText(
                    "Keys Found: " + numKeysFound + "/" + keysNeeded); // Display the number of keys found
            // Display the key found dialogue
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");
            if (numKeysFound == keysNeeded) { // If all keys are found, enable the exit button
                ExitButton.setDisable(false);
            }
        } else {
            // Display the dialogue for not finding a key
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchCabinetsClicked(ActionEvent event) {
        SearchableObject Searched = Cabinets;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void ExitButtonClicked(ActionEvent event) {
        if(numKeysFound != keysNeeded) {
            DialogueText.setText("You haven't found all of the keys. Keep searching to unlock the door.");
        }
        else {
            DialogueText.setText("YOU FOUND ALL THE KEYS AND MADE IT OUT!!");
            FoyerPane.setVisible(false);
            EndPane.setVisible(true);
        }
    }

    @FXML
    void FoyerToHallwayClicked(ActionEvent event) {
        FoyerPane.setVisible(false);
        HallwayPane.setVisible(true);
        DialogueText.setText(
                "You left the Foyer and entered the Hallway....\n\n"
                        + "You enter a long hallway connecting four rooms. Four planters decorate either end of the room, two "
                        + "on each end. To the top left, a shattered mirror has left bloody shards on the floor.");
    }

    @FXML
    void FoyerToLivingRoomClicked(ActionEvent event) {
        FoyerPane.setVisible(false);
        LivingRoomPane.setVisible(true);
        DialogueText.setText(
                "You left the Foyer and entered the Living Room....\n\n"
                        + "You open the door into a large living room with a breakfast bar. A bloody couch sits in the bottom "
                        + "right corner across from a TV, the space between the two covered in blood as well.");
    }

    @FXML
    void Fern2Clicked(ActionEvent event) {
        SearchableObject Searched = FoyerPlant2;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void GrandfatherClockClicked(ActionEvent event) {
        SearchableObject Searched = GrandfatherClock;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void KitchenToDiningRoomClicked(ActionEvent event) {
        KitchenPane.setVisible(false);
        DiningRoomPane.setVisible(true);
        DialogueText.setText(
                "You left the Kitchen and entered the Dining Room....\n\n"
                        + "You walk into an extravagant dining hall with a long and magnificent dining room table in the center. "
                        + "A cabinet filled with fine china sits in the bottom left corner, with some blood scattered on it.\n\n"
                        + "“This room looks almost completely unused… it smells musty. It seems like no one has been in here a "
                        + "long time, except the blood in the corner might tell a different story.”");
    }

    @FXML
    void SearchOvenClicked(ActionEvent event) {
        SearchableObject Searched = Oven;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchBarClicked(ActionEvent event) {
        SearchableObject Searched = Bar;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void LivingRoomToFoyerClicked(ActionEvent event) {
        LivingRoomPane.setVisible(false);
        FoyerPane.setVisible(true);
        DialogueText.setText(
                "You left the Living Room and entered the Foyer....\n\n"
                        + "You find yourself in a foyer dimly lit by the windows in the front. Three doorways connect to "
                        + "different rooms, and each doorway is flanked with two ferns in gilded pots. A grandfather clock sits"
                        + " on the left wall towards the entrance.");
    }

    @FXML
    void LivingRoomToBedroomClicked(ActionEvent event) {
        LivingRoomPane.setVisible(false);
        BedroomPane.setVisible(true);
        DialogueText.setText(
                "You left the Living Room and entered the Bedroom....\n\n"
                        + "You enter a large bedroom decorated with a king-sized bed at the top right and a desk in the bottom "
                        + "left corner. Clothes are scattered on the floor by an open clothes dresser in the bottom right.\n\n"
                        + "“This bedroom is hauntingly large, but I feel like the walls are closing in on me… the smell of iron "
                        + "doesn't exactly ease my nerves either..”\n");
    }

    @FXML
    void SearchBreakfastBarClicked(ActionEvent event) {
        SearchableObject Searched = BreakfastBar;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchLRCouchClicked(ActionEvent event) {
        SearchableObject Searched = LRCouch;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchBookshelfClicked(ActionEvent event) {
        SearchableObject Searched = Bookshelf;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void BedroomToLivingRoomClicked(ActionEvent event) {
        BedroomPane.setVisible(false);
        LivingRoomPane.setVisible(true);
        DialogueText.setText(
                "You left the Bedroom and entered the Living Room....\n\n"
                        + "You open the door into a large living room with a breakfast bar. A bloody couch sits in the bottom "
                        + "right corner across from a TV, the space between the two covered in blood as well.");
    }

    @FXML
    void BedroomToHallwayClicked(ActionEvent event) {
        BedroomPane.setVisible(false);
        HallwayPane.setVisible(true);
        DialogueText.setText(
                "You left the Bedroom and entered the Hallway....\n\n"
                        + "You enter a long hallway connecting four rooms. Four planters decorate either end of the room, two "
                        + "on each end. To the top left, a shattered mirror has left bloody shards on the floor.");
    }

    @FXML
    void BedroomToBackPorchClicked(ActionEvent event) {
        BedroomPane.setVisible(false);
        BackPorchPane.setVisible(true);
        DialogueText.setText(
                "You left the Bedroom and entered the Back Porch....\n\n"
                        + "You find a long back porch with three doorways and a couch at either end of the room. To the right, "
                        + "there is a shattered and boarded up window with bloody glass scattered on the floor.\n\n"
                        + "“It’s a bit chilly in here… I can hear wind blowing into the room. Might not want to stay in "
                        + "here too long…”");
    }

    @FXML
    void SearchBedClicked(ActionEvent event) {
        SearchableObject Searched = Bed;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchClothesClicked(ActionEvent event) {
        SearchableObject Searched = Clothes;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchDeskClicked(ActionEvent event) {
        SearchableObject Searched = Desk;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void DiningRoomToKitchenClicked(ActionEvent event) {
        DiningRoomPane.setVisible(false);
        KitchenPane.setVisible(true);
        DialogueText.setText(
                "You left the Dining Room and entered the Kitchen....\n\n"
                        + "You enter a large kitchen with a bar counter in the bottom right corner and a table in the top "
                        + "right. There are cabinets sitting in the top left, and a large plant in the bottom left. The back"
                        + " of the kitchen has some appliances by the counter. The table corner is splattered with blood, "
                        + "and directly beside it rests a pool of blood.");
    }

    @FXML
    void DiningRoomToHallwayClicked(ActionEvent event) {
        DiningRoomPane.setVisible(false);
        HallwayPane.setVisible(true);
        DialogueText.setText(
                "You left the Dining Room and entered the Hallway....\n\n"
                        + "You enter a long hallway connecting four rooms. Four planters decorate either end of the room, two "
                        + "on each end. To the top left, a shattered mirror has left bloody shards on the floor.");
    }

    @FXML
    void DiningRoomToBackPorchClicked(ActionEvent event) {
        DiningRoomPane.setVisible(false);
        BackPorchPane.setVisible(true);
        DialogueText.setText(
                "You left the Dining Room and entered the Back Porch....\n\n"
                        + "You find a long back porch with three doorways and a couch at either end of the room. To the right, "
                        + "there is a shattered and boarded up window with bloody glass scattered on the floor.\n\n"
                        + "“It’s a bit chilly in here… I can hear wind blowing into the room. Might not want to stay in "
                        + "here too long…”");
    }

    @FXML
    void SearchTableClicked(ActionEvent event) {
        SearchableObject Searched = Table;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchChinaCabinetClicked(ActionEvent event) {
        SearchableObject Searched = ChinaCabinet;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchCounterClicked(ActionEvent event) {
        SearchableObject Searched = Counter;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void HallwayToBackPorchClicked(ActionEvent event) {
        HallwayPane.setVisible(false);
        BackPorchPane.setVisible(true);
        DialogueText.setText(
                "You left the Hallway and entered the Back Porch....\n\n"
                        + "You find a long back porch with three doorways and a couch at either end of the room. To the right, "
                        + "there is a shattered and boarded up window with bloody glass scattered on the floor.\n\n"
                        + "“It’s a bit chilly in here… I can hear wind blowing into the room. Might not want to stay in "
                        + "here too long…”");
    }

    @FXML
    void HallwayToDiningRoomClicked(ActionEvent event) {
        HallwayPane.setVisible(false);
        DiningRoomPane.setVisible(true);
        DialogueText.setText(
                "You left the Hallway and entered the Dining Room....\n\n"
                        + "You walk into an extravagant dining hall with a long and magnificent dining room table in the center. "
                        + "A cabinet filled with fine china sits in the bottom left corner, with some blood scattered on it.\n\n"
                        + "“This room looks almost completely unused… it smells musty. It seems like no one has been in here a "
                        + "long time, except the blood in the corner might tell a different story.”");
    }

    @FXML
    void HallwayToBedroomClicked(ActionEvent event) {
        HallwayPane.setVisible(false);
        BedroomPane.setVisible(true);
        DialogueText.setText(
                "You left the Hallway and entered the Bedroom....\n\n"
                        + "You enter a large bedroom decorated with a king-sized bed at the top right and a desk in the bottom "
                        + "left corner. Clothes are scattered on the floor by an open clothes dresser in the bottom right.\n\n"
                        + "“This bedroom is hauntingly large, but I feel like the walls are closing in on me… the smell of iron "
                        + "doesn't exactly ease my nerves either..”\n");
    }

    @FXML
    void HallwayToFoyerClicked(ActionEvent event) {
        HallwayPane.setVisible(false);
        FoyerPane.setVisible(true);
        DialogueText.setText(
                "You left the Hallway and entered the Foyer....\n\n"
                        + "You find yourself in a foyer dimly lit by the windows in the front. Three doorways connect to "
                        + "different rooms, and each doorway is flanked with two ferns in gilded pots. A grandfather clock sits"
                        + " on the left wall towards the entrance.");
    }

    @FXML
    void SearchMirrorClicked(ActionEvent event) {
        SearchableObject Searched = Mirror;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchHPlantClicked(ActionEvent event) {
        SearchableObject Searched = HPlant;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchHPlant2Clicked(ActionEvent event) {
        SearchableObject Searched = HPlant2;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");
            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void BackPorchToDiningRoomClicked(ActionEvent event) {
        BackPorchPane.setVisible(false);
        DiningRoomPane.setVisible(true);
        DialogueText.setText(
                "You left the Back Porch and entered the Dining Room....\n\n"
                        + "You walk into an extravagant dining hall with a long and magnificent dining room table in the center. "
                        + "A cabinet filled with fine china sits in the bottom left corner, with some blood scattered on it.\n\n"
                        + "“This room looks almost completely unused… it smells musty. It seems like no one has been in here a "
                        + "long time, except the blood in the corner might tell a different story.”");
    }

    @FXML
    void BackPorchToHallwayClicked(ActionEvent event) {
        BackPorchPane.setVisible(false);
        HallwayPane.setVisible(true);
        DialogueText.setText(
                "You left the Back Porch and entered the Hallway....\n\n"
                        + "You enter a long hallway connecting four rooms. Four planters decorate either end of the room, two "
                        + "on each end. To the top left, a shattered mirror has left bloody shards on the floor.");
    }

    @FXML
    void BackPorchToBedroomClicked(ActionEvent event) {
        BackPorchPane.setVisible(false);
        BedroomPane.setVisible(true);
        DialogueText.setText(
                "You left the Back Porch and entered the Bedroom....\n\n"
                        + "You enter a large bedroom decorated with a king-sized bed at the top right and a desk in the bottom "
                        + "left corner. Clothes are scattered on the floor by an open clothes dresser in the bottom right.\n\n"
                        + "“This bedroom is hauntingly large, but I feel like the walls are closing in on me… the smell of iron "
                        + "doesn't exactly ease my nerves either..”\n");
    }

    @FXML
    void SearchLCouchClicked(ActionEvent event) {
        SearchableObject Searched = LCouch;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchRCouchClicked(ActionEvent event) {
        SearchableObject Searched = RCouch;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML
    void SearchGlassClicked(ActionEvent event) {
        SearchableObject Searched = Glass;
        if (Searched.getHoldsKey()) {
            Searched.setHoldsKey(false);
            numKeysFound += 1;
            KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and found a key!");

            if (numKeysFound == keysNeeded) {
                ExitButton.setDisable(false);
            }
        } else {
            DialogueText.setText(
                    Searched.getDialogue()
                            + "\n\nYou searched the "
                            + Searched.getName()
                            + " and didn't find anything.");
        }
    }

    @FXML

    void ReplayButtonClicked(ActionEvent event) {
        EndPane.setVisible(false);
        StartPane.setVisible(true);
        numKeysFound = 0;
        KeysText.setText("Keys Found: " + numKeysFound + "/" + keysNeeded);
        DialogueText.setText("You run into an old mansion to escape a late-night thunderstorm after getting stranded on" +
                " the side of the road. The door suddenly closes behind you and you notice three deadbolts lock into place.");
    }
    @FXML
    void StartButtonClicked(ActionEvent event) {
        StartPane.setVisible(false);
        FoyerPane.setVisible(true);
        DialogueText.setText("“Whew, thank goodness I found some place to get out of that rain… maybe there’s a room " +
                "I can rest in here for a little while…“"
                + System.lineSeparator()
                + System.lineSeparator()
                + "You find yourself in a foyer dimly lit by the windows in the front. Three doorways connect to " +
                "different rooms, and each doorway is flanked with two ferns in gilded pots. A grandfather clock sits " +
                "on the left wall towards the entrance"
        );
        // Randomly place the keys in the Searchable Objects
        int numObjects = MapObjects.size();
        for(int i = 0; i < keysNeeded; i++) {
            int location = (int)(numObjects * Math.random());
            if(MapObjects.get(location).getHoldsKey()){
                i -= 1;
            }
            else {
                MapObjects.get(location).setHoldsKey(true);
            }
        }
    }
}
