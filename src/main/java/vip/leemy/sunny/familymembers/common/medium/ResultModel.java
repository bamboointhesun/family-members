package vip.leemy.sunny.familymembers.common.medium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Leemy
 * @date: 2022/1/12-20:06
 * @description: 结果返回
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultModel {
    private int code;
    private String message;
    private Object data;
    public ResultModel(int code, String message) {
        this.code = code;
        this.message = message;
        this.data = "暂无";
    }
}
