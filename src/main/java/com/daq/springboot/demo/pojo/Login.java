package com.daq.springboot.demo.pojo;

/**
 * @author
 * @description
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * 实体类
 * @author 程就人生
 *
 */
@Validated
@Data
@SuppressWarnings("all")
public class Login {
    private String userUid;
    //用户名不为空，使用默认提示
    @NotNull
    private String userName;

    //密码进行长度和格式的验证，个性化提示
    @Size(min=6, max=15,message="密码长度必须在 6 ~ 15 字符之间！")
    @Pattern(regexp="^[a-zA-Z0-9|_]+$",message="密码必须由字母、数字、下划线组成！")
    private String userPwd;

    //手机号码也用个性化提示，使用正则表达式进行匹配，非空时不验证
    @Pattern(regexp="^1(3|4|5|7|8)\\d{9}$",message="手机号码格式错误！")
    private String userMobile;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date userBirthday;

    private Byte status;

    private Date updateDate;

    private String updateUser;

    private Date createDate;

    private String createUser;
}