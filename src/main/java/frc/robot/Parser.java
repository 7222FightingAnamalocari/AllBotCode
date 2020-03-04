package frc.robot;

import frc.robot.Submodules.*;

import java.util.Stack;

public class Parser {

    public static int findArg() {
        return 0;
    }

    public static void execute(char[] instructionGroup) {
        for (int c = 0; c < instructionGroup.length; c++) {
            switch (instructionGroup[c]) {
                case 'f':
                    for (int i = 0; i < instructionGroup.length + c; i++) {
                        if (instructionGroup[i] > 45 && instructionGroup[i] < 58) {
                            for(int a=c; a<instructionGroup.length-c;a++) {

                            }
                            //Double.valueOf();
                        }
                    }
                    driveTrain.rightG.set(.2);
                    driveTrain.leftG.set(.2);
            }
        }
    }

    public static void doAuton(String instructions) {
        String[] split = instructions.split("/([,])+/g");
        Stack<String> instStack = new <String>Stack();
        for (int i = split.length; i > 0; i--) {
            instStack.push(split[i]);
        }
        for (int i = 0; i < instStack.size(); i++) {
            char[] instruction = instStack.pop().toCharArray();
            execute(instruction);
        }
    }
}
