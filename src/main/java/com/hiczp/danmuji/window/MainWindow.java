package com.hiczp.danmuji.window;

import com.hiczp.danmuji.json.Json;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by czp on 16-8-21.
 * Main window
 */
public class MainWindow extends JFrame {
    private JTextArea mainTextArea;

    public MainWindow(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawContent();
        setSize(new Dimension(200, 400));
        setAlwaysOnTop(true);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel"); //gtk主题
        } catch (Exception e) {
            e.printStackTrace();
        }
        setVisible(true);
    }

    private void drawContent() {
        mainTextArea = new JTextArea();
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);

        getContentPane().add(new JScrollPane(mainTextArea));
    }

    public void updateDanMu() {
        JSONArray danMUs;
        JSONObject danMu;
        String danMuStr;

        danMUs = Json.getDanMu();

        if (danMUs != null) {
            danMuStr = "";
            for (Object object : danMUs) {
                danMu = (JSONObject) object;
                danMuStr += danMu.getString("nickname") + " -> " + danMu.getString("text") + "\n\n";
            }
            mainTextArea.setText(danMuStr);
        }

    }
}
