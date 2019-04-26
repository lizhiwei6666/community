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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/housing")
public class HousingController {
    @Autowired
    private HousingService housingService;

    @RequestMapping(value = "/addHousing",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "新增小区方法",httpMethod ="POST",
            protocols = "HTTP", notes = "新增成功返回200状态码,新增失败返回500状态码")
    public Object addHousing(Housing housing){
        if(housingService.addHousing(housing)>0){
            return "<script>alert('添加成功！');location.href='/housing/getHousing';</script>";
        }else{
            return "<script>alert('添加失败！');location.href='/housing/addhousing';</script>";
        }
    }
    @RequestMapping(value = "/updateHousing",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "修改小区方法",httpMethod ="POST",
            protocols = "HTTP", notes = "修改成功返回200状态码,修改失败返回500状态码")
    public Object updateHousing(Housing housing){
        if(housingService.updateHousing(housing)>0){
            return "<script>alert('修改成功！');location.href='/housing/getHousing';</script>";
        }else{
            return "<script>alert('修改失败！');location.href='/housing/getHousing';</script>";
        }
    }
    @RequestMapping(value = "/delHousing/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    @ApiOperation(value = "删除小区方法",httpMethod ="DELETE",
            protocols = "HTTP", notes = "删除成功返回200状态码,删除失败返回500状态码")
    public Object delHousing(@PathVariable Integer id){
        Map<String,String> map=new HashMap<>();
        int result=housingService.del(id);
        if(result>0){
            map.put("result","true");
        }else if(result==-1){
            map.put("result","false");
        }else{
            map.put("result","error");
        }
        return map;
    }
    @RequestMapping(value = "/getHousing")
    @ApiOperation(value = "查询小区方法",httpMethod ="GET",
            protocols = "HTTP", notes = "")
    public String getHousing(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                             @RequestParam(value = "pageSize",defaultValue = "2")Integer pageSize, Model model){
        int count=housingService.getHousingCount();
        Map<String,Object> parm=new HashMap<>();
        parm.put("pageIndex",pageIndex);
        PageHelper.startPage(pageIndex,pageSize);
        List<Housing> list=housingService.getHousingPage(parm);
        PageInfo<Housing> pageInfo=new PageInfo<Housing>(list);
        Map<String,Object> map=new HashMap<>();
        map.put("pageInfo",pageInfo);
       /* System.out.println(pageInfo.getNavigateLastPage());*/
       /* map.put("list",list);*/

        model.addAttribute("pageInfo",pageInfo);
        return "housinglist";
    }
    @RequestMapping(value = "/getHousing/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "查询小区方法",httpMethod ="GET",
            protocols = "HTTP", notes = "根据id查询小区方法")
    public String delHousing(@PathVariable Integer id,Model model){
        Housing housing=housingService.getHousingById(id);
        model.addAttribute("housing",housing);
        return "updatehousing";
    }

}
