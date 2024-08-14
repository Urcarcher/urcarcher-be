package com.urcarcher.be.syc98syc.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.querydsl.core.support.QueryMixin.Role;
import com.urcarcher.be.blkwntr.auth.MemberRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="T_MEMBER")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberTest implements UserDetails {
	private static final long serialVersionUID = 1L;
	private static final String ROLE_PREFIX = "ROLE_"; 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String memberId;
	private String password;
	
	private String name;
	private String email;
	private String dateOfBirth;
	private String gender;
	private String nationality;
	private String passportNumber;
	private String phoneNumber;
	
	private String locationConsent;
	private String informationConsent;
	private String matchingConsent;
	
	private Integer point;
	
	@CreationTimestamp
	private Timestamp registrationDate;
	
	@Enumerated(EnumType.STRING)
	private MemberRole role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> simpleGrantedAuthority = new ArrayList<>();
		simpleGrantedAuthority.add(new SimpleGrantedAuthority(ROLE_PREFIX + role.name()));
		return simpleGrantedAuthority;
	}

	@Override
	public String getUsername() {
		return memberId;
	}
	
	@Override
    public String getPassword() {
        return password;
    }
 
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
 
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
 
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
 
    @Override
    public boolean isEnabled() {
        return true;
    }
}
