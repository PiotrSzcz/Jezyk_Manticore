import java.util.List;
import java.util.Stack;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

class LLVMGenerator {

    static String header_text = "";
    static String main_text = "";
    static String buffer = "";
    static String valToCall = "";
    static int main_tmp = 1;
    static int reg = 1;
    static int br = 0;
    static Stack<Integer> brstack = new Stack<Integer>();
    static Stack<Double> brstack_double = new Stack<Double>();

    static void declare_int(String id, Boolean global) {
        if (global) {
            header_text += "@" + id + " = global i32 0\n";
        } else {
            buffer += "%" + id + " = alloca i32\n";
        }
    }

    static void declare_float(String id, String precision, Boolean global) {
        if (global) {
            if (precision.equals("FLOAT32")) {
                header_text += "@" + id + " = global float 0.0\n";
            } else if (precision.equals("FLOAT64")) {
                header_text += "@" + id + " = global double 0.0\n";
            }
        } else {
            if (precision.equals("FLOAT32")) {
                buffer += "%" + id + " = alloca float\n";
            } else if (precision.equals("FLOAT64")) {
                buffer += "%" + id + " = alloca double\n";
            }
        }
    }

    static void declare_class(String name, List<String> valuesTypes) {
        header_text += "%" + name + " = type { " + valuesTypes.toString().replace('[', ' ').replace(']', ' ') + "}\n";
    }

    static void assign_class(String name, String type, List<Value> values) {
        header_text += "@" + name + " = global %" + type + " { ";
        values.forEach(value -> {
            String vartype = "";
            switch (value.precision.toString()) {
                case "DM" -> vartype = "i32";
                case "FLOAT32" -> vartype = "float";
                case "FLOAT64" -> vartype = "double";
                default -> throw new IllegalStateException("Unexpected value: " + value);
            }
            if (vartype.equals("float")) {
                String formattedValue = value.name;
                float floatValue = Float.parseFloat(value.name);
                formattedValue = String.format("%.20f", floatValue).replace(",", ".");
                header_text += vartype + " " + formattedValue + ", ";
            } else {
                header_text += vartype + " " + value.name + ", ";
            }
        });
        header_text = header_text.substring(0, header_text.length() - 2);
        header_text += " } \n";

        //@myObject = global %MyClass { i32 10, i8* null }
    }

    static void declare_struc(String name, List<String> values) {
        header_text += "%" + name + " = type {" + values.toString().replace('[', ' ').replace(']', ' ') + "}\n";
    }

    static void assign_struc(String type, String name, List<Value> values) {
        header_text += "@" + name + " = private constant %" + type + "{ ";
        values.forEach(value -> {
            String vartype = "";
            switch (value.precision.toString()) {
                case "DM" -> vartype = "i32";
                case "FLOAT32" -> vartype = "float";
                case "FLOAT64" -> vartype = "double";
                default -> throw new IllegalStateException("Unexpected value: " + value);
            }
            if (vartype.equals("float")) {
                String formattedValue = value.name;
                float floatValue = Float.parseFloat(value.name);
                formattedValue = String.format("%.20f", floatValue).replace(",", ".");
                header_text += vartype + " " + formattedValue + ", ";
            } else {
                header_text += vartype + " " + value.name + ", ";
            }
        });
        header_text = header_text.substring(0, header_text.length() - 2);
        header_text += " } \n";
    }

    static void print_struc(String type, String name, List<Value> valueList) {
        buffer += "%format = getelementptr [17 x i8], [17 x i8]* @str, i32 0, i32 0\n";
        AtomicInteger valCounter = new AtomicInteger(0);
        valueList.forEach(value -> {
            String vartype = "";
            switch (value.precision.toString()) {
                case "DM" -> vartype = "i32";
                case "FLOAT32" -> vartype = "float";
                case "FLOAT64" -> vartype = "double";
                default -> throw new IllegalStateException("Unexpected value: " + value);
            }
            buffer += "%" + reg + " = getelementptr %" + type + ", %" + type + "*" + " @" + name + ", i32 0, i32 " + valCounter + "\n";
            buffer += "%strucVal" + valCounter + " = load " + vartype + ", " + vartype + "* %" + reg + "\n";
            valToCall += vartype + " %strucVal" + valCounter + ", ";
            reg++;
            valCounter.getAndIncrement();
        });
        buffer += "call i32 (i8*, ...) @printf(i8* %format, " + valToCall.substring(0, valToCall.length() - 2) + ")";
        valToCall = "";
        reg++;           //Jak cos nie działą to pewnie to (#czemutoiterujetoniewiem)
    }

