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

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.StringTokenizer;

import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.File;
import java.sql.Date;

import javax.swing.table.DefaultTableModel;

public class Tela extends JFrame {

	private JPanel contentPane;
	
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

	public Tela()  {
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
		
		JTabbedPane tpGrupos = new JTabbedPane(JTabbedPane.TOP);
		pGrupo.add(tpGrupos, BorderLayout.CENTER);
		
		JPanel pCadGrupo = new JPanel();
		tpGrupos.addTab("Cadastrar/Atualizar dados do grupo", null, pCadGrupo, null);
		pCadGrupo.setLayout(null);
		
		JPanel pConsultarGrupos = new JPanel();
		tpGrupos.addTab("Consultar Grupos Cadastrados", null, pConsultarGrupos, null);
		pConsultarGrupos.setLayout(null);
		
		JPanel pOrientacoes = new JPanel();
		tabbedPane.addTab("Orientações", null, pOrientacoes, null);
		pOrientacoes.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tpOrientacoes = new JTabbedPane(JTabbedPane.TOP);
		pOrientacoes.add(tpOrientacoes, BorderLayout.CENTER);
		
		JPanel pMarcaReuniao = new JPanel();
		tpOrientacoes.addTab("Marcar Reunião", null, pMarcaReuniao, null);
		pMarcaReuniao.setLayout(null);

		// TODO add passos <
		JPanel pAddPassos = new JPanel();
		tpOrientacoes.addTab("Adicionar Passos", null, pAddPassos, null);
		pAddPassos.setLayout(null);

		TelaDeifinirPassos.setElements(pAddPassos);
		// TODO add passos >
		JPanel pReuniaoMarcado = new JPanel();
		tpOrientacoes.addTab("Reuniões marcadas", null, pReuniaoMarcado, null);
		pReuniaoMarcado.setLayout(null);

		// Tela Aluno
		TelaCadastroAluno.setElements(pAluno);
		TelaReunioesMarcadas.setElements(pReuniaoMarcado);
		TelaMarcarReuniao.setElements(pMarcaReuniao);
		
		//Tela Grupo
		TelaCadastroGrupo.setElements(pCadGrupo);
		TelaConsultaGrupo.setElements(pConsultarGrupos);

	}
}
