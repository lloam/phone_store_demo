package com.mao.util;

import com.mao.vo.ResultVO;

/**
 * Author: Administrator
 * Date: 2021/6/18 18:06
 * Description:
 */
public class ResultVOUtil {
    public static ResultVO success(Object data){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO error(String error){
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(1);
        resultVO.setMsg(error);
        resultVO.setData(null);
        return resultVO;
    }
}
