declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strd = internal constant [4 x i8] c"%lf\00"
@str = private constant [17 x i8] c"%d %f %lf %d %d\0A\00"

@x = global i32 0
%test = type { i32, float, double, i32, i32 }
@nazwaStruktury = private constant %test{ i32 1, float 2.71000003814697270000, double 3.14, i32 3, i32 4 } 
%Myclass = type {  i32, i32 }
@classExample = global %Myclass { i32 3, i32 4 } 
define i32 @main() nounwind{
  store i32 10, i32* @x
  %format = getelementptr [17 x i8], [17 x i8]* @str, i32 0, i32 0
  %1 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 0
  %strucVal0 = load i32, i32* %1
  %2 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 1
  %strucVal1 = load float, float* %2
  %3 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 2
  %strucVal2 = load double, double* %3
  %4 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 3
  %strucVal3 = load i32, i32* %4
  %5 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 4
  %strucVal4 = load i32, i32* %5
  call i32 (i8*, ...) @printf(i8* %format, i32 %strucVal0, float %strucVal1, double %strucVal2, i32 %strucVal3, i32 %strucVal4)%7 = load i32, i32* @x
  %8 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %7)
  ret i32 0}
