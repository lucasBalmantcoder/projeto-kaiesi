import java.io.Serializable;
//versao ninbus
public class Microprograma implements Serializable {

    private String id_micro;
    private int b_addr;
    private int a_addr;
    private int c_addr;
    private int alu_op;
    private int s_pos;
    private int rw;

    public Microprograma() {
        this.a_addr = 0;
        this.b_addr = 0;
        this.c_addr = 0;
        this.alu_op = 0;
        this.s_pos = 0;
        this.rw = 0;
    }


    public Microprograma( int b_addr, int a_addr, int c_addr, int alu_op, int s_pos, int rw) {

        this.b_addr = b_addr;
        this.a_addr = a_addr;
        this.c_addr = c_addr;
        this.alu_op = alu_op;
        this.s_pos = s_pos;
        this.rw = rw;
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

    public int getRw() {
        return this.rw;
    }

    public void setRw(int rw) {
        this.rw = rw;
    }


    public void setS_pos(int s_pos) {
        this.s_pos = s_pos;
    }

    public void set_conf_a(int pos_sw){
        setA_addr(pos_sw);
    }

    public void set_conf_b(int pos_sw){
        setB_addr(pos_sw);
    }

    public void set_conf_c(int pos_sw){
        setC_addr(pos_sw);
    }

    public void set_conf_alu(int pos_sw){
        setAlu_op(pos_sw);
    }

    public void set_conf_rw(){
        setRw(rw);
    }

    public String getId_micro() {
        return this.id_micro;
    }

    public void setId_micro(String id_micro) {
        this.id_micro = id_micro;
    }
    

}
