# Streams

### Intermediate operations

map(), filter(), distinct(), sorted(), limit(), skip()

### Terminal operations

forEach(), toArray(), reduce(), collect(), min(), max(), count(), anyMatch(), allMatch(), noneMatch(), findFirst(),
findAny()

## reduce 3 type

`list.parallelStream().reduce(1, Integer::sum, Integer::sum);`

- 1 - Начальное значение (`identity`): Это значение будет использовано в качестве начального аккумулируемого значения.

- `Integer::sum` - Функция аккумулятора (`accumulator`): Это лямбда-выражение, которое принимает два аргумента: текущее
  аккумулируемое значение и элемент потока. Здесь оно представлено как метод ссылки `Integer::sum`, который складывает
  два числа.

- `Integer::sum` - Функция комбинатора (`combiner`): Это также метод сложения двух чисел, который используется для
  комбинирования (объединения) результатов параллельных потоков.

## limit & skip in parallel stream

- `limit` в `parallel stream`: `limit` ограничивает количество элементов в потоке до заданного числа. В параллельном
  потоке, каждый подпоток может обработать свой кусок данных, и `limit` ограничит количество элементов в каждом
  подпотоке, а не общее количество элементов во всем потоке.

```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

List<Integer> result = numbers.parallelStream()
                             .limit(5)
                             .collect(Collectors.toList());
```

- `skip` в `parallel stream`: `skip` пропускает заданное количество элементов в потоке. В параллельном потоке, каждый
  подпоток может пропустить свой кусок данных, и `skip` пропустит элементы в каждом подпотоке, а не общее количество
  элементов во всем потоке.

```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

List<Integer> result = numbers.parallelStream()
                             .skip(5)
                             .collect(Collectors.toList());

```
