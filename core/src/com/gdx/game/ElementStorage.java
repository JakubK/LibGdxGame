package com.gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ElementStorage {
    ArrayList<Element> elements;
    Random r;
    public void create() {
        r = new Random();
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
            elements.add(e);
        }
        scanner.close();
    }

    public Element[] getRandomElements() {
        Collections.shuffle(elements);
        return elements
                .stream()
                .limit(GameConstants.ENTITY_COUNT)
                .collect(Collectors.toList())
                .toArray(new Element[GameConstants.ENTITY_COUNT]);
    }


    public void dispose() {
        elements.clear();
    }

}
