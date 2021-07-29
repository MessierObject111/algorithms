package com.alg.other;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        //What is the criteria of getting such a conclusion?
        //I can tell what result does not meet it, thus judging who is meeting it
        //That is, after running through all set of instructions, if the terminal
        //position are away from {0, 0}, and the direction is pointing original
        // direction(north), then it is false; else it is true
        int[] position = {0, 0};
        String direction = "N";
        if(instructions.length() <= 0) return true;
        for(int i = 0; i < instructions.length(); i++) {
            String step = String.valueOf(instructions.charAt(i));
            if(step.equals("G")) {
                position = processMovement(position, direction);
            } else {
                direction = processTurn(direction, step);
            }
        }
//        if(position[0] > 0 && direction.equals("E") ||
//                position[0] < 0 && direction.equals("W") ||
//                position[1] > 0 && direction.equals("N") ||
//                position[1] < 0 && direction.equals("S")) {
//            return false;
//        }
        if(position[0] == 0 && position[1] == 0) return true;
        if(direction.equals("N")) return false;
        return true;
    }

    private int[] processMovement (int[] position, String direction) {
        if(direction.equals("E")) {
            position[0] = position[0]+1;
        }
        if(direction.equals("W")) {
            position[0] = position[0]-1;
        }
        if(direction.equals("N")) {
            position[1] = position[1]+1;
        }
        if(direction.equals("S")) {
            position[1] = position[1]-1;
        }
        return position;
    }

    private String processTurn(String direction, String turnStep) {
        if(direction.equals("E")) {
            if(turnStep.equals("L")) {
                return "N";
            }
            if(turnStep.equals("R")) {
                return "S";
            }
        }
        if(direction.equals("W")) {
            if(turnStep.equals("L")) {
                return "S";
            }
            if(turnStep.equals("R")) {
                return "N";
            }
        }
        if(direction.equals("N")) {
            if(turnStep.equals("L")) {
                return "W";
            }
            if(turnStep.equals("R")) {
                return "E";
            }
        }
        if(direction.equals("S")) {
            if(turnStep.equals("L")) {
                return "E";
            }
            if(turnStep.equals("R")) {
                return "W";
            }
        }
        return direction;
    }

    public static void main(String[] args) {
        RobotBoundedInCircle sol = new RobotBoundedInCircle();
//        String instructions_1 = "GG";//False
//        System.out.println(sol.isRobotBounded(instructions_1));
        String instructions_2 = "LLGRL";//True
        System.out.println(sol.isRobotBounded(instructions_2));
    }
}
