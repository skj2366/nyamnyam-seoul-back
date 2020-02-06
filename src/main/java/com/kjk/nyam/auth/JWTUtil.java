package com.kjk.nyam.auth;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.kjk.nyam.vo.CustomerInfoVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTUtil {

	private static final Date ISSUE_DATE;
	private static final Date EXPIRE_DATE;
	private static final String SALT = "nyamnyam";
	static {
		Calendar calendar = Calendar.getInstance();
		ISSUE_DATE = calendar.getTime();
		calendar.add(Calendar.DATE, 30);
		EXPIRE_DATE = calendar.getTime();
	}
	
	public String makeJWT(CustomerInfoVO cui) {
		String jwt = JWT.create().withIssuer(cui.getCuiId())
				.withIssuedAt(ISSUE_DATE)
				.withExpiresAt(EXPIRE_DATE)
				.sign(Algorithm.HMAC256(SALT));
		return jwt;
	}
	
	public void checkJWT(String tokken, CustomerInfoVO cui) {
		JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SALT))
				.withIssuer(cui.getCuiId()).build();
		DecodedJWT decode = verifier.verify(tokken);
	}
	
	public static void main(String[] args) {
		JWTUtil jwtu = new JWTUtil();
		CustomerInfoVO cui = new CustomerInfoVO();
		cui.setCuiId("skj2366");
		System.out.println(jwtu.makeJWT(cui));
	}
}
