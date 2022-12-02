package br.univille.poo.app.servico;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class GerenteJanela {

    // classe responsavel por abrir as janelas dentro do sistema
    private static JDesktopPane jDesktopPane;

    public GerenteJanela(JDesktopPane jDesktopPane) {
        this.jDesktopPane = jDesktopPane;
    }

    // método que abre uma internal frame dentro da janela principal
    public void abrirJanela(JInternalFrame jInternalFrame) {
        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
        }
    }

}
