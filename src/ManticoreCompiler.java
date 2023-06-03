import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class ManticoreCompiler {
    public static void main(String[] args) {

        assert args.length >= 2 : "Nie podano adresu pliku do kompilacji lub nazwy pliku wyjściowego.";
        String inputFilePath = args[0];
        String outputFileName = args[1];

        try {
            CharStream charStream = CharStreams.fromFileName(inputFilePath);
            MantricoreLexer mantricoreLexer = new MantricoreLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(mantricoreLexer);
            MantricoreParser mantricoreParser = new MantricoreParser(commonTokenStream);
            ParseTree parseTree = mantricoreParser.start();
            System.out.println(parseTree.toStringTree(mantricoreParser));
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(new LLVMActions("./output/irReprezentation"), parseTree);
            System.out.println("IR zostało zapisane do pliku: " + "irReprezentation");

//            ProcessBuilder processBuilder = new ProcessBuilder("llc", " -filetype=obj", " ./output/irReprezentation", " -o", " ./output/output.o");
//            Process process = processBuilder.start();
//            int exitCode = process.waitFor();
//            System.out.println("Kod wyjścia: " + exitCode);
//
//            processBuilder = new ProcessBuilder("clang", " -no-pie", "output.o", " -o", " ./output/program.exe");
//            process = processBuilder.start();
//            exitCode = process.waitFor();
//            System.out.println("Kod wyjścia: " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        }
//        catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}
