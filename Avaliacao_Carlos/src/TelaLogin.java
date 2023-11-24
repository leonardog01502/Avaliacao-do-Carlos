import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaLogin extends JFrame {
    private JTextField campoLogin;
    private JPasswordField campoSenha;

    public TelaLogin() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);

        JLabel labelLogin = new JLabel("Login:");
        JLabel labelSenha = new JLabel("Senha:");
        campoLogin = new JTextField(10);
        campoSenha = new JPasswordField(10);
        JButton botaoEntrar = new JButton("Entrar");
        JButton botaoCadastrar = new JButton("Cadastrar Novo Usuário");

        botaoEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = campoLogin.getText();
                String senha = new String(campoSenha.getPassword());
                if (Login.autenticarUsuario(login, senha)) {
                    System.out.println("Abrir próxima tela após login bem-sucedido");
                    JOptionPane.showMessageDialog(null, "Login efetuado com sucesso !!");
                } else {
                   // caso se der alguma falha :)
                }
            }
        });

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TelaCadastro().setVisible(true);
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelLogin)
                        .addComponent(labelSenha))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(campoLogin)
                        .addComponent(campoSenha)
                        .addComponent(botaoEntrar)
                        .addComponent(botaoCadastrar))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelLogin)
                        .addComponent(campoLogin))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSenha)
                        .addComponent(campoSenha))
                .addComponent(botaoEntrar)
                .addComponent(botaoCadastrar)
        );

        add(painel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaLogin().setVisible(true);
        });
    }
}