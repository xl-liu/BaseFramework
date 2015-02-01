package com.RFramework.common.annotations.processor;

import com.RFramework.utils.template.TemplateHelper;
import freemarker.template.TemplateException;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

/**
 * Created by wangronghua on 15/1/27.
 */
@SupportedAnnotationTypes({"com.RFramework.common.annotations.Entity"})
public class BeanAnnotationProcessor extends AbstractProcessor{

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv)
    {
        super.init(processingEnv);

        try {
            freemarker.log.Logger.selectLoggerLibrary(freemarker.log.Logger.LIBRARY_SLF4J);
        } catch (ClassNotFoundException e) {
            processingEnv.getMessager().printMessage(
                Diagnostic.Kind.ERROR, e.getMessage());
        }

        processingEnv.getMessager().printMessage(    //注释处理器的报告
            Diagnostic.Kind.WARNING, "Hello World!");
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (!roundEnv.processingOver()) {
            processingEnv.getMessager().printMessage(    //注释处理器的报告
            Diagnostic.Kind.NOTE, "Hello World!");
        }
        try {
            FileWriter f = new FileWriter("test");
            TemplateHelper.get().genFile("dao.ftl", new HashMap(), f);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return true;
    }
}
