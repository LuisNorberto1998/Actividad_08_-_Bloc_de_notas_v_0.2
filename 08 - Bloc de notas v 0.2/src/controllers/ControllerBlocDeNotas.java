package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileFilter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.ModelBlocDeNotas;
import views.ViewBlocDeNotas;

/**
 *
 * @author Norberto
 */
public class ControllerBlocDeNotas implements ActionListener {

    ModelBlocDeNotas modelBlocDeNotas;
    ViewBlocDeNotas viewBlocDeNotas;

    public ControllerBlocDeNotas(ModelBlocDeNotas modelBlocDeNotas, ViewBlocDeNotas viewBlocDeNotas) {
        this.modelBlocDeNotas = modelBlocDeNotas;
        this.viewBlocDeNotas = viewBlocDeNotas;
        this.viewBlocDeNotas.jMenuItemOpen.addActionListener(this);
        this.viewBlocDeNotas.jMenuItemReadSave.addActionListener(this);
        inComp();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == viewBlocDeNotas.jMenuItemOpen) {
            jmiRead();
        } else if (e.getSource() == viewBlocDeNotas.jMenuItemReadSave) {
            jmiSave();
        }
    }

    public void jmiRead() {
        try {
            selectPathOpen();
            modelBlocDeNotas.fileRead(modelBlocDeNotas.getPath());
            viewBlocDeNotas.jtaFile.setText(modelBlocDeNotas.getText());
        } catch (Exception ex) {
            Logger.getLogger(ControllerBlocDeNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void jmiSave() {
        try {
            selectPathSave();
            modelBlocDeNotas.setText(viewBlocDeNotas.jtaFile.getText());
            modelBlocDeNotas.writeFile(modelBlocDeNotas.getPath(), modelBlocDeNotas.getText());
        } catch (Exception ex) {
            Logger.getLogger(ControllerBlocDeNotas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void selectPathSave() {
        JFileChooser filechoser = new JFileChooser();
        filechoser.setMultiSelectionEnabled(false);
        filechoser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto *.npr", "npr");
        filechoser.setFileFilter(filter);
        filechoser.showSaveDialog(null);
        modelBlocDeNotas.setPath("" + filechoser.getSelectedFile());
    }

    private void selectPathOpen() {
        JFileChooser filechoser = new JFileChooser();
        filechoser.setMultiSelectionEnabled(false);
        filechoser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto *.npr", "npr");
        filechoser.setFileFilter(filter);
        filechoser.showOpenDialog(null);
        modelBlocDeNotas.setPath("" + filechoser.getSelectedFile());
    }

    public void inComp() {
        viewBlocDeNotas.setTitle("Save and open file");
        viewBlocDeNotas.setLocationRelativeTo(null);
        viewBlocDeNotas.setResizable(false);
        viewBlocDeNotas.setVisible(true);
    }

}
