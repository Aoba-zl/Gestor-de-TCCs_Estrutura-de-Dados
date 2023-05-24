package view;

import br.fatec.ListString.ListString;
import telaController.*;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import br.fatec.ListString.ListString;
import telaController.*;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.Font;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Date;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTable tableGrupoCad;
	private JTable tableReuniaoMarcada;
	private ListString[] listaSubArea;
	
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
		
		JFormattedTextField ftRA_1 = new JFormattedTextField();
		ftRA_1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					ftRA_1.setEditable(true);
				}
				else
				{
					ftRA_1.setEditable(false);
				}
			}
		});
		ftRA_1.setBounds(64, 57, 100, 20);
		pCadGrupo.add(ftRA_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("RA:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_1.setBounds(30, 83, 43, 14);
		pCadGrupo.add(lblNewLabel_1_2_1);
		
		JFormattedTextField ftRA_2 = new JFormattedTextField();
		ftRA_2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					ftRA_2.setEditable(true);
				}
				else
				{
					ftRA_2.setEditable(false);
				}
			}
		});
		ftRA_2.setBounds(64, 83, 100, 20);
		pCadGrupo.add(ftRA_2);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("RA:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_2.setBounds(30, 109, 43, 14);
		pCadGrupo.add(lblNewLabel_1_2_2);
		
		JFormattedTextField ftRA_3 = new JFormattedTextField();
		ftRA_3.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					ftRA_3.setEditable(true);
				}
				else
				{
					ftRA_3.setEditable(false);
				}
			}
		});
		ftRA_3.setBounds(64, 109, 100, 20);
		pCadGrupo.add(ftRA_3);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("RA:");
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_3.setBounds(30, 135, 43, 14);
		pCadGrupo.add(lblNewLabel_1_2_3);
		
		JFormattedTextField ftRA_4 = new JFormattedTextField();
		ftRA_4.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					ftRA_4.setEditable(true);
				}
				else
				{
					ftRA_4.setEditable(false);
				}
			}
		});
		ftRA_4.setBounds(64, 135, 100, 20);
		pCadGrupo.add(ftRA_4);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Código:");
		lblNewLabel_1_2_4.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4.setBounds(280, 60, 51, 16);
		pCadGrupo.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_4_1 = new JLabel("Tema:");
		lblNewLabel_1_2_4_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_1.setBounds(280, 85, 51, 16);
		pCadGrupo.add(lblNewLabel_1_2_4_1);
		
		JLabel lblNewLabel_1_2_4_2 = new JLabel("Área");
		lblNewLabel_1_2_4_2.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_2.setBounds(280, 112, 51, 16);
		pCadGrupo.add(lblNewLabel_1_2_4_2);
		
		JLabel lblNewLabel_1_2_4_3 = new JLabel("SubÁrea");
		lblNewLabel_1_2_4_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_3.setBounds(280, 137, 51, 16);
		pCadGrupo.add(lblNewLabel_1_2_4_3);
		
		JFormattedTextField ftCodGrupo = new JFormattedTextField();
		ftCodGrupo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) 
			{
				char i = e.getKeyChar();
				if (!Character.isLetter(i) || Character.isWhitespace(i) || Character.isISOControl(i))
				{
					ftCodGrupo.setEditable(true);
				}
				else
				{
					ftCodGrupo.setEditable(false);
				}
			}
		});
		ftCodGrupo.setBounds(341, 57, 100, 20);
		pCadGrupo.add(ftCodGrupo);
		
		JFormattedTextField ftTema = new JFormattedTextField();
		ftTema.setBounds(341, 82, 213, 20);
		pCadGrupo.add(ftTema);
		
		
		ComboBoxController cbControll = new ComboBoxController(listaSubArea);
		String[] area = {};
		try {
			area = cbControll.area();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		listaSubArea = cbControll.pegaList();

		
		JComboBox<String> cbArea = new JComboBox<String>();
		cbArea.setModel(new DefaultComboBoxModel<String>(area));
		cbArea.setSelectedIndex(0);
		cbArea.setBounds(341, 108, 213, 20);
		pCadGrupo.add(cbArea);
		
		JComboBox<String> cbSubArea = new JComboBox<String>();
		cbSubArea.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbSubArea.setBounds(341, 133, 213, 20);
		pCadGrupo.add(cbSubArea);
		
		JButton btnSalvaAlteraGrupos = new JButton("Salvar");
		btnSalvaAlteraGrupos.setBounds(442, 217, 100, 30);
		pCadGrupo.add(btnSalvaAlteraGrupos);
		
		JButton btnBuscarRA1 = new JButton("Buscar");
		btnBuscarRA1.setBounds(191, 57, 79, 23);
		pCadGrupo.add(btnBuscarRA1);
		
		JButton btnBuscarRA2 = new JButton("Buscar");
		btnBuscarRA2.setBounds(191, 83, 79, 23);
		pCadGrupo.add(btnBuscarRA2);
		
		JButton btnBuscarRA3 = new JButton("Buscar");
		btnBuscarRA3.setBounds(191, 109, 79, 23);
		pCadGrupo.add(btnBuscarRA3);
		
		JButton btnBuscarRA4 = new JButton("Buscar");
		btnBuscarRA4.setBounds(191, 135, 79, 23);
		pCadGrupo.add(btnBuscarRA4);
		
		JButton btnBuscarCodGrupo = new JButton("Buscar");
		btnBuscarCodGrupo.setBounds(463, 57, 79, 23);
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
		
		JComboBox<String> cbAreaConsulta = new JComboBox<String>();
		cbAreaConsulta.setModel(new DefaultComboBoxModel<String>(area));
		cbAreaConsulta.setBounds(75, 49, 189, 20);
		pConsultarGrupos.add(cbAreaConsulta);
		
		JLabel lblNewLabel_1_2_4_2_1_1 = new JLabel("SubÁrea");
		lblNewLabel_1_2_4_2_1_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_1_2_4_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2_4_2_1_1.setBounds(274, 50, 66, 16);
		pConsultarGrupos.add(lblNewLabel_1_2_4_2_1_1);
		
		JComboBox<String> cbSubAreaConsulta = new JComboBox<String>();
		cbSubAreaConsulta.setModel(new DefaultComboBoxModel<String>(new String[] {""}));
		cbSubAreaConsulta.setBounds(334, 49, 205, 20);
		pConsultarGrupos.add(cbSubAreaConsulta);
		
		JButton btnPesquisarGrupos = new JButton("Pesquisar");
		btnPesquisarGrupos.setBounds(334, 123, 100, 30);
		pConsultarGrupos.add(btnPesquisarGrupos);
		
		JScrollPane spGrupoCad = new JScrollPane();
		spGrupoCad.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spGrupoCad.setBounds(30, 98, 267, 86);
		pConsultarGrupos.add(spGrupoCad);
		
		tableGrupoCad = new JTable();
		spGrupoCad.setViewportView(tableGrupoCad);
		tableGrupoCad.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"C\u00F3digo", "Tema", "\u00DAltima Reuniao"
			}
		));
		tableGrupoCad.getColumnModel().getColumn(1).setPreferredWidth(78);
		tableGrupoCad.getColumnModel().getColumn(2).setPreferredWidth(83);
		tableGrupoCad.setCellSelectionEnabled(true);
		tableGrupoCad.setColumnSelectionAllowed(true);
		
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
		
		JLabel lblMensagemReuniao = new JLabel("aaaaaaaaaaaaaaaaaaaaaaaaaa");
		lblMensagemReuniao.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemReuniao.setBounds(410, 11, 132, 75);
		pMarcaReuniao.add(lblMensagemReuniao);

		// TODO add passos <
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

		JButton btnSalvarPassos = new JButton("Salvar");
		btnSalvarPassos.setBounds(330, 160, 100, 30);
		btnSalvarPassos.setEnabled(false);
		pAddPassos.add(btnSalvarPassos);

		JButton btnBuscarCodPassos = new JButton("Buscar");
		btnBuscarCodPassos.setBounds(310, 51, 79, 23);
		pAddPassos.add(btnBuscarCodPassos);

