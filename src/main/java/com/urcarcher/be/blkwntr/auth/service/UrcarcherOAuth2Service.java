package com.urcarcher.be.blkwntr.auth.service;

import java.util.Map;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.stereotype.Service;

import com.urcarcher.be.blkwntr.auth.AuthorizedUser;
import com.urcarcher.be.blkwntr.auth.dto.OAuth2Profile;
import com.urcarcher.be.blkwntr.auth.dto.TokenDTO;
import com.urcarcher.be.blkwntr.entity.Member;
import com.urcarcher.be.blkwntr.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UrcarcherOAuth2Service extends DefaultOAuth2UserService {
	
	private final MemberRepository memberRepository;

	@Override
	public AuthorizedUser loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		Map<String, Object> oAuth2UserAttributes = super.loadUser(userRequest).getAttributes();
		
		String registrationId = userRequest.getClientRegistration().getRegistrationId();
		String userNameAttributeName = userRequest
											.getClientRegistration()
											.getProviderDetails()
											.getUserInfoEndpoint()
											.getUserNameAttributeName();
		
		OAuth2Profile oAuth2Profile = OAuth2Profile.of(registrationId, oAuth2UserAttributes, userNameAttributeName);
		Member member = memberRepository
							.findByEmailAndProvider(oAuth2Profile.getEmail(), oAuth2Profile.getProvider())
							.orElseGet(oAuth2Profile::toMember);
		
		memberRepository.save(member);
		
		return AuthorizedUser.builder()
				.member(member)
				.attributes(oAuth2UserAttributes)
				.attributeName(userNameAttributeName)
				.build();
	}
}