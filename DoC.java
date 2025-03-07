package CPRE416_HW1_OOP_Design;

import java.util.Map;
import java.util.Random;

public class DoC extends Weapon {

    public DoC(){}

    @Override
    public EqType getType() {
        return WepType.Dagger;
    }

    @Override
    public Map<Core, Integer> getRequirements() {
        return Map.of(
            Core.AGI, 10
        );
    }

    @Override
    public Map<Attribute, Integer> getBonuses() {
        return Map.of(
            Core.AGI, 1
        );
    }

    @Override
    public String getEffects() {
        return "1d6 Melee";
    }

    @Override
    public String getSpecialAbilities() {
        return null;
    }

    @Override
    public int damage() {
        return new Random().nextInt(1, 9);
    }

    @Override
    public String getName() {
        return "Dagger of Crescendo";
    }
    
}
