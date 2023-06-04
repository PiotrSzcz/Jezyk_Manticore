declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strd = internal constant [4 x i8] c"%lf\00"
@str = private constant [17 x i8] c"%d %f %lf %d %d\0A\00"

@x = global i32 0
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

define i32 @main() nounwind{
  store i32 10, i32* @x
  %objPtr = bitcast %Myclass* @classExample to %Myclass*
  call void @foo(%Myclass* %objPtr)
  %1 = load i32, i32* @x
  %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
  ret i32 0}
