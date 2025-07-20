package org.example;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class }; // Основная конфигурация
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class }; // WEB-конфигурация (создадим ниже)
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
