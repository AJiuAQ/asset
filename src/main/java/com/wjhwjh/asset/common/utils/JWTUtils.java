package com.wjhwjh.asset.common.utils;

import com.google.common.collect.Maps;
import com.wjhwjh.asset.common.web.Servlets;
import com.wjhwjh.asset.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

/**
 * @author wjhwjh
 * @description a
 * Created in 9:17 2019/8/26
 */
@Component
public class JWTUtils {
    private static final long serialVersionUID = -3301605591108950415L;

    static final String CLAIM_KEY_USERNAME = "sub";

    static final String CLAIM_KEY_AUDIENCE = "aud";

    static final String AUDIENCE_UNKNOWN = "unknown";

    static final String AUDIENCE_WEB = "web";

    static final String AUDIENCE_MOBILE = "mobile";

    static final String AUDIENCE_TABLET = "tablet";

    @Value("wjhwjh.com")
    private String secret;

    //有效期
    @Value("2592000")
    private long expiration;

    @Value("Authorization")
    private String authorization;


    public String generateToken(User user, Device device) {
        Map<String, Object> claims = Maps.newHashMap();
        claims.put("username", user.getLoginName());
        claims.put("mobile", user.getMobile());
        return doGenerateToken(claims, user.getId().toString(), generateAudience(device));
    }

    private String doGenerateToken(Map<String, Object> claims, String subject, String audience) {
        final Date createdDate = new Date();
        final Date expirationDate = calculateExpirationDate(createdDate);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setAudience(audience)
                .setIssuedAt(createdDate)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Date calculateExpirationDate(Date createdDate) {
        return new Date(createdDate.getTime() + expiration * 1000);
    }

    private String generateAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device != null) {
            if (device.isNormal()) {
                audience = AUDIENCE_WEB;
            } else if (device.isTablet()) {
                audience = AUDIENCE_TABLET;
            } else if (device.isMobile()) {
                audience = AUDIENCE_MOBILE;
            }
        }
        return audience;
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取当前登录用户id
     *
     * @return 用户id
     */
    public String getUserId() {
        HttpServletRequest request = Servlets.getRequest();
        if (request == null) {
            return null;
        }
        return getUserIdFromToken(request.getHeader(authorization));
    }

    /**
     * 从 token取出id
     *
     * @param token
     * @return
     */
    public String getUserIdFromToken(String token) {
        if (StringUtils.isNoneEmpty(token)) {
            return getClaimFromToken(token, Claims::getSubject);
        }
        return null;
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public Boolean validateToken(String token) {
        try {
            Jwts.parser()
                 .setSigningKey(secret)
                 .parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return !isTokenExpired(token);
    }
}
