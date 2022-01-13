package vip.leemy.sunny.familymembers.common.medium;

import lombok.AllArgsConstructor;

/**
 * @author: Leemy
 * @date: 2022/1/12-20:41
 * @description: 太阳星座枚举
 *
 * 辛苦写完,发现没用的枚举
 */
@AllArgsConstructor
public enum ConstellationEnum {
    Capricorn("摩羯座","12-22","01-20"),
    Aquarius("宝瓶座","01-21","02-19"),
    Pisces("双鱼座","02-20","03-20"),
    Aries("白羊座","03-21","04-20"),
    Taurus("金牛座","04-21","05-21"),
    Gemini("双子座","05-22","06-21"),
    Cancer("巨蟹座","06-22","07-22"),
    Leo("狮子座","07-23","08-23"),
    Virgo("室女座","08-24","09-23"),
    Libra("天秤座","09-24","10-23"),
    Scorpio("天蝎座","10-24","11-22"),
    Sagittarius("人马座","11-23","12-21")

    ;
    private String content;
    private String beginDate;
    private String endDate;
    public void setContent(String content) {
        this.content = content;
    }
    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
