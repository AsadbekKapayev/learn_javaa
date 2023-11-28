## Обобщенные Классы и Методы

* **Обобщенные Классы:** Позволяют создавать классы, которые могут работать с разными типами данных.
  Например, `ArrayList<E>`.

```
public class MyGenericClass<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
```

* **Обобщенные Методы:** Позволяют создавать методы, которые могут принимать и возвращать обобщенные типы.

```
public <E> void printArray(E[] array) {
    for (E element : array) {
        System.out.println(element);
    }
}
```

## Обозначения Wildcard

* `?` - означает неопределенный тип (wildcard).
* `<? extends T>` - ограничение сверху, указывает, что тип должен быть подтипом `T`.
* `<? super T>` - ограничение снизу, указывает, что тип должен быть супертипом `T`.

```
public void processElements(List<?> elements) {
    // работает с элементами, но не знает их тип
}

public void printList(List<? extends Number> list) {
    // можно читать элементы типа Number или его подтипы
}
```

## Ограничения Generics

* `extends:` Ограничивает тип сверху (upper bound). Например, `<T extends Number>` означает, что `T` должен быть
  подтипом `Number`.
* `super:` Ограничивает тип снизу (lower bound).

```
public <T extends Comparable<T>> T findMax(List<T> list) {
    // находит максимальный элемент в списке
}

public <T> void copy(List<? super T> dest, List<? extends T> src) {
    // копирует элементы из одного списка в другой
}
```

## Ограниченные Wildcard

* Используются для ограничения типа данных, которые могут быть переданы в метод.

```
public static double sum(List<? extends Number> numbers) {
    double sum = 0.0;
    for (Number number : numbers) {
        sum += number.doubleValue();
    }
    return sum;
}
```

## Erasure (Стирание)

* Во время выполнения информация о типах стирается (erased). Это делается для обеспечения обратной совместимости с кодом, написанным до введения generics.

## Generic-массивы

* Создание обобщенных массивов напрямую не поддерживается из-за ограничений стирания. Используйте ArrayList или другие коллекции.


