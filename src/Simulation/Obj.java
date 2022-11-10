package Simulation;

/**
 * @author QiangQin
 * * @date 2021/9/29
 */
public class Obj  implements Cloneable {
    private int aInt=0;

    public Obj(){
        System.out.println("construct");
    }

    public int getAInt(){return aInt;}
    public void changeInt(){this.aInt=1;    }

    public Object clone() throws CloneNotSupportedException {
        Object o=null;
        o=(Obj)super.clone();
        return o;
    }


    public static void main(String[] args) throws CloneNotSupportedException {
        Obj a = new Obj();
        Obj b = (Obj)a.clone();
        b.changeInt();
        System.out.println("a:"+a.getAInt());
        System.out.println("b:"+b.getAInt());
    }

}
