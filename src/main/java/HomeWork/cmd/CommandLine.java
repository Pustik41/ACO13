package HomeWork.cmd;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dfsdfsddfsdf on 12.07.16.
 */
public class CommandLine {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private String command;

    public void run(){

        File file = new File("/");
        System.out.println(file.getAbsolutePath() + "$ ");

        work(file.getAbsolutePath());
    }

    private void work(String path){

        try {
            command = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] commands = command.split(" ");

        File newFile = new File(commands[1]);

        System.out.println(newFile.getAbsolutePath() + "$ ");

        work(commands[1]);

       /* if(newFile.isDirectory()) {
            File[] files = newFile.listFiles();


            for (File file1 : files) {
                if(!file1.isHidden())
                    System.out.printf("%s   %d\n", file1.getName(), file1.length());
            }
        }*/


    }
}
