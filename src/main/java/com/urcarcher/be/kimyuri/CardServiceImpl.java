package com.urcarcher.be.kimyuri;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.urcarcher.be.blkwntr.entity.MemberEntity;
import com.urcarcher.be.blkwntr.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    final CardRepository cardRepo;
    final MemberRepository memberRepo;
    final CardTypeRepository cardTypeRepo;

//    @Override
//    public void create(CardDTO dto) {
//        CardEntity entity = dtoToEntity(dto);
//        cardRepo.save(entity);
//    }
    
    @Override
    public void create(CardDTO dto) {
        MemberEntity member = memberRepo.findById(dto.getMemberId()).orElse(null);
        CardTypeEntity cardType = cardTypeRepo.findById(dto.getCardTypeId()).orElse(null);
        CardEntity entity = dtoToEntity(dto, member, cardType);
        cardRepo.save(entity);
    }
    

    @Override
    public List<CardDTO> readAll() {
        List<CardEntity> entityList = (List<CardEntity>) cardRepo.findAll();

        List<CardDTO> dtoList = entityList.stream().map(entity -> entityToDTO(entity))
                .collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public CardDTO readById(Long cardId) {
        CardEntity entity = cardRepo.findById(cardId).orElse(null);
        return entity != null ? entityToDTO(entity) : null;
    }

    @Override
    public void update(CardDTO dto) {
        cardRepo.findById(dto.getCardId()).ifPresent(card -> {
            card.setCardNumber(dto.getCardNumber());
            card.setCvvCode(dto.getCvvCode());
            card.setCardBalance(dto.getCardBalance());
            card.setCardStatus(dto.getCardStatus());
            card.setIssueDate(dto.getIssueDate());
            card.setExpirationDate(dto.getExpirationDate());
            card.setCardPassword(dto.getCardPassword());
            card.setCardPickup(dto.getCardPickup());
            card.setPickupDate(dto.getPickupDate());
            card.setCardAccount(dto.getCardAccount());
            card.setPaymentBank(dto.getPaymentBank());
            card.setPaymentDate(dto.getPaymentDate());
            card.setTransportation(dto.getTransportation());

            cardRepo.save(card);
        });
    }

    @Override
    public void delete(Long cardId) {
        cardRepo.deleteById(cardId);
    }
}
