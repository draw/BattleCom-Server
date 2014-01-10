package net.euroboxonline.battlecom;

public class Location
{

    private final long id;
    
    private double latitude = 51.069175;    //51.07224    51.06611
    private double longitude = -0.864745;    //-0.87317    -0.85632

    public Location( long id, double latitude, double longitude )
    {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public long getId()
    {
        return id;
    }
    
    /**
     * @return the latitude
     */
    public final double getLatitude()
    {
        return latitude;
    }

    
    /**
     * @return the longitude
     */
    public final double getLongitude()
    {
        return longitude;
    }

}
