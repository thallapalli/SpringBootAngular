package com.cts.osp.kt.osp.entity;

/*******************************************************************************
 * 2017, this is the user entity class ,
 * this class implements users details of the spring security framework
 *******************************************************************************/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
/**
 * Description of User.
 * 
 * @author kamal berriga
 */
@Entity
@Table(name="AppUser")
@Scope("session")
public  class AppUser implements UserDetails{
	public static enum Role{ USER }
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id ;
	/**
	 * Description of the property email.
	 */
	@Column(unique = true)
	private String username ;
	/**
	 * Description of the property password.
	 */
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password ;
	/**
	 * Description of the property role , to grant authority to the user .
	 */
    private String  role;
    /**
	 * Description of the property full name.
	 */
    private String fullName;
    @Temporal(TemporalType.DATE)
	@Column(name="DOB")
    private Date dob;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    
    @Column(name="EMAIL",unique = true)
    private String email;
    @Column(name="CONTACT_NUM")
    private Long contactNum;
    

    public AppUser(){
    	
    }
    
    public AppUser(String username,String password,String fullName,Date dob,String firstName,String lastName,String email,Long contactNum){
    	this.username=username;
    	this.password= password;
    	this.fullName=fullName;
    	this.dob=dob;
    	this.firstName=firstName;
    	this.lastName=lastName;
    	this.email=email;
    	this.contactNum=contactNum;
    }
	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(role));
		return authorities;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role +
				 ",]";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName=fullName;
	}

	public Long getId() {
		return id;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the contactNum
	 */
	public Long getContactNum() {
		return contactNum;
	}

	/**
	 * @param contactNum the contactNum to set
	 */
	public void setContactNum(Long contactNum) {
		this.contactNum = contactNum;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
