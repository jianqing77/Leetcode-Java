# ▫ Recursion 递归类

递归算法的三个要素：

1. **Determine the **<mark style="color:yellow;">**parameters**</mark>** and **<mark style="color:yellow;">**return values**</mark>** of the recursive function**
   1. 确定哪些参数在recursion过程中需要处理 => 把这些参数加入recursive function
   2. 确定recursion的return值是什么 => 进而确定recursive function 的return type
2. **Determine the **<mark style="color:yellow;">**termination condition**</mark>&#x20;
   1. 经常遇到Stack Overflow栈溢出的问题 => termination的终止条件写的不对
   2. 如果没有明确的终止条件或者终止条件设置得不正确，递归可能会进入无限循环。
3. **Determine the **<mark style="color:yellow;">**logic of the single-layer recursion**</mark>
   1. **确定每层recursion需要处理的信息，在这里会重复调用函数本身来实现递归的过程：**defines the operations to be carried out at each level of recursion
   2. It typically involves <mark style="color:blue;">assuming that the sub-problems have been solved, and then figuring out how to use the solutions to these sub-problems to solve the original problem</mark>. 在这一步中，一般需要通过使用一些数学归纳的思想，**假设子问题已经被解决，然后思考如何利用子问题的解来找出原问题的解。**
