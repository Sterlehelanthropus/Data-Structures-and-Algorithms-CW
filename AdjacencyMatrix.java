/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMP5017CW2;

import java.util.Arrays;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.stream.*;

/**
 *
 * @author Joel
 */
public class AdjacencyMatrix {

    final int NO_LINK = Integer.MAX_VALUE;
    final int MAX_STATIONS = 9;
    final int MAX_LINKS = 13;
    int numStations;
    StationInfo stations[];
    int distance[][];
    int[] gValue;

    public AdjacencyMatrix() {
        stations = new StationInfo[MAX_STATIONS];
        distance = new int[MAX_LINKS][MAX_LINKS];
        gValue = new int[MAX_STATIONS];

        for (int i = 0; i != MAX_STATIONS; i++) {
            for (int j = 0; j != MAX_STATIONS; j++) {
                distance[i][j] = NO_LINK;
            }
        }
    }

    public void networkRead() {
        String txtSplit = "\\s";
        StationInfo station;
        String[] parts;
        Scanner read;
        try {
            BufferedReader br = new BufferedReader(new FileReader("network.txt"));
            for (int i = 0; i != 9; i++) {
                String line = br.readLine();
                parts = line.split(txtSplit);
                String name = parts[0].trim();
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                station = new StationInfo(name, x, y);
                stations[i] = station;
                System.out.println(stations[i]);
            }
            Stream<String> lines = Files.lines(Paths.get("network.txt"));
            String line = lines.skip(8).findFirst().get();
            read = new Scanner(line);
            while (read.hasNextLine()) {
                String data = read.nextLine();
                parts = data.split(txtSplit);
                int sourceStationNumber = indexOf(parts[0]);
                int destStationNumber = indexOf(parts[1]);
                int stationDistance = Integer.parseInt(parts[2]);
                for(StationInfo s: stations){
                 s.gVal = stationDistance;}
                distance[sourceStationNumber][destStationNumber] = stationDistance;
                System.out.println(Arrays.toString(distance));
            }
        } catch (IOException e) {
            System.out.println("e");
        }
        
    }

    public int indexOf(String name) {
        int i = 0;
        while (i != numStations && !name.equals(stations[i].getName())) {
            i++;
        }
        return i;

    }
    
    public ListInt breadthFirstTraversal(String name) {
        StationInfo val = new StationInfo(null, 0, 0);
        for(StationInfo station: stations){
        if(station.getName().equals(name)){
            val = station;
        }
         }
        
        int start = indexOf(val.getName());
        QueueInt q = new QueueInt(MAX_STATIONS);
        ListInt l = new ListInt(MAX_STATIONS);
        q.addToBack(start);
        while (q.getSize() != 0) {
            int s = q.removefromFront();
            l.append(s);
            if (!l.contains(s)) {
                l.append(s);
                for (int i = 0; i != MAX_STATIONS; i++) {
                    int s2 = distance[s][i];
                    if (!l.contains(s2)) {
                        q.addToBack(s2);
                    }
                }
            }
            
        }
        System.out.println(l);
        return l;
    }
    
    public ListInt depthFirstTraversal(String name) {
        StackInt s = new StackInt(MAX_STATIONS);
        ListInt l = new ListInt(MAX_STATIONS);
        StationInfo val = new StationInfo(null, 0, 0);
        for (StationInfo station : stations) {
            if (station.getName().equals(name)) {
                val = station;
            }
        }
        int start = indexOf(val.getName());
        s.push(start);

        while (s.getSize() != 0) {
            int t = s.pop();
            if (!l.contains(t)) {
                l.append(t);
            }
            for (int i = 0; i != MAX_STATIONS; i++) {
                int t2 = distance[t][i];
                if (!l.contains(t2)) {
                    s.push(t2);
                }

            }

        }
        System.out.println(l);
        return l;

    }
    
    public void Dijkstra(String source, String target){
    assert stations.length != 0 && !source.isEmpty() && !target.isEmpty();
    
    StationInfo start, end = new StationInfo(null, 0, 0);
    ListInt open = new ListInt(MAX_STATIONS);
    ListInt closed = new ListInt(MAX_STATIONS);
            for (StationInfo station : stations) {
            if (station.getName().equals(source)) {
                start = station;
            }
            else if(station.getName().equals(target)){
                end = station;
            }
            else{System.out.println("Source or Target station not found");}
           }
            for(StationInfo s: stations){
             open.append(indexOf(s.getName()));}
            
            
            
            while(!closed.contains(indexOf(end.getName()))){
                int x = 
            }
    
    
    }
    
}
