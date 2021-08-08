package com.qymlxin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private int id;
    private int userId;
    private String title;
    private String description;
    private String content;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss",iso = DateTimeFormat.ISO.DATE_TIME)
    private String created;
    private String status;
}
