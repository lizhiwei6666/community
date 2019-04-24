package cn.cmmunity.housing.controller;

import cn.cmmunity.beans.Housing;
import cn.cmmunity.beans.RespBean;
import cn.cmmunity.housing.service.HousingService;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/housing")
public class HousingController {
    @Autowired
    private HousingService housingService;

    @RequestMapping(value = "/addHousing",method = RequestMethod.POST)
    @ApiOperation(value = "新增小区方法",httpMethod ="POST",
            protocols = "HTTP", notes = "新增成功返回200状态码,新增失败返回500状态码")
    public Object addHousing(Housing housing){
        if(housingService.addHousing(housing)>0){
            return RespBean.ok("添加成功！");
        }else{
            return RespBean.error("添加失败！");
        }
    }
    @RequestMapping(value = "/updateHousing",method = RequestMethod.PUT)
    @ApiOperation(value = "修改小区方法",httpMethod ="PUT",
            protocols = "HTTP", notes = "修改成功返回200状态码,修改失败返回500状态码")
    public Object updateHousing(Housing housing){
        if(housingService.updateHousing(housing)>0){
            return RespBean.ok("修改成功！");
        }else{
            return RespBean.error("修改失败！");
        }
    }
    @RequestMapping(value = "/delHousing/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除小区方法",httpMethod ="DELETE",
            protocols = "HTTP", notes = "删除成功返回200状态码,删除失败返回500状态码")
    public Object delHousing(@PathVariable Integer id){
        if(housingService.delHousing(id)>0){
            return RespBean.ok("删除成功！");
        }else{
            return RespBean.error("删除失败！");
        }
    }
    @RequestMapping(value = "/getHousing",method = RequestMethod.GET)
    @ApiOperation(value = "查询小区方法",httpMethod ="GET",
            protocols = "HTTP", notes = "")
    public Map<String,Object> getHousing(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
    @RequestParam(value = "pageSize",defaultValue = "20")Integer pageSize){
        int count=housingService.getHousingCount();
        Map<String,Object> parm=new HashMap<>();
        parm.put("pageIndex",pageIndex);
        PageHelper.startPage(pageIndex,pageSize);
        List<Housing> list=housingService.getHousingPage(parm);
        PageInfo<Housing> pageInfo=new PageInfo<Housing>(list);
        Map<String,Object> map=new HashMap<>();
        map.put("pageInfo",pageInfo);
       /* map.put("list",list);*/
        return map;
    }
   /* @RequestMapping(value = "/getHousing/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "查询小区方法",httpMethod ="GET",
            protocols = "HTTP", notes = "根据id查询小区方法")
    public Object delHousing(@PathVariable Integer id){
        Housing housing=housingService.getHousingById(id);
        return housing;
    }*/

}
