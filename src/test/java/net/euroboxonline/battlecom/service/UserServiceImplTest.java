/**
 * 
 */
package net.euroboxonline.battlecom.service;

import static org.junit.Assert.*;
import net.euroboxonline.battlecom.Application;
import net.euroboxonline.battlecom.domain.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration( classes = Application.class )
public class UserServiceImplTest
{
    @Autowired
    UserService userService;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp()
        throws Exception
    {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown()
        throws Exception
    {
    }

    /**
     * Test method for {@link net.euroboxonline.battlecom.service.UserServiceImpl#getUser(java.lang.String)}.
     */
    @Test
    public void testGetUser()
    {
        // fail( "Not yet implemented" );
    }

    /**
     * Test method for {@link net.euroboxonline.battlecom.service.UserServiceImpl#getUserByEmailAndPassword(java.lang.String, java.lang.String)}.
     */
    @Test
    public void testGetUserByEmailAndPassword()
    {
        // fail( "Not yet implemented" );
    }

    /**
     * Test method for {@link net.euroboxonline.battlecom.service.UserServiceImpl#isUserExisted(java.lang.String)}.
     */
    @Test
    public void testIsUserExisted()
    {
        // fail( "Not yet implemented" );
    }

    /**
     * Test method for {@link net.euroboxonline.battlecom.service.UserServiceImpl#save(net.euroboxonline.battlecom.domain.User)}.
     */
    @Test
    public void testSave()
    {
        User user = new User();
        
        user.setEmail( "draw@iquo.co.uk" );
        user.setName( "Fred Bloggs" );
        user.setPassword( "password" );
        
        this.userService.save( user );
    }

}
