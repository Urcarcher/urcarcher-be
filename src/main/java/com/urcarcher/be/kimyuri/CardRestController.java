package com.urcarcher.be.kimyuri;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urcarcher.be.blkwntr.entity.Member;
import com.urcarcher.be.blkwntr.repository.MemberRepository;
import com.urcarcher.be.syc98syc.signup.dto.MemberDTO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/card")
public class CardRestController {
	
	final CardService cardService;

	
	@GetMapping("/list")
	List<CardDTO> list(){
		return cardService.readAll();
	}
	
	@GetMapping("/get/{cardId}")
	CardDTO read(@PathVariable("cardId") Long cardId) {
		return cardService.readById(cardId);
	}
	
	@PostMapping("/insert")
	String insert(@RequestBody CardDTO dto) {
		cardService.create(dto);
		return "카드 데이터가 성공적으로 저장되었습니다.";
	}
	


	
	@PutMapping("/update")
	String update(@RequestBody CardDTO dto) {
		cardService.update(dto);
		return "수정작업";
	}
	
	@DeleteMapping("/delete/{cardId}")
	String delete(@PathVariable("cardId") Long cardId) {
		cardService.delete(cardId);
		return "삭제작업";
	}
	
	
	// 카드 신청시 회원 기본 정보 불러오기(이름, 휴대전화번호, 주민번호)
	 final MemberRepository memberRepository;

	    @GetMapping("/{memberId}")
	    public MemberDTO getMemberInfo(@PathVariable("memberId") String memberId) {
	        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));
	        return MemberDTO.builder()
	                .memberId(member.getMemberId())
	                .name(member.getName())
	                //.dateOfBirth(member.getDateOfBirth())
	                .phoneNumber(member.getPhoneNumber())
	                .build();
	    }

	
	
}
