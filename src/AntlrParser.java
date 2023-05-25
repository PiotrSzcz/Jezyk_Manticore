import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;

public class AntlrParser {

    public static void main(String[] args) throws IOException {

        CharStream charStream = CharStreams.fromFileName("./src/example.cc");
        MantricoreLexer mantricoreLexer = new MantricoreLexer(charStream);
        CommonTokenStream commonTokenStream = new CommonTokenStream(mantricoreLexer);
        MantricoreParser mantricoreParser = new MantricoreParser(commonTokenStream);
        System.out.println("DUPA!!!");

    }


}
