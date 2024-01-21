# M1 - Asymptotic Notation

<mark style="color:red;">**Big O Notation (O-notation)**</mark><mark style="color:red;">:</mark> Upper bound of function relations.&#x20;

> Most commonly used of the bounds because with algorithms, we usually want an upper bound on the worst case running time.

* It provides an <mark style="color:yellow;">**upper bound on the growth rate**</mark> of a function.&#x20;
* When we say an algorithm is O(f(n)), we mean that for <mark style="color:purple;">**large enough**</mark><mark style="color:purple;">** **</mark><mark style="color:purple;">**`n`**</mark>, the algorithm's running time (or space, depending on context) <mark style="color:yellow;">**will not exceed**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`f(n)`**</mark> multiplied by a constant factor.&#x20;
* It's used to describe the <mark style="color:yellow;">**worst-case scenario**</mark>.&#x20;
*

    <figure><img src="../.gitbook/assets/Screenshot 2024-01-19 at 6.10.14 PM.png" alt=""><figcaption></figcaption></figure>
* 这是最常用的渐近符号。它提供了函数增长率的<mark style="color:yellow;">**上界**</mark>。当我们说一个算法是 O(f(n)) 时，意味着对于足够大的 `n`，算法的运行时间（或空间，根据上下文而定）不会超过 `f(n)` 乘以一个常数因子。它用于描述最坏情况。

<mark style="color:red;">**Big Omega Notation (Ω-notation)**</mark>:  Lower bound of function relations

> &#x20;Ω is analogous to ≥.
>
> &#x20;Used when we may want to say, “This algorithm must take at least this much time”&#x20;
>
> &#x20;f = Ω(g(n)) if, for some positive c and n0, f(n) ≥ cg(n) for all n ≥ n0&#x20;
>
> &#x20;f = Ω(g(n)) iff g = O(f(n))

* This is used to provide a <mark style="color:yellow;">**lower bound on the growth rate**</mark> of a function.&#x20;
* When we say an algorithm is Ω(f(n)), we mean there exists some constant `c` and `n0` such that for all `n` >=`n0`, the running time (or space) is <mark style="color:purple;">**at least**</mark><mark style="color:purple;">** **</mark><mark style="color:purple;">**`c * f(n)`**</mark>.&#x20;
* It's used to describe the <mark style="color:yellow;">**best-case scenario**</mark> or to guarantee a minimum performance of an algorithm.
*

    <figure><img src="../.gitbook/assets/Screenshot 2024-01-19 at 6.11.36 PM.png" alt=""><figcaption></figcaption></figure>
* 这个符号用来提供函数增长率的<mark style="color:yellow;">**下界**</mark>。当我们说一个算法是 Ω(f(n)) 时，意味着存在某个常数 `c` 和 `n0`，使得对于所有n>`n0`，运行时间（或空间）至少是 `c * f(n)`。它用于描述最好情况或保证算法的最低性能。

<mark style="color:red;">**Big Theta Notation (Θ-notation)**</mark><mark style="color:red;">:</mark> <mark style="background-color:yellow;">**Equality**</mark> of function relations

> Θ is analogous to =
>
> &#x20;Used when we may want to say, “This is the exact growth rate of the algorithm’s time complexity”&#x20;
>
> `f = Ω(g(n))`` `<mark style="color:orange;">`&&`</mark>` ``f = O(g(n))`` `<mark style="color:orange;">`=>`</mark>` ``f = Θ(g(n)`

* This is used when a function's growth rate is <mark style="color:yellow;">**bounded both above and below by the same asymptotically tight bound**</mark>.&#x20;
* An algorithm is Θ(f(n)) if <mark style="color:yellow;">**it is both O(f(n)) and Ω(f(n))**</mark>.&#x20;
* This means there exist constants `c1` and `c2` such that for all `n` greater than some `n0`, `c1 * f(n)` is a lower bound and `c2 * f(n)` is an upper bound on the running time (or space).&#x20;
* It's used to give a <mark style="color:yellow;">**tight bound**</mark> on an algorithm's performance.
* 当函数的增长率同时被相同的渐近紧确界限上下约束时使用。如果一个算法是 Θ(f(n))，则意味着它同时是 O(f(n)) 和 Ω(f(n))。这意味着存在常数 `c1` 和 `c2`，对于所有大于某个 `n0` 的 `n`，`c1 * f(n)` 是下界，`c2 * f(n)` 是上界。它用于给出算法性能的一个紧确界限。

<mark style="color:red;">**Little o Notation (o-notation)**</mark>:&#x20;

* This is used to describe an upper bound that is not asymptotically tight.&#x20;
* When we say an algorithm is o(f(n)), it means that the algorithm grows slower than `f(n)` <mark style="color:purple;">**for all large enough**</mark><mark style="color:purple;">** **</mark><mark style="color:purple;">**`n`**</mark><mark style="color:purple;">**.**</mark>&#x20;
* In other words, the growth rate of the algorithm's complexity is <mark style="color:yellow;">**strictly less than**</mark><mark style="color:yellow;">** **</mark><mark style="color:yellow;">**`f(n)`**</mark><mark style="color:yellow;">**.**</mark>

<mark style="color:red;">**Little omega Notation (ω-notation)**</mark><mark style="color:red;">:</mark>&#x20;

* This describes a lower bound that is not tight.&#x20;
* An algorithm is ω(f(n)) if its growth rate strictly exceeds `f(n)` for all sufficiently large `n`.





1. **小o符号（o-符号）**：这个符号用来描述一个不是渐近紧确的上界。当我们说一个算法是 o(f(n)) 时，意味着算法的增长速率对于所有足够大的 `n` 都比 `f(n)` 慢。换句话说，算法复杂度的增长率严格小于 `f(n)`。
2. **小ω符号（ω-符号）**：这描述了一个不紧确的下界。如果算法是 ω(f(n))，则其增长率严格超过 `f(n)`，对于所有足够大的 `n` 都成立。
