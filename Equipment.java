package CPRE416_HW1_OOP_Design;

import java.util.Map;

public interface Equipment {

    public EqType getType();
    public Map<Core, Integer> getRequirements();
    public Map<Attribute, Integer> getBonuses();
    public String getEffects();
    public String getSpecialAbilities();
}
