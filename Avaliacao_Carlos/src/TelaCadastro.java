import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastro extends JFrame {
    private JTextField campoNomeCadastro;
    private JTextField campoLoginCadastro;
    private JPasswordField campoSenhaCadastro;
    private JTextField campoEmailCadastro;

    public TelaCadastro() {
        setTitle("Cadastro de Usuário");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel painel = new JPanel();
        GroupLayout layout = new GroupLayout(painel);
        painel.setLayout(layout);

        JLabel labelNome = new JLabel("Nome:");
        JLabel labelLogin = new JLabel("Login:");
        JLabel labelSenha = new JLabel("Senha:");
        JLabel labelEmail = new JLabel("Email:");
        campoNomeCadastro = new JTextField(10);
        campoLoginCadastro = new JTextField(10);
        campoSenhaCadastro = new JPasswordField(10);
        campoEmailCadastro = new JTextField(10);
        JButton botaoCadastrar = new JButton("Cadastrar");

        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNomeCadastro.getText();
                String login = campoLoginCadastro.getText();
                String senha = new String(campoSenhaCadastro.getPassword());
                String email = campoEmailCadastro.getText();

                Cadastro.cadastrarUsuario(nome, login, senha, email);

                dispose();
            }
        });

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(labelNome)
                        .addComponent(labelLogin)
                        .addComponent(labelSenha)
                        .addComponent(labelEmail))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(campoNomeCadastro)
                        .addComponent(campoLoginCadastro)
                        .addComponent(campoSenhaCadastro)
                        .addComponent(campoEmailCadastro)
                        .addComponent(botaoCadastrar))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNome)
                        .addComponent(campoNomeCadastro))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelLogin)
                        .addComponent(campoLoginCadastro))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelSenha)
                        .addComponent(campoSenhaCadastro))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(labelEmail)
                        .addComponent(campoEmailCadastro))
                .addComponent(botaoCadastrar)
        );

        add(painel);
    }
}
