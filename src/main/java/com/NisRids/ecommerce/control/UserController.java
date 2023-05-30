package com.NisRids.ecommerce.control;

import com.NisRids.ecommerce.Service.UserService;
import com.NisRids.ecommerce.SignUpResponseDto;
import com.NisRids.ecommerce.dto.SignupDto;
import com.NisRids.ecommerce.exceptions.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signup")
    public SignUpResponseDto Signup(@RequestBody SignupDto signupDto) throws CustomException {
        return userService.signUp(signupDto);

    }


}
