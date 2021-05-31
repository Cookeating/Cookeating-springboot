package com.tistory.cookeat.cookeating.service.user;

import com.tistory.cookeat.cookeating.domain.user.User;
import com.tistory.cookeat.cookeating.domain.user.UserRepository;
import com.tistory.cookeat.cookeating.dto.SignUpDTO;
import com.tistory.cookeat.cookeating.exception.DuplicateLoginIdException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(SignUpDTO signUpDTO) throws Exception {
        validateDuplicateLoginId(signUpDTO.getLoginId());
        userRepository.save(signUpDTO.toEntity());
    }

    private void validateDuplicateLoginId(String loginId) throws Exception {
        if(!userRepository.findByLoginId(loginId).isEmpty()){
            throw new DuplicateLoginIdException();
        }
    }
}
