package designmodel.chapter15.抽象工厂模式and配置;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @Author: cxh
 * @CreateTime: 18/1/14 11:35
 * @ProjectName: JavaBaseTest
 */
public class Factory {
    private static final String path="designmodel.chapter15.抽象工厂模式and配置";
    private static String type;
    public static void getType(){
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder db=dbf.newDocumentBuilder();
            Document document=
                    db.parse("/Users/caoxiaohong/IdeaProjects/JavaBaseTest/src/designmodel/chapter15/抽象工厂模式and配置/config.xml");
            NodeList list=document.getElementsByTagName("producta");
            type=list.item(0).getFirstChild().getNodeValue();
        }catch (Exception e){
            System.out.println("解析xml文件出错!");
        }
    }
    public static ProductA getProductA() throws Exception{
        return (ProductA)Class.forName(path+".ConcreteProductA"+type).newInstance();
    }
    public static ProductB getProductB() throws Exception{
        return (ProductB)Class.forName(path+".ConcreteProductB"+type).newInstance();
    }
}
