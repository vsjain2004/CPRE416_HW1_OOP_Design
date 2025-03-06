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

    @Override
    protected int attack(Weapon weapon) {
        if(weapons.contains(weapon)){
            return weapon.damage();
        } else {
            return 0;
        }
    }
    
}
