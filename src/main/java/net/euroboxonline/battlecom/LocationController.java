package net.euroboxonline.battlecom;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

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
        return new Location( counter.incrementAndGet(), 51.069175, -0.864745 );
    }

    @RequestMapping("/zone")
    public @ResponseBody Zone getZone( @RequestParam(value="name", required=false, defaultValue="World") String name)
    {
        List<Location> coordinates = new ArrayList<Location>();
        
        coordinates.add( new Location( counter.incrementAndGet(), 51.07224, -0.87317 ) );
        coordinates.add( new Location( counter.incrementAndGet(), 51.07224, -0.85632 ) );
        coordinates.add( new Location( counter.incrementAndGet(), 51.06611, -0.85632 ) );
        coordinates.add( new Location( counter.incrementAndGet(), 51.06611, -0.87317 ) );
        coordinates.add( new Location( counter.incrementAndGet(), 51.07224, -0.87317 ) );

        
        return new Zone( counter.incrementAndGet(), "Game Zone", coordinates );
    }
}
