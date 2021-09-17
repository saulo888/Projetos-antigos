
package visual;

import classes.*;

public class TelaPrincipal extends javax.swing.JFrame {

    private Dado eventoDado;
    private Dado dado = new Dado();
    private static Jogador jUm;
    private static Jogador jDois;
    private boolean escolhaUm, escolhaDois, escolhaTres, extincao = false;

    public TelaPrincipal(Jogador jUm, Jogador jDois) {
        initComponents();
        setLocationRelativeTo(null);
        txtareaEnunciado.setLineWrap(true);
        txtareaEnunciado.setWrapStyleWord(true);
        switch (jUm.getProfissao()) {
            case "Cientista":
                jUm = new Cientista(jUm.getCor());
                break;
            case "Desempregado":
                jUm = new Desempregado(jUm.getCor());
                break;
            case "Empresário":
                jUm = new Empresario(jUm.getCor());
                break;
        }
        switch (jDois.getProfissao()) {
            case "Cientista":
                jDois = new Cientista(jDois.getCor());
                break;
            case "Desempregado":
                jDois = new Desempregado(jDois.getCor());
                break;
            case "Empresário":
                jDois = new Empresario(jDois.getCor());
                break;
        }

        TelaPrincipal.jUm = jUm;
        TelaPrincipal.jDois = jDois;
        lblCorJUm.setText(jUm.getCor());
        lblCorJDois.setText(jDois.getCor());
        lblProfissaoJUm.setText(jUm.getProfissao());
        lblProfissaoJDois.setText(jDois.getProfissao());
        lblQntdEmpresasJUm.setText(Integer.toString(jUm.getQntdEmpresa()));
        lblQntdEmpresasJDois.setText(Integer.toString(jDois.getQntdEmpresa()));
        lblVez.setText(jUm.getCor());
        escolhaUm = false;
        escolhaDois = false;
        escolhaTres = false;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        painelOpcoes = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblValorDado = new javax.swing.JLabel();
        btnEscolhaUm = new javax.swing.JButton();
        btnEscolhaDois = new javax.swing.JButton();
        btnEscolhaTres = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        painelJogadorUm = new javax.swing.JPanel();
        lblCorJUm = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblProfissaoJUm = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblQntdEmpresasJUm = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblPAJUm = new javax.swing.JLabel();
        lblDinheiroJUm = new javax.swing.JLabel();
        lblPosicaoJUm = new javax.swing.JLabel();
        btnRolarJUm = new javax.swing.JButton();
        painelJogadorDois = new javax.swing.JPanel();
        lblCorJDois = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblProfissaoJDois = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblQntdEmpresasJDois = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPAJDois = new javax.swing.JLabel();
        lblDinheiroJDois = new javax.swing.JLabel();
        lblPosicaoJDois = new javax.swing.JLabel();
        btnRolarJDois = new javax.swing.JButton();
        painelInformacoes = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();
        barraMedidorDeExtincao = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        lblVez = new javax.swing.JLabel();
        painelQuestoes = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareaEnunciado = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtareaResultadoUm = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtareaResultadoDois = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtareaResultadoTres = new javax.swing.JTextArea();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMaximumSize(new java.awt.Dimension(751, 628));
        setResizable(false);

        painelOpcoes.setBackground(new java.awt.Color(0, 0, 0));
        painelOpcoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        lblValorDado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblValorDado.setForeground(new java.awt.Color(255, 255, 255));
        lblValorDado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblValorDado.setText("6");

        btnEscolhaUm.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEscolhaUm.setText("1");
        btnEscolhaUm.setEnabled(false);
        btnEscolhaUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolhaUmActionPerformed(evt);
            }
        });

        btnEscolhaDois.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEscolhaDois.setText("2");
        btnEscolhaDois.setEnabled(false);
        btnEscolhaDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolhaDoisActionPerformed(evt);
            }
        });

        btnEscolhaTres.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnEscolhaTres.setText("3");
        btnEscolhaTres.setEnabled(false);
        btnEscolhaTres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolhaTresActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Opção");

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Opção");

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Opção");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEscolhaUm))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEscolhaTres))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEscolhaDois)))
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblValorDado, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lblValorDado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscolhaUm)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscolhaDois)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEscolhaTres)
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelOpcoesLayout = new javax.swing.GroupLayout(painelOpcoes);
        painelOpcoes.setLayout(painelOpcoesLayout);
        painelOpcoesLayout.setHorizontalGroup(
            painelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelOpcoesLayout.setVerticalGroup(
            painelOpcoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelOpcoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        painelJogadorUm.setBackground(new java.awt.Color(0, 0, 0));
        painelJogadorUm.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblCorJUm.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCorJUm.setForeground(new java.awt.Color(255, 255, 255));
        lblCorJUm.setText("Cor Um");

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Profissão: ");

        lblProfissaoJUm.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblProfissaoJUm.setForeground(new java.awt.Color(255, 255, 255));
        lblProfissaoJUm.setText("Prof JUm");

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Empresas: ");

        lblQntdEmpresasJUm.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblQntdEmpresasJUm.setForeground(new java.awt.Color(255, 255, 255));
        lblQntdEmpresasJUm.setText("Qntd Empresas JUm");

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Posição:");

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dinheiro:");

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("P.A");

        lblPAJUm.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPAJUm.setForeground(new java.awt.Color(102, 255, 0));
        lblPAJUm.setText("0");

        lblDinheiroJUm.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblDinheiroJUm.setForeground(new java.awt.Color(255, 255, 51));
        lblDinheiroJUm.setText("20");

        lblPosicaoJUm.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPosicaoJUm.setForeground(new java.awt.Color(255, 255, 255));
        lblPosicaoJUm.setText("1");

        btnRolarJUm.setText("Rolar");
        btnRolarJUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolarJUmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelJogadorUmLayout = new javax.swing.GroupLayout(painelJogadorUm);
        painelJogadorUm.setLayout(painelJogadorUmLayout);
        painelJogadorUmLayout.setHorizontalGroup(
            painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelJogadorUmLayout.createSequentialGroup()
                .addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelJogadorUmLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel2))
                    .addGroup(painelJogadorUmLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lblCorJUm))
                    .addGroup(painelJogadorUmLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPosicaoJUm)
                            .addComponent(lblQntdEmpresasJUm, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelJogadorUmLayout.createSequentialGroup()
                                .addComponent(btnRolarJUm)
                                .addGap(89, 89, 89))
                            .addComponent(lblProfissaoJUm, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblPAJUm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDinheiroJUm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_S/IZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelJogadorUmLayout.setVerticalGroup(
            painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelJogadorUmLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCorJUm)  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblProfissaoJUm))
                .addGap(4, 4, 4)
.addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblQntdEmpresasJUm)         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED .addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(lblPosicaoJUm))        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)      .addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblDinheiroJUm))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(painelJogadorUmLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblPAJUm))      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRolarJUm)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelJogadorDois.setBackground(new java.awt.Color(0, 0, 0));
painelJogadorDois.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblCorJDois.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblCorJDois.setForeground(new java.awt.Color(255, 255, 255));
        lblCorJDois.setText("Cor JDois");
        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Profissão: ");
        lblProfissaoJDois.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblProfissaoJDois.setForeground(new java.awt.Color(255, 255, 255));
        lblProfissaoJDois.setText("Prof JDois");
        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Empresas: ");
        lblQntdEmpresasJDois.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblQntdEmpresasJDois.setForeground(new java.awt.Color(255, 255, 255));
        lblQntdEmpresasJDois.setText("Qntd Empresas JDois");
        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Posição:");
        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Dinheiro:");
        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("P.A");
        lblPAJDois.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPAJDois.setForeground(new java.awt.Color(102, 255, 0));
        lblPAJDois.setText("0");
        lblDinheiroJDois.setFont(new ava.awt.Font("Verdana", 0, 12)); // NOI18N
        lblDinheiroJDois.setForeground(new java.awt.Color(255, 255, 51));
        lblDinheiroJDois.setText("20");
        lblPosicaoJDois.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblPosicaoJDois.setForeground(new java.awt.Color(255, 255, 255));
        lblPosicaoJDois.setText("1");
        btnRolarJDois.setText("Rolar");
        btnRolarJDois.setEnabled(false);
        btnRolarJDois.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRolarJDoisActionPerformed(evt);
            }
        });
        javax.swing.GroupLayout painelJogadorDoisLayout = new javax.swing.GroupLayout(painelJogadorDois);
        painelJogadorDois.setLayout(painelJogadorDoisLayout);
        painelJogadorDoisLayout.setHorizontalGroup( painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelJogadorDoisLayout.createSequentialGroup()                .addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(painelJogadorDoisLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jLabel5))                   .addGroup(painelJogadorDoisLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lblCorJDois))
 .addGroup(painelJogadorDoisLayout.createSequentialGroup()
                        .addGap(38, 38, 38)                .addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)                        .addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPosicaoJDois)
                            .addComponent(lblQntdEmpresasJDois, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRolarJDois)
                            .addComponent(lblProfissaoJDois, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lblPAJDois, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblDinheiroJDois, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        painelJogadorDoisLayout.setVerticalGroup(
painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelJogadorDoisLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCorJDois)  .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblProfissaoJDois))
                .addGap(4, 4, 4)
.addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblQntdEmpresasJDois))      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lblPosicaoJDois))                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblDinheiroJDois))      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(painelJogadorDoisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(lblPAJDois))       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
               .addComponent(btnRolarJDois)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelInformacoes.setBackground(new java.awt.Color(0, 0, 0));
painelInformacoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Turno: ");
        lblTurno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblTurno.setForeground(new java.awt.Color(255, 255, 255));
        lblTurno.setText("1");
        barraMedidorDeExtincao.setBackground(new java.awt.Color(102, 255, 0));
        barraMedidorDeExtincao.setForeground(new java.awt.Color(51, 255, 0));
        barraMedidorDeExtincao.setMaximum(2);
        barraMedidorDeExtincao.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        barraMedidorDeExtincao.setName(""); // NOI18N
        barraMedidorDeExtincao.setString("Medidor de extinção");
        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Medidor de extinção: ");
        lblVez.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblVez.setForeground(new java.awt.Color(255, 255, 255));
 lblVez.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVez.setText("Vez");
        javax.swing.GroupLayout painelInformacoesLayout = new javax.swing.GroupLayout(painelInformacoes);
        painelInformacoes.setLayout(painelInformacoesLayout);
        painelInformacoesLayout.setHorizontalGroup( painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(lblVez, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jLabel11)
                .addGap(14, 14, 14)
                .addComponent(barraMedidorDeExtincao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelInformacoesLayout.setVerticalGroup(
            painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelInformacoesLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)      .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(barraMedidorDeExtincao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(lblTurno)
                        .addComponent(jLabel11)
                        .addComponent(lblVez)))
                .addGap(11, 11, 11))
        );
        painelQuestoes.setBackground(new java.awt.Color(0, 0, 0));
        painelQuestoes.setMaximumSize(new java.awt.Dimension(751, 379));
        txtareaEnunciado.setEditable(false);
        txtareaEnunciado.setBackground(new java.awt.Color(0, 0, 0));
        txtareaEnunciado.setColumns(20);
        txtareaEnunciado.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        txtareaEnunciado.setForeground(new java.awt.Color(255, 255, 255));
        txtareaEnunciado.setLineWrap(true);
        txtareaEnunciado.setRows(5);
        txtareaEnunciado.setText("Enunciado");
        txtareaEnunciado.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtareaEnunciado);
        txtareaResultadoUm.setEditable(false);
        txtareaResultadoUm.setBackground(new java.awt.Color(0, 0, 0));
        txtareaResultadoUm.setColumns(20);
        txtareaResultadoUm.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtareaResultadoUm.setForeground(new java.awt.Color(255, 255, 255));
        txtareaResultadoUm.setLineWrap(true);
        txtareaResultadoUm.setRows(2);
        txtareaResultadoUm.setText("Resultado 1");
        txtareaResultadoUm.setWrapStyleWord(true);
        jScrollPane3.setViewportView(txtareaResultadoUm);
        txtareaResultadoDois.setEditable(false);
        txtareaResultadoDois.setBackground(new java.awt.Color(0, 0, 0));
        txtareaResultadoDois.setColumns(20);
        txtareaResultadoDois.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtareaResultadoDois.setForeground(new java.awt.Color(255, 255, 255));
        txtareaResultadoDois.setLineWrap(true);
        txtareaResultadoDois.setRows(2);
        txtareaResultadoDois.setText("Resultado 2");
        txtareaResultadoDois.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtareaResultadoDois);
        txtareaResultadoTres.setEditable(false);
        txtareaResultadoTres.setBackground(new java.awt.Color(0, 0, 0));
        txtareaResultadoTres.setColumns(20);
        txtareaResultadoTres.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        txtareaResultadoTres.setForeground(new java.awt.Color(255, 255, 255));
        txtareaResultadoTres.setLineWrap(true);
        txtareaResultadoTres.setRows(2);
        txtareaResultadoTres.setText("Resultado 3\n");
        txtareaResultadoTres.setWrapStyleWord(true);
        jScrollPane5.setViewportView(txtareaResultadoTres);
        javax.swing.GroupLayout painelQuestoesLayout = new javax.swing.GroupLayout(painelQuestoes);
        painelQuestoes.setLayout(painelQuestoesLayout);
        painelQuestoesLayout.setHorizontalGroup(
painelQuestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelQuestoesLayout.createSequentialGroup()
                .addContainerGap()    .addGroup(painelQuestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
painelQuestoesLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jScrollPane3, jScrollPane4, jScrollPane5});
        painelQuestoesLayout.setVerticalGroup(
painelQuestoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelQuestoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
painelQuestoesLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jScrollPane3, jScrollPane4, jScrollPane5});
        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(painelJogadorUm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelOpcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelJogadorDois, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(painelInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelQuestoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel7Layout.setVerticalGroup(
jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
.addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelJogadorUm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelJogadorDois, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelOpcoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelInformacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)      .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelQuestoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel7Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {painelJogadorDois, painelJogadorUm});
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void finalizarJogo() {
        double jUmScore, jDoisScore;
        lblDinheiroJUm.setText(Integer.toString(jUm.getDinheiro()));
        lblPAJUm.setText(Integer.toString(jUm.getPontosAmbientais()));
        lblPosicaoJUm.setText(Integer.toString(jUm.getPosicao()));
        lblPosicaoJDois.setText(Integer.toString(jDois.getPosicao()))
        jUmScore = ((jUm.getPontosAmbientais() * 2) + (jUm.getDinheiro()));
        jDoisScore = (((jDois.getPontosAmbientais() * 2) + jDois.getDinheiro()));
        if (Integer.parseInt(lblPosicaoJUm.getText()) > Integer.parseInt(lblPosicaoJDois.getText())) {
            jUmScore += Integer.parseInt(lblPosicaoJUm.getText());
        } else if (jUm.getPosicao() < jDois.getPosicao()) {
            jDoisScore += Integer.parseInt(lblPosicaoJDois.getText());
        }
        if (jUmScore > jDoisScore) {
            txtareaEnunciado.setText("Jogador um venceu com: " + jUmScore + " pontos, parabéns!\n Jogador 2 pontos: " + jDoisScore);
        } else {
            txtareaEnunciado.setText("Jogador dois venceu com: " + jDoisScore + " pontos, parabéns!\n Jogador 1 pontos: " + jUmScore);
        }
        btnEscolhaUm.setEnabled(false);
        btnEscolhaDois.setEnabled(false);
        btnEscolhaTres.setEnabled(false);
        btnRolarJUm.setEnabled(false);
        btnRolarJDois.setEnabled(false);
    }
    public void badEnd() {
        btnRolarJDois.setEnabled(false);
        btnRolarJUm.setEnabled(false);
        txtareaEnunciado.setText("Por conta dos acontecimentos atuais, o mundo está em decadência e para a raça humana não ser extinta o que vocês vão fazer?");
        txtareaResultadoUm.setText("Mesmo sendo tarde, ajudar um ao outro em coleta de lixo e reciclagem");
        txtareaResultadoDois.setText("Doar os dinheiros somados para ONU e ver o que pode acontecer...");
        txtareaResultadoUm.setText("Todos irão morrer um dia.");
        btnEscolhaUm.setEnabled(true);
        btnEscolhaDois.setEnabled(true);
        btnEscolhaTres.setEnabled(true);}
    private void btnRolarJUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolarJUmActionPerformed
        dado.rolar();
        jUm.avancar(dado.getValorAtual());
        lblPosicaoJUm.setText(Integer.toString(jUm.getPosicao()));
        lblValorDado.setText(Integer.toString(dado.getValorAtual()));
        btnRolarJUm.setEnabled(false);
        btnEscolhaUm.setEnabled(true);
        btnEscolhaDois.setEnabled(true);
        btnEscolhaTres.setEnabled(true);
        // Escolhendo evento  
        do {
            eventoDado = new Dado(ev0000.getEventoContagemSize());
            eventoDado.rolar();
            if (ev0000.getEvento(eventoDado.getValorAtual() - 1).getProfissao() == "Nenhuma"){
                break;
            }
        } while (jUm.getProfissao() != ev0000.getEvento(eventoDado.getValorAtual() - 1).getProfissao());
        // Se a profissao de evento for diferente da profissão do jogador irá repetir a rolagem até cair num evento de mesma profissão
        // Se a profissão for "Nenhuma" continue...
txtareaEnunciado.setText(ev0000.getEvento(eventoDado.getValorAtual() - 1).getEnunciado());
txtareaResultadoUm.setText(ev0000.getEvento(eventoDado.getValorAtual() - 1).getResultadoA());
txtareaResultadoDois.setText(ev0000.getEvento(eventoDado.getValorAtual() - 1).getResultadoB());
txtareaResultadoTres.setText(ev0000.getEvento(eventoDado.getValorAtual() - 1).getResultadoC());
    }//GEN-LAST:event_btnRolarJUmActionPerformed
    private void btnRolarJDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRolarJDoisActionPerformed
        dado.rolar();
        jDois.avancar(dado.getValorAtual());
        lblPosicaoJDois.setText(Integer.toString(jDois.getPosicao()));
        lblValorDado.setText(Integer.toString(dado.getValorAtual()));
        btnRolarJDois.setEnabled(false);
        btnEscolhaUm.setEnabled(true);
        btnEscolhaDois.setEnabled(true);
        btnEscolhaTres.setEnabled(true);
        // Escolhendo evento  
        do {
            eventoDado = new Dado(ev0000.getEventoContagemSize());
            eventoDado.rolar();
            if (ev0000.getEvento(eventoDado.getValorAtual() - 1).getProfissao() == "Nenhuma"){
                break;
            }
        } while (jDois.getProfissao() != ev0000.getEvento(eventoDado.getValorAtual() - 1).getProfissao());
        // Se a profissao de evento for diferente da profisso do jogador irá repetir a rolagem até cair num evento de mesma profissão
        // Se a profissão for "Nenhuma" continue...
