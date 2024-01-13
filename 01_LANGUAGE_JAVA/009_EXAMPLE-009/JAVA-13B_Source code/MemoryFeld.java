package com.example.aufgabe_22;
//f¸r die Klassen Arrays und Collections
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Collections;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import java.awt.event.ActionListener.*;

public class MemoryFeld {

    DialogInfo DialogInfo;

    //eine innere Klasse f¸r den Eventhandler des Timer
    class TimerHandler implements EventHandler<ActionEvent> {
            @Override
            //die Methode ruft die Methode karteSchliessen() auf
            public void handle(ActionEvent arg0) {
                karteSchliessen();
            }
        }

    class ButtonHide implements EventHandler<ActionEvent> {
        @Override
        //die Methode ruft die Methode karteSchliessen() auf
        public void handle(ActionEvent arg0) {
            schummelnHide();
        }
    }
    class ButtonHandler implements EventHandler<ActionEvent> {
        private Timeline timerClose;
        @Override
        //die Methode ruft die Methode karteSchliessen() auf
        public void handle(ActionEvent arg0) {

            schummeln();
            timerClose = new Timeline(new KeyFrame(Duration.millis(2000),new ButtonHide()));
            timerClose.play();
        }
    }



    //das Array f¸r die Karten
    private final MemoryKarte[] karten;
    
    //das Array f¸r die Namen der Grafiken
    private final String[] bilder = {"" +
            "/apfel.jpg",
            "/birne.jpg",
            "/blume.jpg",
            "/blume2.jpg",
            "/ente.jpg",
            "/fisch.jpg",
            "/fuchs.jpg",
            "/igel.jpg",
            "/kaenguruh.jpg",
            "/katze.jpg",
            "/kuh.jpg",
            "/maus1.jpg",
            "/maus2.jpg",
            "/maus3.jpg",
            "/melone.jpg",
            "/pilz.jpg",
            "/ronny.jpg",
            "/schmetterling.jpg",
            "/sonne.jpg",
            "/wolke.jpg",
            "/maus4.jpg"};
    
    //f¸r die Punkte
    private int menschPunkte, computerPunkte;
    //zwei Labels f¸r die Punkte
    private Label menschPunkteLabel, computerPunkteLabel, menschOderComputeLabel;
    private Button schummeln;
    
    //wie viele Karten sind aktuell umgedreht?
    private int umgedrehteKarten;
    
    //f¸r das aktuell umdrehte Paar
    private final MemoryKarte[] paar;
    
    //f¸r den aktuellen Spieler
    private int spieler;
    
    //das "Ged‰chtnis" f¸r den Computer
    //er speichert hier wo das Gegenst¸ck liegt
    private final int[][] gemerkteKarten;
    
    //f¸r die Spielst‰rke
    private final int spielstaerke;
    
    //f¸r den Timer
    private Timeline timer;

    //der Konstruktor
    public MemoryFeld() {
        //das Array f¸r die Karten erstellen, insgesamt 42 St¸ck
        karten = new MemoryKarte[42];

        //f¸r das Paar
        paar = new MemoryKarte[2];

        //f¸r das Ged‰chtnis
        //es speichert f¸r jede Karte paarweise die Position im Spielfeld
        gemerkteKarten = new int[2][21];
        
        //keiner hat zu Beginn einen Punkt
        menschPunkte = 0;
        computerPunkte = 0;
        
        //es ist keine Karte umgedreht
        umgedrehteKarten = 0;
        
        //der Mensch f‰ngt an
        spieler = 0;
        
        //die Spielst‰rke ist 10
        spielstaerke = 10;
        
        //es gibt keine gemerkten Karten
        for (int aussen = 0; aussen < 2; aussen++)
            for (int innen = 0; innen < 21; innen++)
                gemerkteKarten[aussen][innen] = -1;
    }

    //die Methode erstellt die Oberfl‰che und zeichnet die Karten ¸ber eine eigene Methode
    //¸bergeben wird ein FlowPane


    public FlowPane initGUI(FlowPane feld) {
        //f¸r die Ausgaben
        kartenZeichnen(feld);
        menschPunkteLabel = new Label();
        computerPunkteLabel = new Label();
        //==================
        menschOderComputeLabel = new Label();
        //==================
        menschPunkteLabel.setText(Integer.toString(menschPunkte));
        computerPunkteLabel.setText(Integer.toString(computerPunkte));
        
        //in zwei Spalten anzeigen
        GridPane tempGrid = new GridPane();
        //und einf¸gen, dabei werden die Koordinaten angegeben
        tempGrid.add(new Label("Mensch: "), 0 , 0 );
        tempGrid.add(menschPunkteLabel, 1, 0);
        tempGrid.add(new Label("Computer: "), 0, 1);
        tempGrid.add(computerPunkteLabel, 1 ,1);
        //==================
        tempGrid.add(new Label("Es zieht: "), 0, 2);
        tempGrid.add(menschOderComputeLabel, 1 ,2);
        menschOderComputeLabel.setText("Mensch");
        schummeln = new Button("Schummeln");
        schummeln.setOnAction(new ButtonHandler());
        tempGrid.add(schummeln,1,3);
        //==================
        feld.getChildren().add(tempGrid);
        return feld;
    }
    
