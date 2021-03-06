package cn.cmmunity.housing.service;

import cn.cmmunity.beans.Housing;
import cn.cmmunity.housing.mapper.HousingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class HousingServiceImpl implements  HousingService {
    @Resource(name = "housingMapper")
    HousingMapper housingMapper;

    @Override
    public Housing getHousingById(Integer id) {
        return housingMapper.getHousingById(id);
    }

    @Override
    public int addHousing(Housing housing) {
        return housingMapper.addHousing(housing);
    }

    @Override
    public int updateHousing(Housing housing) {
        return housingMapper.updateHousing(housing);
    }

    @Override
    public int delHousing(Integer id) {
        return housingMapper.delHousing(id);
    }

    @Override
    public List<Housing> getHousingPage(Map<String, Object> parm) {
        return housingMapper.getHousingPage(parm);
    }

    @Override
    public int getHousingCount() {
        return housingMapper.getHousingCount();
    }

    @Override
    public int del(Integer id) {
        Housing housing=new Housing();
        housing.setId(id);
        housingMapper.del(housing);
        return housing.getResult();
    }
}
