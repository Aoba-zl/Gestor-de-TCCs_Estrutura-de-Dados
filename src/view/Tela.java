package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JButton btnBuscarAssunto;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}



	
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 375);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pAluno = new JPanel();
		tabbedPane.addTab("Alunos", null, pAluno, null);
		pAluno.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Dados Aluno");
		lblNewLabel.setBounds(30, 11, 100, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBackground(UIManager.getColor("Button.disabledShadow"));
		pAluno.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RA:");
		lblNewLabel_1.setBounds(105, 118, 68, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pAluno.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome:");
		lblNewLabel_1_1.setBounds(105, 143, 68, 14);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pAluno.add(lblNewLabel_1_1);
		
		JButton btnSalvaAluno = new JButton("Salvar");
		btnSalvaAluno.setBounds(459, 257, 100, 30);
		pAluno.add(btnSalvaAluno);
		
		JFormattedTextField tfRA = new JFormattedTextField();
		tfRA.setBounds(158, 117, 144, 20);
		tfRA.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					tfRA.setEditable(true);
				}
				else
				{
					tfRA.setEditable(false);
				}
			}
		});
		pAluno.add(tfRA);
		
		JFormattedTextField tfNome = new JFormattedTextField();
		tfNome.setBounds(158, 143, 144, 20);
		tfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				char c = e.getKeyChar();
				if (Character.isLetter(c) || Character.isWhitespace(c) || Character.isISOControl(c))
				{
					tfNome.setEditable(true);
				}
				else
				{
					tfNome.setEditable(false);					
				}
			}
		});
		pAluno.add(tfNome);
		
		JButton btnBuscarAluno = new JButton("Buscar");
		btnBuscarAluno.setBounds(321, 116, 76, 23);
		pAluno.add(btnBuscarAluno);
		
		JButton btnExcluirAluno = new JButton("Excluir");
		btnExcluirAluno.setBounds(349, 257, 100, 30);
		pAluno.add(btnExcluirAluno);
		
		JLabel lblMensagemAluno = new JLabel("");
		lblMensagemAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemAluno.setBounds(300, 21, 116, 57);
		pAluno.add(lblMensagemAluno);
		
		JPanel pGrupo = new JPanel();
		tabbedPane.addTab("Grupos", null, pGrupo, null);
		pGrupo.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_2 = new JTabbedPane(JTabbedPane.TOP);
		pGrupo.add(tabbedPane_2, BorderLayout.CENTER);
		
		JPanel pCadGrupo = new JPanel();
		tabbedPane_2.addTab("Cadastrar/Atualizar dados do grupo", null, pCadGrupo, null);
		pCadGrupo.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Dados Grupo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(30, 11, 100, 20);
		pCadGrupo.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("RA:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(30, 57, 43, 14);
		pCadGrupo.add(lblNewLabel_1_2);
		
		JFormattedTextField tfRA_1 = new JFormattedTextField();
		tfRA_1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					tfRA_1.setEditable(true);
				}
				else
				{
					tfRA_1.setEditable(false);
				}
			}
		});
		tfRA_1.setBounds(64, 57, 100, 20);
		pCadGrupo.add(tfRA_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("RA:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(30, 83, 43, 14);
		pCadGrupo.add(lblNewLabel_1_2_1);
		
		JFormattedTextField tfRA_2 = new JFormattedTextField();
		tfRA_2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					tfRA_2.setEditable(true);
				}
				else
				{
					tfRA_2.setEditable(false);
				}
			}
		});
		tfRA_2.setBounds(64, 83, 100, 20);
		pCadGrupo.add(tfRA_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("RA:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(30, 109, 43, 14);
		pCadGrupo.add(lblNewLabel_1_2_2);
		
		JFormattedTextField tfRA_3 = new JFormattedTextField();
		tfRA_3.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					tfRA_3.setEditable(true);
				}
				else
				{
					tfRA_3.setEditable(false);
				}
			}
		});
		tfRA_3.setBounds(64, 109, 100, 20);
		pCadGrupo.add(tfRA_3);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("RA:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(30, 135, 43, 14);
		pCadGrupo.add(lblNewLabel_1_2_3);
		
		JFormattedTextField tfRA_4 = new JFormattedTextField();
		tfRA_4.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					tfRA_4.setEditable(true);
				}
				else
				{
					tfRA_4.setEditable(false);
				}
			}
		});
		tfRA_4.setBounds(64, 135, 100, 20);
		pCadGrupo.add(tfRA_4);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Código:");
		lblNewLabel_1_2_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4.setBounds(294, 58, 51, 16);
		pCadGrupo.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Tema:");
		lblNewLabel_1_2_4_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_1.setBounds(294, 83, 51, 16);
		pCadGrupo.add(lblNewLabel_1_2_4_1);
		
		JLabel lblNewLabel_1_2_4_2 = new JLabel("Área");
		lblNewLabel_1_2_4_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_2.setBounds(294, 110, 51, 16);
		pCadGrupo.add(lblNewLabel_1_2_4_2);
		
		JLabel lblNewLabel_1_2_4_3 = new JLabel("SubÁrea");
		lblNewLabel_1_2_4_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_3.setBounds(294, 135, 51, 16);
		pCadGrupo.add(lblNewLabel_1_2_4_3);
		
		JFormattedTextField tfCodGrupo = new JFormattedTextField();
		tfCodGrupo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					tfCodGrupo.setEditable(true);
				}
				else
				{
					tfCodGrupo.setEditable(false);
				}
			}
		});
		tfCodGrupo.setBounds(355, 55, 100, 20);
		pCadGrupo.add(tfCodGrupo);
		
		JFormattedTextField tfTema = new JFormattedTextField();
		tfTema.setBounds(355, 80, 100, 20);
		pCadGrupo.add(tfTema);
		
		JComboBox cbArea = new JComboBox();
		cbArea.setBounds(355, 106, 100, 20);
		pCadGrupo.add(cbArea);
		
		JComboBox cbSubArea = new JComboBox();
		cbSubArea.setBounds(355, 131, 100, 20);
		pCadGrupo.add(cbSubArea);
		
		JButton btnSalvaGrupos = new JButton("Salvar");
		btnSalvaGrupos.setBounds(454, 229, 100, 30);
		pCadGrupo.add(btnSalvaGrupos);
		
		JButton btnBuscarRA1 = new JButton("Buscar");
		btnBuscarRA1.setBounds(174, 55, 79, 23);
		pCadGrupo.add(btnBuscarRA1);
		
		JButton btnBuscarRA2 = new JButton("Buscar");
		btnBuscarRA2.setBounds(174, 81, 79, 23);
		pCadGrupo.add(btnBuscarRA2);
		
		JButton btnBuscarRA3 = new JButton("Buscar");
		btnBuscarRA3.setBounds(174, 107, 79, 23);
		pCadGrupo.add(btnBuscarRA3);
		
		JButton btnBuscarRA4 = new JButton("Buscar");
		btnBuscarRA4.setBounds(174, 133, 79, 23);
		pCadGrupo.add(btnBuscarRA4);
		
		JButton btnBuscarCodGrupo = new JButton("Buscar");
		btnBuscarCodGrupo.setBounds(465, 55, 79, 23);
		pCadGrupo.add(btnBuscarCodGrupo);
		
		JPanel pConsultarGrupos = new JPanel();
		tabbedPane_2.addTab("Consultar Grupos Cadastrados", null, pConsultarGrupos, null);
		pConsultarGrupos.setLayout(null);
		
		JLabel lblGrupos = new JLabel("Grupos");
		lblGrupos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGrupos.setBackground(Color.WHITE);
		lblGrupos.setBounds(30, 11, 100, 20);
		pConsultarGrupos.add(lblGrupos);
		
		JLabel lblNewLabel_1_2_4_2_1 = new JLabel("Área:");
		lblNewLabel_1_2_4_2_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_2_1.setBounds(30, 50, 51, 16);
		pConsultarGrupos.add(lblNewLabel_1_2_4_2_1);
		
		JComboBox cbAreaConsulta = new JComboBox();
		cbAreaConsulta.setBounds(91, 48, 100, 20);
		pConsultarGrupos.add(cbAreaConsulta);
		
		JLabel lblNewLabel_1_2_4_2_1_1 = new JLabel("SubÁrea");
		lblNewLabel_1_2_4_2_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_2_1_1.setBounds(211, 50, 66, 16);
		pConsultarGrupos.add(lblNewLabel_1_2_4_2_1_1);
		
		JComboBox cbSubAreaConsulta = new JComboBox();
		cbSubAreaConsulta.setBounds(287, 49, 100, 20);
		pConsultarGrupos.add(cbSubAreaConsulta);
		
		JButton btnPesquisarGrupos = new JButton("Pesquisar");
		btnPesquisarGrupos.setBounds(334, 123, 100, 30);
		pConsultarGrupos.add(btnPesquisarGrupos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(30, 98, 267, 86);
		pConsultarGrupos.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Tema", "\u00DAltima Reuniao"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(78);
		table.getColumnModel().getColumn(2).setPreferredWidth(83);
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
		
		JPanel pOrientacoes = new JPanel();
		tabbedPane.addTab("Orientações", null, pOrientacoes, null);
		pOrientacoes.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane_3 = new JTabbedPane(JTabbedPane.TOP);
		pOrientacoes.add(tabbedPane_3, BorderLayout.CENTER);
		
		JPanel pMarcaReuniao = new JPanel();
		tabbedPane_3.addTab("Marcar Reunião", null, pMarcaReuniao, null);
		pMarcaReuniao.setLayout(null);
		
		JLabel lblMarcarReuniao = new JLabel("Marcar Reunião");
		lblMarcarReuniao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMarcarReuniao.setBackground(Color.WHITE);
		lblMarcarReuniao.setBounds(30, 11, 127, 20);
		pMarcaReuniao.add(lblMarcarReuniao);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Código do grupo:");
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5.setBounds(55, 64, 127, 20);
		pMarcaReuniao.add(lblNewLabel_1_2_5);
		
		JFormattedTextField ftCodGrupoReuniao = new JFormattedTextField();
		ftCodGrupoReuniao.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					ftCodGrupoReuniao.setEditable(true);
				}
				else
				{
					ftCodGrupoReuniao.setEditable(false);
				}
			}
		});
		ftCodGrupoReuniao.setBounds(192, 66, 119, 20);
		pMarcaReuniao.add(ftCodGrupoReuniao);
		
		JLabel lblNewLabel_1_2_5_1 = new JLabel("Assunto da reunião:");
		lblNewLabel_1_2_5_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5_1.setBounds(55, 95, 127, 20);
		pMarcaReuniao.add(lblNewLabel_1_2_5_1);
		
		JFormattedTextField ftAssuntoReuniao = new JFormattedTextField();
		ftAssuntoReuniao.setBounds(192, 97, 119, 20);
		pMarcaReuniao.add(ftAssuntoReuniao);
		
		JLabel lblNewLabel_1_2_5_2 = new JLabel("Data:");
		lblNewLabel_1_2_5_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5_2.setBounds(55, 126, 127, 20);
		pMarcaReuniao.add(lblNewLabel_1_2_5_2);
		
		JFormattedTextField ftDataReuniao = new JFormattedTextField();
		ftDataReuniao.setBounds(192, 128, 119, 20);
		pMarcaReuniao.add(ftDataReuniao);
		
		JButton btnSalvaReuniao = new JButton("Salvar");
		btnSalvaReuniao.setBounds(330, 160, 100, 30);
		pMarcaReuniao.add(btnSalvaReuniao);
		
		JButton btnBuscarCodReuniao = new JButton("Buscar");
		btnBuscarCodReuniao.setBounds(321, 65, 79, 23);
		pMarcaReuniao.add(btnBuscarCodReuniao);
		
		JPanel pAddPassos = new JPanel();
		tabbedPane_3.addTab("Adicionar Passos", null, pAddPassos, null);
		pAddPassos.setLayout(null);
		
		JLabel lblDefinirPassos = new JLabel("Definir Passos");
		lblDefinirPassos.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDefinirPassos.setBackground(Color.WHITE);
		lblDefinirPassos.setBounds(30, 11, 108, 20);
		pAddPassos.add(lblDefinirPassos);
		
		JLabel lblNewLabel_1_2_5_3 = new JLabel("Código do grupo:");
		lblNewLabel_1_2_5_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5_3.setBounds(55, 50, 127, 20);
		pAddPassos.add(lblNewLabel_1_2_5_3);
		
		JLabel lblNewLabel_1_2_5_3_1 = new JLabel("Assunto da Reunião:");
		lblNewLabel_1_2_5_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5_3_1.setBounds(55, 81, 127, 20);
		pAddPassos.add(lblNewLabel_1_2_5_3_1);
		
		JLabel lblNewLabel_1_2_5_3_2 = new JLabel("Passos:");
		lblNewLabel_1_2_5_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5_3_2.setBounds(55, 112, 61, 20);
		pAddPassos.add(lblNewLabel_1_2_5_3_2);
		
		JFormattedTextField ftCodGrupoPassos = new JFormattedTextField();
		ftCodGrupoPassos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					ftCodGrupoPassos.setEditable(true);
				}
				else
				{
					ftCodGrupoPassos.setEditable(false);
				}
			}
		});
		ftCodGrupoPassos.setBounds(192, 52, 108, 18);
		pAddPassos.add(ftCodGrupoPassos);
		
		JFormattedTextField ftAssuntoReuniaoPassos = new JFormattedTextField();
		ftAssuntoReuniaoPassos.setBounds(192, 83, 108, 18);
		pAddPassos.add(ftAssuntoReuniaoPassos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(126, 112, 174, 72);
		pAddPassos.add(scrollPane);
		
		JTextArea taPassos = new JTextArea();
		taPassos.setLineWrap(true);
		scrollPane.setViewportView(taPassos);
		
		JButton btnSalvaPassos = new JButton("Salvar");
		btnSalvaPassos.setBounds(330, 160, 100, 30);
		pAddPassos.add(btnSalvaPassos);
		
		JButton btnBuscarCodPassos = new JButton("Buscar");
		btnBuscarCodPassos.setBounds(310, 51, 79, 23);
		pAddPassos.add(btnBuscarCodPassos);
		
		btnBuscarAssunto = new JButton("Buscar");
		btnBuscarAssunto.setBounds(310, 82, 79, 23);
		pAddPassos.add(btnBuscarAssunto);
		
		JPanel pReuniaoMarcado = new JPanel();
		tabbedPane_3.addTab("Reuniões marcadas", null, pReuniaoMarcado, null);
		pReuniaoMarcado.setLayout(null);
		
		JLabel lblDefinirPassos_1 = new JLabel("Reunião");
		lblDefinirPassos_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDefinirPassos_1.setBackground(Color.WHITE);
		lblDefinirPassos_1.setBounds(30, 11, 74, 20);
		pReuniaoMarcado.add(lblDefinirPassos_1);
		
		JLabel lblNewLabel_1_2_5_3_3 = new JLabel("Pesquisa:");
		lblNewLabel_1_2_5_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_5_3_3.setBounds(82, 58, 64, 20);
		pReuniaoMarcado.add(lblNewLabel_1_2_5_3_3);
		
		JFormattedTextField ftPesquisarReuniao = new JFormattedTextField();
		ftPesquisarReuniao.setBounds(156, 60, 121, 18);
		pReuniaoMarcado.add(ftPesquisarReuniao);
		
		JButton btnPesquisarReuniao = new JButton("Pesquisar");
		btnPesquisarReuniao.setBounds(286, 55, 100, 30);
		pReuniaoMarcado.add(btnPesquisarReuniao);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_2.setBounds(20, 89, 403, 95);
		pReuniaoMarcado.add(scrollPane_2);
		
		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Tema", "Data", "C\u00F3d. Grupo", "Conclu\u00EDda"
			}
		));
		table_1.getColumnModel().getColumn(3).setPreferredWidth(64);
	}
}
