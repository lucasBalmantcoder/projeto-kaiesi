import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("kaiesi"); // Cria uma janela com t�tulo
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a janela ao clicar no bot�o "X"
        frame.setSize(400, 300); // Define o tamanho da janela (largura x altura)

        JPanel panel = new JPanel(); // Cria um painel
        JLabel label = new JLabel("olha o carro do leite"); // Cria um r�tulo com texto

        panel.add(label); // Adiciona o r�tulo ao painel
        frame.add(panel); // Adiciona o painel � janela

        frame.setVisible(true); // Torna a janela vis�vel
    }
}




