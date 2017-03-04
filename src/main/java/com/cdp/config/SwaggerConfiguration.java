//package com.cdp.config;
//
//import fr.rca.banques.config.AppProperties.Swagger;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.StopWatch;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import static springfox.documentation.builders.PathSelectors.regex;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfiguration {
//	private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);
//	public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
//
//	@Bean
//	public Docket rcaBanqueApi(AppProperties appProperties) {
//		log.debug("Starting Swagger");
//		StopWatch watch = new StopWatch();
//		watch.start();
//
//		Swagger swagger = appProperties.getSwagger();
//		ApiInfo apiInfo = new ApiInfo(
//			swagger.getTitle(),
//			swagger.getDescription(),
//			swagger.getVersion(),
//			swagger.getTermsOfServiceUrl(),
//			swagger.getContact(),
//			swagger.getLicense(),
//			swagger.getLicenseUrl());
//
//		Docket docket = new Docket(DocumentationType.SWAGGER_2)
//			.apiInfo(apiInfo)
//			.select()
//			.paths(regex(DEFAULT_INCLUDE_PATTERN))
//			.build();
//
//		watch.stop();
//		log.debug("Started Swagger in {} ms", watch.getTotalTimeMillis());
//
//		return docket;
//	}
//}
