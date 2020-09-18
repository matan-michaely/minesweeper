package commands;

public class CommandFactory {

    public static Command getCommand(final String command, final int rows, final int cols) {
        if (command.toUpperCase().equals(Commands.EXIT.toString())) {
            return new ExitCommand();
        }
        return getCommandWithParams(command, rows, cols);

    }

    private static Command getCommandWithParams(final String command, final int rows, final int cols) {
        String[] input = command.split("\\s+");
        if (input.length != 3) {
            return new InvalidCommand();
        }

        int row;
        int col;
        try{
            row = Integer.parseInt(input[1]);
            col = Integer.parseInt(input[2]);
        }
        catch (NumberFormatException e){
            return new InvalidCommand();
        }
        if((row < 0 || row >=rows) || (col<0 || col >=cols)){
            return new InvalidCommand();
        }

        if(input[0].toUpperCase().equals(Commands.OPEN.toString())){
            return new OpenCommand(row,col);
        }

        return new InvalidCommand();


    }
}
