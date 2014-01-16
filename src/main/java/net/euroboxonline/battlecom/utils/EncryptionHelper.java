/**
 * 
 */
package net.euroboxonline.battlecom.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.util.Assert;

import net.euroboxonline.battlecom.domain.User;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
public class EncryptionHelper
{

    static public User encryptPassword( User user, String password )
    {
        String salt = UUID.randomUUID().toString().substring( 0, 10 );
        String encryptedPassword = null;
        
        Assert.hasText( password, "We must have a valid password to encrypt." );

        encryptedPassword = encryptString( salt, password );

        user.setSalt( salt );
        user.setEncryptedPassword( encryptedPassword );
        
        return user;
    }
    
    static public boolean isPasswordCorrect( User user, String password )
    {
        boolean retVal = false;
        String salt = user.getSalt();
        String encryptedPassword = null;
        
        Assert.hasText( password, "We must have a valid password to check." );

        encryptedPassword = encryptString( salt, password );

        if ( encryptedPassword.equals( user.getEncryptedPassword() ) )
        {
            retVal = true;
        }
        
        return retVal;
    }
    
    static private String encryptString( String salt, String data )
    {
        byte[] binaryData;

        String encryptedString = null;
        MessageDigest md = null;

        try
        {
            md = MessageDigest.getInstance("SHA-1");
        }
        catch( NoSuchAlgorithmException e )
        {
            e.printStackTrace();
        } 

        binaryData = md.digest( ArrayUtils.addAll( data.getBytes(), salt.getBytes() ) );

        encryptedString = Base64.encodeBase64String( ArrayUtils.addAll( binaryData, salt.getBytes() ) );

        return encryptedString;
    }
    
}
