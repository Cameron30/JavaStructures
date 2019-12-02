/**
 * The abstract class Weapon describes items that can be
 * used offensively in combat.  Weapons carry information
 * about the damage they can deal, as well as their durability.
 * If a weapon's durability reaches zero, it breaks.
 * 
 * This class defines the abstract method polish() which a sub-class
 * can implement in order to improve various stats of the weapon.
 * 
 * @author Nicholas
 * @version 2016-09-22
 *
 */
public abstract class Weapon extends Item
{
    /**
     * The rate that the weapon's modifiers can change at
     * any one time.
     */
    public static final double MODIFIER_CHANGE_RATE = 0.05;
    
    /**
     * The base amount of damage able to be dealt by this weapon.
     */
    private final double baseDamage;
    
    /**
     * Added to the baseDamage to get the weapon's total damage.
     */
    protected double damageModifier;
    
    /**
     * The durability of the weapon, should be a value 
     * between 0.0 and 1.0.
     */
    private final double baseDurability;
    
    /**
     * The durability modifier of the weapon, should be a 
     * value between 0.0 and 1.0. This modifier is added 
     * to the baseDurability to get the weapon's durability.
     */
    protected double durabilityModifier;
       
    /**
     * "Polishing" the weapon should increase its stat modifiers
     * by varying amounts, depending on what type the weapon is.
     * Each time polish() is called on an instance of Weapon,
     * stat modifiers should increase or decrease by 
     * MODIFIER_CHANGE_RATE.  No more, no less.
     */
    public abstract void polish();
    
    /**
     * Creates new weapon, damage and durability
     * modifiers are initialized to zero.
     * 
     * @param name The name of the weapon.
     * @param baseDamage The weapon's base damage value.
     * @param baseDurability The weapon's base durability value.
     * @param value The value of the weapon.
     * @param weight The weight of the weapon.
     */
    public Weapon(String name, double baseDamage,
        double baseDurability, int value, double weight)
    {
        super(name, value, weight);
        
        this.baseDamage = baseDamage;
        this.damageModifier = 0;
        this.baseDurability = baseDurability;
        this.durabilityModifier = 0;
    }
    
    /**
     * @see Item#use()
     * 
     * "Using" a Weapon lowers its effective durability by
     * Weapon.MODIFIER_CHANGE_RATE.  If the effective durability
     * of the Weapon hits or drops below 0, the Weapon will "break".
     * If the Weapon "breaks", the method should output this information
     * to the player, otherwise a String describing the use and damage
     * dealt is returned.
     * 
     * @return The text describing what happened when using the Weapon.
     */
    public String use()
    {
        String result;
        
        // Is the item usable?
        if (getDurability() > 0)
        {
            // Yes
            durabilityModifier -= MODIFIER_CHANGE_RATE;

            result = String.format("You use the %s, dealing %2.2f"
                    + " points of damage.", getName(), getDamage());
            
            // Did the object break?
            if (getDurability() <= 0)
            {
                // Yes
                result += String.format("\nThe %s breaks.", getName());
            }            
        }
        else
        {
            // The item is not useful
            result = String.format("You can't use the %s, it is broken.",
                    getName());
        }
        
        return result;
    }
   
    /**
     * Base Damage
     * 
     * @return the baseDamage
     */
    public double getBaseDamage()
    {
        return baseDamage;
    }
    
    /**
     * Effective damage
     * 
     * @return the effective damage
     */
    public double getDamage()
    {
        double effectiveDamage = baseDamage + damageModifier;
        
        return (effectiveDamage <= 0) ? 0 : effectiveDamage;
    }

    /**
     * Damage modifier
     * 
     * @return the damageModifier
     */
    public double getDamageModifier()
    {
        return damageModifier;
    }    
    
    /**
     * Base durability
     * 
     * @return the baseDurability
     */
    public double getBaseDurability()
    {
        return baseDurability;
    }

    /**
     * Return the effective durability
     * 
     * @return the durability
     */
    public double getDurability()
    {
        double modifiedDurability = baseDurability + durabilityModifier;
        
        return (modifiedDurability <= 0) ? 0 : modifiedDurability;
    }    
    
    /**
     * Durability Modifier
     * 
     * @return the durabilityModifier
     */
    public double getDurabilityModifier()
    {
        return durabilityModifier;
    }

    /**
     * Set the damage modifier
     * 
     * @param damageModifier the damageModifier to set
     */
    public void setDamageModifier(double damageModifier)
    {
        this.damageModifier = damageModifier;
    }

    /**
     * Set the durability modifier
     * 
     * @param durabilityModifier the durabilityModifier to set
     */
    public void setDurabilityModifier(double durabilityModifier)
    {
        this.durabilityModifier = durabilityModifier;
    }
    
    /**
     * Describe the weapon
     * 
     * @return String describing the weapon
     * @see Item#toString()
     */
    @Override
    public String toString()
    {
        return String.format("%s, Damage: %.2f, Durability: %.2f%%",
                super.toString(), getDamage(), getDurability() * 100);
    }
}
