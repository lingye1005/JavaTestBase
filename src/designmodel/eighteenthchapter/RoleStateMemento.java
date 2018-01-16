package designmodel.eighteenthchapter;

/**
 * @Author: cxh
 * @CreateTime: 18/1/16 09:15
 * @ProjectName: JavaBaseTest
 */
public class RoleStateMemento{
    private int lifeLen;
    private int attackLen;
    private int defendLen;
    RoleStateMemento(int life,int attack,int defend){
        this.lifeLen=life;
        this.attackLen=attack;
        this.defendLen=defend;
    }

    //get
    public int getLifeLen() {
        return lifeLen;
    }

    public int getAttackLen() {
        return attackLen;
    }

    public int getDefendLen() {
        return defendLen;
    }
}
