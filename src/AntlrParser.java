import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

public class AntlrParser {
    public static void main(String[] args) {
        try {
            CharStream charStream = CharStreams.fromFileName("./src/example.cc");
            MantricoreLexer mantricoreLexer = new MantricoreLexer(charStream);
            CommonTokenStream commonTokenStream = new CommonTokenStream(mantricoreLexer);
            MantricoreParser mantricoreParser = new MantricoreParser(commonTokenStream);
            ParseTree parseTree = mantricoreParser.start();
            System.out.println(parseTree.toStringTree(mantricoreParser));
            ParseTreeWalker walker = new ParseTreeWalker();
            System.out.println("Tutaj sie zaczyna :");
            walker.walk(new LLVMActions(), parseTree);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
