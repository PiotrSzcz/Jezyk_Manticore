declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strd = internal constant [4 x i8] c"%lf\00"
@str = private constant [17 x i8] c"%d %f %lf %d %d\0A\00"

@x = global i32 0
%test = type { i32, double, double, i32, i32 }
@mystruc = private constant %test{ i32 2, double 2.2, double 2.2, i32 2, i32 2 } 
%Myclass = type {  i32, i32 }
@classExample = global %Myclass { i32 3, i32 4 } 
define void @foo(%Myclass* %obj) {
  %objVal = load %Myclass, %Myclass* %obj
  %1 = extractvalue %Myclass %objVal, 1
  %2 = extractvalue %Myclass %objVal, 0
  %3 = add i32 %2, %1
  %y = alloca i32
  store i32 %3, i32* %y
  %4 = load i32, i32* %y
  %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
  ret void
}

%Myclasss = type {  i32, i32 }
@classExamplee = global %Myclasss { i32 5, i32 11 } 
define void @fooo(%Myclasss* %obj) {
  %objVal = load %Myclasss, %Myclasss* %obj
  %1 = extractvalue %Myclasss %objVal, 1
  %2 = extractvalue %Myclasss %objVal, 0
  %3 = add i32 %2, %1
  %y = alloca i32
  store i32 %3, i32* %y
  %4 = load i32, i32* %y
  %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
  ret void
}

define i32 @main() nounwind{
  store i32 10, i32* @x
  %format = getelementptr [17 x i8], [17 x i8]* @str, i32 0, i32 0
  %1 = getelementptr %test, %test* @mystruc, i32 0, i32 0
  %strucVal0 = load i32, i32* %1
  %2 = getelementptr %test, %test* @mystruc, i32 0, i32 1
  %strucVal1 = load double, double* %2
  %3 = getelementptr %test, %test* @mystruc, i32 0, i32 2
  %strucVal2 = load double, double* %3
  %4 = getelementptr %test, %test* @mystruc, i32 0, i32 3
  %strucVal3 = load i32, i32* %4
  %5 = getelementptr %test, %test* @mystruc, i32 0, i32 4
  %strucVal4 = load i32, i32* %5
  call i32 (i8*, ...) @printf(i8* %format, i32 %strucVal0, double %strucVal1, double %strucVal2, i32 %strucVal3, i32 %strucVal4)%objPtr1 = bitcast %Myclass* @classExample to %Myclass*
  call void @foo(%Myclass* %objPtr1)
  %objPtr2 = bitcast %Myclasss* @classExamplee to %Myclasss*
  call void @fooo(%Myclasss* %objPtr2)
  %7 = sub i32 1, 1
  %8 = add i32 2, %7
  %9 = icmp eq i32 2, %8
  %10 = zext i1  %9 to i32
  %11 = icmp ne i32 %10, 0
  br i1 %11, label %true1, label %false1
  true1:
  %12 = load i32, i32* @x
  %13 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %12)
  br label %false1
  false1:
  %14 = add i32 5, 1
  %15 = sub i32 2, %14
  %16 = alloca i32
  store i32 0, i32* %16
  br label %cond2
  cond2:
  %17 = load i32, i32* %16
  %18 = add i32 %17, 1
  store i32 %18, i32* %16
  %19 = icmp slt i32 %17, %15
  br i1 %19, label %true2, label %false2
  true2:
  %20 = load i32, i32* @x
  %21 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %20)
  br label %cond2
  false2:
  ret i32 0}
