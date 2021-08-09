package com.tistory.cookeat.cookeating.service.user;

import com.tistory.cookeat.cookeating.domain.user.User;
import com.tistory.cookeat.cookeating.domain.user.UserRepository;
import com.tistory.cookeat.cookeating.dto.SignUpDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    void signUp() throws Exception {
        when(userRepository.save(any(User.class)))
                .then(AdditionalAnswers.returnsFirstArg());

        SignUpDTO expect = new SignUpDTO();
        expect.setLoginId("testID");
        expect.setPassword("testPW");

        User actual = userService.signUp(expect);
        assertEquals(expect.getLoginId(), actual.getLoginId());
        assertEquals(expect.getPassword(), actual.getPassword());

    }
}