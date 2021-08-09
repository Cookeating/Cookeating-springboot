package com.tistory.cookeat.cookeating.service.user;

import com.tistory.cookeat.cookeating.domain.user.User;
import com.tistory.cookeat.cookeating.domain.user.UserRepository;
import com.tistory.cookeat.cookeating.dto.LoginDTO;
import com.tistory.cookeat.cookeating.dto.SignUpDTO;
import com.tistory.cookeat.cookeating.exception.DuplicateLoginIdException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User login(LoginDTO loginDTO) throws Exception {
        log.info("User : {}",loginDTO.toEntity().toString());
        Optional<User> optionalUser = userRepository.findByLoginId(loginDTO.getLoginId()).stream().findFirst();
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (loginDTO.getPassword().equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Transactional
    public User signUp(SignUpDTO signUpDTO) throws Exception {
        validateDuplicateLoginId(signUpDTO.getLoginId());
        log.info("User : {}",signUpDTO.toEntity().toString());
        return userRepository.save(signUpDTO.toEntity());
    }

    private void validateDuplicateLoginId(String loginId) throws Exception {
        if(!userRepository.findByLoginId(loginId).isEmpty()){
            throw new DuplicateLoginIdException();
        }
    }
}
