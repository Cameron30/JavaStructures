//import org.junit.Test;
//import org.junit.Assert;
import java.io.IOException;

/**
 * 
 * @author cameron ray / justin huebner
 * @version 20160919
 * Test for the constructor
 */
public class DataMonthTest 
{

    /*
    private double windSpeedAvg = 11.567;
    private double windSpeedMin = 56.987;
    private double windSpeedMax = 9.007;
    private double solarRadiationAvg = 6.876;
    private double solarRadiationMax = 5.345;
    private double solarRadiationMin = 6.444;
    private double solarRadiationTotal = 9.456;
    */
    
    
    /**
     * 
     * @throws IOException magic!
     * tests getters and setters
     */
    public void gettersSettersTests() throws IOException
    {
        /*
        DataMonth june14 = new DataMonth();
//        System.out.println(june14);
        
        june14.setMonth(3);
        Assert.assertEquals(june14.getMonth(), 3);
    
        june14.setSolarRadiationAverage(solarRadiationAvg);
        june14.setSolarRadiationMax(solarRadiationMax);
        june14.setSolarRadiationMin(solarRadiationMin);
        june14.setSolarRadiationTotal(solarRadiationTotal);
        
        Assert.assertEquals(solarRadiationAvg, 
                june14.getSolarRadiationAverage(), 0);
        Assert.assertEquals(solarRadiationMax, 
                june14.getSolarRadiationMax(), 0);
        Assert.assertEquals(solarRadiationMin, 
                june14.getSolarRadiationMin(), 0);
        Assert.assertEquals(solarRadiationTotal, 
                june14.getSolarRadiationTotal(), 0);
        
        june14.setWindSpeedAverage(windSpeedAvg);
        june14.setWindSpeedMin(windSpeedMin);
        june14.setWindSpeedMax(windSpeedMax);
        
        Assert.assertEquals(windSpeedAvg, june14.getWindSpeedAverage(), 0);
        Assert.assertEquals(windSpeedMax, june14.getWindSpeedMax(), 0);
        Assert.assertEquals(windSpeedMin, june14.getWindSpeedMin(), 0);
        
        june14.setStationID("STATIONID");
        Assert.assertEquals("STATIONID", june14.getStationID());
        
        june14.setYear(1998);
        Assert.assertEquals(1998, june14.getYear());
        */
    }
    
    /**
     * 
     * @throws IOException magic
     * Tests toString
     */
    public void toStringTest() throws IOException
    {
        /*
        DataMonth june14 = new DataMonth("data/june_2014.csv");
        
        Assert.assertEquals(june14.toString(), "2014-06, TISH: Wind = [0.0000,"
                + " 9.3897, 28.5000], Solar Radiation = [13.2000, 22.3431, "
                + "30.5200, 647.9500]");
                */
    }
}
