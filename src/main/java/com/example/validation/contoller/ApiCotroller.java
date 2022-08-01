package com.example.validation.contoller;


import com.example.validation.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class ApiCotroller {
    @PostMapping("/user")
    public ResponseEntity user(@Valid @RequestBody User user , BindingResult bindingResult)
    {
        StringBuilder sb = new StringBuilder();

        if(bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(ObjectError -> {
                FieldError field = (FieldError) ObjectError;
                String message = ObjectError.getDefaultMessage();
                System.out.println("filed : " + field.getField());
                System.out.println("message" + message);

                sb.append("filed : " + field.getField());
                sb.append("message" + message);
            });

        }
        System.out.println(user);
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        //@Valid , @Email
        //User{name='ghdrlfehd', age=10, email='Asdasdasd', phoneNumber='null'}
    //전화번호 형태, 이메일 형태가 아님 , 기존에 우리가 생각하는 형태들이 아님.
        //그래서 validation @어노테이션이 필요한것임
    }

//    {
//        "name" : "ghdrlfehd",
//            "age" : 10,
//            "email" : "Asdasdasd",
//            "phoneNumbeer": "01011111111"
//    }
}
