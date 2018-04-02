package designmodel.chapter1;

/**
 * @Author: cxh
 * @CreateTime: 17/12/31 17:50
 * @ProjectName: JavaBaseTest
 */
public class OperationFactory {
    public static Operation createOperation(String s){
        switch (s){
            case "+":
                return new OperationAdd();
            case "-":
                return new OperationSubs();
            case "*":
                return new OperationMul();
            case "/":
                return new OperationDevide();
        }
        return null;
    }
}
