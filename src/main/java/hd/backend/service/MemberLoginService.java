package hd.backend.service;

import hd.backend.domain.MemberLogin;

public interface MemberLoginService {
    int check(String email,String pwd);
    MemberLogin getLogin(String email);
}
