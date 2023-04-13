
/**
 * Contains all code for the Butterfly class
 */

public class Butterfly implements Contract { 
    String bName;
    String item;
    String direction;
    int x;
    int y;
    double weight = 0.5;

 /**
 * Constructs a Butterfly
 *
 * @param bName
 */

    public Butterfly(String bName) {
        this.bName = bName;
    }

/**
 * Prints that the butterfly has landed on an item and calls examine(item)
 *
 * @param item
 */

    public void grab(String item) {
        // land on item
        System.out.println(bName + " has landed on a(n) " + item);
        examine(item);
    }

/**
 * Prints that the butterfly has left an item
 *
 * @param item
 * @return item
 */

    public String drop(String item) {
        // leave item
        System.out.println(bName + " leaves the " + item);
        return item;
    }

/**
 * Calls use(item) if it is edible and drop(item) if it isn't
 *
 * @param item
 */

    public void examine(String item) {
        if (item.equals("flower") || item.equals("milkweed")) {
            use(item);
        } else {
            drop(item);
        }
    }

/**
 * The butterfly enjoys eating from the item and gains weight
 *
 * @param item
 */

    public void use(String item) {
        System.out.println(bName + " says, 'Yummy! I love " + item + ".'");
        grow();

    }

/**
 * Turns the butterfly in a direction and returns a boolean of whether that direction is north
 *
 * @param direction
 * @return true if the direction is north, false otherwise
 */

    public boolean walk(String direction) {
        System.out.println(bName + " turns to face " + direction + " and takes a step.");
        return direction.equals("north");
    }

/**
 * If the butterfly is facing north, it flies and loses weight. Otherwise, it changes direction and tries again. Either way, it returns its meters per second
 *
 * @param x
 * @param y
 * @return true if y/x > 5, false otherwise
 */

    public boolean fly(int x, int y) {
        if (walk(direction)) {
            System.out.println(bName + " flies " + x + " meter(s) in " + y + "second(s).");
            shrink();
        }
        else {
            System.out.println(bName + " can only fly to the north, but they are facing " + direction + "right now!");
            walk("north");
            fly(x, y);
        }
        return y/x > 5;
    }

/**
 * Makes the butterfly lose weight, warns if the weight is getting low, and kills the butterfly if its weight is too low
 *
 * @return weight
 */

    public Number shrink() {
        weight -= 0.01;
        if (weight < 0.15) {
            throw new RuntimeException("Oh no! " + bName + " died.");
        }    
        else if (weight < 0.3) {
            System.out.println(bName + " needs to eat more!");
        } 
        return weight;     
        
    }

/**
 * Makes the butterfly gain weight, warns if the weight is getting high, and kills the butterfly if its weight is too high
 *
 * @return weight
 */

    public Number grow() {
        weight += 0.01;
        if (weight > 0.85) {
            throw new RuntimeException("Oh no! " + bName + " died.") ;
        }
        else if (weight > 0.7) {
            System.out.println(bName + " needs to fly more!");
        }
        return weight;

    }

/**
 * Prints what kind of rest the butterfly is taking based on its previous flying speed
 */

    public void rest() {
        if (fly(x, y)) {
            System.out.println(bName + " says, 'I've been flying so fast! I should take a nap to regain energy.");
        } else {
            System.out.println(bName + " says, 'I haven't been flying that fast. I only need a quick break to regain energy.");
        }
    }

/**
 * Resets the butterfly's weight to its original
 */

    public void undo() {
        weight = 0.5;
        System.out.println(bName + "'s weight has been reset.");
    }

/**
 * Creates an instance of the House class
 *
 * @param args The command line arguments (ignored)
 */

    public static void main(String[] args) {
        Butterfly yourB = new Butterfly("Nectar");
        //Example commands:
        //yourB.grab("milkweed");
        //yourB.grab("rock");
        

    }
}

