/**
 * 
 */
package net.euroboxonline.battlecom.service;

import net.euroboxonline.battlecom.domain.User;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
public interface UserService
{
    public User getUser( String uniqueId );
    
    public User getUserByEmailAndPassword( String email, String password );
    
    public User getUserByEmail( String email );

    public boolean isUserExisted( String email );
    
    public User save( User user );
}
