package com.urcarcher.be.jjjh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.urcarcher.be.jjjh.dto.StoreCategoryDTO;
import com.urcarcher.be.jjjh.dto.StoreDTO;
import com.urcarcher.be.jjjh.dto.StoreWithCountDTO;
import com.urcarcher.be.jjjh.entity.StoreEntity;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, String> {

	//test_card , test_payment 테이블로 테스트
	 @Query(value = "SELECT s.category_code, s.category_name, COUNT(*) AS usage_count " +
             "FROM test_payment p " +
             "JOIN store s ON p.store_id = s.store_id " +
             "JOIN test_card c ON p.card_id = c.card_id " +
             "WHERE c.member_id = :memberId " +
             "AND p.payment_date BETWEEN NOW() - INTERVAL 1 MONTH AND NOW() " +
             "GROUP BY s.category_code, s.category_name " +
             "ORDER BY usage_count DESC", 
     nativeQuery = true)
	 List<Object[]> findMostUsedCategoriesByMemberId(@Param("memberId") String memberId);	
	 
	 //상위 3개 카테고리 정보 
	 @Query(value = "SELECT s.category_code, s.category_name, COUNT(*) AS usage_count " +
             "FROM test_payment p " +
             "JOIN store s ON p.store_id = s.store_id " +
             "JOIN test_card c ON p.card_id = c.card_id " +
             "WHERE c.member_id = :memberId " +
             "AND p.payment_date BETWEEN NOW() - INTERVAL 1 MONTH AND NOW() " +
             "GROUP BY s.category_code, s.category_name " +
             "ORDER BY usage_count DESC, "
             + "    s.category_name ASC " +
             "LIMIT 3",
     nativeQuery = true)
	 List<Object[]> findTopCategoriesByMemberId(@Param("memberId") String memberId);
	 
	 //전체 회원의 한 달간 결제 내역 중 총 결제 건수가 많은 가맹점 정보
	  @Query(value = "SELECT " +
              "s.store_id, " +
              "s.store_name, " +
              "s.store_addr, " +
              "s.store_road_addr, " +
              "s.store_phone, " +
              "s.store_url, " +
              "s.store_x, " +
              "s.store_y, " +
              "s.category_code, " +
              "s.category_name, " +
              "COUNT(p.payment_id) AS usage_count " +
              "FROM test_payment p " +
              "JOIN store s ON p.store_id = s.store_id " +
              "JOIN test_card c ON p.card_id = c.card_id " +
              "WHERE c.member_id != :memberId " +  // 로그인한 회원의 결제 내역 제외
              "GROUP BY s.store_id, s.store_name, s.store_addr, s.store_road_addr, " +
              "s.store_phone, s.store_url, s.store_x, s.store_y, " +
              "s.category_code, s.category_name " +
              "ORDER BY usage_count DESC", 
      nativeQuery = true)
	  List<Object[]> findMostUsedStoresExcludingMember(@Param("memberId") String memberId);

}
