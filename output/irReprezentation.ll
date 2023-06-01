declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strd = internal constant [4 x i8] c"%lf\00"

define i32 @main() nounwind{
  %x = alloca i32
  store i32 10, i32* %x
  %1 = load i32, i32* %x
  %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
  %y = alloca double
  store double 3.14, double* %y
  %3 = load double, double* %y
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %3)
  %z = alloca float
  store float 2.71000003814697270000, float* %z
  %5 = load float, float* %z
  %6 = fpext float %5 to double 
  %7 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %6)
  %8 = add i32 2, 2
  %9 = add i32 100, %8
  %d = alloca i32
  store i32 %9, i32* %d
  %10 = fdiv double 4.12, 4.21
  %f = alloca double
  store double %10, double* %f
  %11 = load i32, i32* %d
  %12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %11)
  %13 = load double, double* %f
  %14 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpd, i32 0, i32 0), double %13)
  %15 = icmp eq i32 0, 0
  %16 = xor i1 %15, true
  %17 = select i1 %16, i32 0, i32 1
  %a = alloca i32
  store i32 %17, i32* %a
  %18 = load i32, i32* %a
  %19 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %18)
  ret i32 0}
