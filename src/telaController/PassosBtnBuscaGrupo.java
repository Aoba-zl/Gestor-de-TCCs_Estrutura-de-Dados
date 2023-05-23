package telaController;

import br.fatec.ListObject.ListObject;
import br.fatec.StackObject.StackObject;
import controller.ManterPassos;
import model.Reuniao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
        String caminhoRaiz, caminhoArquivo;

        caminhoRaiz = System.getProperty("user.home") + File.separator;
        caminhoRaiz += "TEMP" + File.separator;
        caminhoArquivo = caminhoRaiz + "Reunioes.csv";

        return caminhoArquivo;
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
            lblMensagem.setText("Houve algum erro inesperado");
            lblMensagem.setForeground(Color.red);
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
