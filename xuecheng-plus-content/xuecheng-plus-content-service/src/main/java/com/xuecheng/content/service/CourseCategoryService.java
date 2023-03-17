package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseCategoryService {
     List<CourseCategoryTreeDto> queryTreeNodes(String id);
}
