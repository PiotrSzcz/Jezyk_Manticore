import java.util.Stack;
import java.nio.ByteBuffer;
class LLVMGenerator{

    static String main_text = "";
    static String buffer = "";
    static int reg = 1;

    static Stack<Integer> brstack = new Stack<Integer>();
    static Stack<Double> brstack_double = new Stack<Double>();

    static void call(String id) {
        buffer += "call void @" + id + "()\n";
    }

    static void declare_int(String id){
        buffer += "%"+id+" = alloca i32\n";
    }

    static void declare_float(String id, String value, String precision){
        if (precision.equals("FLOAT32")) {
            buffer += "%"+id+" = alloca float\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%"+id+" = alloca double\n";
        }
    }

    static void assign_int(String id, String value){
        buffer += "store i32 " + value + ", i32* %" + id + "\n";
    }

    static void assign_float(String id, String value, String precision) {
        if (precision.equals("FLOAT32")) {
            float floatValue = Float.parseFloat(value);
            String formattedValue = String.format("%.20f", floatValue).replace(",", ".");
            buffer += "store float " + formattedValue + ", float* %" + id + "\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "store double " + value + ", double* %" + id + "\n";
        }
    }


    static void printf_int(String id){
        buffer += "%" + reg + " = load i32, i32* %" + id + "\n";
        reg++;
        buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %"+(reg-1)+")\n";
        reg++;
    }

    static void printf_float(String id, String precision){
        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg + " = load float, float* %" + id + "\n";
            reg++;
            buffer += "%" + reg + " = fpext float %" +(reg-1)+ " to double \n";
            reg ++;
            buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %"+(reg-1)+")\n";
            reg++;
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = load double, double* %" + id + "\n";
            reg++;
            buffer += "%"+reg+" = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %"+(reg-1)+")\n";
            reg++;
        }
    }

    static void scantf_int(String id){
        buffer += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %" + id + ")\n";
        reg++;
    }

    static void scantf_double(String id, String precision){
        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strsd, i32 0, i32 0), float* %" + id + ")\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strsd, i32 0, i32 0), double* %" + id + ")\n";
        }
        reg++;
    }

    static void load_int(String id){
        buffer += "%" + reg + " = load i32, i32* %" + id + "\n";
        reg++;
    }

    static void load_float(String id, String precision){
        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg+ " = load float, double* %" + id + "\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg+ " = load double, double* %" + id + "\n";
        }
        reg++;
    }

    static void add_int(String val1, String val2){
        buffer += "%"+reg+" = add i32 "+val1+", "+val2+"\n";
        reg++;
    }

    static void add_float(String val1, String val2, String precision){
        if (precision.equals("FLOAT32")) {
            buffer += "%"+reg+" = fadd float "+val1+", "+val2+"\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%"+reg+" = fadd double "+val1+", "+val2+"\n";
        }
        reg++;
    }

    static void sub_int(String val1, String val2){
        buffer += "%"+reg+" = sub i32 "+val1+", "+val2+"\n";
        reg++;
    }

    static void sub_float(String val1, String val2, String precision){
        if (precision.equals("FLOAT32")) {
            buffer += "%"+reg+" = fsub float "+val2+", "+val1+"\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%"+reg+" = fsub double "+val2+", "+val1+"\n";
        }
        reg++;
    }

    static void mult_int(String val1, String val2){
        buffer += "%"+reg+" = mul i32 "+val1+", "+val2+"\n";
        reg++;
    }

    static void mult_float(String val1, String val2, String precision){
        if (precision.equals("FLOAT32")) {
            buffer += "%"+reg+" = fmul float "+val1+", "+val2+"\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%"+reg+" = fmul double "+val1+", "+val2+"\n";
        }
        reg++;
    }

    static void div_int(String val1, String val2){
        buffer += "%"+reg+" = sdiv i32 "+val1+", "+val2+"\n";
        reg++;
    }

    static void div_float(String val1, String val2, String precision){
        if (precision.equals("FLOAT32")) {
            buffer += "%"+reg+" = fdiv float "+val2+", "+val1+"\n";
        } else if (precision.equals("FLOAT64")) {
            buffer += "%"+reg+" = fdiv double "+val2+", "+val1+"\n";
        }
        reg++;
    }

    static void comp_int(String id, String value){
        buffer += "%"+reg+" = load i32, i32* %"+id+"\n";
        reg++;
        buffer += "%"+reg+" = icmp eq i32 %"+(reg-1)+", "+value+"\n";
        reg++;
    }

    static void comp_float(String id, String value, String precision){

        if (precision.equals("FLOAT32")) {
            buffer += "%" + reg + " = load float, double* %" + id + "\n";
            reg++;
            buffer += "%"+reg+" = fcmp oeq float %"+(reg-1)+", "+value+"\n";
            reg++;
        } else if (precision.equals("FLOAT64")) {
            buffer += "%" + reg + " = load double, double* %" + id + "\n";
            reg++;
            buffer += "%"+reg+" = fcmp oeq double %"+(reg-1)+", "+value+"\n";
            reg++;
        }
    }

    static void close_main(){
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

    static String generate(){
        String text = "";
        text += "declare i32 @printf(i8*, ...)\n";
        text += "declare i32 @scanf(i8*, ...)\n";
        text += "@strpi = constant [4 x i8] c\"%d\\0A\\00\"\n";
        text += "@strpd = constant [4 x i8] c\"%f\\0A\\00\"\n";
        text += "@strs = constant [3 x i8] c\"%d\\00\"\n";
        text += "@strd = internal constant [4 x i8] c\"%lf\\00\"\n";
        text += "\n";
        text += "define i32 @main() nounwind{\n";
        text += main_text;
        text += "  ret i32 0}\n";
        return text;
    }

}
