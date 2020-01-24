package com.blazejprzyluski.chess.client;

import com.blazejprzyluski.chess.Pieces.Move;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;

public class Client extends Thread {
    private Player player;
    private Player activePlayer;
    private PrintWriter pWriter;
    private BufferedReader receiveRead;
    private Move moveToSend = null;
    private Move moveToMake = null;

    public void prepare() throws IOException {
        Socket sock = new Socket("127.0.0.1", 5000);
        OutputStream oStream = sock.getOutputStream();
        this.pWriter = new PrintWriter(oStream, true);

        // receiving from server ( receiveRead  object)
        InputStream iStream = sock.getInputStream();
        receiveRead = new BufferedReader(new InputStreamReader(iStream));

        String inputData = receiveRead.readLine();
        System.out.println(inputData);
        IncomingData data = parseResponse(inputData);
        player = data.getPlayer();
        activePlayer = Player.WHITE;
        System.out.println(player);
    }

    @Override
    public void run() {
        String inputData = "";
        IncomingData data;
        while (true) {
            if (player == activePlayer) {
                System.out.println("Waiting for move.");
                while (this.moveToSend == null) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    pWriter.println(createJson(moveToSend));
                    System.out.println("Sending json" + createJson(moveToSend));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                pWriter.flush();
                changePlayer();
                moveToSend = null;
            } else {
                try {
                    System.out.println("Waiting for input.");
                    inputData = receiveRead.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                data = parseResponse(inputData);
                moveToMake = data.getMove();
                changePlayer();
            }
        }
    }

    private String createJson(Move m) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        if (mapper.canSerialize(SendingData.class)) {
            return mapper.writeValueAsString(new SendingData(this.activePlayer, m));
        } else {
            return null;
        }
    }

    public boolean isActivePlayer() {
        return this.activePlayer == this.player;
    }

    public IncomingData parseResponse(String response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("Getting response: " + response);
            return mapper.readValue(response, IncomingData.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setMove(Move m) {
        this.moveToSend = m;
    }

    private void changePlayer() {
        if (activePlayer == Player.WHITE) {
            activePlayer = Player.BLACK;
        } else {
            activePlayer = Player.WHITE;
        }
    }

    public Player getPlayer() {
        return this.player;
    }

    public Move getMoveToMake() {
        return this.moveToMake;
    }

    public void setMoveToMake(Move moveToMake) {
        this.moveToMake = moveToMake;
    }
}
