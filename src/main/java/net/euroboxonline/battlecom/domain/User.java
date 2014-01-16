/**
 * 
 */
package net.euroboxonline.battlecom.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import net.euroboxonline.battlecom.utils.EncryptionHelper;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * @author Draw
 * @version $Revision: 1.4 $ $Date: 2013-10-08 14:08:52 $
 *
 */
@Entity
public class User implements Serializable
{

    /**
     * 
     */
    private static final long serialVersionUID = -349036429807493027L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size( max = 36 )
    private String uniqueId;

    @NotNull
    @Size( max = 50 )
    private String name;

    @NotNull
    @Size( max = 100 )
    private String email;

    @NotNull
    @Size( max = 80 )
    private String encryptedPassword;

    @NotNull
    @Size( max = 10 )
    private String salt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
//    @Type( type = "org.joda.time.contrib.hibernate.PersistentDateTime" )
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
//    @Type( type = "org.joda.time.contrib.hibernate.PersistentDateTime" )
    private Date updatedAt;
    
    @Version
    @Column(name = "version")
    private Integer version;

    /**
     * @return the id
     */
    public final Long getId()
    {
        return id;
    }

    /**
     * @param id the id to set
     */
    public final void setId( Long id )
    {
        this.id = id;
    }

    /**
     * @return the unique_id
     */
    public final String getUniqueId()
    {
        return uniqueId;
    }

    /**
     * @param unique_id the unique_id to set
     */
    public final void setUniqueId( String uniqueId )
    {
        this.uniqueId = uniqueId;
    }

    /**
     * @return the name
     */
    public final String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public final void setName( String name )
    {
        this.name = name;
    }

    /**
     * @return the email
     */
    public final String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public final void setEmail( String email )
    {
        this.email = email;
    }

    /**
     * @return the encryptedPassword
     */
    public final String getEncryptedPassword()
    {
        return encryptedPassword;
    }

    /**
     * @param encryptedPassword the encryptedPassword to set
     */
    public final void setEncryptedPassword( String encryptedPassword )
    {
        this.encryptedPassword = encryptedPassword;
    }

    /**
     * @return the salt
     */
    public final String getSalt()
    {
        return salt;
    }

    /**
     * @param salt the salt to set
     */
    public final void setSalt( String salt )
    {
        this.salt = salt;
    }

    /**
     * @return the createdAt
     */
    public final Date getCreatedAt()
    {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public final void setCreatedAt( Date createdAt )
    {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public final Date getUpdatedAt()
    {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public final void setUpdatedAt( Date updatedAt )
    {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the version
     */
    public final Integer getVersion()
    {
        return version;
    }

    /**
     * @param version the version to set
     */
    public final void setVersion( Integer version )
    {
        this.version = version;
    }
    
    public final void setPassword( String password )
    {
        EncryptionHelper.encryptPassword( this, password );
    }
    
}
