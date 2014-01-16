/**
 * 
 */
package net.euroboxonline.battlecom.beans;

import java.util.List;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
public class Zone
{

    private final long id;
    
    private String description;

    private List<Location> coordinates = null;
    
    public Zone( long id, String description, List<Location> coordinates )
    {
        this.id = id;
        this.description = description;
        this.coordinates = coordinates;
    }

    public long getId()
    {
        return this.id;
    }
    
    public String getDescription()
    {
        return this.description;
    }
    
    public List<Location> getCoordinates()
    {
        return this.coordinates;
    }
    
}
