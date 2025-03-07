package CPRE416_HW1_OOP_Design;

import java.util.ArrayList;

public class Bard extends Character {

    private ArrayList<Weapon> weapons;

    public Bard(){
        super();
        weapons.add(new DoC());
    }

    
    @Override
    protected void applyClassBonus() {
        coreAttributes.replace(Core.VIT, coreAttributes.get(Core.VIT) - 1);
    }

    /*
     * Example of Stamp coupling.
     * The coupling exists because:
     * The entire Weapon object is passed to the method as a parameter
     * However, the method only uses two aspects of the weapon:
     * It checks if the weapon exists in the character's inventory (weapons.contains(weapon))
     * It calls the damage() method on the weapon
     * This is stamp coupling because the method receives the entire Weapon complex data structure, 
     * even though it only needs a small portion of its functionality.
     */
    @Override
    protected int attack(Weapon weapon) {
        if(weapons.contains(weapon)){
            return weapon.damage();
        } else {
            return 0;
        }
    }
    
}
