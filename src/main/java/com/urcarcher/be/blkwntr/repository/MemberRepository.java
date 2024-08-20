<<<<<<< HEAD
package com.urcarcher.be.blkwntr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urcarcher.be.blkwntr.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

}
=======
package com.urcarcher.be.blkwntr.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urcarcher.be.blkwntr.auth.MemberProvider;
import com.urcarcher.be.blkwntr.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {
	Optional<Member> findByEmailAndProvider(String email, MemberProvider provider);
}
>>>>>>> e0976b33df46727ffa61c1363548f8ec5366ba5f
