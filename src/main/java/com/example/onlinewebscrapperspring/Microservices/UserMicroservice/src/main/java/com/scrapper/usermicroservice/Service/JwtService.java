package com.scrapper.usermicroservice.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Service
public class JwtService {

    public static final String SECRET = "8f4369454fb3d5686667fd2beb9bad9fd52f10181cdab4fd62908bd60430e763af4f87f565e041e2b27cc27aef540c646083e38f780abb17e5a09a8a19956b2b028364a6052a087610f537101adbddf9ac4046b9a330dc9d0754224005eddfde8828a44a007bb7bbfa04e7226e50565d41f496c5ba4a18e64e94b771b1d0e29a2b8de6aeb3eab2ea121494bfd897019af4a17b43ceb4967edb28a88fe9b06bf7ecf459dffe52e2f46a5b7d7a7a3e164b273b024e0bc32d9b52c54ea2ccf3ab9040b701c89f9ba385dbff4eac2d492e7405cf5d79257e10726faf9d38977d9268bde1c09197c85625fbb119a038c1d29c1d7b293512b100b47e50df39bc4c6770"
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<String, Object>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
