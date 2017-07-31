package JVM;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by caoxiaohong on 17/5/12.
 */
public class NetworkClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        //return super.findClass(name);
        byte[] classData=downloadClassData(name);  //从远程下载
        if(classData==null){
            super.findClass(name);//未找到,抛异常
        }else {
            return defineClass(name,classData,0,classData.length);
        }
        return null;
    }
    private byte[] downloadClassData(String name) {
        //从localhost下载.class文件
        String path = "/Users/caoxiaohong/Documents/csgsim/java_src/ResourceOperationRiskEarlyWarning/dao"
                + File.separatorChar + "java"
                + File.separatorChar + name.replace('.', File.separatorChar)
                + ".class";
        try {
            URL url = new URL(path);
            InputStream ins = url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int buffersize = 4096;
            byte[] buffer = new byte[buffersize];
            int byteNumRead = 0;
            while ((byteNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, byteNumRead);// 把下载的二进制数据存入 ByteArrayOutputStream
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String className = "classloader.SlotMarginDao";
        NetworkClassLoader networkClassLoader = new NetworkClassLoader();
        try{
            Class<?> clazz  = networkClassLoader.loadClass(className);
            if(clazz!=null){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
