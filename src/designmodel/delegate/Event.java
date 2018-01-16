package designmodel.delegate;

import java.lang.reflect.Method;

/**
 * @Author: cxh
 * @CreateTime: 18/1/10 23:29
 * @ProjectName: JavaBaseTest
 */
public class Event{
    //要执行方法的对象
    private Object object;
    //要执行的方法名称
    private String methodName;
    //要执行方法的参数
    private Object[] params;
    //要执行方法的参数类型
    private Class[] paramType;

    //两个构造函数
    public Event(){}
    public Event(Object object,String methodName,Object... args){
        this.object=object;
        this.methodName=methodName;
        this.params=args;
        //获取参数类型
        getParaTypes(args);
    }
    private void getParaTypes(Object[] params){
        int size=params.length;
        this.paramType=new Class[size];//4个私有变量,只有这个变量实现了深拷贝
        for(int i=0;i<size;i++)
            paramType[i]=params[i].getClass();
    }

    //执行该对象的方法
    public void invoke() throws Exception{
        Method method=object.getClass().getMethod(getMethodName(),getParamType());
        if(null==method)
            return;
        method.invoke(getObject(),getParams());
    }

    //get,set方法
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }

    public Class[] getParamType() {
        return paramType;
    }

    public void setParamType(Class[] paramType) {
        this.paramType = paramType;
    }
}
