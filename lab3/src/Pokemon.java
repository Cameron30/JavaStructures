
/**
 * 
 * @author Cameron
 * @version 09092016
 */
public class Pokemon 
{
    //initializes all of the pokemon variables
    private static int number;
    private String name;
    private String type1;
    private String type2;
    private int total;
    private int hp;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private int generation;
    private boolean legendary;
    

    /**
     * 
     * @param poke String of the pokemon stats
     * assigns all the stats proper variables
     */
    public Pokemon(String poke) 
    {
        //parses the string for code
        String[] separate = poke.split(",");

        //assigns variables
        number = Integer.parseInt(separate[0]);
        name = separate[1];
        type1 = separate[2];
        type2 = separate[3];
        total = Integer.parseInt(separate[4]);
        hp = Integer.parseInt(separate[5]);
        attack = Integer.parseInt(separate[6]);
        defense = Integer.parseInt(separate[7]);
        spAttack = Integer.parseInt(separate[8]);
        spDefense = Integer.parseInt(separate[9]);
        speed = Integer.parseInt(separate[10]);
        generation = Integer.parseInt(separate[11]);
        legendary = Boolean.parseBoolean(separate[12]);  
    }

    /**
     * 
     * @return boolean for first gen legendary
     */
    public boolean isFirstGenLegendary() 
    {
        //if gen 1 and legendary then true
        if (generation == 1 && legendary) 
        {
            return true;
        }
        
        //false if not correct pokemon
        return false;
    }
    
    /**
     * 
     * @return boolean for third gen psychic
     */
    public boolean isThirdGenPsychic() 
    {
        //if psychic then asks if gen 3
        if (this.getType1().equals("Psychic") | 
                this.getType2().equals("Psychic")) 
        {
            if (this.getGeneration() == 3) 
            {
                return true;
            }    
        }
        
        //false if not correct pokemon
        return false;
    }
    
    /**
     * 
     * @return boolean for legendary water water type
     */
    public boolean isLegendaryWater() 
    {
        //if legendary then if water type then true
        if (legendary) 
        {
            if (this.getType1().equals("Water") || 
                    this.getType2().equals("Water")) 
            {
                return true;
            }
           
        }
        
        //false if not correct
        return false;
    }
    
    /**
     * concatenates a proper string
     * @return string of the pokemon
     */
    public String toString() 
    {
        //easy way to print legendary
        String legend = "";
        if (legendary) 
        {
            legend = "Legendary";
        }
        
        //creates string with inserted variables
        String ret = String.format("%-25s %-12s %-12s Generation: %-6d%s", name,
                type1, type2, generation, legend);
        return ret;
    }

    /**
     * 
     * @return number
     */
    public static int getNumber()
    {
        return number;
    }

    /**
     * 
     * @return number
     */
    public String getName() 
    {
        return name;
    }

    /**
     * 
     * @return first type
     */
    public String getType1()
    {
        return type1;
    }

    /**
     * 
     * @return second type
     */
    public String getType2() 
    {
        return type2;
    }

    /**
     * 
     * @return total
     */
    public int getTotal() 
    {
        return total;
    }

    /**
     * 
     * @return HP
     */
    public int getHp() 
    {
        return hp;
    }

    /**
     * 
     * @return attack
     */
    public int getAttack() 
    {
        return attack;
    }

    /**
     * 
     * @return defense
     */
    public int getDefense() 
    {
        return defense;
    }

    /**
     * 
     * @return special attack
     */
    public int getSpAttack()
    {
        return spAttack;
    }

    /**
     * 
     * @return special defense
     */
    public int getSpDefense()
    {
        return spDefense;
    }

    /**
     * 
     * @return speed
     */
    public int getSpeed() 
    {
        return speed;
    }

    /**
     * 
     * @return generation
     */
    public int getGeneration() 
    {
        return generation;
    }

    /**
     * 
     * @return boolean for legendary
     */
    public boolean isLegendary() 
    {
        return legendary;
    }
}
