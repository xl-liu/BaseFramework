package com.RFramework.utils.template;

import com.RFramework.common.constants.Constants;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import util.ServerContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ArrayList;
import java.util.List;

/**
 * 用来加载系统临时模板或配置文件，目录可通过server.properties配置
 * Created by wangronghua on 14-8-1.
 */
public class FileLoader {
    protected static Logger LOG = LoggerFactory.getLogger(TemplateHelper.class);

    private static final String[] paths;
    private static final String[] DEFAULT_PATH = {"template"};

    static {
//        String pathString = ServerContext.getValue("file.path.read");
        List<File> files = new ArrayList<File>();
//        if( StringUtils.isNotEmpty(pathString) ) {
//            String[] readPaths = pathString.split(";");
//            for(String readPath : readPaths) {
//                if (!readPath.startsWith("/") && readPath.indexOf(":") == -1) {
//                    readPath = Constants.ROOT_PATH + readPath;
//                }
//                File f = new File(readPath);
//                if(f.exists() && !files.contains(f)) {
//                    files.add(f);
//                }
//            }
//        }
        for(String readPath : DEFAULT_PATH) {
            if (!readPath.startsWith("/") && readPath.indexOf(":") == -1) {
                readPath = Constants.ROOT_PATH + readPath;
            }
            File f = new File(readPath);
            if(f.exists() && !files.contains(f)) {
                files.add(f);
            }
        }


        paths = new String[files.size()];
        for(int index = 0; index < files.size(); index ++) {
            paths[index] = files.get(index).getAbsolutePath();
        }
    }

    /**
     * 根据提供的fileName遍历预定义的目录，查找文件，如果文件不存在，抛出FileNotFoundException
     * @param fileName
     * @return
     * @throws java.io.IOException
     */
    public static File getReadFile(final String fileName) throws IOException {
        try {
            return (File)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws IOException {
                for (String path : paths) {
                    File file = new File(path + "/" + fileName);
                    if (file.exists()) {
                        return file;
                    }
                }
                throw new FileNotFoundException(fileName);
                }
            });
        } catch(PrivilegedActionException e) {
            LOG.error("File Load Exception:", e);
            throw (IOException)e.getException();
        }
    }

    /**
     * 向第一顺序目录中写入文件名为fileName的文件
     * @param fileName
     * @return
     */
    public static File getWriteFile(final String fileName) throws IOException {
        try {
            return (File)AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws IOException {
                for (String path : paths) {
                    File file = new File(path + "/" + fileName);
                    if(!file.exists()) {
                        file.createNewFile();
                    }
                    return file;
                }
                throw new IOException("No available temp folder to write the file!");
                }
            });
        } catch (PrivilegedActionException e) {
            LOG.error("File Load Exception:", e);
            throw (IOException)e.getException();
        }
    }

    public static String[] getPaths() {
        return paths;
    }
}
