package com.study.ws.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Movie {
    @TableId
    private String movie_id;
    private String detail_id;
    private String movie_name;
    private String sname;
    private String namehash;
    private String movie_type;
    private String movie_url;
    private String collecting_time;

}
