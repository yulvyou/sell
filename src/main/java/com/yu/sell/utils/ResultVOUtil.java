package com.yu.sell.utils;

import com.yu.sell.viewobject.ResultVO;

/**
 * 返回结果对象工具
 */
public class ResultVOUtil {

    /**
     * 查询成功
     * @param object 返回的数据对象
     * @return
     */
    public static ResultVO sucess(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO sucess(){
        return sucess(null);
    }


    /**
     * 查询失败
     */
    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
