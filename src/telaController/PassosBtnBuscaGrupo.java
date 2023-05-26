package telaController;

import br.fatec.ListObject.ListObject;
import br.fatec.StackObject.StackObject;
import controller.ManterPassos;
import model.Reuniao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class PassosBtnBuscaGrupo implements ActionListener
{
    private final JLabel lblMensagem;
    private final JFormattedTextField campoCodGrupo;
    private final JFormattedTextField campoAssunto;
    private final JTextArea campoPassos;
    private final JButton btnSalvar;
    private String caminhoArquivoReunioes;
    private ListObject reunioes;
    private Reuniao ultimaReuniaoGrupo;

    public PassosBtnBuscaGrupo(JLabel lblMensagem, JFormattedTextField campoCodGrupo,
                               JFormattedTextField campoAssunto, JTextArea campoPassos,
                               JButton btnSalvar)
    {
        this.lblMensagem = lblMensagem;
        this.campoCodGrupo = campoCodGrupo;
        this.campoAssunto = campoAssunto;
        this.campoPassos = campoPassos;
        this.btnSalvar = btnSalvar;
        this.caminhoArquivoReunioes = getArquivoReunioes();
    }

    private String getArquivoReunioes()
    {
        return Constantes.H_REUINOES;
    }

    private boolean grupoTemReuniao(String codigo) throws Exception {
        File readFile = new File(Constantes.H_GRUPOS);
        FileReader read = new FileReader(readFile);
        BufferedReader buffer = new BufferedReader(read);

        String line;

        line = buffer.readLine();

        while (line!=null)
        {
            if (line.contains(codigo) && line.contains("true"))
            {
                System.out.println("grupo " + codigo + "Já concluio");
                return true;
            }

            line = buffer.readLine();
        }

        return false;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        btnSalvar.setEnabled(false);

        lblMensagem.setText("");
        lblMensagem.setForeground(Color.black);
        if (campoCodGrupo.getText() == "" ||
        campoCodGrupo.getText().length() != 4)
        {
            lblMensagem.setText("Código inválido!");
            lblMensagem.setForeground(Color.red);
            return;
        }
        ManterPassos manterPassos = new ManterPassos();

        try {
            if (grupoTemReuniao(campoCodGrupo.getText()))
            {
                lblMensagem.setForeground(Color.red);
                lblMensagem.setText("<html>O grupo " + campoCodGrupo.getText() + " já " +
                        "<br>termiou o TCC</html>");
                return;
            }

            this.reunioes = manterPassos.getReunioes(getArquivoReunioes());

            if (reunioes == null)
            {
                lblMensagem.setText("<html>Erro na leitura" +
                        "<br>do arquivo Reunioes.csv</html>");
                lblMensagem.setForeground(Color.red);
                return;
            }

            int codigoGrupo = Integer.parseInt(campoCodGrupo.getText());
            this.ultimaReuniaoGrupo = pegarUltimaReunião(codigoGrupo, reunioes);

            if (ultimaReuniaoGrupo == null)
            {
                lblMensagem.setText("<html>Grupo " + codigoGrupo +
                        " não<br> tem reuniões marcadas</html>");
                lblMensagem.setForeground(Color.red);
                return;
            }
            campoAssunto.setText(ultimaReuniaoGrupo.getAssunto());
            btnSalvar.setEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
            lblMensagem.setForeground(Color.red);
            lblMensagem.setText("Houve algum erro inesperado");
        }
    }

    private Reuniao pegarUltimaReunião(int codigo, ListObject reunioes) throws Exception {
        StackObject reunioesGrupo = new StackObject();
        int size = reunioes.size();

        for (int index = 0; index < size; index++)
        {
            Reuniao reuniao= (Reuniao) reunioes.get(index);
            int codigoAux = reuniao.getCodigoGrupo();
            if (codigoAux == codigo)
                reunioesGrupo.push(reuniao);
        }

        if (reunioesGrupo.isEmpty())
            return null;

        return ((Reuniao) reunioesGrupo.top());
    }
}
