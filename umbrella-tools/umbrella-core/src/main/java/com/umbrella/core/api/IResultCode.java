package com.umbrella.core.api;

import java.io.Serializable;

public interface IResultCode extends Serializable {

    /**
     * 返回提示
     * @return
     */
    String getMessage();

    /**
     * 返回码
     * @return
     */
    int getCode();
}