    static void assign_int(String id, String value, HashSet<String> global) {
        if (global != null && global.contains(id)) {
            buffer += "store i32 " + value + ", i32* @" + id + "\n";
        } else {
            buffer += "store i32 " + value + ", i32* %" + id + "\n";
        }
    }

    static void assign_float(String id, String value, String precision, HashSet<String> global) {
        if (global.contains(id)) {
            if (precision.equals("FLOAT32")) {
                String formattedValue = value;
                if (!value.contains("%")) {
                    float floatValue = Float.parseFloat(value);
                    formattedValue = String.format("%.20f", floatValue).replace(",", ".");
                }
                buffer += "store float " + formattedValue + ", float* @" + id + "\n";
            } else if (precision.equals("FLOAT64")) {
                buffer += "store double " + value + ", double* @" + id + "\n";
            }
        } else {
            if (precision.equals("FLOAT32")) {
                String formattedValue = value;
                if (!value.contains("%")) {
                    float floatValue = Float.parseFloat(value);
                    formattedValue = String.format("%.20f", floatValue).replace(",", ".");
                }
                buffer += "store float " + formattedValue + ", float* %" + id + "\n";
            } else if (precision.equals("FLOAT64")) {
                buffer += "store double " + value + ", double* %" + id + "\n";
            }
        }


    }

