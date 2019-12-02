import java.awt.Color;
import java.awt.Graphics;

/**
 * station definition class
 * @author cameron / justin
 * @version 10262016
 */
public class StationDefinition extends StatisticsAbstract {

    private String stationId;

    private String name;

    private String city;

    private double nlat;

    private double elon;

    private DataSet dataSet = new DataSet();

    /**
     * constructor
     * @param stationId variable id
     * @param name of variable
     * @param city recorded
     * @param nlat location
     * @param elon location
     */
    public StationDefinition(String stationId, String name, String city, 
            double nlat, double elon)
    {
        this.stationId = stationId;
        this.name = name;
        this.city = city;
        this.nlat = nlat;
        this.elon = elon;
    }

    /**
     * adds day
     * @param day to add
     */
    protected void addDay(DataDay day)
    {
        //use the addDay method of dataSet
        dataSet.addDay(day);
    }

    /**
     * @return station id
     */
    public String getStationId() 
    {
        return stationId;
    }

    /**
     * @return name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * @return city
     */
    public String getCity() 
    {
        return city;
    }

    /**
     * @return latitude
     */
    public double getNlat() 
    {
        return nlat;
    }

    /**
     * @return longitude
     */
    public double getElon() 
    {
        return elon;
    }

    /** 
     * @param statisticId name of stat
     * @param k null
     * @return corresponding number
     */
    public Sample getStatisticAverage(String statisticId, KeyConstraints k)
    {
        return dataSet.getStatisticAverage(statisticId, k);
    }

    /**
     * @param statisticId name of stat
     * @param k null
     * @return day with lowest stat
     */
    public DataDay getStatisticMinDay(String statisticId, KeyConstraints k)
    {
        return dataSet.getStatisticMinDay(statisticId, k);
    }

    /**
     * @param statisticId name of stat
     * @param k null
     * @return day with highest stat
     */
    public DataDay getStatisticMaxDay(String statisticId, KeyConstraints k)
    {
        return dataSet.getStatisticMaxDay(statisticId, k);
    }

    /**
     * @return formatted string
     */
    public String toString()
    {
        //describe this object
        return String.format("%s %s %s %f %f", stationId, name, city, 
                nlat, elon); 
    }

    /**
     * @return structured string
     */
    public String getStructure()
    {
        //attempt to show the structure using tabs
        return String.format("%s %s %s \n\t%s", this.stationId, 
                this.city, this.name, dataSet.getStructure());
    }
    
    /**
     * draw the graphics
     * @param g2 2dgraphics object
     */
    public void draw(Graphics g2)
    {
        //draws a circle at the position of the station in the county
        g2.setColor(Color.BLACK);
        g2.fillOval((int) (elon * StateFrame.LONGITUDE_SCALE + 
                StateFrame.getOffsetX()), (int) (nlat * 
                        StateFrame.LATITUDE_SCALE + StateFrame.getOffsetY()),
                StateFrame.STATION_RADIUS, StateFrame.STATION_RADIUS);
    }
    
}