    //das eigentliche Spielfeld erstellen
    private void kartenZeichnen(FlowPane feld) {
        int count = 0;
        for (int i = 0; i <= 41; i++) {
            //eine neue Karte erzeugen
            karten[i] = new MemoryKarte(bilder[count], count, this);
            //bei jeder zweiten Karte kommt auch ein neues Bild
            if ((i + 1) % 2 == 0)
                count++;
        }
        //die Karten werden gemischt
        Collections.shuffle(Arrays.asList(karten));

        //und ins Spielfeld gesetzt
        for (int i = 0; i <= 41; i++) {
            feld.getChildren().add(karten[i]);
            //die Position der Karte setzen
            karten[i].setBildPos(i);
        }
    }


    private void schummeln() {
        for (int i = 0; i <= 41; i++) {
            //feld.getChildren().add(karten[i]);
            //die Position der Karte setzen
            if (karten[i].isNochImSpiel())
            {
                karten[i].showPicture();
            }
        }
    }

    private void schummelnHide() {
        for (int i = 0; i <= 41; i++) {
            //feld.getChildren().add(karten[i]);
            //die Position der Karte setzen
            if (karten[i].isNochImSpiel())
            {
                karten[i].hidePicture();
            }
        }
    }
    
    //die Methode ¸bernimmt die wesentliche Steuerung des Spiels
    //Sie wird beim Anklicken einer Karte ausgef¸hrt
    public void karteOeffnen(MemoryKarte karte) {
        //zum Zwischenspeichern der ID und der Position
        int kartenID, kartenPos;

        //die Karten zwischenspeichern
        paar[umgedrehteKarten]=karte;
        
        //die ID und die Position beschaffen
        kartenID = karte.getBildID();
        kartenPos = karte.getBildPos();
        
        //die Karte in das Ged‰chtnis des Computers eintragen
        //aber nur dann, wenn es noch keinen Eintrag an der entsprechenden Stelle gibt
        if ((gemerkteKarten[0][kartenID] == -1))
            gemerkteKarten[0][kartenID] = kartenPos;
        else
            //wenn es schon einen Eintrag gibt
            //und der nicht mit der aktuellen Position ¸bereinstimmt, dann haben wir die
            //zweite Karte gefunden
            //die wird dann in die zweite Dimension eingetragen
            if (gemerkteKarten[0][kartenID] != kartenPos)
                gemerkteKarten[1][kartenID] = kartenPos;
        //umgedrehte Karten erhˆhen
        umgedrehteKarten++;
        
        //sind 2 Karten umgedreht worden?
        if (umgedrehteKarten == 2) {
            //dann pr¸fen wir, ob es ein Paar ist
            paarPruefen(kartenID);
            //den Timer erzeugen
            timer = new Timeline(new KeyFrame(Duration.millis(2000), new TimerHandler()));
            //und starten
            timer.play();
        }
        //haben wir zusammen 21 Paare, dann ist das Spiel vorbei
        //if (computerPunkte + menschPunkte == 21) {
            //wir beenden es hier direkt
        //    Platform.exit();
        //}
        closeProgram();
    }
    void closeProgram()
    {
        if (computerPunkte + menschPunkte == 21) {
            DialogInfo DialogInfo = new DialogInfo(new Stage());
            if(computerPunkte>menschPunkte)
            {
                DialogInfo.setInformation(Integer.toString(menschPunkte), Integer.toString(computerPunkte), "Computer");
            }
            else {
                DialogInfo.setInformation(Integer.toString(menschPunkte), Integer.toString(computerPunkte), "User");
            }
            DialogInfo.showScene();
        }
    }
    
    //die Methode dreht die Karten wieder auf die R¸ckseite
    //bzw. nimmt sie aus dem Spiel
    private void karteSchliessen() {
        boolean raus = paar[0].getBildID() == paar[1].getBildID();
        //ist es ein Paar?
        //wenn es ein Paar war, nehmen wir die Karten aus dem Spiel
        //sonst drehen wir sie nur wieder um
        paar[0].rueckseiteZeigen(raus);
        paar[1].rueckseiteZeigen(raus);
        //es ist keine Karte mehr geˆffnet
        umgedrehteKarten = 0;
        //hat der Spieler kein Paar gefunden?
        if (!raus)
            //dann wird der Spieler gewechselt
            spielerWechseln();
        else
            //hat der Computer ein Paar gefunden?
            //dann ist er noch einmal an der Reihe
            if (spieler == 1)
                computerZug();
    }







