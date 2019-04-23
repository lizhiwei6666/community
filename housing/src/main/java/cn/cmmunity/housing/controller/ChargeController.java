package cn.cmmunity.housing.controller;

import cn.cmmunity.beans.Charge;
import cn.cmmunity.beans.Housing;
import cn.cmmunity.beans.RespBean;
import cn.cmmunity.housing.service.ChargeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/charge")
public class ChargeController {
    @Autowired
    ChargeService chargeService;

    @RequestMapping(value = "/addCharge",method = RequestMethod.POST)
    @ApiOperation(value = "新增缴费方法",httpMethod ="POST",
            protocols = "HTTP", notes = "新增成功返回200状态码,新增失败返回500状态码")
    public Object addCharge(Charge charge){
        if(chargeService.addCharge(charge)>0){
            return RespBean.ok("添加成功！");
        }else{
            return RespBean.error("添加失败！");
        }
    }
    @RequestMapping(value = "/updateCharge",method = RequestMethod.PUT)
    @ApiOperation(value = "修改缴费方法",httpMethod ="PUT",
            protocols = "HTTP", notes = "修改成功返回200状态码,修改失败返回500状态码")
    public Object updateHousing(Charge charge){
        if(chargeService.updateCharge(charge)>0){
            return RespBean.ok("修改成功！");
        }else{
            return RespBean.error("修改失败！");
        }
    }
    @RequestMapping(value = "/delCharge/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除缴费方法",httpMethod ="DELETE",
            protocols = "HTTP", notes = "删除成功返回200状态码,删除失败返回500状态码")
    public Object delHousing(@PathVariable Integer id){
        if(chargeService.delCharge(id)>0){
            return RespBean.ok("删除成功！");
        }else{
            return RespBean.error("删除失败！");
        }
    }
    @RequestMapping(value = "/getCharge",method = RequestMethod.GET)
    @ApiOperation(value = "查询缴费分页方法",httpMethod = "GET",produces = "HTTP",notes = "查询成功返回集合")
    public Map<String,Object> getChargePage(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                                            @RequestParam(value = "pageSize",defaultValue = "20")Integer pageSize,
                                            @RequestParam(value = "name",required = false)String name,
                                            @RequestParam(value = "housingId",required = false)Integer housingId,
                                            @RequestParam(value = "paymentType",required = false)Integer paymentType,
                                            @RequestParam(value = "paymentStatus",required = false)Integer paymentStatus){

        Map<String,Object> parm=new HashMap<>();
        parm.put("name",name);
        parm.put("housingId",housingId);
        parm.put("paymentType",paymentType);
        parm.put("paymentStatus",paymentStatus);
        PageHelper.startPage(pageIndex,pageSize);
        List<Charge> list=chargeService.getChargePage(parm);
        PageInfo<Charge> pageInfo=new PageInfo<Charge>(list);
        Map<String,Object> map=new HashMap<>();
        map.put("pageInfo",pageInfo);
        return map;
    }
}
