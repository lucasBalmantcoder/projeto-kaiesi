import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class JanelaSwing {

    public static void main(String[] args) {
        JFrame frame = new JFrame("kaiesi"); // Cria uma janela com título
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha a janela ao clicar no botão "X"
        frame.setSize(400, 300); // Define o tamanho da janela (largura x altura)

        JPanel panel = new JPanel(); // Cria um painel
        JLabel label = new JLabel("olha o carro do leite"); // Cria um rótulo com texto

        panel.add(label); // Adiciona o rótulo ao painel
        frame.add(panel); // Adiciona o painel à janela

        frame.setVisible(true); // Torna a janela visível
    }
}




