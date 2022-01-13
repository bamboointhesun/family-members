package vip.leemy.sunny.familymembers.service.impl;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vip.leemy.sunny.familymembers.common.medium.ResultModel;
import vip.leemy.sunny.familymembers.common.utils.ConstellationCalculator;
import vip.leemy.sunny.familymembers.dao.MembersRepository;
import vip.leemy.sunny.familymembers.model.FamilyMembers;
import vip.leemy.sunny.familymembers.service.MembersService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Leemy
 * @date: 2022/1/12-20:12
 * @description: MembersService
 */
@Service
@Slf4j
public class MembersServiceImpl implements MembersService {

    private final MembersRepository membersRepository;

    public MembersServiceImpl(MembersRepository membersRepository) {
        this.membersRepository = membersRepository;
    }

    @Override
    public FamilyMembers insert(FamilyMembers familyMembers) {
        ResultModel resultModel = checkConstellation(familyMembers.getBirthday());
        if (resultModel.getCode() == 1){
            familyMembers.setConstellation((String)resultModel.getData());
        }
        int age = LocalDate.now().getYear() - familyMembers.getBirthYear();
        familyMembers.setAge(age);
        FamilyMembers familyMembers1 = membersRepository.saveAndFlush(familyMembers);
        log.info("添加的成员==>{}",familyMembers1);
        return familyMembers1;
    }

    @Override
    public List<FamilyMembers> visitAll() {
        return membersRepository.findAll();
    }

    @Override
    public ResultModel checkConstellationAndUpdate(String date) {
        ResultModel constellationBean = ConstellationCalculator.Constellation(date);
        String constellation = "";
        if (constellationBean.getCode() == 1){
            constellation = (String)constellationBean.getData();
        }
        int cu = membersRepository.checkAndUpdateConstellation(constellation, date);
        if (cu > 0){
            return new ResultModel(0,"成功验证星座并写入数据库", StrUtil.format("成功修改{}条数据",cu));
        }
        return new ResultModel(-1,"修改星座失败", constellationBean);
    }
}
