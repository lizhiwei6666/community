package cn.cmmunity.housing.service;

import cn.cmmunity.beans.Housing;

import java.util.List;
import java.util.Map;

public interface HousingService {
    /**
     * 根据id查询小区方法
     * @param id
     * @return
     */
    Housing getHousingById(Integer id);

    /**
     * 新增小区方法
     * @param housing
     * @return
     */
    int addHousing(Housing housing);
    /**
     * 修改小区方法
     * @param housing
     * @return
     */
    int updateHousing(Housing housing);

    /**
     * 删除小区方法
     * @param id
     * @return
     */
    int delHousing(Integer id);

    /**
     * 小区分页查询
     * @param parm
     * @return
     */
    List<Housing> getHousingPage(Map<String,Object> parm);

    /**
     * 查询小区总记录数
     * @return
     */
    int getHousingCount();
}
