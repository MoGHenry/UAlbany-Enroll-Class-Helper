import datatype.ClassDatatype;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class StateEntry {
    private File file;
    private int state;
    private ClassDatatype classDatatype;
    private StateMachine stateMachine;
    private Connecter connecter;

    public StateEntry(File file) {
        this.file = file;
        this.state = 0;
        this.classDatatype = new ClassDatatype();
        this.stateMachine = new StateMachine();
        this.connecter = new Connecter();
        try{
            this.connecter.showDatabase();
        }catch(SQLException e){}

        start();
    }

    public void start(){
        try {
            Scanner fileReader = new Scanner(this.file);
            while (fileReader.hasNextLine()){
                String data = fileReader.nextLine();

                this.state = stateMachine.GetState(state,data,this.classDatatype);
                this.classDatatype.setOther("");

                if((this.state == 1)){
                    if (!this.classDatatype.getLevel().equalsIgnoreCase("")) {
                        //System.out.println(this.classDatatype.getLevel().equalsIgnoreCase(""));

                        //output the class data to database
//                        System.out.println(this.classDatatype.toString()); //right now just output to shell
//                        if(this.classDatatype.getClassNumber().equalsIgnoreCase("5350")){
//                            while(true){}
//                        }
                        try{
                            this.connecter.sent(this.classDatatype);
                        }catch(SQLException e){}
                        this.classDatatype = new ClassDatatype();
                    }
                    //new class data
                    this.state = stateMachine.GetState(state,null,classDatatype);

                }


            }

            fileReader.close();
            try{
                this.connecter.showDatabase();
                this.connecter.closeConnecter();
            }catch(SQLException e){}

        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //upload finish
        System.out.println("finish analyze");
    }


}
