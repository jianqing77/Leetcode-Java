# M2 - Complexity (Computability & Cryptography)

<mark style="color:yellow;">**Primes and Composites**</mark>

A **prime number** is a natural number greater than 1 that has no positive divisors other than 1 and itself. In other words, a prime number is a number that cannot be formed by multiplying two smaller natural numbers. Examples of prime numbers are 2, 3, 5, 7, 11, 13, and so on.

A **composite number** is a positive integer that has at least one positive divisor other than 1 and itself, which means it can be formed from multiplying two smaller natural numbers. For example, the number 6 is composite because it is the product of 2 and 3.

{% hint style="info" %}
GCD(A,B) = largest number D such that D is a divisor of A and D is a divisor of B
{% endhint %}

<mark style="color:yellow;">**Euclid's algorithm**</mark>

{% hint style="info" %}
$$GCD(A,B) = GCD(B, A   mod B)$$
{% endhint %}

The algorithm is based on the principle that the GCD of two numbers also divides their difference.

1. If (B = 0), then $$GCD(A, B)$$is (A) (since the GCD of any number and 0 is the number itself), and the algorithm stops.
2. If (B $$\neq$$ 0), calculate the $$GCD(A, B) = GCD(B,  Amod B):$$, where "mod" is the modulo operation, which gives the remainder of the division of (A) by (B).
3. Replace (A) with (B) and (B) with (A) mod (B) and repeat the process until (B) equals 0.

Here's the step-by-step example using the formula $$GCD(A, B) = GCD(B, Amod B):$$

1. GCD(48, 18) = GCD(18, 48 mod 18). Since 48 mod 18 is 12, the equation becomes GCD(18, 12).
2. GCD(18, 12) = GCD(12, 18 mod 12).18 mod 12 is 6, so the equation becomes GCD(12, 6).
3. GCD(12, 6) = GCD(6, 12 mod 6), 12 mod 6 is 0, so the equation becomes GCD(6, 0).
4. At this point, since the second number is 0, the GCD is the first non-zero number, which is 6. Thus, the GCD of 48 and 18 is 6.

Let's denote the two numbers for which we want to find the GCD as `a` and `b`. If `n` is the number of bits representing the larger of the two numbers, the complexity of Euclid's algorithm can be analyzed as follows:

1. **Each step of Euclid's algorithm**: In each step, the algorithm <mark style="color:green;">**replaces the pair**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`(a, b)`**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**with**</mark><mark style="color:green;">** **</mark><mark style="color:green;">**`(b, a mod b)`**</mark>, where `mod` denotes the modulo operation. The key observation is that this operation reduces the size of one of the integers by at least half every two steps, which can be proved by the Lamé's theorem.
2. **Number of steps**: Due to the reduction property mentioned, the number of steps in Euclid's algorithm is at most `2n` for n-bit integers.
3. **Complexity of each step**: Each step of the algorithm requires a division, which is the most complex part. The division operation of two n-bit numbers can be done in `O(n^2)` using long division. However, faster algorithms like Karatsuba or Schönhage-Strassen can perform division (and multiplication, since division algorithms use multiplication) in subquadratic time.
4. **Total complexity**: If we use `O(n^2)` for each division, the overall worst-case complexity of the algorithm would be `O(n^3)`. However, with more advanced multiplication and division algorithms, this can be reduced.

Polynomial:多项式

<figure><img src="../.gitbook/assets/Screenshot 2024-01-20 at 2.25.04 PM.png" alt=""><figcaption></figcaption></figure>

<mark style="color:yellow;">**Modular Arithmetic (**</mark>clock arithmetic<mark style="color:yellow;">**)**</mark>

Quotient-remainder Theorem&#x20;

* For integers a, b > 0, there exist unique q and r such that a = qb + r where 0 ≤ r ≤ b-1 •
* Definition: a ≡ b (mod n) if n | (a – b) read ≡ as “congruent to”&#x20;
* <mark style="color:yellow;">**“a mod n”**</mark> means the remainder when a is divided by n&#x20;

{% hint style="info" %}
* <mark style="color:yellow;">**a ≡ b (mod n)**</mark> means <mark style="color:green;">**a and b have the same remainder when divided by n**</mark>
* Addition: if a ≡ b (mod n) and c ≡ d (mod n) then (a + c) ≡ (b + d) (mod n)
* Multiplication: if a ≡ b (mod n) and c ≡ d (mod n) then a_c ≡ b_d (mod n)&#x20;
{% endhint %}

Example: 9876 ≡ 6 (mod 10) and 17642 ≡ 2 (mod 10) => 9876 + 17642 (mod 10) ≡ 6 + 2 (mod 10) ≡ 8 (mod 10)   Also, 9876 \* 17642 (mod 10) ≡ 6 \* 2 (mod 10) ≡ 2 (mod 10)

