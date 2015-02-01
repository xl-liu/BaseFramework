package com.RFramework.utils.template;

import freemarker.cache.TemplateLoader;
import freemarker.template.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;

/**
 * Created by wangronghua on 14-1-27.
 */
public class TemplateHelper {
    protected static Logger LOG = LoggerFactory.getLogger(TemplateHelper.class);

    private static TemplateHelper instance = new TemplateHelper();
    private static Configuration tempCfg = new Configuration();

    private TemplateHelper() {}

    static {
        init();
    }

    public static TemplateHelper get() {
        return instance;
    }

    private static void init() {
        tempCfg.setTemplateLoader(new TemplateLoader() {
            @Override
            public Object findTemplateSource(String name) throws IOException {
                return FileLoader.getReadFile(name);
            }

            @Override
            public long getLastModified(final Object templateSource) {
                return ((Long)(AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        return new Long(((File) templateSource).lastModified());
                    }
                }))).longValue();
            }

            @Override
            public Reader getReader(final Object templateSource, final String encoding) throws IOException {
                try
                {
                    return (Reader)AccessController.doPrivileged(new PrivilegedExceptionAction()
                    {
                        public Object run()
                            throws
                            IOException
                        {
                            return new InputStreamReader(new FileInputStream(
                                (File)templateSource), encoding);
                        }
                    });
                }
                catch(PrivilegedActionException e)
                {
                    throw (IOException)e.getException();
                }
            }

            @Override
            public void closeTemplateSource(Object templateSource) throws IOException {

            }
        });
        tempCfg.setObjectWrapper(new DefaultObjectWrapper());
        tempCfg.setDefaultEncoding("UTF-8");
        tempCfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
        tempCfg.setLocalizedLookup(false);

    }

    public void genFile(String templateId, Object object, Writer out) throws IOException, TemplateException {
        Template temp ;
        try {
            temp = tempCfg.getTemplate(templateId);
        } catch (IOException e) {
            LOG.warn("Exception happened while trying to find template",  e);
            throw(e);
        }

        try {
            temp.process(object, out);
        } catch (TemplateException e) {
            LOG.warn("Exception happened while trying to parse template", e);
            throw(e);
        }
    }

    public String getTemplate (String templateName, Object param) {
        StringWriter result = new StringWriter();
        try {
            this.genFile(templateName + ".ftl", param, result);
        } catch (IOException e) {
            LOG.error("IOException happened: {}", e);
        } catch (TemplateException e) {
            LOG.error("Template Exception happened: {}", e);
        }
        return result.toString();
    }

    public boolean getTemplate (String templateName, Object param, Writer out) {
        try {
            this.genFile(templateName + ".ftl", param, out);
            return true;
        } catch (IOException e) {
            LOG.error("IOException happened: {}", e);
        } catch (TemplateException e) {
            LOG.error("Template Exception happened: {}", e);
        }
        return false;
    }
}
