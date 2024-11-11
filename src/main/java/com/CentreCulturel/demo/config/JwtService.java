package com.CentreCulturel.demo.config;

import java.security.Key;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class JwtService {
	private static final String SECRET_KEY="G6LEBwzWLxRubD32KNNzAgPEE5ZsBRYN77Alrqf6eusDQy52yEtOmRtMfD1rBugn";
	public String extarctuserEmail(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getSubject);
	}
	public String generatetoken(UserDetails userdetails) {
		return generatetoken(new HashMap<>(),userdetails);
		
	}
	// create a token
	public String generatetoken(Map<String,Object> extraclaims,
			                    UserDetails userdetails) {
									return Jwts.builder()
											.subject(userdetails.getUsername())
											.issuedAt(new Date(System.currentTimeMillis()) )
											.expiration(new Date(System.currentTimeMillis()+1000*60*24))
											.signWith(getSignInKey(), Jwts.SIG.HS256)
											.claims(extraclaims)
											.compact();
											
	}
	public boolean istockenvalid(String token,UserDetails userdetails) {
		String username=extarctuserEmail(token);
		return(username.equals(userdetails.getUsername()) && !istockenexpired(token));
		
	}
	  private boolean istockenexpired(String token) {
		// TODO Auto-generated method stub
		  return extractExpiration(token).before(new Date());
	}
	private Date extractExpiration(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims ::getExpiration);
	}
	public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	private Claims extractAllClaims(String token){
	    return Jwts
	            .parser()
	            .verifyWith(getSignInKey())
	            .build()
	            .parseSignedClaims(token)
	            .getPayload();
	}
	
	 private SecretKey getSignInKey() {
	        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
	        return Keys.hmacShaKeyFor(keyBytes);
	    }

}
