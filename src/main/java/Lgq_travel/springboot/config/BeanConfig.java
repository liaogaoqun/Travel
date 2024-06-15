package Lgq_travel.springboot.config;


import Lgq_travel.springboot.utils.DateConveter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class BeanConfig {
    /**
     * 表单全局日期转换器
     */
    @Bean
    public ConversionService getConversionService(DateConveter dateConverter){
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(dateConverter);
        factoryBean.setConverters(converters);
        return factoryBean.getObject();
    }
}
