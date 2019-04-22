package cn.cmmunity.housing.mapper;

import cn.cmmunity.beans.Charge;

import java.util.List;
import java.util.Map;

public interface ChargeMapper {
    int addCharge(Charge charge);
    int updateCharge(Charge charge);
    int delCharge(Integer id);
    List<Charge> getChargePage(Map<String,Object> parm);
    int getChargeCount(Map<String,Object> parm);
    Charge getChargeById(Integer id);
}
