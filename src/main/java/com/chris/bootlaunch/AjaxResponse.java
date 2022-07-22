package com.chris.bootlaunch;

//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
//@ApiModel(value = "通用響應數據結構類") //Swagger 2 用法
@Schema(title = "通用響應數據結構類") //Swagger 3 用法
public class AjaxResponse {
// @ApiModelProperty(value = "請求是否處裡成功")
@Schema(title = "請求是否處裡成功")
    private boolean isok;
//@ApiModelProperty(value = "請求響應狀態碼", example = "200、400、500")
@Schema(title = "請求響應狀態碼", example = "200、400、500")
    private int code;
//@ApiModelProperty(value = "請求結果敘述")
@Schema(title = "請求結果敘述")
    private String message;
//@ApiModelProperty(value = "請求結果數據")
@Schema(title = "請求結果數據")
    private Object data;

    private AjaxResponse(){}

    //請求成功的響應，不帶查詢數據(用於刪除、修改、新增接口)
    public static AjaxResponse success(){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("OK No Object");
        return ajaxResponse;
    }

    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setIsok(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("OK Has Object");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }



}
