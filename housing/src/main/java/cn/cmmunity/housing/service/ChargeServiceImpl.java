package cn.cmmunity.housing.service;

import cn.cmmunity.beans.Charge;
import cn.cmmunity.beans.PaymentType;
import cn.cmmunity.beans.User;
import cn.cmmunity.housing.mapper.ChargeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ChargeServiceImpl implements ChargeService {

    @Resource(name = "chargeMapper")
    ChargeMapper chargeMapper;

    @Override
    public int addCharge(Charge charge) {
        return chargeMapper.addCharge(charge);
    }

    @Override
    public List<PaymentType> getAllPaymentType() {
        return chargeMapper.getAllPaymentType();
    }

    @Override
    public int updateCharge(Charge charge) {
        return chargeMapper.updateCharge(charge);
    }

    @Override
    public int delCharge(Integer id) {
        return chargeMapper.delCharge(id);
    }

    @Override
    public List<Charge> getChargePage(Map<String, Object> parm) {
        return chargeMapper.getChargePage(parm);
    }

    @Override
    public int getChargeCount(Map<String, Object> parm) {
        return chargeMapper.getChargeCount(parm);
    }

    @Override
    public Charge getChargeById(Integer id) {
        return chargeMapper.getChargeById(id);
    }

    @Override
    public User getUserByName(String name) {
        return chargeMapper.getUserByName(name);
    }

    @Override
    public int addCharges(List<Charge> chargeList) {
        return chargeMapper.addCharges(chargeList);
    }
}
