package br.com.gv.api.service;

import br.com.gv.api.controller.request.LoginRequest;
import br.com.gv.api.domain.UserInfo;
import br.com.gv.api.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

@Service
public class UserService {
    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid username or password";
    private static final String TOKEN = "12EGAHZ&$3_Sasa123EV";

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserInfoRepository userInfoRepository;

    public ResponseEntity<String> login(LoginRequest request) {
        UserInfo user = userInfoRepository.findByEmail(request.getEmail());
        boolean hasCorrectPassword = passwordEncoder.matches(request.getPassword(), user.getUserPassword());

        if (!hasCorrectPassword) {
            return new ResponseEntity<>(INVALID_CREDENTIALS_MESSAGE, UNAUTHORIZED);
        }

        return new ResponseEntity<>(TOKEN, OK);
    }
}
