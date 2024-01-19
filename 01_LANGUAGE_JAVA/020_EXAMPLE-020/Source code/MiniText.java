import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.event.InputEvent;
import java.awt.print.PrinterException;
import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.lang.String;
import javax.swing.text.StyledEditorKit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import  java.awt.event.*;
import javax.swing.filechooser.FileFilter;
import java.awt.Component;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.lang.Object;
import java.awt.event.ActionListener;
import java.awt.*;

public class MiniText extends JFrame {
    String newButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/new24.png";
    String openButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/open24.png";
    String saveButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/save24.png";
    String saveUsButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/saveus24.png";
    String closeButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/close24.png";
    String boldButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/bold24.png";
    String italicButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/italic24.png";
    String underlineButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/underline24.png";
    String right = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/right24.png";
    String left = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/left24.png";
    String centered = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/centered24.png";
    String justified = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/justified24.png";
    String print = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/print24.png";
    String web = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/web24.png";
    String newMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/new24small.png";
    String openMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/open24small.png";
    String saveMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/save24small.png";
    String saveUsMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/saveus24small.png";
    String closeMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/close24small.png";
    String webMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/web24small.png";
    String printMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/print24small.png";
    String copyMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/copy24small.png";
    String pasteMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/paste24small.png";
    String cutMenu = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/cut24small.png";
    String copyButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/copy24.png";
    String pasteButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/paste24.png";
    String cutButton = "/Volumes/DOKUMENTY/FERNAKADEMIE/11_JAVA-11B/01_KOD/Java_11B_AUFGABE-1/Aufgabe 1/Aufgabe 3 1/src/cut24.png";
    private HTMLEditorKit htmlFormat;
    private JEditorPane eingabeFeld;
    JToolBar leiste = new JToolBar();
    MeineAktionen oeffnenAct, speichernAct, beendenAct, neuAct, webAct, help, about, copy, paste, cut;
    MiniTextDialoge dialog;
    File datei;
    JPopupMenu kontext;
    String title;
    public MiniText(String text) {
        super(text);
        title = text;
        titleFunction(null);
        setLayout(new BorderLayout());
        eingabeFeld = new JEditorPane();
        htmlFormat = new HTMLEditorKit();
        eingabeFeld.setEditorKit(htmlFormat);
        dialog = new MiniTextDialoge();
        menu();
        leiste();
        kontextMenu();
        eingabeFeld.addMouseListener(new MeinKontextMenuListener());
        add(new JScrollPane(eingabeFeld), BorderLayout.CENTER);
        setExtendedState(MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(600, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        eingabeFeld.requestFocus();
    }

    private void titleFunction(String text) {
        if (datei == null) {
            this.setTitle(title+" - ohneName");
        }
        else {
            this.setTitle(title+" - "+text);
        }
    }

    private void leiste() {
        JToolBar leiste = new JToolBar();
        MeineAktionen neuAct = new MeineAktionen(null, new ImageIcon(newButton), "Erstellt ein neues Dokument", KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK), "neu");
        MeineAktionen oeffnenAct = new MeineAktionen(null, new ImageIcon(openButton), "Öffnet ein vorhandenes Dokument", KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK), "laden");
        MeineAktionen speichernAct = new MeineAktionen(null, new ImageIcon(saveButton), "Speichert das aktuelle Dokument", KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK), "speichern");
        MeineAktionen speichernActUnter = new MeineAktionen(null, new ImageIcon(saveUsButton), "Speichert das aktuelle Dokument unter", KeyStroke.getKeyStroke('U', InputEvent.CTRL_DOWN_MASK), "speichernUnter");
        MeineAktionen beendenAct = new MeineAktionen(null, new ImageIcon(closeButton), "Close", null, "beenden");
        leiste.add(neuAct);
        leiste.add(oeffnenAct);
        leiste.add(speichernAct);
        leiste.add(speichernActUnter);
        leiste.addSeparator();
        leiste.add(beendenAct);
        leiste.addSeparator();
        MeineAktionen webAct = new MeineAktionen(null, new ImageIcon(web), "Web", null, "web");
        leiste.add(webAct);
        leiste.addSeparator();
        Action fettFormat = new StyledEditorKit.BoldAction();
        fettFormat.putValue(Action.SHORT_DESCRIPTION, "Fett formatieren");
        fettFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon(boldButton));
        leiste.add(fettFormat);
        Action kursivFormat = new StyledEditorKit.ItalicAction();
        kursivFormat.putValue(Action.SHORT_DESCRIPTION, "Kursiv formatieren");
        kursivFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon(italicButton));
        leiste.add(kursivFormat);
        Action unterstrichenFormat = new StyledEditorKit.UnderlineAction();
        unterstrichenFormat.putValue(Action.SHORT_DESCRIPTION, "Unterstrichen formatieren");
        unterstrichenFormat.putValue(Action.LARGE_ICON_KEY, new ImageIcon(underlineButton));
        leiste.add(unterstrichenFormat);
        leiste.addSeparator();
        Action linksAbsatz = new StyledEditorKit.AlignmentAction("Linksbündig", StyleConstants.ALIGN_LEFT);
        linksAbsatz.putValue(Action.SHORT_DESCRIPTION, "Linksbündig ausrichten");
        linksAbsatz.putValue(Action.LARGE_ICON_KEY, new ImageIcon(left));
        leiste.add(linksAbsatz);
        Action zentriertAbsatz = new StyledEditorKit.AlignmentAction("Zentriert", StyleConstants.ALIGN_CENTER);
        zentriertAbsatz.putValue(Action.SHORT_DESCRIPTION, "Zentriert ausrichten");
        zentriertAbsatz.putValue(Action.LARGE_ICON_KEY, new ImageIcon(centered));
        leiste.add(zentriertAbsatz);
        Action rechtsAbsatz = new StyledEditorKit.AlignmentAction("Rechts", StyleConstants.ALIGN_RIGHT);
        rechtsAbsatz.putValue(Action.SHORT_DESCRIPTION, "Rechtsbündig ausrichten");
        rechtsAbsatz.putValue(Action.LARGE_ICON_KEY, new ImageIcon(right));
        leiste.add(rechtsAbsatz);
        Action blockAbsatz = new StyledEditorKit.AlignmentAction("Blocksatz", StyleConstants.ALIGN_JUSTIFIED);
        blockAbsatz.putValue(Action.SHORT_DESCRIPTION, "Im Blocksatz ausrichten");
        blockAbsatz.putValue(Action.LARGE_ICON_KEY, new ImageIcon(justified));
        leiste.add(blockAbsatz);
        leiste.addSeparator();
        MeineAktionen druckenAct = new MeineAktionen("Drucken…", new ImageIcon(print), "Druckt das aktuelle Dokument", KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK), "drucken");
        leiste.add(druckenAct);
        leiste.addSeparator();
        Action copy = new DefaultEditorKit.CopyAction();
        copy.putValue(Action.SHORT_DESCRIPTION, "Copy text");
        copy.putValue(Action.LARGE_ICON_KEY, new ImageIcon(copyButton));
        leiste.add(copy);
        Action paste = new DefaultEditorKit.PasteAction();
        paste.putValue(Action.SHORT_DESCRIPTION, "Paste text");
        paste.putValue(Action.LARGE_ICON_KEY, new ImageIcon(pasteButton));
        leiste.add(paste);
        Action cut = new DefaultEditorKit.CutAction();
        cut.putValue(Action.SHORT_DESCRIPTION, "Cut text");
        cut.putValue(Action.LARGE_ICON_KEY, new ImageIcon(cutButton));
        leiste.add(cut);
        this.add(leiste,BorderLayout.NORTH);
    }
    private void menu() {
        JMenu dateiMenu = new JMenu("Datei");
        JMenuBar menu = new JMenuBar();
        JMenu dateiOeffnen = new JMenu("Öffnen");
        dateiOeffnen.add(oeffnenAct = new MeineAktionen("Öffnen…", new ImageIcon(openMenu), "Öffnet ein vorhandenes Dokument", KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK), "laden"));
        dateiOeffnen.add(webAct = new MeineAktionen("Öffnen web…", new ImageIcon(webMenu), "Öffnet ein Web-Dokument", KeyStroke.getKeyStroke('W', InputEvent.CTRL_DOWN_MASK), "web"));
        dateiMenu.add(neuAct = new MeineAktionen("Neu…", new ImageIcon(newMenu), "Erstellt ein neues Dokument", KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK), "neu"));
        dateiMenu.add(dateiOeffnen);
        dateiMenu.add(speichernAct = new MeineAktionen("Speichern…", new ImageIcon(saveMenu), "Speichert das aktuelle Dokument", KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK), "speichern"));
        dateiMenu.add(speichernAct = new MeineAktionen("Speichern unter…", new ImageIcon(saveUsMenu), "Speichert das aktuelle Dokument unter", KeyStroke.getKeyStroke('U', InputEvent.CTRL_DOWN_MASK), "speichernUnter"));
        dateiMenu.addSeparator();
        dateiMenu.add(beendenAct = new MeineAktionen("Print", new ImageIcon(printMenu), "Print", KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK), "print"));
        dateiMenu.addSeparator();
        dateiMenu.add(beendenAct = new MeineAktionen("Beenden", new ImageIcon(closeMenu), "Close", null, "beenden"));
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(help = new MeineAktionen("Help for this program", null, "Help", KeyStroke.getKeyStroke('H', InputEvent.CTRL_DOWN_MASK), "help"));
        helpMenu.add(about = new MeineAktionen("About this program", null, "About program", KeyStroke.getKeyStroke('I', InputEvent.CTRL_DOWN_MASK), "about"));
        JMenu editMenu = new JMenu("Edit");
        editMenu.add(copy = new MeineAktionen("Copy text", new ImageIcon(copyMenu), "Copy", KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK), "copy"));
        editMenu.add(paste = new MeineAktionen("Paste text", new ImageIcon(pasteMenu), "Paste", KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK), "paste"));
        editMenu.add(cut = new MeineAktionen("Cut text", new ImageIcon(cutMenu), "Cut", KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK), "cut"));
        menu.add(dateiMenu);
        menu.add(helpMenu);
        menu.add(editMenu);
        this.setJMenuBar(menu);
        leiste.add(neuAct);
    }
    class MeineAktionen extends AbstractAction {
        public MeineAktionen(String text, ImageIcon icon, String bildschirmtipp, KeyStroke shortcut, String actionText) {
            super(text, icon);
            putValue(SHORT_DESCRIPTION, bildschirmtipp);
            putValue(ACCELERATOR_KEY, shortcut);
            putValue(ACTION_COMMAND_KEY, actionText);
        }
        @Override public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("copy"))
            {
                eingabeFeld.copy();
            }
            if (e.getActionCommand().equals("paste"))
            {
                eingabeFeld.paste();
            }
            if (e.getActionCommand().equals("cut"))
            {
                eingabeFeld.cut();
            }
            if (e.getActionCommand().equals("help"))
            {
                help();
            }
            if (e.getActionCommand().equals("about"))
            {
                about();
            }
            if (e.getActionCommand().equals("neu"))
            {
                dateiNeu();
            }
            if (e.getActionCommand().equals("laden"))
            {
                dateiLaden();
            }
            if (e.getActionCommand().equals("speichern"))
            {
                dateiSpeichern();
            }
            if (e.getActionCommand().equals("speichernUnter"))
            {
                dateiSpeichernUnter();
            }
            if (e.getActionCommand().equals("beenden")) {
                beenden();
            }
            if (e.getActionCommand().equals("web")) {
                webLaden();
            }
            if (e.getActionCommand().equals("drucken")) {
                if (e.getSource() instanceof JButton)
                {
                    drucken(false);
                }
                if (e.getSource() instanceof JMenuItem) {
                    drucken(true);
                }
            }
        }
        private void help(){
            JFrame help = new JFrame("Help");
            help.setLayout(new BorderLayout());
            help.setExtendedState(MAXIMIZED_BOTH);
            help.setMinimumSize(new Dimension(300,200));
            help.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            help.setVisible(true);
        }
        private void about()
        {
            JOptionPane.showMessageDialog(MiniText.this, "This is 'MiniText' program.\nProgram development Pawel Gaborek","About this program", JOptionPane.INFORMATION_MESSAGE);
        }
        private void beenden() {
            if(JOptionPane.showConfirmDialog(MiniText.this, "Sind Sie sicher?","Anwendung schließen", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                System.exit(0);
        }
        private void dateiLaden() {
            dialog = new MiniTextDialoge();
            File dateiLokal = dialog.oeffnenDialogZeigen();
            if (dateiLokal != null) {
                try {
                    eingabeFeld.read(new FileReader(dateiLokal), null);
                    datei = dateiLokal;
                    titleFunction(datei.getName() + " - " + datei.getPath());
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(MiniText.this, "Beim Laden hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        private void dateiNeu() {
            if(JOptionPane.showConfirmDialog(MiniText.this, "Wollen Sie wirklich ein neues Dokument anlegen?","Neues Dokument", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
            {
                eingabeFeld.setText("");
                datei = null;
                titleFunction(null);
            }
        }
        private void dateiSpeichernUnter() {
            //MiniTextDialoge dialog = new MiniTextDialoge();
            File dateiLokal = dialog.speichernDialogZeigen();
            if (dateiLokal != null)
            {
                datei = dateiLokal;
                dateiSpeichern();
            }
        }
        private void dateiSpeichern() {
            if (datei == null) {
                dialog = new MiniTextDialoge();
                datei = dialog.speichernDialogZeigen();
            }
            if (datei != null) {
                try {
                    OutputStream output = new FileOutputStream(datei+".html");
                    htmlFormat.write(output, eingabeFeld.getDocument(), 0, eingabeFeld.getDocument().getLength());
                    titleFunction(datei.getName() + " - " + datei.getPath());
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(MiniText.this, "Beim Speichern hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        private void drucken(boolean dialogZeigen) {
            try {
                if (dialogZeigen == true)
                {
                    eingabeFeld.print();
                }
                else
                {
                    eingabeFeld.print(null, null, false, null, null, true);
                }
            }
            catch (PrinterException e) {
                JOptionPane.showMessageDialog(MiniText.this, "Beim Drucken hat es ein Problem gegeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        }
        private void webLaden() {
            String adresse;
            adresse = JOptionPane.showInputDialog("Bitte geben Sie die URL der Seite ein:", "https://");
            if (adresse != null) {
                eingabeFeld.setText("");
                try {
                    eingabeFeld.setPage(adresse);
                    titleFunction(adresse);
                }
                catch (IOException e) {
                    JOptionPane.showMessageDialog(MiniText.this, "Beim Laden ist ein Problem aufgetreten");
                }
            }
        }
    }
    class MeinKontextMenuListener extends MouseAdapter {
        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            //if (e.isPopupTrigger())
            if (e.getButton()==3)
            {
                kontext.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }
    private void kontextMenu() {
        kontext = new JPopupMenu();
        kontext.add(new MeineAktionen("Neu…", new ImageIcon(newMenu), "Erstellt ein neues Dokument", KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK), "neu"));
        kontext.add(new MeineAktionen("Öffnen…", new ImageIcon(openMenu), "Öffnet ein vorhandenes Dokument", KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK), "laden"));
        kontext.add(new MeineAktionen("Öffnen web…", new ImageIcon(webMenu), "Öffnet ein Web-Dokument", KeyStroke.getKeyStroke('W', InputEvent.CTRL_DOWN_MASK), "web"));
    }
}

