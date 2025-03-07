package CPRE416_HW1_OOP_Design;

import java.util.Map;
import java.util.Random;

public class ArcaneStaff extends Weapon {
 
    @Override
    public EqType getType() {
        return WepType.Staff_Magic;
    }

    @Override
    public Map<Core, Integer> getRequirements() {
        return Map.of(
            Core.INT, 12
        );
    }

    @Override
    public Map<Attribute, Integer> getBonuses() {
        return Map.of(
            Core.INT, 1
        );
    }

    @Override
    public String getEffects() {
        return "1d8 Melee";
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
      return "Arcane Staff";
  }
}
