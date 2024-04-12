package com.edu.xmu.rag.controller.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserVo {
    @NotBlank(message = "用户名不能为空")
    String name;
    @NotBlank(message = "密码不能为空")
//    @Password(message = "密码长度为6，且至少包含大写字母，小写字母，数字和特殊符号")
    String password;

}
