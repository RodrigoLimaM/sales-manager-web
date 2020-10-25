package br.com.salesmanagerweb.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;

@Setter
@Getter
public class Customer implements UserDetails {

    private String _id;

    private String name;

    private String email;

    private String password;

    private BigDecimal balance;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this._id.equals("5f959a1534263543d88047ba"))
            return Collections.singletonList(Role.ADMIN);
        else
            return Collections.singletonList(Role.USER);
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
