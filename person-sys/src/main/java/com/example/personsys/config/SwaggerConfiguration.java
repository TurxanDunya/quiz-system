package com.example.personsys.config;//package com.example.quizsys.config;
//
//import az.kapitalbank.atlas.statement.config.properties.ApplicationProperties;
//import az.kapitalbank.front.lib.error.model.RestErrorResponse;
//import com.fasterxml.classmate.TypeResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.RequestMethod;
//import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.builders.ResponseMessageBuilder;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.ResponseMessage;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.*;
//
//@EnableSwagger2
//@Configuration
//@Import({BeanValidatorPluginsConfiguration.class})
//public class SwaggerConfiguration {
//
//    private final ApplicationProperties.Swagger properties;
//
//    public SwaggerConfiguration(ApplicationProperties properties) {
//        this.properties = properties.getSwagger();
//    }
//
//    @Bean
//    public Docket docket(TypeResolver typeResolver) {
//        Contact contact = new Contact(
//                properties.getContactName(),
//                properties.getContactUrl(),
//                properties.getContactEmail()
//        );
//
//        ApiInfo apiInfo = new ApiInfo(
//                properties.getTitle(),
//                properties.getDescription(),
//                properties.getVersion(),
//                properties.getTermsOfServiceUrl(),
//                contact,
//                properties.getLicense(),
//                properties.getLicenseUrl(),
//                new ArrayList<>()
//        );
//
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .paths(PathSelectors.regex(properties.getDefaultIncludePattern()))
//                .apis(RequestHandlerSelectors.basePackage("az.kapitalbank.atlas.statement"))
//                .build()
//                .apiInfo(apiInfo)
//                .host(properties.getHost())
//                .protocols(new HashSet<>(Arrays.asList(properties.getProtocols())))
//                .produces(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
//                .consumes(Collections.singleton(MediaType.APPLICATION_JSON_VALUE))
//                .globalResponseMessage(RequestMethod.GET, getCustomizedResponseMessages())
//                .globalResponseMessage(RequestMethod.PUT, getCustomizedResponseMessages())
//                .globalResponseMessage(RequestMethod.DELETE, getCustomizedResponseMessages())
//                .globalResponseMessage(RequestMethod.POST, getCustomizedResponseMessages())
//                .additionalModels(typeResolver.resolve(RestErrorResponse.class));
//    }
//
//    private List<ResponseMessage> getCustomizedResponseMessages() {
//
//        final ModelRef errorResponse = new ModelRef("RestErrorResponse");
//
//        List<ResponseMessage> responseMessages = new ArrayList<>();
//        responseMessages.add(new ResponseMessageBuilder()
//                .code(HttpStatus.BAD_REQUEST.value())
//                .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
//                .responseModel(errorResponse)
//                .build());
//
//        responseMessages.add(new ResponseMessageBuilder()
//                .code(HttpStatus.UNAUTHORIZED.value())
//                .message(HttpStatus.UNAUTHORIZED.getReasonPhrase())
//                .build());
//
//        responseMessages.add(new ResponseMessageBuilder()
//                .code(HttpStatus.FORBIDDEN.value())
//                .message(HttpStatus.FORBIDDEN.getReasonPhrase())
//                .build());
//
//        responseMessages.add(new ResponseMessageBuilder()
//                .code(HttpStatus.NOT_FOUND.value())
//                .message(HttpStatus.NOT_FOUND.getReasonPhrase())
//                .build());
//
//        responseMessages.add(new ResponseMessageBuilder()
//                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
//                .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
//                .responseModel(errorResponse)
//                .build());
//
//        return responseMessages;
//    }
//
//}