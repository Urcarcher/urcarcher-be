package com.urcarcher.be.syc98syc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urcarcher.be.blkwntr.entity.Member;
import com.urcarcher.be.syc98syc.entity.MemberTest;

public interface SignupRepository extends JpaRepository<MemberTest, Long>{

}
