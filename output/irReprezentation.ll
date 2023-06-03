declare i32 @printf(i8*, ...)
declare i32 @scanf(i8*, ...)
@strpi = constant [4 x i8] c"%d\0A\00"
@strpd = constant [4 x i8] c"%f\0A\00"
@strs = constant [3 x i8] c"%d\00"
@strd = internal constant [4 x i8] c"%lf\00"

@x = global i32 0
define void @dupa() nounwind {
  %z = alloca i32
  store i32 1, i32* %z
  %1 = load i32, i32* @x
  %2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %1)
  %3 = load i32, i32* %y
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %3)
  ret void
}

define i32 @main() nounwind{
  store i32 10, i32* @x
  %1 = icmp eq i32 1, 1
  %2 = zext i1  %1 to i32
  %3 = icmp ne i32 %2, 0
  br i1 %3, label %true1, label %false1
  true1:
  %y = alloca i32
  store i32 3, i32* %y
  %4 = load i32, i32* @x
  %5 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @strpi, i32 0, i32 0), i32 %4)
  br label %false1
  false1:
  call void @dupa()
  ret i32 0}
