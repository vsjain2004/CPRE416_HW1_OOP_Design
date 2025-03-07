package CPRE416_HW1_OOP_Design;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Character {

    protected Map<Core, Integer> coreAttributes;
    protected Map<Core, Integer> modifiers = new HashMap<>();
    protected Map<Attribute, Integer> inFight = new HashMap<>();

    public Character(){
        setCoreAttributes();
        applyClassBonus();
        setCoreModifiers();
    };

    public Map<Core, Integer> getCoreAttributes() {
        return coreAttributes;
    };

    private void setCoreAttributes(){
        Random dice = new Random();
        for (Core att : Core.values()) {
            int v1 = dice.nextInt(1, 7);
            int v2 = dice.nextInt(1, 7);
            int v3 = dice.nextInt(1, 7);
            int atval = 0;
            if(v1 >= v2 && v1 >= v3) {
                atval += v1;
                if(v2 >= v3){
                    atval += v2;
                } else {
                    atval += v3;
                }
            } else if(v2 >= v1 && v2 >= v3) {
                atval += v2;
                if(v1 >= v3){
                    atval += v1;
                } else {
                    atval += v3;
                }
            } else {
                if(v1 >= v2) {
                    atval = v1 + v3;
                } else {
                    atval = v2 + v3;
                }
            }
            coreAttributes.put(att, atval);
        }
    };

    private void setCoreModifiers() {
        for(Core att : coreAttributes.keySet()){
            switch (coreAttributes.get(att)) {
                case 0:
                    modifiers.put(att, -4);
                    break;
                case 1:
                case 2:
                    modifiers.put(att, -3);
                    break;
                case 3:
                case 4:
                    modifiers.put(att, -2);
                    break;
                case 5:
                case 6:
                    modifiers.put(att, -1);
                    break;
                case 7:
                case 8:
                    modifiers.put(att, 0);
                    break;
                case 9:
                case 10:
                    modifiers.put(att, 1);
                    break;
                case 11:
                case 12:
                    modifiers.put(att, 2);
                    break;
                case 13:
                case 14:
                    modifiers.put(att, 3);
                    break;
                case 15:
                case 16:
                    modifiers.put(att, 4);
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

    public Map<Core, Integer> getModifiers(){
        return modifiers;
    }

    protected abstract void applyClassBonus();

    protected abstract int attack(Weapon Weapon);

    /*
     * This is an example of data coupling.
     * Simple Parameter Type: It accepts only a primitive int parameter (the damage amount), 
     * which is the minimal, exact data needed to perform its function.
      */
    public void damage(int damage) {
        int vit = inFight.get(Core.VIT);
        vit = Math.max(vit - damage, 0);
        inFight.replace(Core.VIT, vit);
    }
}