/**
 * 
 */
package net.euroboxonline.battlecom.rest;

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
    public @ResponseBody String register( @RequestParam( value="name", required=true ) String name, @RequestParam( value="email", required=true ) String email, @RequestParam( value="password", required=true ) String password )
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
                sb.append( "\",\"updated_at\": " );
                if ( user.getUpdatedAt() != null )
                {
                    sb.append( "\"" );
                    sb.append( user.getUpdatedAt() );
                    sb.append( "\"" );
                }
                else
                {
                    sb.append( user.getUpdatedAt() );
                }
                sb.append( "}}" );
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

    @RequestMapping("/login")
    public @ResponseBody String login( @RequestParam( value="email", required=true ) String email, @RequestParam( value="password", required=true ) String password )
    {
        User user = null;
        StringBuffer sb = new StringBuffer();

        user = this.userService.getUserByEmailAndPassword( email, password );
        
        if ( user != null )
        {
            sb.append( "{\"tag\": \"login\",\"success\": 1,\"error\": 0,\"uid\": \"" );
            sb.append( user.getUniqueId() );
            sb.append( "\",\"user\": {\"name\": \"" );
            sb.append( user.getName() );
            sb.append( "\",\"email\": \"" );
            sb.append( user.getEmail() );
            sb.append( "\",\"created_at\": \"" );
            sb.append( user.getCreatedAt() );
            sb.append( "\",\"updated_at\": " );
            if ( user.getUpdatedAt() != null )
            {
                sb.append( "\"" );
                sb.append( user.getUpdatedAt() );
                sb.append( "\"" );
            }
            else
            {
                sb.append( user.getUpdatedAt() );
            }
            sb.append( "}}" );
        }
        else
        {
            sb.append( "{\"tag\": \"login\",\"success\": 0,\"error\": 1,\"error_msg\": \"Incorrect email or password!\"}" );
        }
        
        return sb.toString();
    }

    @RequestMapping("/changepassword")
    public @ResponseBody String changePassword( @RequestParam( value="email", required=true ) String email, @RequestParam( value="oldPassword", required=true ) String oldPassword, @RequestParam( value="newPassword", required=true ) String newPassword )
    {
        User user = null;
        StringBuffer sb = new StringBuffer();

        user = this.userService.getUserByEmailAndPassword( email, oldPassword );
        
        if ( user != null )
        {
            try
            {
                user.setPassword( newPassword );
                this.userService.save( user );
                
                sb.append( "{\"tag\": \"changePassword\",\"success\": 1,\"error\": 0,\"uid\": \"" );
                sb.append( user.getUniqueId() );
                sb.append( "\",\"user\": {\"name\": \"" );
                sb.append( user.getName() );
                sb.append( "\",\"email\": \"" );
                sb.append( user.getEmail() );
                sb.append( "\",\"created_at\": \"" );
                sb.append( user.getCreatedAt() );
                sb.append( "\",\"updated_at\": " );
                if ( user.getUpdatedAt() != null )
                {
                    sb.append( "\"" );
                    sb.append( user.getUpdatedAt() );
                    sb.append( "\"" );
                }
                else
                {
                    sb.append( user.getUpdatedAt() );
                }
                sb.append( "}}" );
            }
            catch ( Exception e )
            {
                e.printStackTrace();
                sb.append( "{\"tag\": \"changePassword\",\"success\": 0,\"error\": 1,\"error_msg\": \"Error occured in Changing Password\"}" );
            }
        }
        else
        {
            sb.append( "{\"tag\": \"changePassword\",\"success\": 0,\"error\": 1,\"error_msg\": \"Incorrect email or password!\"}" );
        }

        return sb.toString();
    }

    @RequestMapping("/forgotpassword")
    public @ResponseBody String forgotPassword( @RequestParam( value="email", required=true ) String email )
    {
        User user = null;
        StringBuffer sb = new StringBuffer();
        
        user = this.userService.getUserByEmail( email );
        
        if ( user != null )
        {
            sb.append( "{\"tag\": \"forgotPassword\",\"success\": 0,\"error\": 1,\"error_msg\": \"Not Yet Implemented\"}" );
        }
        else
        {
            sb.append( "{\"tag\": \"forgotPassword\",\"success\": 0,\"error\": 1,\"error_msg\": \"No User Found.\"}" );
        }

        return sb.toString();
    }

    @RequestMapping("/resetpassword")
    public @ResponseBody String resetPassword( @RequestParam( value="email", required=true ) String email, @RequestParam( value="newPassword", required=true ) String newPassword, @RequestParam( value="authCode", required=true ) String authCode )
    {
        User user = null;
        StringBuffer sb = new StringBuffer();

        user = this.userService.getUserByEmail( email );
        
        if ( user != null )
        {
            sb.append( "{\"tag\": \"resetPassword\",\"success\": 0,\"error\": 1,\"error_msg\": \"Not Yet Implemented\"}" );
        }
        else
        {
            sb.append( "{\"tag\": \"forgotPassword\",\"success\": 0,\"error\": 1,\"error_msg\": \"No User Found.\"}" );
        }

        return sb.toString();
    }

}