    //die Methode pr¸ft, ob ein Paar gefunden wurde
    private void paarPruefen(int kartenID) {
        if (paar[0].getBildID() == paar[1].getBildID()) {
            //die Punkte setzen
            paarGefunden();
            //die Karten aus dem Ged‰chtnis lˆschen
            gemerkteKarten[0][kartenID]=-2;
            gemerkteKarten[1][kartenID]=-2;
        }
    }

    //die Methode setzt die Punkte, wenn ein Paar gefunden wurde
    private void paarGefunden() {
        //spielt gerade der Mensch?
        if (spieler == 0) {
            menschPunkte++;
            menschPunkteLabel.setText(Integer.toString(menschPunkte));
            menschOderComputeLabel.setText("Mensch");
        }
        else {
            computerPunkte++;
            computerPunkteLabel.setText(Integer.toString(computerPunkte));
            menschOderComputeLabel.setText("Rechner");
        }
    }
    
    //die Methode wechselt den Spieler
    private void spielerWechseln() {
        //wenn der Mensch an der Reihe war,
        //kommt jetzt der Computer
        if (spieler == 0) {
            spieler = 1;
            computerZug();
            menschOderComputeLabel.setText("Rechner");
        }
        else
        {
            spieler = 0;
            menschOderComputeLabel.setText("Mensch");
        }

    }
    
    //die Methode setzt die Computerz¸ge um
    private void computerZug() {
        int kartenZaehler = 0;
        int zufall = 0;
        boolean treffer = false;
        //zur Steuerung ¸ber die Spielst‰rke
        if ((int)(Math.random() * spielstaerke) == 0) {
            //erst einmal nach einem Paar suchen
            //dazu durchsuchen wir das Array gemerkteKarten, bis wir in beiden Dimensionen
            //einen Wert finden
            while ((kartenZaehler < 21) && (!treffer)) {
                //gibt es in beiden Dimensionen einen Wert grˆﬂer oder gleich 0?
                if ((gemerkteKarten[0][kartenZaehler] >=0) &&  (gemerkteKarten[1][kartenZaehler] >=0)) {
                    //dann haben wir ein Paar
                    treffer = true;
                    //die Vorderseite der Karte zeigen
                    karten[gemerkteKarten[0][kartenZaehler]].vorderseiteZeigen();
                    //und dann die Karte ˆffnen
                    karteOeffnen(karten[gemerkteKarten[0][kartenZaehler]]);
                    //die zweite Karte auch
                    karten[gemerkteKarten[1][kartenZaehler]].vorderseiteZeigen();
                    karteOeffnen(karten[gemerkteKarten[1][kartenZaehler]]);
                }
                kartenZaehler++;
            }
        }
        //wenn wir kein Paar gefunden haben, drehen wir zuf‰llig zwei Karten um
        if (!treffer) {
            //solange eine Zufallszahl suchen, bis eine Karte gefunden wird, die noch im Spiel ist
            do {
                zufall = (int)(Math.random() * karten.length);
            } while (!karten[zufall].isNochImSpiel());
            //die erste Karte umdrehen
            //die Vorderseite der Karte zeigen
            karten[zufall].vorderseiteZeigen();
            //und dann die Karte ˆffnen
            karteOeffnen(karten[zufall]);

            //f¸r die zweite Karte m¸ssen wir auﬂerdem pr¸fen, ob sie nicht gerade angezeigt wird
            do {
                zufall = (int)(Math.random() * karten.length);
            } while ((!karten[zufall].isNochImSpiel()) || (karten[zufall].isUmgedreht()));
            //und die zweite Karte umdrehen
            karten[zufall].vorderseiteZeigen();
            karteOeffnen(karten[zufall]);
        }
    }
    
    //die Methode liefert, ob Z¸ge des Menschen erlaubt sind
    //die R¸ckgabe ist false, wenn gerade der Computer zieht
    //oder wenn schon zwei Karten umgedreht sind
    //sonst ist die R¸ckgabe true
    public boolean zugErlaubt() {
        boolean erlaubt = spieler != 1;
        //zieht der Computer?
        //sind schon zwei Karten umdreht?
        if (umgedrehteKarten == 2)
            erlaubt = false;
        return erlaubt;
    }
    
}

