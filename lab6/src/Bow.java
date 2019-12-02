/**
 * 
 * @author Cameron
 * @version 09292016
 * Class for the Bow weapon
 */
public class Bow extends Weapon
{
    /**
     * 
     * @param baseDamage base damage
     * @param baseDurability base durability
     * @param value for the bow
     * @param weight for the bow
     */
    public Bow(double baseDamage, double baseDurability, int value, double 
            weight)
    {
        super("bow", baseDamage, baseDurability, value, weight);
    }

    /**
     * polishes the bow by adding to durability
     */
    @Override
    public void polish() 
    {
        if (durabilityModifier <= .95)
        {
            durabilityModifier += Weapon.MODIFIER_CHANGE_RATE;
        }
    }

}
