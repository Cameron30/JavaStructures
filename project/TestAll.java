import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author cameron / justin
 * @version 20161116
 */
public class TestAll {

    /**
     * test everything
     * @throws IOException if error occurs
     */
    @Test
    public void testEverything() throws IOException
    {
        //setup for keyconstraints
        KeyConstraints kc = new KeyConstraints();
        kc.add(6, 9);
        Assert.assertEquals(1, kc.get(6), .1);
        
        //setup for datadefinitionlist 
        DataDefinitionList dataList = new DataDefinitionList(
                "Data/DataTranslation.csv");
        DataDay.setDataDefinitionList(dataList);
        String[] str = new String[50];
        
        //simulate a file read, setup for testing DataDay
        str[0] = "2011";
        str[1] = "12";
        str[2] = "31";
        str[3] = "WOOD";
        str[4] = "76.51";
        str[5] = "38.77";
        str[6] = "52.68";
        str[7] = "32.49";
        str[8] = "14.34";
        str[9] = "26.89";
        str[10] = "9.49";
        str[11] = "43.40";
        str[12] = "40.75";
        str[13] = "41.83";
        str[14] = "47.66";
        str[15] = "41.26";
        str[16] = "43.94";
        str[17] = "66.32";
        str[18] = "14.43";
        str[19] = "39.92";
        str[20] = "28.13";
        str[21] = "27.48";
        str[22] = "27.72";
        str[23] = "29.87";
        str[24] = "585.75";
        str[25] = "12.01";
        str[26] = "9";
        str[27] = "25.00";
        str[28] = "15";
        str[29] = "19.44";
        str[30] = "36.89";
        str[31] = "5.99";
        str[32] = "21.72";
        str[33] = "6.59";
        str[34] = "53.55";
        str[35] = "0.00";
        str[36] = "0";
        str[37] = "0.00";
        str[38] = "53.05";
        str[39] = "29.64";
        str[40] = "4.27";
        str[41] = "17.14";
        str[42] = "5.46";
        str[43] = "7.36";
        str[44] = "0.00";
        str[45] = "-996.00";
        str[46] = "30.10";
        
        //set relationships
        DataYear dY = new DataYear();
        DataMonth dM = new DataMonth();
        DataDay dD = new DataDay();
        dY.addDay(dD);
        dM.addDay(dD);
        
        System.out.println(dD.getDate() + dD.getMonth() + dD.getStationID());
        System.out.println(dY.getStatisticAverage("DMAX", kc));
        System.out.println(dM.getStatisticAverage("DMAX", kc));
        
        //new stationdefinitionlist and load data, print structure
        StationDefinitionList statList = new 
                StationDefinitionList("Data/geoinfo.csv");
        statList.loadData("Data/test.csv");
        statList.getStructure();
        
        //test Sample
        Sample nullSamp = new Sample();
        Sample bigSamp = new Sample(99);
        Sample smallSamp = new Sample(1);
        
        //assertions
        Assert.assertEquals(null, nullSamp.getValue());
        Assert.assertFalse(nullSamp.isValid());
        Assert.assertTrue(bigSamp.isValid());
        Assert.assertTrue(bigSamp.isGreaterThan(nullSamp));
        Assert.assertTrue(bigSamp.isGreaterThan(smallSamp));
        Assert.assertFalse(bigSamp.isLessThan(smallSamp));
        Assert.assertFalse(smallSamp.isGreaterThan(bigSamp));
        Assert.assertTrue(smallSamp.isLessThan(bigSamp));
        
        //test datadef
        DataDefinitionList statDef = new 
                DataDefinitionList("data/DataTranslation.csv");
        System.out.println(statDef.getDataInfo("DMAX"));
        
        //final assert
        Assert.assertEquals(37.41666667, statList
                .getStatisticAverage("ACME", "TMAX", null).getValue(), .0001);   
        
    }
}
