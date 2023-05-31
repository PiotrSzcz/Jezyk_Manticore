declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strd = internal constant [4 x i8] c"%lf\00"

define i32 @main() nounwind{
  %x = alloca i32
  store i32 10, i32* %x
  %y = alloca double
  store double 3.14, double* %y
  %z = alloca float
  store float 2.71000003814697270000, float* %z
  %1 = load i32, i32* %x
  %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
  %3 = call i32 (i8*, ...) @scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @strs, i32 0, i32 0), i32* %x)
  %4 = load double, double* %y
  %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %4)
  ret i32 0}