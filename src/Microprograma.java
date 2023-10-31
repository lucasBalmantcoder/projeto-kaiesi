import java.io.Serializable;
//versão ninbus
public class Microprograma implements Serializable {

    private int[] a_addr = new int[1];
    private int[] b_addr = new int[1];
    private int[] c_addr = new int[1];
    private int[] alu_op = new int[1];//{0,1}
    private int[] s_pos = new int[3]; //{0,0,0,0}
    
    //int a[3] = {0};


    public Microprograma(int a_addr, int b_addr, int c_addr, int alu_op, i) {
        this.a_addr = a_addr;
        this.b_addr = b_addr;
        this.c_addr = c_addr;
        this.alu_op = alu_op;
        this.s_pos = s_pos;
    }



}
