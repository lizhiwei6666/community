package cn.cmmunity.housing.mapper;

import cn.cmmunity.beans.Housing;

import java.util.List;
import java.util.Map;

public interface HousingMapper {
    int addHousing(Housing housing);
    int updateHousing(Housing housing);
    int delHousing(Integer id);
    Housing getHousing(Integer id);
    List<Housing> getHousingPage(Map<String,Object> parm);
    int getHousingCount();
}
