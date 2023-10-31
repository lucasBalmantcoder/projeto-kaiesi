import java.io.Serializable;
//versao ninbus
public class Microprograma implements Serializable {

    private int b_addr;
    private int a_addr;
    private int c_addr;
    private int alu_op;
    private int s_pos;

    public Microprograma() {
        this.a_addr = 0;
        this.b_addr = 0;
        this.c_addr = 0;
        this.alu_op = 0;
        this.s_pos = 0;
    }
    
    public int getB_addr() {
        return b_addr;
    }

    public void setB_addr(int b_addr) {
        this.b_addr = b_addr;
    }

    public int getA_addr() {
        return a_addr;
    }

    public void setA_addr(int a_addr) {
        this.a_addr = a_addr;
    }

    public int getC_addr() {
        return c_addr;
    }

    public void setC_addr(int c_addr) {
        this.c_addr = c_addr;
    }

    public int getAlu_op() {
        return alu_op;
    }

    public void setAlu_op(int alu_op) {
        this.alu_op = alu_op;
    }

    public int getS_pos() {
        return s_pos;
    }

    public void setS_pos(int s_pos) {
        this.s_pos = s_pos;
    }

}