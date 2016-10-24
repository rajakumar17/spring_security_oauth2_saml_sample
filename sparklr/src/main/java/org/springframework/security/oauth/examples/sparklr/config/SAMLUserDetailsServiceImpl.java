package org.springframework.security.oauth.examples.sparklr.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.saml.SAMLCredential;
import org.springframework.security.saml.userdetails.SAMLUserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thirur on 10/11/2016.
 */
@Service
public class SAMLUserDetailsServiceImpl implements SAMLUserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(SAMLUserDetailsServiceImpl.class);

    @Override
    public Object loadUserBySAML(SAMLCredential credential) throws UsernameNotFoundException {
        String userId = credential.getNameID().getValue();
        logger.info("Logged in user :" + userId);

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
        authorities.add(authority);

        return new User("marissa", "koala", authorities);
    }
}
