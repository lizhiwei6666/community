package cn.cmmunity.housing.controller;

import cn.cmmunity.beans.*;
import cn.cmmunity.housing.service.ChargeService;
import cn.cmmunity.housing.service.HousingService;
import cn.cmmunity.housing.utils.PoiUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/charge")
public class ChargeController {
    @Autowired
    ChargeService chargeService;
    @Autowired
    HousingService housingService;
    @RequestMapping(value = "/importEmp", method = RequestMethod.POST)
    @ResponseBody
    public Object importEmp(MultipartFile file) {

        return "";
    }

    @RequestMapping(value = "/exportCharge", method = RequestMethod.GET)
    public ResponseEntity<byte[]> exportEmp() {
        return PoiUtils.exportEmp2Excel(chargeService.getChargePage(new HashMap<>()));
    }


    @RequestMapping(value = "/getUserByName",method = RequestMethod.GET)
    @ApiOperation(value = "根据用户名查找用户",httpMethod ="GET",
            protocols = "HTTP", notes = "查找成功返回true状态码,查找失败返回false状态码")
    @ResponseBody
    public Object getUserByName(@RequestParam(value = "name") String name){
        User user=chargeService.getUserByName(name);
        Map<String,String> map=new HashMap<>();
        if(null!=user){
            map.put("result","true");
        }else {
            map.put("result","false");
        }
        return map;
    }


    @RequestMapping(value = "/addCharge",method = RequestMethod.POST)
    @ApiOperation(value = "新增缴费方法",httpMethod ="POST",
            protocols = "HTTP", notes = "新增成功返回200状态码,新增失败返回500状态码")
    @ResponseBody
    public Object addCharge(Charge charge){
        if(chargeService.addCharge(charge)>0){
            return "<script>alert('添加成功！');location.href='/charge/getCharge';</script>";
        }else{
            return "<script>alert('添加失败！');location.href='/charge/addcharge';</script>";
        }
    }
    @RequestMapping(value = "/toUpdateCharge/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "跳转到修改页面查询方法",httpMethod ="GET",
            protocols = "HTTP", notes = "新增成功返回200状态码,新增失败返回500状态码")
    public String toUpdateCharge(@PathVariable Integer id,Model model){
        Charge charge=chargeService.getChargeById(id);
        List<Housing> housingList=housingService.getHousingPage(new HashMap<>());
        List<PaymentType> paymentTypeList=chargeService.getAllPaymentType();
        model.addAttribute("charge",charge);
        model.addAttribute("housingList",housingList);
        model.addAttribute("paymentTypeList",paymentTypeList);
        return "updatecharge";
    }
    @RequestMapping(value = "/toAddCharge",method = RequestMethod.GET)
    @ApiOperation(value = "跳转到添加页面方法",httpMethod ="GET",
            protocols = "HTTP", notes = "新增成功返回200状态码,新增失败返回500状态码")
    public String toAddCharge(Model model){
        List<Housing> housingList=housingService.getHousingPage(new HashMap<>());
        List<PaymentType> paymentTypeList=chargeService.getAllPaymentType();
        model.addAttribute("housingList",housingList);
        model.addAttribute("paymentTypeList",paymentTypeList);
        return "addcharge";
    }

    @RequestMapping(value = "/updateCharge",method = RequestMethod.POST)
    @ApiOperation(value = "修改缴费方法",httpMethod ="POST",
            protocols = "HTTP", notes = "修改成功返回200状态码,修改失败返回500状态码")
    @ResponseBody
    public Object updateHousing(Charge charge){
        if(chargeService.updateCharge(charge)>0){
            return "<script>alert('修改成功！');location.href='/charge/getCharge';</script>";
        }else{
            return "<script>alert('修改失败！');location.href='/charge/getCharge';</script>";
        }
    }
    @RequestMapping(value = "/delCharge/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除缴费方法",httpMethod ="DELETE",
            protocols = "HTTP", notes = "删除成功返回200状态码,删除失败返回500状态码")
    @ResponseBody
    public Object delHousing(@PathVariable Integer id){
        Map<String,Object> map=new HashMap<>();
        if(chargeService.delCharge(id)>0){
            map.put("result","true");
        }else{
            map.put("result","false");
        }
        return map;
    }
    @RequestMapping(value = "/getCharge")
    @ApiOperation(value = "查询缴费分页方法",httpMethod = "GET",produces = "HTTP",notes = "查询成功返回集合")
    public String getChargePage(@RequestParam(value = "pageIndex",defaultValue = "1")Integer pageIndex,
                                @RequestParam(value = "pageSize",defaultValue = "1")Integer pageSize,
                                @RequestParam(value = "name",required = false)String name,
                                @RequestParam(value = "housingId",required = false)Integer housingId,
                                @RequestParam(value = "paymentTypeId",required = false)Integer paymentTypeId,
                                @RequestParam(value = "paymentStatus",required = false)Integer paymentStatus, Model model){

        Map<String,Object> parm=new HashMap<>();
        parm.put("name",name);
        parm.put("housingId",housingId);
        parm.put("paymentType",paymentTypeId);
        parm.put("paymentStatus",paymentStatus);
        List<Housing> housingList=housingService.getHousingPage(parm);
        List<PaymentType> paymentTypeList=chargeService.getAllPaymentType();
        PageHelper.startPage(pageIndex,pageSize);
        List<Charge> list=chargeService.getChargePage(parm);
        PageInfo<Charge> pageInfo=new PageInfo<Charge>(list);
        Map<String,Object> map=new HashMap<>();
        map.put("pageInfo",pageInfo);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("housingId",housingId);
        model.addAttribute("paymentTypeId",paymentTypeId);
        model.addAttribute("name",name);
        model.addAttribute("paymentStatus",paymentStatus);
        model.addAttribute("housingList",housingList);
        model.addAttribute("paymentTypeList",paymentTypeList);
        return "chargelist";
    }
}
