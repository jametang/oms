package com.zjjc.oms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserLogin {
    @Getter
    private String username;
    private String email;
    private String password;
    private Timestamp create_time;

}
