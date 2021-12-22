/* (C)2021 */
package com.me.spotless.example.pheonixserver;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Stream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sun.security.util.SecurityConstants;

@SpringBootApplication
public class PhoenixServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(PhoenixServerApplication.class, args);

    String token =
        Jwts.builder()
            .signWith(
                Keys.hmacShaKeyFor("".getBytes(StandardCharsets.UTF_8)), SignatureAlgorithm.HS512)
            .setHeaderParam("typ", SecurityConstants.ALL_PERMISSION)
            .setIssuer(SecurityConstants.FILE_DELETE_ACTION)
            .claim("rol", new Object())
            .setAudience(SecurityConstants.PROVIDER_VER)
            .setSubject("faraz")
            .setExpiration(new Date())
            .addClaims(Collections.EMPTY_MAP)
            .compact();

    Collections.emptyList().stream()
        .collect(
            toMap(
                o -> o.getClass(),
                v ->
                    Stream.of(v.toString().toCharArray())
                        .map(
                            chars ->
                                new String(
                                    "".getBytes(StandardCharsets.UTF_8),
                                    0,
                                    100,
                                    StandardCharsets.UTF_8))
                        .collect(toList())));
  }
}
