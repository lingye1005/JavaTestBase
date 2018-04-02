package designmodel.chapter18;

/**
 * @Author: cxh
 * @CreateTime: 18/1/16 09:12
 * @ProjectName: JavaBaseTest
 */
public class GameRole {
    private int lifeLenth;
    private int attackLength;
    private int defendLength;

    GameRole(int life,int attack,int defend){
        this.lifeLenth=life;
        this.attackLength=attack;
        this.defendLength=defend;
    }
    //保存状态
    public RoleStateMemento getMemento(){
        return new RoleStateMemento(lifeLenth,attackLength,defendLength);
    }
    //攻击前状态
    public void beforeAttack(){
        printState("攻击前");
    }
    //攻击后状态
    public void afterAttack(){
        this.lifeLenth=0;
        this.attackLength=0;
        this.defendLength=0;
        printState("攻击后");
    }
    //恢复状态
    public void recover(CareTaker careTaker){
        this.lifeLenth=careTaker.getMemento().getLifeLen();
        this.attackLength=careTaker.getMemento().getAttackLen();
        this.defendLength=careTaker.getMemento().getDefendLen();
        printState("恢复后");
    }
    //输出当前状态
    private void printState(String time){
        System.out.println(time+"状态: 生命力"+lifeLenth+",攻击力"+attackLength+",防守力"+defendLength);
    }
}
