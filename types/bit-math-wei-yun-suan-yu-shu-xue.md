# ▫ Bit & Math 位运算与数学

Math

<details>

<summary>base-10 =>其他base</summary>

**Base 2 (Binary):**

9 / 2 = 4 Remainder = 1 (这是最低位)\
4 / 2 = 2 Remainder = 0\
2 / 2 = 1 Remainder = 0\
1 / 2 = 0 Remainder = 1 (这是最高位)

从最高位到最低位读，9在二进制下表示为1001。

**Base 3 (Ternary):**

9 / 3 = 3 Remainder = 0 (这是最低位)\
3 / 3 = 1 Remainder = 0\
1 / 3 = 0 Remainder = 1 (这是最高位)

从最高位到最低位读，9在三进制下表示为100。

**Base 4 (Quaternary):**

9 / 4 = 2 Remainder = 1 (这是最低位)\
2 / 4 = 0 Remainder = 2 (这是最高位)

从最高位到最低位读，9在四进制下表示为21。

**Base 5 (Quinary):**

9 / 5 = 1 Remainder = 4 (这是最低位)\
1 / 5 = 0 Remainder = 1 (这是最高位)

从最高位到最低位读，9在五进制下表示为14。

**Base 6 (Senary):**

9 / 6 = 1 Remainder = 3 (这是最低位)\
1 / 6 = 0 Remainder = 1 (这是最高位)

从最高位到最低位读，9在六进制下表示为13。

**Base 7 (Septenary):**

9 / 7 = 1 Remainder = 2 (这是最低位)\
1 / 7 = 0 Remainder = 1 (这是最高位)

从最高位到最低位读，9在七进制下表示为12。

</details>

<details>

<summary>其他base进制 => base 10</summary>

将二进制数转换为十进制数的方法是通过权重来进行的。二进制数的每一位（从右往左，从0开始数）都有一个相应的权重，这个权重是2的n次方，其中n是这一位的位置。然后，对于二进制数中的每一位，如果这一位是1，就把它的权重加到总和中。这个总和就是二进制数的十进制表示。

例如，我们有一个二进制数1011:

1. 最右边的位是1，它的权重是2^0 = 1，所以我们把1加到总和中。
2. 下一位也是1，它的权重是2^1 = 2，所以我们把2加到总和中。
3. 下一位是0，所以我们不加任何东西。
4. 最左边的位是1，它的权重是2^3 = 8，所以我们把8加到总和中。

加起来，我们得到1 + 2 + 8 = 11。所以，二进制数1011的十进制表示就是11。

</details>

<details>

<summary>Binary  &#x26; Octal &#x26; Hex</summary>

```
Binary  | Octal  |   Hex
--------|---------|----------
000     |   0     |    0
001     |   1     |    1
010     |   2     |    2
011     |   3     |    3
100     |   4     |    4
101     |   5     |    5
110     |   6     |    6
111     |   7     |    7
--------|---------|----------
1000    |  10     |    8
1001    |  11     |    9
1010    |  12     |    A 10
1011    |  13     |    B 11
1100    |  14     |    C 12
1101    |  15     |    D 13
1110    |  16     |    E 14
1111    |  17     |    F 15
```

<mark style="color:yellow;">**Binary to Octal:**</mark>

*   **Binary to Octal**: From right to left (from the least significant digit to the most significant), group the binary numbers, <mark style="color:red;">**three digits per group**</mark>, and then convert each group to the corresponding octal number.&#x20;

    ```
    Binary Number:  1  101  011 101
    Grouping:       1  101  011  101
                   (1)  (5)  (3)  (5)
    Octal Number: 1535
    ```

<!---->

* **Octal to Binary**: Convert each octal digit into the corresponding three-digit binary number. For example, octal number `1535` corresponds to binary numbers `001`, `101`, `011`, `101`. So, `1535` is represented as `110101101` in binary.
* Why group by 3 digits in binary? \
  &#x20;<mark style="color:red;">**in the octal system, the maximum value that each digit can represent is 7 (total num = 8)**</mark> To represent the 16 possible values of a hexadecimal digit, we need four binary digits: 2^3 = 8&#x20;

<mark style="color:yellow;">**Binary to Hexadecimal:**</mark>

* **Binary to Hexadecimal**: From right to left, group the binary numbers, <mark style="color:red;">**four digits per group**</mark>, and then convert each group to the corresponding hexadecimal number. For example, binary number `110101101` can be grouped as `11`, `0101`, `1011`. The corresponding hexadecimal numbers are `3`, `5`, `B`. So, `110101101` is represented as `35B` in hexadecimal.
* **Hexadecimal to Binary**: Convert each hexadecimal digit into the corresponding four-digit binary number. For example, hexadecimal number `35B` corresponds to binary numbers `0011`, `0101`, `1011`. So, `35B` is represented as `110101101` in binary.
* Why group by 4 digits in binary? \
  &#x20;<mark style="color:red;">**in the hex system, the maximum value that each digit can represent is 15(total num = 16)**</mark> To represent the 16 possible values of a hexadecimal digit, we need four binary digits: 2^4 = 16

<mark style="color:yellow;">**Octal to Hexadecimal:**</mark>

The conversion between octal and hexadecimal usually involves binary as an intermediary. First, convert the octal or hexadecimal number to binary, and then convert the binary number to hexadecimal or octal.

</details>
