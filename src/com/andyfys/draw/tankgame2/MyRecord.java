package com.andyfys.draw.tankgame2;


import java.io.*;
import java.util.Vector;

/**
 * @author Andyfys
 * @version 1.0
 */
public class MyRecord {
    private static int count = 0;
    private static String filePath = "src\\myRecord.txt";
    private static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;
    private static Vector<EnemyTank> enemyTanks = null;
    private static Vector<Node> nodes = new Vector<>();


    public static Vector<Node> getNodes() {
        return nodes;
    }

    public static void setNodes(Vector<Node> nodes) {
        MyRecord.nodes = nodes;
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        MyRecord.enemyTanks = enemyTanks;
    }

    public static void record() {
        count++;
    }

    public static String getFilePath() {
        return filePath;
    }

    public static int getCount() {
        return count;
    }

    public static void readRecord() {

        String readLine = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
            count = Integer.parseInt(bufferedReader.readLine());
            while ((readLine = bufferedReader.readLine()) != null) {
                String[] s = readLine.split(" ");
                Node node = new Node(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                nodes.add(node);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }


    public static void writeRecord() {

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.write(count + "\r\n");
            for (int i = 0; i < enemyTanks.size(); i++) {
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isState() == true) {
                    String tankInfo = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDirection();
                    bufferedWriter.write(tankInfo + "\r\n");

                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
