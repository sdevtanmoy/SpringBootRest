package me.aboullaite.jwt;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import me.aboullaite.model.User;

public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUserId(),
                user.getUserFname(),
                user.getUserLname(),
                user.getPasswd(),
                mapToGrantedAuthorities(user.getRoles()),
                (  "Y".equals(user.getActiveFlag()) ? true : false),
                user.getCreateTime()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority))
                .collect(Collectors.toList());
    }
}
