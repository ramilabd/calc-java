## Calculator

### Console application, powered by [Java 17](https://www.oracle.com/java/technologies/downloads/#java17)

### Features:

- works with Arabic and Roman numbers from 0 to 10 (from I to X)
- addition
- subtraction
- multiplication
- division

### Examples:

**Input:**
```1 + 2```

**Output:**
```3```

**Input:**
```VI / III```

**Output:**
``II``

### If the mathematical expression is incorrect, an exception is thrown:

**Input:**
```I - II```

**Output:**
```throws Exception //т.к. в римской системе нет отрицательных чисел```

**Input:**
```I - I```

**Output:**
```throws Exception //т.к. в римской системе счисления нет цифры 0```

**Input:**
```I + 1```

**Output:**
```throws Exception //т.к. используются одновременно разные системы счисления```

**Input:**
```1```

**Output:**
```throws Exception //т.к. строка не является математической операцией```

**Input:**
```1 + 2 + 3```

**Output:**
```throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)```

### Instalation

**clone the repository**:

    $ git@github.com:ramilabd/calc-java.git

**go to the directory:**

    $ cd calc-java/

**compile the program:**

    $ javac src/com/Main.java -sourcepath src -d out

**start programm:**

    $ java -cp ./out com.Main
