package com.urcarcher.be.blkwntr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urcarcher.be.blkwntr.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, String> {

}
