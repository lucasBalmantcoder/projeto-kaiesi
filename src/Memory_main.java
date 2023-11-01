import java.io.Serializable;

public class Memory_main implements Serializable {
    private int m_0 = 0;
    private int m_1 = 0;
    private int m_2 = 0;
    private int m_3 = 0;
    private int m_4 = 0;
    private int var = 0;
    private boolean a_mm = false;//acesso a memoria 

    public Memory_main(int m_0, int m_1, int m_2, int m_3, int m_4) {
        this.m_0 = m_0;
        this.m_1 = m_1;
        this.m_2 = m_2;
        this.m_3 = m_3;
        this.m_4 = m_4;
    }


    public int getM_0() {
        return this.m_0;
    }

    public void setM_0(int m_0) {
        this.m_0 = m_0;
    }

    public int getM_1() {
        return this.m_1;
    }

    public void setM_1(int m_1) {
        this.m_1 = m_1;
    }

    public int getM_2() {
        return this.m_2;
    }

    public void setM_2(int m_2) {
        this.m_2 = m_2;
    }

    public int getM_3() {
        return this.m_3;
    }

    public void setM_3(int m_3) {
        this.m_3 = m_3;
    }

    public int getM_4() {
        return this.m_4;
    }

    public void setM_4(int m_4) {
        this.m_4 = m_4;
    }
    
     public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }
    

    public void remove_all(){//zera todos os elementos de mm
        setM_0(0);
        setM_1(0);
        setM_2(0);
        setM_3(0);
        setM_4(0);
    }

    /*Selecionar um slot de memoria de endereco*/
    public void select_mm(int mmDest, int valor){
        if (mmDest == 0) {
              setM_0(valor);
          } else if (mmDest == 1) {
              setM_1(valor);
          } else if (mmDest == 2) {
              setM_2(valor);
          } else if (mmDest == 3) {
              setM_3(valor);
          } else if (mmDest == 4) {
              setM_4(valor);
          }
    }
    /*Remover (zerar) um slot de memória especifico*/
    public void removeValue(int mmDestino) {
        select_mm(mmDestino, 0);
    }

    public int retornar_mm(int mm){
        int value = 0;
        switch (mm) {
            case 0: value = getM_0(); break;
            case 1: value = getM_1(); break;
            case 2: value = getM_2(); break;
            case 3: value = getM_3(); break;
            case 4: value = getM_4(); break;
        
            default:
                break;
        }
        return value;

    }


    public boolean isA_mm() {
        return this.a_mm;
    }

    public boolean getA_mm() {
        return this.a_mm;
    }

    public void setA_mm(boolean a_mm) {
        this.a_mm = a_mm;
    }
    

    

}
