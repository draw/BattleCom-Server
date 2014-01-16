package net.euroboxonline.battlecom.utils;

import static org.junit.Assert.*;
import net.euroboxonline.battlecom.domain.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EncryptionHelperTest
{

    @Before
    public void setUp()
        throws Exception
    {
    }

    @After
    public void tearDown()
        throws Exception
    {
    }

    @Test
    public void testEncryptPassword()
    {
        User user = new User();
        
        EncryptionHelper.encryptPassword( user, "password" );
        
        assertNotNull( "Make sure that the Salt has been set.", user.getSalt() );
        assertNotNull( "Make sure we have an Encrypted Password", user.getEncryptedPassword() );
        
        System.out.println( user.getSalt() );
        System.out.println( user.getEncryptedPassword() );
    }

    @Test
    public void testIsPasswordCorrect()
    {
        User user = new User();
        
        user.setSalt( "165f7d1b-9" );
        user.setEncryptedPassword( "Bu5G2RAbKtAu6WHQHKnnCTmGcesxNjVmN2QxYi05" );
        
        assertTrue( "", EncryptionHelper.isPasswordCorrect( user, "password" ) );
        
        assertFalse( "", EncryptionHelper.isPasswordCorrect( user, "test" ) );
    }

}
