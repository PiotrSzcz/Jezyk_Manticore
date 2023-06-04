declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strd = internal constant [4 x i8] c"%lf\00"
@str = private constant [17 x i8] c"%d %f %lf %d %d\0A\00"

@x = global i32 0
@y = global i32 0
define void @function() nounwind {
  %z = alloca i32
  store i32 3, i32* %z
  %1 = load i32, i32* @y
  %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
  %3 = load i32, i32* %z
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
  ret void
}

%test = type { i32, float, double, i32, i32 }
@nazwaStruktury = private constant %test{ i32 1, float 2.71000003814697270000, double 3.14, i32 3, i32 12 } 
@w = global float 0.0
define i32 @main() nounwind{
  store i32 1, i32* @x
  %1 = icmp eq i32 1, 1
  %2 = zext i1  %1 to i32
  %3 = icmp ne i32 %2, 0
  br i1 %3, label %true1, label %false1
  true1:
  store i32 2, i32* @y
  %4 = load i32, i32* @x
  %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
  br label %false1
  false1:
  %format = getelementptr [17 x i8], [17 x i8]* @str, i32 0, i32 0
  %6 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 0
  %strucVal0 = load i32, i32* %6
  %7 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 1
  %strucVal1 = load float, float* %7
  %8 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 2
  %strucVal2 = load double, double* %8
  %9 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 3
  %strucVal3 = load i32, i32* %9
  %10 = getelementptr %test, %test* @nazwaStruktury, i32 0, i32 4
  %strucVal4 = load i32, i32* %10
  call i32 (i8*, ...) @printf(i8* %format, i32 %strucVal0, float %strucVal1, double %strucVal2, i32 %strucVal3, i32 %strucVal4)store float 3.14000010490417500000, float* @w
  %12 = load float, float* @w
  %13 = fpext float %12 to double 
  %14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %13)
  call void @function()
  ret i32 0}
