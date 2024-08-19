package com.urcarcher.be.swimming.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.urcarcher.be.swimming.entity.ExchangeInfoEntity;

public interface ExchangeRepository extends JpaRepository<ExchangeInfoEntity, Long> {

}