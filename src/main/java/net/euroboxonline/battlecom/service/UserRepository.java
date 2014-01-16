/**
 * 
 */
package net.euroboxonline.battlecom.service;

import net.euroboxonline.battlecom.domain.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
public interface UserRepository extends Repository<User, Long>
{
    public Page<User> findAll( Pageable pageable );

    public User findByUniqueId( String uniqueId );
    
    public User findByEmailAndEncryptedPassword( String email, String encryptedPassword );
    
    public User findByEmail( String email );
    
    public User save( User user );
}
