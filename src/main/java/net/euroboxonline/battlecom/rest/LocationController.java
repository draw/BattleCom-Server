package net.euroboxonline.battlecom.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import net.euroboxonline.battlecom.beans.Location;
import net.euroboxonline.battlecom.beans.Zone;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LocationController
{

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/location")
    public @ResponseBody Location greeting( @RequestParam(value="name", required=false, defaultValue="World") String name)
    {
        // return new Location( counter.incrementAndGet(), 51.069175, -0.864745 );
        return new Location( counter.incrementAndGet(), 50.846431, -1.165538 );
    }

    @RequestMapping("/zone")
    public @ResponseBody Zone getZone( @RequestParam(value="name", required=false, defaultValue="gameZone") String name)
    {
        List<Location> coordinates = new ArrayList<Location>();
        
//        coordinates.add( new Location( counter.incrementAndGet(), 51.07224, -0.87317 ) );
//        coordinates.add( new Location( counter.incrementAndGet(), 51.07224, -0.85632 ) );
//        coordinates.add( new Location( counter.incrementAndGet(), 51.06611, -0.85632 ) );
//        coordinates.add( new Location( counter.incrementAndGet(), 51.06611, -0.87317 ) );
//        coordinates.add( new Location( counter.incrementAndGet(), 51.07224, -0.87317 ) );

        if ( name.equals( "gameZone" ) )
        {
            coordinates.add( new Location( counter.incrementAndGet(), 50.8524500,  -1.1664605 ) );     // Length: 0.249 km (0.155 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8501606,  -1.1663532 ) );     // Length: 0.416 km (0.259 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8477084,  -1.1709023 ) );     // Length: 0.143 km (0.089 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8477626,  -1.1730051 ) );     // Length: 0.208 km (0.129 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8485755,  -1.1758590 ) );     // Length: 0.1 km (0.062 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8478846,  -1.1768246 ) );     // Length: 0.254 km (0.158 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8459353,  -1.1749551 ) );     // Length: 0.063 km (0.039 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8454459,  -1.1744857 ) );     // Length: 0.068 km (0.042 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8448700,  -1.1741289 ) );     // Length: 0.064 km (0.04 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8443230,  -1.1738259 ) );     // Length: 0.077 km (0.048 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8436523,  -1.1735523 ) );     // Length: 0.088 km (0.055 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8428665,  -1.1734208 ) );     // Length: 0.119 km (0.074 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8417977,  -1.1733350 ) );     // Length: 0.043 km (0.027 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8414065,  -1.1732653 ) );     // Length: 0.044 km (0.027 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8410559,  -1.1729541 ) );     // Length: 0.064 km (0.04 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8405884,  -1.1724016 ) );     // Length: 0.057 km (0.036 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8401988,  -1.1718544 ) );     // Length: 0.063 km (0.039 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8399888,  -1.1710203 ) );     // Length: 0.072 km (0.044 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8401497,  -1.1700252 ) );     // Length: 0.135 km (0.084 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8402378,  -1.1681020 ) );     // Length: 0.166 km (0.103 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8408628,  -1.1659482 ) );     // Length: 0.176 km (0.109 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8413421,  -1.1635584 ) );     // Length: 0.056 km (0.034 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8416521,  -1.1629334 ) );     // Length: 0.187 km (0.116 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8433085,  -1.1633465 ) );     // Length: 0.042 km (0.026 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8436574,  -1.1630809 ) );     // Length: 0.135 km (0.084 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8444212,  -1.1615708 ) );     // Length: 0.099 km (0.062 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8448396,  -1.1603183 ) );     // Length: 0.156 km (0.097 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8445076,  -1.1581483 ) );     // Length: 0.062 km (0.038 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8444365,  -1.1572444 ) );     // Length: 0.237 km (0.147 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8464552,  -1.1584353 ) );     // Length: 0.191 km (0.119 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8481420,  -1.1578560 ) );     // Length: 0.237 km (0.147 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8482910,  -1.1612356 ) );     // Length: 0.157 km (0.097 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8496932,  -1.1610746 ) );     // Length: 0.033 km (0.02 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8497541,  -1.1615360 ) );     // Length: 0.187 km (0.116 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8514340,  -1.1612356 ) );     // Length: 0.383 km (0.238 mi)
            coordinates.add( new Location( counter.incrementAndGet(), 50.8524500,  -1.1664605 ) );     // Length: 0.249 km (0.155 mi)
        }
        else if ( name.equals(  "safeZone" ) )
        {
            coordinates.add( new Location( counter.incrementAndGet(), 50.8514069,  -1.1610854  ) ); 
            coordinates.add( new Location( counter.incrementAndGet(), 50.8497338,  -1.1612999  ) ); 
            coordinates.add( new Location( counter.incrementAndGet(), 50.8496458,  -1.1603880  ) ); 
            coordinates.add( new Location( counter.incrementAndGet(), 50.8512240,  -1.1602378  ) ); 
            coordinates.add( new Location( counter.incrementAndGet(), 50.8514069,  -1.1610854  ) ); 
        }
        else if ( name.equals(  "respawn" ) )
        {
            coordinates.add( new Location( counter.incrementAndGet(), 50.8486229, -1.1675481 ) );
            coordinates.add( new Location( counter.incrementAndGet(), 50.8485696, -1.1675669 ) );
            coordinates.add( new Location( counter.incrementAndGet(), 50.8485874, -1.1676528 ) );
            coordinates.add( new Location( counter.incrementAndGet(), 50.8484917, -1.1677024 ) );
            coordinates.add( new Location( counter.incrementAndGet(), 50.8484409, -1.1674918 ) );
            coordinates.add( new Location( counter.incrementAndGet(), 50.8485552, -1.1674342 ) );
            coordinates.add( new Location( counter.incrementAndGet(), 50.8485679, -1.1674958 ) );
            coordinates.add( new Location( counter.incrementAndGet(), 50.8486094, -1.1674798 ) );
            coordinates.add( new Location( counter.incrementAndGet(), 50.8486229, -1.1675481 ) );
        }

        return new Zone( counter.incrementAndGet(), "Game Zone", coordinates );
    }
}
