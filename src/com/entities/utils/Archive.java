package com.entities.utils;

import java.io.*;

public class Archive {


    public Archive(){
    }

    public static String Read(String path){
        String conteudo = "";
        try {
            FileReader arq = new FileReader(path);
            BufferedReader read = new BufferedReader(arq);
            String line="";
            try {
                line = read.readLine();
                while(line!=null){
                    conteudo += line+"\n";
                    line = read.readLine();
                }
                arq.close();
                return conteudo;
            } catch (IOException ex) {
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    public static void Write(String path, String name, String patology, String birth, String payment, String discount, String cd) {
        try {

            FileWriter arq = new FileWriter(path);
            try (PrintWriter gravar = new PrintWriter(arq)) {
                gravar.print(name + ";" + birth + ";" + patology + ";" + payment + ";" + discount + ";" + cd);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void Write2(String path, String task) {
        try {

            FileWriter arq = new FileWriter(path);
            try (PrintWriter gravar = new PrintWriter(arq)) {
                gravar.print(task);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
