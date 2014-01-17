/**
 * 
 */
package net.euroboxonline.battlecom.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.google.common.base.Strings;

import net.euroboxonline.battlecom.domain.User;
import net.euroboxonline.battlecom.utils.EncryptionHelper;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
@Service( "userService" )
@Transactional
public class UserServiceImpl implements UserService
{

    UserRepository userRepository;
    
    @Autowired
    public UserServiceImpl( UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }
    
    
    /* (non-Javadoc)
     * @see net.euroboxonline.battlecom.service.UserService#getUser(java.lang.String)
     */
    @Override
    public User getUser( String uniqueId )
    {
        return this.userRepository.findByUniqueId( uniqueId );
    }

    /* (non-Javadoc)
     * @see net.euroboxonline.battlecom.service.UserService#getUserByEmailAndPassword(java.lang.String, java.lang.String)
     */
    @Override
    public User getUserByEmailAndPassword( String email, String password )
    {
        User user = null;
        
        user = this.userRepository.findByEmail( email );
        
        if ( user != null )
        {
            if ( !EncryptionHelper.isPasswordCorrect( user, password ) )
            {
                user = null;
            }
        }
        
        return user;
    }
    
    /* (non-Javadoc)
     * @see net.euroboxonline.battlecom.service.UserService#getUserByEmail(java.lang.String)
     */
    @Override
    public User getUserByEmail( String email )
    {
        return this.userRepository.findByEmail( email );
    }


    /* (non-Javadoc)
     * @see net.euroboxonline.battlecom.service.UserService#isUserExisted(java.lang.String)
     */
    @Override
    public boolean isUserExisted( String email )
    {
        Assert.notNull( email, "" );
        
        User user = this.userRepository.findByEmail( email );
        
        if ( user == null )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /* (non-Javadoc)
     * @see net.euroboxonline.battlecom.service.UserService#save(net.euroboxonline.battlecom.domain.User)
     */
    @Override
    public User save( User user )
    {
        Assert.notNull( user, "User must not be null to save." );
        
        if ( Strings.isNullOrEmpty( user.getUniqueId() ) )
        {
            user.setUniqueId( UUID.randomUUID().toString() );
        }
        
        if ( user.getCreatedAt() == null )
        {
            user.setCreatedAt( new java.util.Date() );
        }
        else
        {
            user.setUpdatedAt( new java.util.Date() );
        }
        
        return this.userRepository.save( user );
    }

}
