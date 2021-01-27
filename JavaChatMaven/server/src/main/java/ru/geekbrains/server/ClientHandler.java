package ru.geekbrains.server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ClientHandler {
    private Server server;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private String nickname;
    ExecutorService executorService;

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            executorService= Executors.newSingleThreadExecutor();
            executorService.execute(new MyThread("Thread1"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickname() {
        return nickname;
    }

    class MyThread implements Runnable{
        String name;
        public MyThread(String name){
            this.name = name;
            new Thread(this);
        }
        @Override
        public void run() {
            try {
                while (true) {
                    String str = in.readUTF();
                    // /auth login1 password1
                    if (str.startsWith("/auth")) {
                        String[] subStrings = str.split(" ", 3);
                        if (subStrings.length == 3) {
                            String nickFromDB = SQLHandler.getNickByLoginAndPassword(subStrings[1], subStrings[2]);
                            if (nickFromDB != null) {
                                if (!server.isNickInChat(nickFromDB)) {
                                    nickname = nickFromDB;
                                    sendMsg("/authok " + nickname);
                                    server.subscribe(ClientHandler.this);
                                    break;
                                } else {
                                    sendMsg("This nick already in use");
                                }
                            } else {
                                sendMsg("Wrong login/password");
                            }
                        } else {
                            sendMsg("Wrong data format");
                        }
                    }
                    if (str.startsWith("/registration")) {
                        String[] subStr = str.split(" ");
                        // /registration login pass nick
                        if (subStr.length == 4) {
                            if (SQLHandler.tryToRegister(subStr[1], subStr[2], subStr[3])) {
                                sendMsg("Registration complete");
                            } else {
                                sendMsg("Incorrect login/password/nickname");
                            }
                        }
                    }
                }
                while (true) {
                    String str = in.readUTF();
                    System.out.println("Сообщение от клиента: " + str);
                    if (str.startsWith("/")) {
                        if (str.equals("/end")) {
                            break;
                        } else if (str.startsWith("/w")) {
                            // /w nick hello m8! hi
                            final String[] subStrings = str.split(" ", 3);
                            if (subStrings.length == 3) {
                                final String toUserNick = subStrings[1];
                                if (server.isNickInChat(toUserNick)) {
                                    server.unicastMsg(toUserNick, "from " + nickname + ": " + subStrings[2]);
                                    sendMsg("to " + toUserNick + ": " + subStrings[2]);
                                } else {
                                    sendMsg("User with nick '" + toUserNick + "' not found in chat room");
                                }
                            } else {
                                sendMsg("Wrong private message");
                            }
                        } else if (str.startsWith("/changenick")){
                            // /changenick Macmepuo Macmepuo3
                            final String[] subStrings = str.split(" ", 3);
                            if (subStrings.length == 3) {
                                final String toUserNick = subStrings[1];
                                if (server.isNickInChat(toUserNick)) {
                                    String toUserNick2 = SQLHandler.ChangeNick(subStrings[2], toUserNick);
                                    nickname=toUserNick2;
                                    server.subscribe(ClientHandler.this);
                                    sendMsg("Смена ника выполнена");
                                } else {
                                    sendMsg("User with nick '" + toUserNick + "' not found in chat room");
                                }
                            } else {
                                sendMsg("Incorrect");
                            }
                        }
//
                    } else {
                        server.broadcastMsg(nickname + ": " + str);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server.unsubscribe(ClientHandler.this);
            }
        }
        }
}
