/**
 * 
 * @author Cameron
 * @version 09292016
 * Sword class
 */
public class Sword extends Weapon
{

    /**
     * 
     * @param baseDamage base damage
     * @param baseDurability base durability
     * @param value for the sword
     * @param weight for the sword
     */
    public Sword(double baseDamage, double baseDurability, 
            int value, double weight)
    {
        super("sword", baseDamage, baseDurability, value, weight);
    }

    /**
     * damage modifier is changed
     */
    @Override
    public void polish() 
    {
        if (damageModifier < .25 * super.getBaseDamage())
        {
            damageModifier += Weapon.MODIFIER_CHANGE_RATE;
        }
    }
}
