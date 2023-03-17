package com.xuecheng.content.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.base.model.R;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.EditCourseDto;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseBaseInfoService {

   PageResult<CourseBase> queryCourseBaseList(PageParams pageParams , QueryCourseParamsDto dto);

    CourseBaseInfoDto addCourseBase(Long companyId, AddCourseDto dto);

    CourseBaseInfoDto getCourseBaseInfoDto(Long courseId);

    CourseBaseInfoDto modifyCourseBase(EditCourseDto editCourseDto);
}
