import datatype.ClassDatatype;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StateEntry {
    private File file;
    private int state;
    private ClassDatatype classDatatype;
    private StateMachine stateMachine;

    public StateEntry(File file) {
        this.file = file;
        this.state = 0;
        this.classDatatype = new ClassDatatype();
        this.stateMachine = new StateMachine();
        start();
    }

    public void start(){
        try {
            Scanner fileReader = new Scanner(this.file);
            while (fileReader.hasNextLine()){
                String data = fileReader.nextLine();

//                String[] split = data.split(":");
//                if(split.length > 1){
//                    System.out.println(data);
//                    System.out.println(split[1].substring(2,split[1].length()-1));
//                }
                //System.out.println(data);

                this.state = stateMachine.GetState(state,data,this.classDatatype);

                if(this.state == 1){

                    //output the class data to database
                    System.out.println(this.classDatatype.toString());


                    //new class data
                    this.state = stateMachine.GetState(state,null,classDatatype);
                }


            }

            fileReader.close();
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //upload finish
        System.out.println("finish analyze");
    }


}
