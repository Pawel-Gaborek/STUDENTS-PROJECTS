import javax.swing.filechooser.FileFilter;
import java.io.File;
import javax.swing.JFileChooser;

public class MiniTextDialoge {
    class MeinFilter extends FileFilter {
        public boolean accept(File f) {
            String name = f.getName().toLowerCase();
            if (f.isDirectory()) {
                return true;
            }
            if (name.endsWith(".htm")) {
                return true;
            }
            if (name.endsWith(".html")) {
                return true;
            }
            return false;
        }
        @Override public String getDescription()
        {
            return "HTML-Dateien";
        }
    }
    public File speichernDialogZeigen() {
        JFileChooser speichernDialog = new JFileChooser();
        speichernDialog.setFileFilter(new MeinFilter());
        speichernDialog.setAcceptAllFileFilterUsed(false);
        int status = speichernDialog.showSaveDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            return (speichernDialog.getSelectedFile());
        }
        else
        {
            return null;
        }
    }
    public File oeffnenDialogZeigen() {
        JFileChooser oeffnenDialog = new JFileChooser();
        oeffnenDialog.setFileFilter(new MeinFilter());
        oeffnenDialog.setAcceptAllFileFilterUsed(false);
        int status = oeffnenDialog.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            return (oeffnenDialog.getSelectedFile());
        }
        else {
            return null;
        }
    }
}