txtareaEnunciado.setText(ev0000.getEvento(eventoDado.getValorAtual() - 1).getEnunciado());
txtareaResultadoUm.setText(ev0000.getEvento(eventoDado.getValorAtual() - 1).getResultadoA());
txtareaResultadoDois.setText(ev0000.getEvento(eventoDado.getValorAtual() - 1).getResultadoB());
txtareaResultadoTres.setText(ev0000.getEvento(eventoDado.getValorAtual() - 1).getResultadoC());
    }//GEN-LAST:event_btnRolarJDoisActionPerformed
    private void btnEscolhaUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolhaUmActionPerformed
        if (barraMedidorDeExtincao.getValue() == 2) {
            extincao = true;
        }        
       if (extincao != true) {
            ev0000.getEvento(eventoDado.getValorAtual() - 1).setRespostaJogador(txtareaResultadoUm.getText());
            Resultado dialog = new Resultado(new javax.swing.JFrame(), true, ev0000.getEvento(eventoDado.getValorAtual() - 1).getMensagemResultadoA());
            dialog.setVisible(true);
            //se turno impar = jogador 1
            if ((Integer.parseInt(lblTurno.getText())) % 2 != 0) {
 jUm.ganharPontos(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorAmbientalA());
                jUm.receber(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorDinheiroA());
                if (jUm.getDinheiro() < 0) {
                    jUm.setEndividado(true);
                } else {
                    jUm.setEndividado(false);
                }
                jUm.finalizar();
                lblDinheiroJUm.setText(Integer.toString(jUm.getDinheiro()));               lblPAJUm.setText(Integer.toString(jUm.getPontosAmbientais()));
                lblPosicaoJUm.setText(Integer.toString(jUm.getPosicao()));
                lblVez.setText(jDois.getCor());
                btnRolarJDois.setEnabled(true);
            } // se turno par = jogador 2
            else {
 jDois.ganharPontos(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorAmbientalA());
                jDois.receber(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorDinheiroA());
                if (jDois.getDinheiro() < 0) {
                    jDois.setEndividado(true);
                } else {
                    jDois.setEndividado(false);
                }
                jDois.finalizar();                lblDinheiroJDois.setText(Integer.toString(jDois.getDinheiro()));
lblPAJDois.setText(Integer.toString(jDois.getPontosAmbientais()));
                lblPosicaoJUm.setText(Integer.toString(jDois.getPosicao()));
                lblVez.setText(jUm.getCor());
                btnRolarJUm.setEnabled(true);
            }
lblTurno.setText(Integer.toString(Integer.parseInt(lblTurno.getText()) + 1));
            btnEscolhaUm.setEnabled(false);
            btnEscolhaDois.setEnabled(false);
            btnEscolhaTres.setEnabled(false);
            if (Integer.parseInt(lblTurno.getText()) > 6) {
                finalizarJogo();
            }
        }
        if (ev0000.getEvento(eventoDado.getValorAtual() - 1).getGrave() == ev0000.getEvento(eventoDado.getValorAtual() - 1).getMensagemResultadoA())    barraMedidorDeExtincao.setValue(barraMedidorDeExtincao.getValue() + 1);
        }
        if (barraMedidorDeExtincao.getValue() == 2) {
            badEnd();
        }
        if (barraMedidorDeExtincao.getValue() == 2 && extincao) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnEscolhaUmActionPerformed
    private void btnEscolhaDoisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolhaDoisActionPerformed
        if (barraMedidorDeExtincao.getValue() == 2) {
            extincao = true;
        }
        if (extincao != true) {
            ev0000.getEvento(eventoDado.getValorAtual() - 1).setRespostaJogador(txtareaResultadoDois.getText());
            Resultado dialog = new Resultado(new javax.swing.JFrame(), true, ev0000.getEvento(eventoDado.getValorAtual() - 1).getMensagemResultadoB());
            dialog.setVisible(true);
            //se turno impar = jogador 1
            if ((Integer.parseInt(lblTurno.getText())) % 2 != 0) {
 jUm.ganharPontos(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorAmbientalB());
                jUm.receber(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorDinheiroB())
                if (jUm.getDinheiro() < 0) {
                    jUm.setEndividado(true);
                } else {
                    jUm.setEndividado(false);
                }
                jUm.finalizar();
                lblDinheiroJUm.setText(Integer.toString(jUm.getDinheiro()));               lblPAJUm.setText(Integer.toString(jUm.getPontosAmbientais()));
                lblPosicaoJUm.setText(Integer.toString(jUm.getPosicao()));
                lblVez.setText(jDois.getCor());
                btnRolarJDois.setEnabled(true);
            } // se turno par = jogador 2
            else {
 jDois.ganharPontos(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorAmbientalB());
                jDois.receber(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorDinheiroB());
                if (jDois.getDinheiro() < 0) {
                    jDois.setEndividado(true);
                } else {
                    jDois.setEndividado(false);
                }
                jDois.finalizar();
lblDinheiroJDois.setText(Integer.toString(jDois.getDinheiro())); lblPAJDois.setText(Integer.toString(jDois.getPontosAmbientais()));
                lblPosicaoJUm.setText(Integer.toString(jDois.getPosicao()));
                lblVez.setText(jUm.getCor());
                btnRolarJUm.setEnabled(true);
            }
lblTurno.setText(Integer.toString(Integer.parseInt(lblTurno.getText()) + 1));
            btnEscolhaUm.setEnabled(false);
            btnEscolhaDois.setEnabled(false);
            btnEscolhaTres.setEnabled(false);
            if (Integer.parseInt(lblTurno.getText()) > 6) {
                finalizarJogo();
            }
        }
        if (ev0000.getEvento(eventoDado.getValorAtual() - 1).getGrave() == ev0000.getEvento(eventoDado.getValorAtual() - 1).getMensagemResultadoB()) {
barraMedidorDeExtincao.setValue(barraMedidorDeExtincao.getValue() + 1);
        }
        if (barraMedidorDeExtincao.getValue() == 2) {
            badEnd();
        }
        if (barraMedidorDeExtincao.getValue() == 2 && extincao) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnEscolhaDoisActionPerformed
    private void btnEscolhaTresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolhaTresActionPerformed
        if (barraMedidorDeExtincao.getValue() == 2) {
            extincao = true;
        }
        if (extincao != true) {
            ev0000.getEvento(eventoDado.getValorAtual() - 1).setRespostaJogador(txtareaResultadoTres.getText());
            Resultado dialog = new Resultado(new javax.swing.JFrame(), true, ev0000.getEvento(eventoDado.getValorAtual() - 1).getMensagemResultadoC());
            dialog.setVisible(true);
            //se turno impar = jogador 1
            if ((Integer.parseInt(lblTurno.getText())) % 2 != 0) {
jUm.ganharPontos(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorAmbientalC());
                jUm.receber(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorDinheiroC());
                if (jUm.getDinheiro() < 0) {
                    jUm.setEndividado(true);
                } else {
                    jUm.setEndividado(false);
                }
                jUm.finalizar();
                lblDinheiroJUm.setText(Integer.toString(jUm.getDinheiro()));               lblPAJUm.setText(Integer.toString(jUm.getPontosAmbientais()));
                lblPosicaoJUm.setText(Integer.toString(jUm.getPosicao()));
                lblVez.setText(jDois.getCor());
                btnRolarJDois.setEnabled(true);
            } // se turno par = jogador 2
            else {
 jDois.ganharPontos(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorAmbientalC());
                jDois.receber(ev0000.getEvento(eventoDado.getValorAtual() - 1).getValorDinheiroC());
                if (jDois.getDinheiro() < 0) {
                    jDois.setEndividado(true);
                } else {
                    jDois.setEndividado(false);
                }
                jDois.finalizar();    lblDinheiroJDois.setText(Integer.toString(jDois.getDinheiro()));
lblPAJDois.setText(Integer.toString(jDois.getPontosAmbientais()));
                lblPosicaoJUm.setText(Integer.toString(jDois.getPosicao()));
                lblVez.setText(jUm.getCor());
                btnRolarJUm.setEnabled(true);
           }
     lblTurno.setText(Integer.toString(Integer.parseInt(lblTurno.getText()) + 1));
            btnEscolhaUm.setEnabled(false);
            btnEscolhaDois.setEnabled(false);
            btnEscolhaTres.setEnabled(false);
            if (Integer.parseInt(lblTurno.getText()) > 6) {
                finalizarJogo();
            }
        }
        if (ev0000.getEvento(eventoDado.getValorAtual() - 1).getGrave() == ev0000.getEvento(eventoDado.getValorAtual() - 1).getMensagemResultadoC()) {
            barraMedidorDeExtincao.setValue(barraMedidorDeExtincao.getValue() + 1);
        }
        if (barraMedidorDeExtincao.getValue() == 2) {
            badEnd();
        }
        if (barraMedidorDeExtincao.getValue() == 2 && extincao) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnEscolhaTresActionPerformed
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal(jUm, jDois).setVisible(true);
            }
        });
    }

    // Variáveis eventos possíveis:
    // Cientista:
    private Evento ev0000 = new Evento("Cientista",
            "Canudos demoram 500 anos para se decompor na natureza, e é prejudicial ao meio ambiente, a universidade precisa da sua influência como pesquisador para ajuda-los a melhorar o uso descontrolado do mesmo:",
            "Reinvidicar ações do governo para a conscientização do não uso de canudos plásticos e proibir estabelecimentos de fornece-los.",
            "Sugerir à universidade começar pequeno, e promover incentivos para seus alunos mudarem de comportamento.",
            "Compre o MÁXIMO de canudos que puder para outras pessoas não terem como usar",
            "Sua luta de conscientização contra o uso de canudinhos foi ouvida mas teve o efeito contrário ao meio ambiente, devivo ao alto preço de canudos sustentáveis, ao invés de fornece-los, agora comerciantes estão usando garrafas plásticas, ainda mais prejudiciais. Perca 10 pontos ambientais.",
            "A universidade, seguindo seus conselhos, começou com um programa de concientização para seus alunos e fizeram um projeto para coletar o máximo de canudos plásticos possíveis para levar para a reciclagem ec com o dinheiro arrecadado, usar para melhorias na universidade para os alunos. Ganhe 5 dinheiros e ganhe 10 pontos ambientais.",
            "Parabéns, você se esforçou pra comprar 50 dinheiros de canudos, perca 50 dinheiros e ganhe 1 ponto ambiental.",
            -10, 10, 1, 0, 5, -50, "0");
    private Evento ev0001 = new Evento("Cientista",
            "A principal usina hidrelétrica que abastece a cidade está quase sem água, e você é um dos especialistas que deverá propor uma solução para este problema.",
            "Fazer campanhas de conscientização e pedir para que as pessoas economizem água até que os reservatórios encham novamente.",
            "Avisar a população da situação.",
            "Propor um aumento no preço da energia elétrica até que os reservatórios encham novamente.",
            "Muitos não diminuiram o consumo, e isso fez com que os reservatórios atingissem níveis críticos de água. Perca 10 pontos ambientais e perca 5 dinheiros.",
            "A população ignorou. Perca 15 pontos ambientais",
            "Com o preço alto, as pessoas se viram obrigadas a diminuir o consumo da energia elétrica, o que acarretou na recuperação dos níveis de água, o que proporcionaram a volta dos preços normais. Ganhe 20 pontos ambientais e 5 dinheiros",
            -10, -15, 20, -5, 0, 5, "0");
    private Evento ev0002 = new Evento("Cientista",
            "A pesca ilegal está sendo praticada num lago próximo a sua universidade, você juntamente com a instituição se sente na obrigação de ajudar a combater isso, o que fará?",
            "Com a ajuda de voluntários próximos a área, proteger o local e denunciar os meliantes.",
            "Promover manifestações com a ajuda de alunos interessados na causa para forçar medidas do governo para regulamentar este lago.",
            "Se fantasie de algum herói que faz justiça pelas próprias mãos e aterrorize os meliantes.",
            "As pescas ilegais diminuiram após a prisão de alguns pescadores, outros com medo pararam com a prática. Ganhe 10 pontos ambientais ",
            "As manifestações funcionaram! O governo prometeu medidas para impedir que a pesca ilegal continue, porém, as regulamentações não surtiram efeito e as pescas continuam. Perca 10 pontos ambientais",
            "A vida não é um jogo de computador, você foi preso e sua família teve que pagar a fiança, perca 30 dinheiros.",
            10, -10, 0, 0, 0, -30, "0");
    private Evento ev0003 = new Evento("Empresário",
            "O governo proibiu o fornecimento de canudos plásticos para fins de preservação do meio ambiente, para não desobedecer a lei, terá que escolher:",
            "Fornecer canudos de papel ao invés dos de plástico.",
            "Deixar de fornecer canudos.",
            "Fornecer garrafas plásticas no lugar de canudos.",
            "Sua substituição fará um bem para o meio ambiente, porém, cada unidade de canudo de papel custa em média 10 vezes mais caro que o de plástico e você terá que arcar com os prejuízos. Perca 10 dinheiros e ganhe 10 pontos ambientais.",
            "Sua empresa agora está andando lado a lado com o meio ambiente, porém alguns clientes não aceitam beber seus sucos sem canudo. Perca 5 dinheiros e ganhe 15 pontos ambientais.",
            "Você está de acordo com a lei, porém garrafas plásticas são mais prejudiciais ao meio ambiente que canudos. Perca 10 pontos ambientais",
            10, 15, -10, -10, -5, 0, "0");
    private Evento ev0004 = new Evento("Empresário",
            "A principal usina hidrelétrica que abastece a cidade está quase sem água, e pede para que as pessoas e empresas economizem energia elétrica até que o nível dos reservatórios aumentem. Você, como dono de uma empresa, o que fará?",
            "Manter a produção no mesmo ritmo.",
            "Diminuir a produção.",
            "Aumentar a produção.",
            "Ao não poupar energia elétrica como muitos outros, os reservatórios estão em nível crítico e haverá mudanças nas bandeiras tarifárias e o aumento será de 42,8% até que os reservatórios se recuperem. Perca 10 dinheiros e perca 5 pontos ambientais.",
            "Ao poupar energia, a usina conseguiu se reestabilizar e não precisou de um aumento na energia elétrica para todos, embora perdeu clientes nesse período você acabou evitando um prejuizo maior no futuro. Ganhe 10 pontos ambientais e perca 5 dinheiros. ",
            "Você é muito mal e decidiu aumentar mais ainda a produção, por conta disso os reservatórios entraram em níveis críticos muito cedo e haverá mudanças nas bandeiras tarifárias com um aumento de 100% até que os reservatórios se recuperem. Perca 35 dinheiros e 20 pontos ambientais.",
            -5, 10, -20, -10, -5, -35, "0");
    private Evento ev0005 = new Evento("Empresário",
            "Ao procurar novos fornecedores de peixe para seu restaurante, acha um grupo que vende peixes em abundância além de um certo peixe raro que, além de barato, há uma grande procura devido sua raridade. Após contratar seus serviços, descobre que os mesmos praticam pesca ilegal e abusiva e este peixe está correndo risco de extinção. Sabendo disso, o que fará?",
            "Aproveitará a falta de concorrentes e investirá ainda mais para aumentar o lucro.",
            "Cortar relações com o fornecedor e denunciá-los.",
            "Finja que não sabe de nada e compre o necessário para não desconfiarem.",
            "Devido a pesca desenfreada e preços baixos, o lucro \"decolou\"! Seus concorrentes desconfiaram e investigaram, você e seus fornecedores foram descobertos e todos presos, você porém foi salvo pela sua família que lhe pagou a fiança de 30 dinheiros. Infelizmente não deu tempo de salvar a espécie rara de peixe, que por conta sua foi extinta. Perca 30 dinheiros, perca 30 pontos ambientais e medidor de extinção cresce em 1.",
            "Graças a sua ação, não só seus fornecedores foram presos, mas abriu as portas para maiores investigações no local e salvará muito mais peixes. Apesar de perder o fornecedor barato, o marketing \"boca-a-boca\" acabou compensando, pessoas ao saber de sua ação ao denuncia-los, criaram uma simpatia por seu restaurante e foram conhece-lo. Ganhe 5 dinheiros, ganhe 15 pontos ambientais.",
            "Um outro empresário denuncia o fornecedor e você acaba que lucrando nada além de quase matar uma espécie de peixes raros. Perca 10 pontos ambientais.",
            -30, 15, -10, -30, -5, 0, "1");
    private Evento ev0006 = new Evento("Desempregado",
            "Em mais uma ida ao restaurante que você gosta, ao pedir seu refrigerante com gelo e limão, o garçom não te deu canudo, o que você faz?",
            "Nada, consigo beber meu refrigerante diretamente no copo.",
            "Peço meu canudo.",
            "Pergunto para o garçom o motivo de não ter canudo desta vez.",
            "Muito bem, ao beber direto do copo, menos 1 canudo irá para o mar e isso pode ter evitado uma morte. Ganhe 5 pontos ambientais",
            "Seu canudo foi parar no mar, e o mesmo acabou entalado na narina de uma tartaruga que acabou falecendo. Perca 5 pontos ambientais",
            "\"Pois 80% de todo lixo presente no oceano é feito de plástico\", como o canundinho é muito pequeno ele passa por qualquer filtro de reciclagem sendo então inútil após o uso.' Com essa explicação você se conscientiza e para de pedir canudinhos em outros lugares. Ganhe 10 pontos ambientais.",
            5, -5, 10, 0, 0, 0, "0");
    private Evento ev0007 = new Evento("Desempregado",
            "A principal usina hidrelétrica que abastece a cidade está quase sem água, e pede para que as pessoas e empresas economizem energia elétrica até que o nível dos reservatórios aumentem. O que fará em casa?",
            "Manter tudo normalmente, os outros economizam por mim.",
            "Economizar.",
            "Ir com seus pais ficar por um tempo com sua família em outro estado por um mês",
            "Muitos pensaram igual a você, e como resultado os reservatórios estão em nível crítico e haverá mudanças nas bandeiras tarifárias, o aumento será de 42,8% até que os reservatórios se recuperem. Perca 10 dinheiros e perca 5 pontos ambientais.",
            "Ao poupar energia, a usina conseguiu se reestabilizar e não precisou de um aumento na energia elétrica para todos, e você acabou evitando um prejuizo maior no futuro. Ganhe 10 pontos ambientais.",
            "Embora você economizou indiretamente isso contribuiu para que o reservatório enchesse rapidamente, mas sua viagem lhe custou algo. Ganhe 15 pontos ambientas e perca 5 dinheiros",
            -5, 10, 15, -10, 0, -5, "0");
    private Evento ev0008 = new Evento("Desempregado",
            "Uma oportunidade de emprego num navio petroleiro surge e você aceita sem hesitar. Em sua primeira viagem já percebe diversas irregularidades e devido a isso decide procurar outro emprego. No entanto, você não para de se perguntar: Devo denunciar?",
            "Não.",
            "Sim.",
            "Pedir suborno para não denunciar.",
            "Um desastre ocorreu. Devido a falta de manutenção no navio, o mesmo acaba explodindo e em meio as chamas afundou ao lago de Xangai. Onze dias após o ocorrido as manchas de óleo já cobrem a área de 101km (equivalente ao tamanho de Paris) e preocupa ambientalistas que consideram a área como uma das mais ricas em biodiversidade do mundo. Perca 10 pontos ambientais e medidor de extinção cresce em 1.",
            "Sua denuncia foi ouvida e graças a ela foi possível identificar uma série de irregularidades no navio e os responsáveis pela regulamentação serão devidamente punidos. Especialistas afirmam: Um grande desastre poderia ter ocorrido caso esse navio continuasse no mar, por conta disso te recompensaram com uma quantia de dinheiro. Ganhe 20 pontos ambientais e 5 dinheiros.",
            "A policia descobriu as irregularidades e te deduraram, para não ir para cadeia pagou 95% do que tinha recebido dos subornos. Ganhe 5 dinheiros",
            -10, 20, 0, 0, 5, 5, "1");
    //Fim dos eventos exclusivos
    //Eventos aleatórios
    private Evento ev0009 = new Evento("Nenhuma",
            "Você está no banho e deu vontade de fazer xixi, o que fazer?",
            "Saio do banho e vou para a privada",
            "Faço no chuveiro",
            "Vai ser rápido, deixo o chuveiro ligado enquanto vou para privada ",
            "Pode não parecer, mas essa ação a longo prazo causa um impacto não só financeiro, mas para o meio ambiente. Um adulto gasta em média 49 litros com descargas e no chuveiro você pode diminuir essa quantidade de água desperdiçada. Perca 5 pontos ambientais.",
            "Muito bem, sabia que ao fazer xixi no banheiro, evitando uma descarga desnecessária resulta, em média, na economia de 4380 litros de água potável por ano? Ganhe 5 pontos ambientais.",
            "Além de dar descarga, a água caindo desnecessária do chuveiro fez que demorasse um pouco mais pra tomar banho assim desperdiçando água. Perca 10 pontos ambientais.",
            -5, 5, -10, 0, 0, 0, "0");   
    private Evento ev0010 = new Evento("Nenhuma",
            "Você vai ao banheiro escovar os dentes. Pega escova, passa a pasta de dente, abre a torneira, molha um pouco... E depois?",
            "Escovo os dentes e fecho a torneira.",
            "Fecho a torneira e escovo os dentes.",
            "Escovo os dentes e saio do banheiro.",
            "Apenas 1% da água do planeta é própria para o consumo humano. Algo pequeno como escovar os dentes com a torneira aberta diariamente, pode acabar desperdiçando em média 16 mil litros de água por ano. Perca 5 pontos ambientais.",
            "Opção correta, uma pequena ação como esta pode economizar até 46 litros de água por dia. Ganhe 5 pontos ambientais.",
            "Você só lembrou uma hora depois que deixou a torneira aberta e correu para fechar, além de desperdiçar muita água sua conta veio mais cara. Perca 10 pontos ambientais e 5 dinheiros.",
            -5, 5, -10, 0, 0, -5, "0");
    private Evento ev0011 = new Evento("Nenhuma",
            "Você acabou de comer um salgadinho e está na rua, não há nenhum lixo em volta, o você fará?",
            "Jogar a embalagem no chão.",
            "Guardar a embalagem até achar um lixo.",
            "Re-usar a embalagem para guardar outras coisas.",
            "Foi apenas uma embalagem, porém, mais pessoas fizeram como você, o lixo se acumulou na rua e foi parar nos bueiros causando uma grande enchente num dia chuvoso, por sorte só houve danos financeiros. Perca 5 pontos ambientais",
            "Muito bem! Você colaborou para que os bueiros continuassem livres de lixo. Ganhe 5 pontos ambientais.",
            "Pesquisando na internet você descobre um jeito de fazer um estojo escolar com a embalagem presenteando o seu primo. Ganhe 5 pontos ambientais.",
            -5, 5, 5, 0, 0, 0, "0");
    private Evento ev0012 = new Evento("Nenhuma",
            "Numa visita a sua vó, ela resolve fazer uma janta especial para comemorar o reencontro, e enquanto está tudo no fogo descansa. Curioso, você vai ver o que ela está preparando e vê as panelas destampadas, depois da bisbilhotada você:",
            "Tampo as panelas e volto para a sala.",
            "Volto para a sala.",
            "Deixo no fogo baixo",
            "Algo simples como tampar as panelas enquanto cozinha gera uma economia de 70% do gás a ser utilizado, além de ajudar o meio ambiente você economizou o gás da sua vó. Ganhe 5 dinheiros e ganhe 5 pontos ambientais.",
            "Cozinhar com as panelas destampadas gasta mais gás e por conseguinte, prejudica o meio ambiente e o \"bolso\". O gás acabou no meio da preparação da janta, você vai embora com fome e ainda fará a gentileza de comprar outro gás para sua vó. Perca 5 dinheiros e perca 5 pontos ambientais.",
            "Embora você deixou as panelas destampadas, o fogo baixo segurou o consumo em troca de mais tempo pra cozinhar. Não ganhe nada.",
            5, -5, 0, 5, -5, 0, "0");
    //Fim dos eventos
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barraMedidorDeExtincao;
    private javax.swing.JButton btnEscolhaDois;
    private javax.swing.JButton btnEscolhaTres;
    private javax.swing.JButton btnEscolhaUm;
    private javax.swing.JButton btnRolarJDois;
    private javax.swing.JButton btnRolarJUm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCorJDois;
    private javax.swing.JLabel lblCorJUm;
    private javax.swing.JLabel lblDinheiroJDois;
    private javax.swing.JLabel lblDinheiroJUm;
    private javax.swing.JLabel lblPAJDois;
    private javax.swing.JLabel lblPAJUm;
    private javax.swing.JLabel lblPosicaoJDois;
    private javax.swing.JLabel lblPosicaoJUm;
    private javax.swing.JLabel lblProfissaoJDois;
    private javax.swing.JLabel lblProfissaoJUm;
    private javax.swing.JLabel lblQntdEmpresasJDois;
    private javax.swing.JLabel lblQntdEmpresasJUm;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JLabel lblValorDado;
    private javax.swing.JLabel lblVez;
    private javax.swing.JPanel painelInformacoes;
    private javax.swing.JPanel painelJogadorDois;
    private javax.swing.JPanel painelJogadorUm;
    private javax.swing.JPanel painelOpcoes;
    private javax.swing.JPanel painelQuestoes;
    private javax.swing.JTextArea txtareaEnunciado;
    private javax.swing.JTextArea txtareaResultadoDois;
    private javax.swing.JTextArea txtareaResultadoTres;
    private javax.swing.JTextArea txtareaResultadoUm;
    // End of variables declaration//GEN-END:variables
}