    static void printf_int(String id, HashSet<String> global) {
        if (global.contains(id)) {
            buffer += "%" + reg + " = load i32, i32* @" + id + "\n";
        } else {
            buffer += "%" + reg + " = load i32, i32* %" + id + "\n";
        }
        reg++;
        buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %" + (reg - 1) + ")\n";
        reg++;
    }

    static void printf_float(String id, String precision, HashSet<String> global) {
        if (global.contains(id)) {
            if (precision.equals("FLOAT32")) {
                buffer += "%" + reg + " = load float, float* @" + id + "\n";
                reg++;
                buffer += "%" + reg + " = fpext float %" + (reg - 1) + " to double \n";
                reg++;
                buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %" + (reg - 1) + ")\n";
                reg++;
            } else if (precision.equals("FLOAT64")) {
                buffer += "%" + reg + " = load double, double* @" + id + "\n";
                reg++;
                buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %" + (reg - 1) + ")\n";
                reg++;
            }
        } else {
            if (precision.equals("FLOAT32")) {
                buffer += "%" + reg + " = load float, float* %" + id + "\n";
                reg++;
                buffer += "%" + reg + " = fpext float %" + (reg - 1) + " to double \n";
                reg++;
                buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %" + (reg - 1) + ")\n";
                reg++;
            } else if (precision.equals("FLOAT64")) {
                buffer += "%" + reg + " = load double, double* %" + id + "\n";
                reg++;
                buffer += "%" + reg + " = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %" + (reg - 1) + ")\n";
                reg++;
            }
        }


    }

    static void scantf_int(String id, HashSet<String> global) {
        if (global.contains(id)) {
            buffer += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %" + id + ")\n";
        } else {
            buffer += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %" + id + ")\n";
        }
        reg++;
    }

    static void load_float(String id, String precision) {
        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg + " = load float, double* %" + id + "\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = load double, double* %" + id + "\n";
        }
        reg++;
    }

    static void int_to_i1(String val) {
        buffer += "%" + reg + " = icmp ne i32 " + val + ", 0\n";
        reg++;
    }

    static void add_int(String val1, String val2) {
        buffer += "%" + reg + " = add i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void add_args(String val1, String val2, String className) {

        buffer += "%" + reg + " = extractvalue %" + className + " %objVal," + val1.replace("arg", " ") + "\n";
        reg++;
        buffer += "%" + reg + " = extractvalue %" + className + " %objVal," + val2.replace("arg", " ") + "\n";
        reg++;
        buffer += "%" + reg + " = add i32 %" + (reg - 1) + ", %" + (reg - 2) + "\n";
        reg++;
    }

    static void add_float(String val1, String val2, String precision) {
        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg + " = fadd float " + val1 + ", " + val2 + "\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = fadd double " + val1 + ", " + val2 + "\n";
        }
        reg++;
    }

    static void sub_int(String val1, String val2) {
        buffer += "%" + reg + " = sub i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void sub_float(String val1, String val2, String precision) {
        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg + " = fsub float " + val2 + ", " + val1 + "\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = fsub double " + val2 + ", " + val1 + "\n";
        }
        reg++;
    }

    static void mult_int(String val1, String val2) {
        buffer += "%" + reg + " = mul i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void mult_float(String val1, String val2, String precision) {
        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg + " = fmul float " + val1 + ", " + val2 + "\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = fmul double " + val1 + ", " + val2 + "\n";
        }
        reg++;
    }

    static void div_int(String val1, String val2) {
        buffer += "%" + reg + " = sdiv i32 " + val1 + ", " + val2 + "\n";
        reg++;
    }

    static void div_float(String val1, String val2, String precision) {
        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg + " = fdiv float " + val2 + ", " + val1 + "\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = fdiv double " + val2 + ", " + val1 + "\n";
        }
        reg++;
    }

    static void comp_int(String val1, String val2) {
        buffer += "%" + reg + " = icmp eq i32 " + val1 + ", " + val2 + "\n";
        reg++;
        buffer += "%" + reg + " = zext i1  %" + (reg - 1) + " to i32\n";
        reg++;
    }

    static void comp_float(String val1, String val2, String precision) {

        if (precision.equals("FLOAT32")) {
            float float1Value = Float.parseFloat(val1);
            String formattedValue1 = String.format("%.20f", float1Value).replace(",", ".");
            float float2Value = Float.parseFloat(val2);
            String formattedValue2 = String.format("%.20f", float2Value).replace(",", ".");
            buffer += "%" + reg + " = fcmp oeq float " + formattedValue1 + ", " + formattedValue2 + "\n";
            reg++;
            buffer += "%" + reg + " = zext i1  %" + (reg - 1) + " to i32\n";
            reg++;
            buffer += "%" + reg + " = sitofp i32  %" + (reg - 1) + " to float\n";
            reg++;
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = fcmp ueq double " + val1 + ", " + val2 + "\n";
            reg++;
            buffer += "%" + reg + " = zext i1  %" + (reg - 1) + " to i32\n";
            reg++;
            buffer += "%" + reg + " = sitofp i32  %" + (reg - 1) + " to double\n";
            reg++;
        }
    }

    static void and_int(String val1, String val2) {
        buffer += "%" + reg + " = icmp ne i32 " + val1 + ", 0\n";
        reg++;
        buffer += "%" + reg + " = icmp ne i32 " + val2 + ", 0\n";
        reg++;
        buffer += "%" + reg + " = and i1 %" + (reg - 1) + ", %" + (reg - 2) + "\n";
        reg++;
        buffer += "%" + reg + " = zext i1  %" + (reg - 1) + " to i32\n";
        reg++;
    }

    static void or_int(String val1, String val2) {
        buffer += "%" + reg + " = icmp ne i32 " + val1 + ", 0\n";
        reg++;
        buffer += "%" + reg + " = icmp ne i32 " + val2 + ", 0\n";
        reg++;
        buffer += "%" + reg + " = or i1 %" + (reg - 1) + ", %" + (reg - 2) + "\n";
        reg++;
        buffer += "%" + reg + " = zext i1 %" + (reg - 1) + " to i32\n";
        reg++;
    }

    static void not_int(String val) {
        buffer += "%" + reg + " = icmp eq i32 " + val + ", 0\n";
        reg++;
        buffer += "%" + reg + " = xor i1 %" + (reg - 1) + ", true\n";
        reg++;
        buffer += "%" + reg + " = select i1 %" + (reg - 1) + ", i32 0, i32 1\n";
        reg++;
    }

    static void repeatstart(String repetitions) {
        String id = Integer.toString(reg);
        buffer += "%" + id + " = alloca i32\n";

        int counter = reg;
        reg++;

        id = Integer.toString(counter);
        buffer += "store i32 " + "0" + ", i32* %" + id + "\n";
        br++;

        buffer += "br label %cond" + br + "\n";
        buffer += "cond" + br + ":\n";

        buffer += "%" + reg + " = load i32, i32* %" + id + "\n";
        reg++;

        String val1 = "%" + (reg - 1);
        String val2 = "1";
        buffer += "%" + reg + " = add i32 " + val1 + ", " + val2 + "\n";
        reg++;

        String value = "%" + (reg - 1);
        buffer += "store i32 " + value + ", i32* %" + id + "\n";

        buffer += "%" + reg + " = icmp slt i32 %" + (reg - 2) + ", " + repetitions + "\n";
        reg++;

        buffer += "br i1 %" + (reg - 1) + ", label %true" + br + ", label %false" + br + "\n";
        buffer += "true" + br + ":\n";
        brstack.push(br);
    }

    static void repeatend() {
        int b = brstack.pop();
        buffer += "br label %cond" + b + "\n";
        buffer += "false" + b + ":\n";
    }

    static void function_start(String id) {
        main_text += buffer;
        main_tmp = reg;
        buffer = "define void @" + id + "() nounwind {\n";
        reg = 1;
    }

    static void function_end() {
        buffer += "ret void\n";
        formatBuffer();
        buffer += "}\n\n";
        header_text += buffer;
        buffer = "";
        reg = main_tmp;
    }

    static void classFun_start(String name, String type) {
        main_text += buffer;
        main_tmp = reg;
        buffer = "define void @" + name + "(%" + type + "* %obj) {\n";
        buffer += "%objVal = load %" + type + ", %" + type + "* %obj\n";
        reg = 1;
    }

    static void classFun_end() {
        buffer += "ret void\n";
        formatBuffer();
        buffer += "}\n\n";
        header_text += buffer;
        buffer = "";
        reg = main_tmp;
    }

    static void ifstart() {
        br++;
        buffer += "br i1 %" + (reg - 1) + ", label %true" + br + ", label %false" + br + "\n";
        buffer += "true" + br + ":\n";
        brstack.push(br);
    }

    static void ifend() {
        int b = brstack.pop();
        buffer += "br label %false" + b + "\n";
        buffer += "false" + b + ":\n";
    }

    static void call(String id) {
        buffer += "call void @" + id + "()\n";
    }

    static void classFunCall(String obj, String funID, String className, int classNumber) {
        buffer += "%objPtr"+classNumber+" = bitcast %" + className + "* @" + obj + " to %" + className + "*\n";
        buffer += "call void @" + funID + "(%" + className + "* %objPtr" +classNumber+ ")\n";
    }

    private static void formatBuffer() {
        String[] lines = buffer.split("\n");
        StringBuilder sb = new StringBuilder();
        sb.append(lines[0]).append("\n");
        for (int i = 1; i < lines.length; i++) {
            sb.append("  ").append(lines[i]).append("\n");
        }
        buffer = sb.toString();
    }

    static void close_main() {
        main_text += buffer;
        formatMainText();
    }

    private static void formatMainText() {
        String[] lines = main_text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append("  ").append(line).append("\n");
        }
        main_text = sb.toString();
    }

    static String generate() {
        String text = "";
        text += "declare i32 @printf(i8*, ...)\n";
        text += "declare i32 @scanf(i8*, ...)\n";
        text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n";
        text += "@strs = constant [3 x i8] c\"%d\\00\"\n";
        text += "@strd = internal constant [4 x i8] c\"%lf\\00\"\n";
        text += "@str = private constant [17 x i8] c\"%d %f %lf %d %d\\0A\\00\"\n";
        text += "\n";
        text += header_text;
        text += "define i32 @main() nounwind{\n";
        text += main_text;
        text += "  ret i32 0}\n";
        return text;
    }
}
