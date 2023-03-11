package com.xuecheng.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


import javax.annotation.Resource;
import java.util.List;
import java.util.Queue;

@SpringBootTest
public class CourseBaseMapperTests {

    @Resource
    CourseBaseMapper courseBaseMapper;

    @Test
    public  PageResult<CourseBase> testCourseBaseMapper(){
        CourseBase courseBase = courseBaseMapper.selectById(1);
        System.out.println(courseBase);

        LambdaQueryWrapper<CourseBase> wrapper = new LambdaQueryWrapper<>();

        QueryCourseParamsDto dto = new QueryCourseParamsDto();

        wrapper.like(StringUtils.isNotEmpty(dto.getCourseName()),CourseBase::getName,dto.getCourseName());
        wrapper.eq(StringUtils.isNotEmpty(dto.getAuditStatus()),CourseBase::getAuditStatus,dto.getAuditStatus());
        wrapper.eq(StringUtils.isNotEmpty(dto.getPublishStatus()),CourseBase::getAuditStatus,dto.getPublishStatus());

        Page<CourseBase> page = new Page<>(PageParams.DEFAULT_PAGE_CURRENT, PageParams.DEFAULT_PAGE_SIZE);

        Page<CourseBase> basePage = courseBaseMapper.selectPage(page, wrapper);

        List<CourseBase> records = basePage.getRecords();
        long total = basePage.getTotal();

        return new PageResult<CourseBase>(records,total,PageParams.DEFAULT_PAGE_CURRENT, PageParams.DEFAULT_PAGE_SIZE);

    }
}
