# OldFashionPound

Write a library (package OldFashionPound) implementing the 4 arithmetic operations (sum, subtraction, multiplication and division) for pre-1970 UK prices. 
Under the old money system of UK, before 1970, there were 12 pence in a shilling and 20 shillings, or 240 pence, in a pound. Thus, a price in th OldUK Money system was expressed in Pounds, Shillings and Pence. For example "12p 6s 10d" is 12 Pounds, 6 Shillings and 10 Pence.

Sum and Subtraction should add or subtract two prices respectively.
Example SUM:                  5p 17s 8d + 3p 4s 10d= 9p 2s 6d
Example SUBTRACTION:               5p 17s 8d - 3p 4s 10d= 2p 12s 10d

Subtractions giving negative results should be managed.

Multiplication and division will multiply or divide a price by an integer (no decimal is necessary)
Example MULTIPLICATION:         5p 17s 8d * 2 = 11p 15 s 4d
Example DIVISION                          5p 17s 8d / 3 = 1p 19s 2d (2p) (2 pence as remainder - the remainder should be represented between parenthesis)
Another Example DIVISION          18p 16s 1d / 15 = 1p 5s 0d   (1s 1d) (1 Shillings and 1 penny as remainder - the remainder should be represented between parenthesis)

The library should be able to receive and produce strings in the format "Xp Ys Zd", as in the examples

