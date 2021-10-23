package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.Scanner;

public class ElementStorage {
    ArrayList<Element> elements;
    public void create() {
        elements = new ArrayList<>();

        FileHandle handle = Gdx.files.internal("symbols.txt");
        Scanner scanner = new Scanner(handle.read());

        while(scanner.hasNextLine())
        {
            Element e = new Element();
            String line = scanner.nextLine();
            String[] lineData = line.split("\\s+");
            e.Name = lineData[0];
            e.Symbol = lineData[1];
        }
        scanner.close();
    }

    public void dispose() {
        elements.clear();
    }

}
