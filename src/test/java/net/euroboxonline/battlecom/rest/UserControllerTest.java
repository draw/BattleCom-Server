/**
 * 
 */
package net.euroboxonline.battlecom.rest;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import net.euroboxonline.battlecom.Application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
@RunWith( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration(classes = Application.class )
@WebAppConfiguration
//@ActiveProfiles( "scratch" )
public class UserControllerTest
{

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp()
        throws Exception
    {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
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
     * Test method for {@link net.euroboxonline.battlecom.rest.UserController#register(java.lang.String, java.lang.String, java.lang.String)}.
     */
    @Test
    public void testRegister()
       throws Exception
    {
        this.mvc.perform( get( "/user/register" ).param( "name", "Fred Bloggs" ).param( "email", "draw@iquo.co.uk" ).param( "password", "password" ) ).andExpect( status().isOk() );
        
        // .andExpect( content().string("Bath") );
    }

}
