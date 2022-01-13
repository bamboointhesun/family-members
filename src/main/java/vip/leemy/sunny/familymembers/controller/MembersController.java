package vip.leemy.sunny.familymembers.controller;

import org.springframework.web.bind.annotation.*;
import vip.leemy.sunny.familymembers.common.medium.ResultModel;
import vip.leemy.sunny.familymembers.model.FamilyMembers;
import vip.leemy.sunny.familymembers.service.MembersService;

import java.util.List;

/**
 * @author: Leemy
 * @date: 2022/1/12-20:05
 * @description: 成员类控制器操作
 */
@RestController
@RequestMapping("/members")
public class MembersController {

    private final MembersService membersService;

    public MembersController(MembersService membersService) {
        this.membersService = membersService;
    }

    @Deprecated
    @PostMapping("/familyTest")
    public ResultModel engageANewFamilyTest(@RequestBody FamilyMembers familyMember){
        FamilyMembers insert = membersService.insert(familyMember);
        return new ResultModel(1,"操作完成",insert);
    }

    @PostMapping("/family")
    public ResultModel engageANewFamily(@RequestBody FamilyMembers familyMember){
        FamilyMembers insert = membersService.insert(familyMember);
        return new ResultModel(1,"操作完成",insert);
    }



    @GetMapping("/allMembers")
    public ResultModel visitMyAllFamilies(){
        List<FamilyMembers> familyMembers = membersService.visitAll();
        return new ResultModel(1,"操作完成",familyMembers);
    }

    /**
     * 给定一个参数然后返回星座
     * @param date 日期
     * @return
     * 04-01
     */
    @PostMapping("/checkConstellation/{date}")
    public ResultModel checkConstellation(@PathVariable(required = false) String date){
        return membersService.checkConstellation(date);
    }

    /**
     * 给定一个参数然后校正星座
     * @param date 日期
     * @return
     * 04-01
     */
    @PutMapping("/checkConstellation/{date}")
    public ResultModel checkConstellationAndUpdate(@PathVariable(required = false) String date){
        return membersService.checkConstellationAndUpdate(date);
    }


}
