package org.web3soft.commons.support.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ResponseBody注解返回的JSON对象类
 *
 * @author web3soft-team
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> {
    /**
     * 200表示成功;
     * 非200表示失败并需要有提示信息
     */
    private int code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 是否成功
     *
     * @return true|false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.code == 0;
    }
}
