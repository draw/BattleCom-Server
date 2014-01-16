/**
 * 
 */
package net.euroboxonline.battlecom.rest;

import net.euroboxonline.battlecom.beans.Location;
import net.euroboxonline.battlecom.domain.User;
import net.euroboxonline.battlecom.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
@Controller
@RequestMapping( "/user" )
public class UserController
{
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public @ResponseBody String register( @RequestParam( value="name", required=true ) String name, @RequestParam( value="email", required=true ) String email, @RequestParam( value="name", required=true ) String password )
    {
        User user = null;
        StringBuffer sb = new StringBuffer();
        
        if ( !this.userService.isUserExisted( email ) )
        {
            try
            {
                user = new User();
                
                user.setName( name );
                user.setEmail( email );
                user.setPassword( password );
                
                user = this.userService.save( user );
                
                sb.append( "{\"tag\": \"register\",\"success\": 1,\"error\": 0,\"uid\": \"" );
                sb.append( user.getUniqueId() );
                sb.append( "\",\"user\": {\"name\": \"" );
                sb.append( user.getName() );
                sb.append( "\",\"email\": \"" );
                sb.append( user.getEmail() );
                sb.append( "\",\"created_at\": \"" );
                sb.append( user.getCreatedAt() );
                sb.append( "\",\"updated_at\": null}}" );
            }
            catch ( Exception e )
            {
                e.printStackTrace();

                sb.append( "{\"tag\": \"register\",\"success\": 0,\"error\": 1,\"error_msg\": \"Error occured in Registartion\"}" );
            }
        }
        else
        {
            sb.append( "{\"tag\": \"register\",\"success\": 0,\"error\": 2,\"error_msg\": \"User already existed\"}" );
        }
        
        return sb.toString();
    }

//    @RequestMapping("/login")
//    public @ResponseBody Location login( @RequestParam(value="name", required=false, defaultValue="World") String name)
//    {
//        // return new Location( counter.incrementAndGet(), 51.069175, -0.864745 );
//        return new Location( counter.incrementAndGet(), 50.846431, -1.165538 );
//    }

}