//        JButton btnBuscarAssunto = new JButton("Buscar");
//        btnBuscarAssunto.setBounds(310, 82, 79, 23);
//        pAddPassos.add(btnBuscarAssunto);

		JCheckBox checkBoxStatus_Passos = new JCheckBox("Trabalho concluido");
		checkBoxStatus_Passos.setBounds(19, 232, 243, 23);
		pAddPassos.add(checkBoxStatus_Passos);

		JLabel lblMensagemDefinirPassos = new JLabel("");
		lblMensagemDefinirPassos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemDefinirPassos.setBounds(411, 0, 132, 75);
		pAddPassos.add(lblMensagemDefinirPassos);

		PassosBtnBuscaGrupo btnBuscaGrupo =
				new PassosBtnBuscaGrupo(lblMensagemDefinirPassos, ftCodGrupoPassos,
						ftAssuntoReuniaoPassos, taPassos, btnSalvarPassos);
		PassosBtnSalvarPassos btnSalvarPassosCtrl =
				new PassosBtnSalvarPassos(lblMensagemDefinirPassos, ftCodGrupoPassos,
						ftAssuntoReuniaoPassos, taPassos, checkBoxStatus_Passos);
		btnBuscarCodPassos.addActionListener(btnBuscaGrupo);
		btnSalvarPassos.addActionListener(btnSalvarPassosCtrl);
		// TODO add passos >
		JPanel pReuniaoMarcado = new JPanel();
		tabbedPane_3.addTab("Reuniões marcadas", null, pReuniaoMarcado, null);
		pReuniaoMarcado.setLayout(null);
		
		JLabel lblReuniao = new JLabel("Reunião");
		lblReuniao.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblReuniao.setBackground(Color.WHITE);
		lblReuniao.setBounds(30, 11, 74, 20);
		pReuniaoMarcado.add(lblReuniao);
		
		JLabel lblCodGrupoReunMarcada = new JLabel("Código do grupo:");
		lblCodGrupoReunMarcada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodGrupoReunMarcada.setBounds(37, 58, 109, 20);
		pReuniaoMarcado.add(lblCodGrupoReunMarcada);
		
		JFormattedTextField ftPesquisarReuniao = new JFormattedTextField();
		ftPesquisarReuniao.setBounds(156, 60, 121, 18);
		pReuniaoMarcado.add(ftPesquisarReuniao);
		
		JButton btnPesquisarReuniao = new JButton("Pesquisar");
		btnPesquisarReuniao.setBounds(286, 55, 100, 30);
		pReuniaoMarcado.add(btnPesquisarReuniao);
		
		JScrollPane spReuniaoMarcada = new JScrollPane();
		spReuniaoMarcada.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spReuniaoMarcada.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		spReuniaoMarcada.setBounds(20, 89, 523, 170);
		pReuniaoMarcado.add(spReuniaoMarcada);
		
		tableReuniaoMarcada = new JTable();
		spReuniaoMarcada.setViewportView(tableReuniaoMarcada);
		tableReuniaoMarcada.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"C\u00F3d. Grupo", "Tema", "Data", "Status"
			}
		));
		tableReuniaoMarcada.setEnabled(false);
		tableReuniaoMarcada.getColumnModel().getColumn(3).setPreferredWidth(64);

		JLabel lblMensagemReuniaoMarcada = new JLabel("aaaaaaaaaaaaaaaaaaaaaaaaaa");
		lblMensagemReuniaoMarcada.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemReuniaoMarcada.setBounds(411, 0, 132, 75);
		pReuniaoMarcado.add(lblMensagemReuniaoMarcada);
		
		
		
		JLabel lblMensagemRA1Grupo = new JLabel("");
		lblMensagemRA1Grupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemRA1Grupo.setBounds(166, 57, 23, 20);
		pCadGrupo.add(lblMensagemRA1Grupo);
		
		JLabel lblMensagemRA2Grupo = new JLabel("");
		lblMensagemRA2Grupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemRA2Grupo.setBounds(166, 83, 23, 20);
		pCadGrupo.add(lblMensagemRA2Grupo);
		
		JLabel lblMensagemRA3Grupo = new JLabel("");
		lblMensagemRA3Grupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemRA3Grupo.setBounds(166, 109, 23, 20);
		pCadGrupo.add(lblMensagemRA3Grupo);
		
		JLabel lblMensagemRA4Grupo = new JLabel("");
		lblMensagemRA4Grupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemRA4Grupo.setBounds(166, 135, 23, 20);
		pCadGrupo.add(lblMensagemRA4Grupo);
		
		JLabel lblMessageCodGrupo = new JLabel("");
		lblMessageCodGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessageCodGrupo.setForeground(Color.RED);
		lblMessageCodGrupo.setBounds(442, 57, 23, 20);
		pCadGrupo.add(lblMessageCodGrupo);
		
		JLabel lblMensagemGrupoCad = new JLabel("");
		lblMensagemGrupoCad.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemGrupoCad.setBounds(30, 197, 192, 48);
		pCadGrupo.add(lblMensagemGrupoCad);

		JButton btnExcluirGrupos = new JButton("Excluir");
		btnExcluirGrupos.setBounds(329, 217, 100, 30);
		btnExcluirGrupos.setVisible(false);
		pCadGrupo.add(btnExcluirGrupos);

		JFormattedTextField[] RA = {ftRA_1, ftRA_2, ftRA_3, ftRA_4};
		BotaoGrupoPesquisaController bRaCont1 = new BotaoGrupoPesquisaController(ftRA_1, lblMensagemRA1Grupo, 0);
		BotaoGrupoPesquisaController bRaCont2 = new BotaoGrupoPesquisaController(ftRA_2, lblMensagemRA2Grupo, 0);
		BotaoGrupoPesquisaController bRaCont3 = new BotaoGrupoPesquisaController(ftRA_3, lblMensagemRA3Grupo, 0);
		BotaoGrupoPesquisaController bRaCont4 = new BotaoGrupoPesquisaController(ftRA_4, lblMensagemRA4Grupo, 0);
		BotaoGrupoPesquisaController bCodCont = new BotaoGrupoPesquisaController(ftCodGrupo, lblMessageCodGrupo, 1);
		BotaoGrupoSalvarController bSGrupoCont = new BotaoGrupoSalvarController(RA, ftCodGrupo, ftTema, cbArea, cbSubArea, lblMensagemGrupoCad);
		BotaoGrupoExcluirController bExGrupoCont = new BotaoGrupoExcluirController(RA, ftCodGrupo, ftTema, cbArea, cbSubArea, lblMensagemGrupoCad);
		ComboBoxAreaGrupoController cbAreaCont = new ComboBoxAreaGrupoController(cbArea, cbSubArea, area, listaSubArea);
		ComboBoxSubAreaController cbSubAreaCont = new ComboBoxSubAreaController(cbArea, cbSubArea, ftCodGrupo);
		ComboBoxAreaGrupoController cbAreaConsultCont = new ComboBoxAreaGrupoController(cbAreaConsulta, cbSubAreaConsulta, area, listaSubArea);
		bCodCont.setList(listaSubArea, area);
		bCodCont.setComand(RA, ftTema, cbArea, cbSubArea, lblMensagemGrupoCad, btnSalvaAlteraGrupos, btnExcluirGrupos);
		bSGrupoCont.commands(btnSalvaAlteraGrupos, btnExcluirGrupos);
		bExGrupoCont.command(btnSalvaAlteraGrupos, btnExcluirGrupos);

		BTReuniaoSalvaController BTReuniaoSalva= new BTReuniaoSalvaController(ftCodGrupoReuniao, ftAssuntoReuniao, ftDataReuniao, lblMensagemReuniao);
		BTReuniaoBuscaCodigoController BTReuniaoBuscaCodigo= new BTReuniaoBuscaCodigoController(ftCodGrupoReuniao, ftAssuntoReuniao, ftDataReuniao, lblMensagemReuniao);

		btnBuscarCodReuniao.addActionListener(BTReuniaoBuscaCodigo);
		btnSalvaReuniao.addActionListener(BTReuniaoSalva);
		btnBuscarRA1.addActionListener(bRaCont1);
		btnBuscarRA2.addActionListener(bRaCont2);
		btnBuscarRA3.addActionListener(bRaCont3);
		btnBuscarRA4.addActionListener(bRaCont4);
		btnBuscarCodGrupo.addActionListener(bCodCont);
		btnSalvaAlteraGrupos.addActionListener(bSGrupoCont);
		btnExcluirGrupos.addActionListener(bExGrupoCont);
		cbArea.addActionListener(cbAreaCont);
		cbSubArea.addActionListener(cbSubAreaCont);
		cbAreaConsulta.addActionListener(cbAreaConsultCont);

		// Tela Aluno
		JLabel lblAlunoDados = new JLabel("Dados Aluno");
		lblAlunoDados.setBounds(30, 11, 100, 31);
		lblAlunoDados.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAlunoDados.setBackground(UIManager.getColor("Button.disabledShadow"));
		pAluno.add(lblAlunoDados);

		JLabel lblAlunoRA = new JLabel("RA:");
		lblAlunoRA.setBounds(105, 118, 68, 14);
		lblAlunoRA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pAluno.add(lblAlunoRA);

		JLabel lblAlunoNome = new JLabel("Nome:");
		lblAlunoNome.setBounds(105, 143, 68, 14);
		lblAlunoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pAluno.add(lblAlunoNome);
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
		btnExcluirAluno.setVisible(false);

		JLabel lblMensagemAluno = new JLabel("");
		lblMensagemAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagemAluno.setBounds(300, 21, 280, 70);
		pAluno.add(lblMensagemAluno);

		AlunoBtnBuscaController buscaController = new AlunoBtnBuscaController(tfRA, tfNome,
				lblMensagemAluno, btnExcluirAluno);
		AlunoBtnSalvarController salvarController = new AlunoBtnSalvarController(tfRA, tfNome,
				lblMensagemAluno);
		AlunoBtnExcluirController excluirController = new AlunoBtnExcluirController(tfRA, tfNome,
				lblMensagemAluno, btnExcluirAluno);
		btnBuscarAluno.addActionListener(buscaController);
		btnSalvaAluno.addActionListener(salvarController);
		btnExcluirAluno.addActionListener(excluirController);

	}
}
