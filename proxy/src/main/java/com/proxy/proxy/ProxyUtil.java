package com.proxy.proxy;


import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {


    /**
     *  content --->string
     *  .java  io
     * .class
     *
     *
     *
     * .new   反射----》class
     * @return
     */
    public static Object newInstance(Class target, MyImplInvocationHandler h){
        Object proxy=null;
        //String handlerName = CoustomInvocationHandler.class.
        Method methods[] =target.getDeclaredMethods();
        String line="\n";
        String tab ="\t";
        String infName = target.getSimpleName();
        String content ="";
        String packageContent = ""+line;
        String importContent = "import "+target.getName()+";"+line
                             +"import com.proxy.proxy.MyImplInvocationHandler;"+line
                             +"import java.lang.Exception;"
                             +"import java.lang.reflect.Method;"+line;
        String clazzFirstLineContent = "public class $Proxy implements "+infName+"{"+line;
        String filedContent  =tab+"private MyImplInvocationHandler h;"+line;
        String constructorContent =tab+"public $Proxy (MyImplInvocationHandler h){" +line
                                  +tab+tab+"this.h =h;"
                                  +line+tab+"}"+line;
        String methodContent = "";
        for (Method method : methods) {
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName =method.getName();
            // Sting.class String.class
            Class args[] = method.getParameterTypes();
            String argsContent = "";
            String paramsContent="";
            int flag =0;
            for (Class arg : args) {
                String temp = arg.getSimpleName();
                //String
                //String p0,Sting p1,
                argsContent+=temp+" p"+flag+",";
                paramsContent+="p"+flag+",";
                flag++;
            }
            if (argsContent.length()>0){
                argsContent=argsContent.substring(0,argsContent.lastIndexOf(",")-1);
                paramsContent=paramsContent.substring(0,paramsContent.lastIndexOf(",")-1);
            }

            methodContent+=tab+"public "+returnTypeName+" "+methodName+"("+argsContent+")throws Exception {"+line
                           +tab+tab+"Method method = Class.forName(\""+target.getName()+"\").getDeclaredMethod(\""+methodName+"\");"+line
                            +tab+tab+"return ("+returnTypeName+")h.invoke(method);"+line;
            methodContent+=tab+"}"+line;
        }

        content=packageContent+importContent+clazzFirstLineContent+filedContent+constructorContent+methodContent+"}";

        File file =new File("/Users/changkaijie/Downloads/luban/$Proxy.java");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

            StandardJavaFileManager fileMgr = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileMgr.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileMgr, null, null, null, units);
            t.call();
            fileMgr.close();

            URL[] urls = new URL[]{new URL("file:/Users/changkaijie/Downloads/luban/")};
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            Class clazz = urlClassLoader.loadClass("$Proxy");

            Constructor constructor = clazz.getConstructor(MyImplInvocationHandler.class);
            proxy = constructor.newInstance(h);
            //clazz.newInstance();
            //Class.forName()
        }catch (Exception e){
            e.printStackTrace();
        }





        /**
         * public UserDaoLog(UserDao target){
         * 		this.target =target;
         *
         *        }
         */
        return proxy;
    }
}
