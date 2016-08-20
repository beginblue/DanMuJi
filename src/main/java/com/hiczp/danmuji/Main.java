package com.hiczp.danmuji;

import com.hiczp.danmuji.window.MainWindow;

/**
 * Created by czp on 16-8-20.
 * Main class
 */
public class Main {
    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow("DanMuJi");

        while (true) {
            mainWindow.updateDanMu();

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
