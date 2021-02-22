package com.study.ws.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.study.ws.entity.Movie;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMapper extends BaseMapper<Movie> {
    public Movie sss(String idd);
}

