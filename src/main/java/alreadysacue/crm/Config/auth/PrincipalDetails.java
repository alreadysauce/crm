package alreadysacue.crm.Config.auth;


import alreadysacue.crm.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

//시큐리티가 login을 낚아채서 로그인을 진행시킴
// 로그인 진행이 완료가 되면 시큐리티 session을 만들어준다. (Security ContextHolder)
// 오브젝트 Authentication 객체
// Authentication -> User 정보
// User오브젝트의 타입 => UserDetails 타입 객체
// 시큐리티가 가지고 있는 세션명령 => Authentication = UserDetails
public class PrincipalDetails implements UserDetails {

    private User user;

    public PrincipalDetails(User user){
        this.user = user;
    }

    //유저의 권한을 리턴
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

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
