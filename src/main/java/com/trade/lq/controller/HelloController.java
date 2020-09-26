package com.trade.lq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * describle :
 * author : huh
 * 2020/8/19 0019
 * 下午 1:32
 *
 * swagger注解
 * swagger通过注解表明该接口会生成文档，包括接口名、请求方法、参数、返回信息的等等。
 *
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError ：发生错误返回的信息
 * @ApiImplicitParam：一个请求参数
 * @ApiImplicitParams：多个请求参数
 *
 */
@RestController
@Slf4j
//@Api(tags = "接口测试")
public class HelloController extends BaseController{


    /*@ApiOperation(value = "管理员问候",notes = "跟管理员打个招呼吧！")
    @ApiImplicitParam(paramType = "path")*/
    @GetMapping("/admin/hello")
    public String getAdminHello() {
        return "Hello admin!";
    }
   /* @ApiResponses({
            @ApiResponse(code = 200,message = "数据库管理员已经收到你跟他打的招呼"),
            @ApiResponse(code = 500,message = "数据库管理员未收到你跟他打的招呼")
    })
    @ApiOperation(value = "数据库管理员问候",notes = "跟数据库管理员打个招呼吧！")
    @ApiImplicitParam(paramType = "path")*/
    @GetMapping("/dba/hello")
    public String getDbaHello() {
        return "Hello dba!";
    }
    @GetMapping("/user/hello")
    public String getUserHello() {
        return "Hello user!";
    }

    /*@GetMapping("/uploadFile")
    @ResponseBody
    public String uploadFiles(@RequestParam("file") MultipartFile[] files)  {
        *//*String fileName = null;
        String msg = "";

        if (files != null && files.length > 0) {
            for (int i = 0; i < files.length; i++) {
                try {
                    fileName = files[i].getOriginalFilename();
                    byte[] bytes = files[i].getBytes();
                    BufferedOutputStream buffStream =
                            new BufferedOutputStream(new FileOutputStream(new File("/tmp/" + fileName)));
                    buffStream.write(bytes);
                    buffStream.close();
                    msg += "You have successfully uploaded " + fileName;
                } catch (Exception e) {
                    return "You failed to upload " + fileName + ": " + e.getMessage();
                }
            }
        }else {
            return "file is null";
        }
        return fileName;*//*
    }*/


}