#### <mark style="color:yellow;">Fast Modular Exponentiation</mark>

{% embed url="https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/fast-modular-exponentiation" %}

<mark style="color:yellow;">**Modular arithmetic**</mark>

Modular arithmetic has several other properties that are frequently used in various mathematical computations and cryptographic algorithms:

\- Addition: $$(a + b) \mod p = [(a \mod p) + (b \mod p)] \mod p$$

\- Subtraction: $$(a - b) \mod p = [(a \mod p) - (b \mod p)] \mod p$$

\- Multiplication: $$(a \cdot b) \mod p = [(a \mod p) \cdot (b \mod p)] \mod p$$

\- Distributive: $$a \cdot (b + c) \mod p = [(a \cdot b) + (a \cdot c)] \mod p$$

\- $$(x^y \mod p) = (x \mod p)^y \mod p$$



\- Inverses: For every non-zero integer a modulop where p is a prime, there exists an inverse $$a^{-1}$$such that $$a \cdot a^{-1} \mod p = 1$$

\- Fermat's Little Theorem: If p is a prime number, then for any integer a that is not divisible by p, $$a^{(p-1)} \mod p = 1$$

\


<mark style="color:yellow;">**Diffie-Hellman Key Exchange Protocol**</mark>

* Cryptography uses this dichotomy to achieve remarkable results&#x20;
* Alice and Bob can communicate securely over a public channel&#x20;
* &#x20;Thus cryptography can be seen as an application of algorithmic ideas (<mark style="color:green;">fast modular exponentiation</mark> enables Diffie-Hellman key exchange)
* The invention of a fast algorithm for discrete log will break Diffie-Hellman.
* Cryptography was revolutionized by the invention of the Diffie-Hellman key exchange protocol.

{% hint style="info" %}
Diffie-Hellman Key Exchange Protocol（迪菲-赫尔曼密钥交换协议）是一种安全协议，允许两个通信方在不安全的通道上创建一个共享的秘密密钥，这个密钥可以用于之后的通信加密。这个协议是基于离散对数问题的困难性，这个问题在数学上是难以解决的，从而为通信提供了安全保障。

#### 工作原理

1. **选择全局参数**：首先，两个通信方同意使用一个大的素数 ( p ) 和它的一个原根 ( g ) 作为基数。这些参数是公开的，并且可以被通信双方之外的人知晓。
2. **生成私钥**：每个通信方各自randomly选择一个私钥。Alice选择 ( a )，Bob选择 ( b )。这些私钥是秘密的，不被对方或其他任何人知晓。
3. **计算公钥**：Alice计算 ( $$A = g^a \mod p$$ ) 并将结果 ( A ) 发送给Bob。同样，Bob计算 ( $$B = g^b \mod p$$ ) 并将结果 ( B ) 发送给Alice。
4. **生成共享密钥**：当Alice收到Bob的公钥 ( B ) 后，她用自己的私钥 ( a ) 计算共享密钥 ( $$s = B^a \mod p$$ )。Bob也同样使用Alice的公钥 ( A ) 和自己的私钥 ( b ) 计算共享密钥 ( $$s = A^b \mod p$$ )。

#### 结果

根据模幂运算的性质，Alice和Bob计算出的共享密钥是相等的：

$$[ B^a \mod p = (g^b)^a \mod p = g^{ab} \mod p ]$$\
$$[ A^b \mod p = (g^a)^b \mod p = g^{ab} \mod p ]$$

因此，无论是Alice还是Bob，他们都得到了相同的结果 ( $$g^{ab} \mod p$$ )，这个结果就是他们的共享密钥。

#### 安全性

即使一个攻击者知道公开的素数 ( p )，基数 ( g )，以及Alice和Bob的公钥 ( A ) 和 ( B )，在没有知道私钥 ( a ) 或 ( b ) 的情况下，也很难计算出共享密钥。这是因为离散对数问题在数学上是困难的，即给定 ( A = g^a \mod p )，很难解出 ( a )。

#### 使用场景

Diffie-Hellman密钥交换在许多安全通信协议中都有使用，例如SSL/TLS协议，它是HTTPS安全通信的基础。然而，Diffie-Hellman协议本身并不提供身份验证，因此它通常与其它形式的身份验证方法结合使用，以保证通信双方的身份，并预防中间人攻击（MITM）。在现代应用中，Diffie-Hellman通常是在椭圆曲线密码学（Elliptic Curve Cryptography, ECC）的背景下实现的，称为椭圆曲线Diffie-Hellman（ECDH）。
{% endhint %}
