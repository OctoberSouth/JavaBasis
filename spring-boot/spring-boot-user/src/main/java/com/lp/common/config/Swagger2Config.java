package com.lp.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘攀
 * @version 1.0
 * @time 2019/12/6 15:36
 * @describe
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        List<Parameter> pars = new ArrayList<Parameter>();
        ParameterBuilder ticketPar = new ParameterBuilder();
        // header中的ticket参数非必填，传空也可以
        ticketPar.name("token").description("用户token").modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        // 根据每个方法名也知道当前方法在设置什么参数
        pars.add(ticketPar.build());
        List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
        responseMessageList.add(new ResponseMessageBuilder().code(200).message("请求接口成功，业务正确").build());
        responseMessageList.add(new ResponseMessageBuilder().code(412).message("请求接口成功，业务失败，前端返回预先定义的统一错误信息").build());
        responseMessageList.add(new ResponseMessageBuilder().code(500).message("不明错误，前端返回预先定义的统一错误信息").build());
        return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(pars)
                .globalResponseMessage(RequestMethod.GET, responseMessageList)
                .globalResponseMessage(RequestMethod.HEAD, responseMessageList)
                .globalResponseMessage(RequestMethod.POST, responseMessageList)
                .globalResponseMessage(RequestMethod.PUT, responseMessageList)
                .globalResponseMessage(RequestMethod.PATCH, responseMessageList)
                .globalResponseMessage(RequestMethod.DELETE, responseMessageList)
                .globalResponseMessage(RequestMethod.OPTIONS, responseMessageList)
                .globalResponseMessage(RequestMethod.TRACE, responseMessageList).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.lp.controller")).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("刘攀", "https://www.cnblogs.com/shiyuelp", "lp123092@163.com");
        return new ApiInfoBuilder()
                // 标题
                .title("Spring Boot中使用Swagger2构建RESTful API")
                // 描述信息
                .description("统一返回JSON类 {</br>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;data : 返回数据 ,</br>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;message : 返回消息 ,</br>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;statusCode : 返回结果 ,</br>"
                        + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}</br>" + "data里面具体数据会在相应接口具体表示")
                // 联系方式
                .contact(contact)
                //版本号
                .version("1.0")
                .build();
    }
}
