package com.liqiang.hrm.web.controller;

import com.liqiang.hrm.client.EsCourseClient;
import com.liqiang.hrm.doc.EsCourse;
import com.liqiang.hrm.domain.Course;
import com.liqiang.hrm.query.CourseQuery;
import com.liqiang.hrm.service.ICourseService;
import com.liqiang.hrm.util.AjaxResult;
import com.liqiang.hrm.util.PageList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    private Logger logger = LoggerFactory.getLogger(CourseController.class);
    @Autowired
    public ICourseService courseService;
    @Autowired
    private EsCourseClient esCourseClient;//远程调用

    /**
    * 保存和修改公用的
    * @param course  传递的实体
    * @return Ajaxresult转换结果
    */
    @RequestMapping(value="/save",method= RequestMethod.POST)
    public AjaxResult save(@RequestBody Course course){
        try {
            //tenantId tenantName userId userName
            // @TODO 以后登录成功都能获取,现在适用holder来模拟
            //course.setTenantId(UserInfoHolder.getTenant().getId());
            //course.setTenantName(UserInfoHolder.getTenant().getCompanyName());
            //course.setUserId(UserInfoHolder.getLoginUser().getId());
            //course.setUserName(UserInfoHolder.getLoginUser().getUsername());
            if(course.getId()!=null){
                courseService.updateById(course);
            }else{
                courseService.insert(course);
            }
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.me().setMessage("保存对象失败！"+e.getMessage());
        }
    }

    /**
    * 删除对象信息
    * @param id
    * @return
    */
    @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
    public AjaxResult delete(@PathVariable("id") Long id){
        try {
            courseService.deleteById(id);

            return AjaxResult.me();
        } catch (Exception e) {
        e.printStackTrace();
            return AjaxResult.me().setMessage("删除对象失败！"+e.getMessage());
        }
    }

    //获取用户
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public Course get(@PathVariable("id")Long id)
    {
        return courseService.selectById(id);
    }


    /**
    * 查看所有
    * @return
    */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<Course> list(){
        return courseService.selectList(null);
    }


    /**
    * 分页查询数据
    * @param query 查询对象
    * @return PageList 分页对象
    */
    @RequestMapping(value = "/json",method = RequestMethod.POST)
    public PageList<Course> json(@RequestBody CourseQuery query)
    {
        //Page<Course> page = new Page<Course>(query.getPage(),query.getRows());
        //    page = courseService.selectPage(page);
        //    return new PageList<Course>(page.getTotal(),page.getRecords());
        return  courseService.selectListPage(query);
    }
    /**
     * 课程上线
     * @param ids 批量上线的课程的id 集合
     */
    @PostMapping("/onLine")
    public AjaxResult online(@RequestBody Long[] ids){
        List<Course> courseList = courseService.getBatchIds(ids);
        //List<Course> courseList = mapper.selectBatchIds(Arrays.asList(ids));
        List<EsCourse> esCourseList = courseList2EsCourse(courseList);
        try {
            courseService.onLine(ids);
            esCourseClient.batchSave(esCourseList);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("online failed!"+e);
            return AjaxResult.me().setSuccess(false)
                    .setMessage("上线失败!"+e.getMessage());
        }
    }
    /**
     * 课程下线
     * @param ids 批量下线的课程的id 集合
     */
    @PostMapping("/offLine")
    public AjaxResult offLine(@RequestBody Long[] ids){
        List<Course> courseList = courseService.getBatchIds(ids);
        List<EsCourse> esCourseList = courseList2EsCourse(courseList);
        try {
            courseService.offLine(ids);
            esCourseClient.batchDel(esCourseList);
            return AjaxResult.me();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("online failed!"+e);
            return AjaxResult.me().setSuccess(false)
                    .setMessage("下线失败!"+e.getMessage());
        }
    }

    private List<EsCourse> courseList2EsCourse(List<Course> courseList) {
        List<EsCourse> result = new ArrayList<>();
        for (Course course : courseList) {
            result.add(course2EsCourse(course));
        }
        return result;
    }

    // @TODO 不同服务,反3Fn设计冗余字段
    // @TODO 相同服务,关联查询
    private EsCourse course2EsCourse(Course course) {
        EsCourse  result = new EsCourse();
        result.setId(course.getId());
        result.setName(course.getName());
        result.setUsers(course.getUsers());
        result.setCourseTypeId(course.getCourseTypeId());
        //type-同库
        if (course.getCourseType() != null)
            result.setCourseTypeName(course.getCourseType().getName());
        //跨服务操作
        result.setGradeId(course.getGrade());
        result.setGradeName(null);
        result.setStatus(course.getStatus());
        result.setTenantId(course.getTenantId());
        result.setTenantName(course.getTenantName());
        result.setUserId(course.getUserId());
        result.setUserName(course.getUserName());
        result.setStartTime(course.getStartTime());
        result.setEndTime(course.getEndTime());
        //Detail
        result.setIntro(null);
        //resource
        result.setResources(null);
        //market
        result.setExpires(null);
        result.setPrice(null);
        result.setPriceOld(null);
        result.setQq(null);
        return result;
    }
}
