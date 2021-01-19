import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class XorMachine {
    public static void main(String[] args) {
        try {
            if (args.length > 0) {
                int loop = 0;
                boolean a, b;
                a = b = false;
                String program = Files.readString(Path.of(args[0]));
                for (int c = 0, l = program.length() ; c < l ; c++) {
                    loop++;
                    char i = program.charAt(c);
                    try {
                        if (i == 'a' && program.charAt(loop) == 'a') {
                            a = (a && !a) || (!a && a);
                        } else if (i == 'a' && program.charAt(loop) == 'b') {
                            a = (a && !b) || (!a && b);
                        } else if (i == 'a' && program.charAt(loop) == '1') {
                            a = (a && !true) || (!a && true);
                        } else if (i == 'b' && program.charAt(loop) == 'a') {
                            b = (b && !a) || (!b && a);
                        } else if (i == 'b' && program.charAt(loop) == 'b') {
                            b = (b && !b) || (!b && b);
                        } else if (i == 'b' && program.charAt(loop) == '1') {
                            b = (b && !true) || (!b && true);
                        }
                    } catch (ArrayIndexOutOfBoundsException error) {;}
                } 
                System.out.println((a ? 1 : 0) > (b ? 1 : 0) ? 1 : 0);
            } else {
                System.out.println("No arguments supplied.");
            }
        } catch (IOException error) {
            System.out.printf("No such file or directory: %s\n", args[0]);
        }
    }
}
