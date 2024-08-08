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


import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
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
		return "입력작업";
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
	
	
}
