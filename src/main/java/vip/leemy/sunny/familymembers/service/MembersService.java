package vip.leemy.sunny.familymembers.service;

import vip.leemy.sunny.familymembers.common.medium.ResultModel;
import vip.leemy.sunny.familymembers.common.utils.ConstellationCalculator;
import vip.leemy.sunny.familymembers.model.FamilyMembers;

import java.util.List;

/**
 * @author: Leemy
 * @date: 2022/1/12-20:01
 * @description: 成员类服务层操作
 */
public interface MembersService {
    FamilyMembers insert(FamilyMembers familyMembers);
    List<FamilyMembers> visitAll();
    ResultModel checkConstellationAndUpdate(String date);

    default ResultModel checkConstellation(String date){
        return ConstellationCalculator.Constellation(date);
    }


}
