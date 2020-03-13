package com.zzw.base;

import lombok.Data;

/**
 * 功能描述：TODO
 *
 * @author by 周梓武
 * @package com.zzw.base
 * @since 2020/3/11
 */
@Data
public class ResponseData<T> {
    private Integer code;
    private String msg;
    /**
     * 返回客户端有效数据
     */
    private T data ;

    public ResponseData(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}