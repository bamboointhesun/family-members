package vip.leemy.sunny.familymembers.common.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import vip.leemy.sunny.familymembers.common.medium.ResultModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Leemy
 * @date: 2022/1/12-20:38
 * @description: 生肖和星座计算器
 */
@Slf4j
public class ConstellationCalculator {
    private static final int[] days = {20,19,20,20,21,21,22,23,23,23,22,21};
    private static final String[] constellations = {"摩羯座","宝瓶座","双鱼座","白羊座","金牛座","双子座","巨蟹座","狮子座","室女座","天秤座","天蝎座","人马座"};
    /**
     *
     * @param date 日期格式 04-25
     * @return
     * code = 1 表示成功校对星座，反之则失败
     */
    public static ResultModel Constellation(String date){
        if (!constellationCheck(date)){
            return new ResultModel(-1,StrUtil.format("不合规范的日期格式:{}",date),"正确日期格式举例:04-25或3-02");
        }
        String[] dateMd = date.split(StrUtil.DASHED);
        int month = Integer.parseInt(dateMd[0]);
        int day = Integer.parseInt(dateMd[1]);
        String result = day > days[month-1]?constellations[month]:constellations[month-1];
        return new ResultModel(1,"星座校对成功",result);
    }




    /**
     *
     * @param date 日期格式 04-25
     * @return
     * 符合要求返回 true,反之为 false
     */
    private static boolean constellationCheck(String date){
        String pa = "^(0?)([1-9])-([0-3])(\\d)$";
        String pa1 = "^(1?)([0-2])-([0-3])(\\d)$";
        Pattern compile = Pattern.compile(pa);
        Pattern compile1 = Pattern.compile(pa1);
        Matcher matcher = compile.matcher(date);
        Matcher matcher1 = compile1.matcher(date);
        if (!matcher.find() && !matcher1.find()){
            log.error("日期不符合regex");
            return false;
        }
        if (Integer.parseInt(date.split(StrUtil.DASHED)[1]) > 31){
            log.error("日期不符合Integer");
            return false;
        }
        return true;
    }

    /**
     *  hutool 的星座计算
     *  不符合我的计算规则,
     *  舍弃不用
     */
    @Deprecated
    public static void hutoolCounter() {
        System.out.println(DateUtil.getZodiac(2, 18));
    }
}
