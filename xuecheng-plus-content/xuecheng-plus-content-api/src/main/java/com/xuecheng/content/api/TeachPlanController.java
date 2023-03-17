package com.xuecheng.content.api;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.service.TeachPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
 @Api(value = "课程计划编辑接口",tags = "课程计划编辑接口")
 @RestController
public class TeachPlanController {

     @Resource
     TeachPlanService teachPlanService;

     @ApiOperation("查询课程计划树形结构")
     @ApiImplicitParam(value = "courseId", name = "课程Id", required = true, dataType = "Long", paramType = "path")
     @GetMapping("/teachPlan/{courseId}/tree-nodes")
     public List<TeachplanDto> getTreeNodes(@PathVariable Long courseId) {
         return teachPlanService.findTeachplayTree(courseId);
     }

     @ApiOperation("课程计划创建或修改")
     @PostMapping("/teachplan")
     public void saveTeachplan( @RequestBody SaveTeachplanDto teachplan){
           teachPlanService.saveTeachplan(teachplan);
     }
 }