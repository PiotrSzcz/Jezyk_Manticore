declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strd = internal constant [4 x i8] c"%lf\00"

@x = global i32 0
%test = type { i32, float, double }
@y = global double 0.0
@nazwaStruktury = private constant %test{ i32 1, float 2.71000003814697270000, double 3.14 } 
define i32 @main() nounwind{
  store i32 10, i32* @x
  %1 = load i32, i32* @x
  %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
  store double 2.1, double* @y
  %3 = load double, double* @y
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %3)
  ret i32 0}
