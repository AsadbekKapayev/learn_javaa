# ООП принципы: наследование, инкапсуляция, полиморфизм, абстракция

### Инкапсуляция

— это упаковка данных и функций в одну единицу, называемую объектом.

Так, например, можно представить автомобиль как объект, который содержит данные (марка, модель, цвет) и функции (едет,
останавливается).

### Наследование

— это способность объекта наследовать свойства и методы от другого объекта.

Это помогает сократить повторение кода. Если мы продолжим пример с автомобилем, то можно представить объект «спортивный
автомобиль», который наследует свойства от базового объекта «автомобиль», но при этом имеет дополнительные свойства,
такие как «максимальная скорость».

### Полиморфизм

позволяет объектам использовать методы, которые были определены в их родительских классах, но при этом они могут иметь
свою собственную реализацию этих методов.

Например, у всех автомобилей есть метод «едет», но для спортивного автомобиля этот метод может иметь более сложную
реализацию, например, учитывающую максимальную скорость.

### Абстракция

— это процесс сокрытия деталей реализации и показа только функциональности.

В контексте ООП это означает, что детали реализации методов и свойств объектов скрыты от пользователя. Если мы продолжим
пример с автомобилем, то пользователю не нужно знать, как именно работает двигатель, чтобы управлять автомобилем.

# Что такое паттерн Singleton?

Создание Singleton включает в себя определение класса, который возвращает новый экземпляр класса, если он еще не
существует, или возвращает существующий экземпляр, если он уже был создан ранее.

В Java это можно сделать несколькими способами, ниже приведены два наиболее распространенных:

* Eager Initialization <1>: Этот подход включает создание экземпляра Singleton во время загрузки класса. Это самый
  простой способ реализовать шаблон Singleton.
* Lazy Initialization <2>: В этом подходе создание экземпляра Singleton откладывается до тех пор, пока он не
  потребуется. Это может быть полезно, если создание экземпляра занимает много ресурсов.

# Что такое SOLID?

### Принцип единственной ответственности (Single Responsibility Principle)

говорит о том, что каждый класс или модуль должен иметь только одну ответственность.

Это означает, что класс должен быть ответственным только за один аспект функциональности или поведения. Если он имеет
слишком много ответственностей, он становится сложным в понимании, изменении и тестировании. Поэтому разделение
функциональности на отдельные классы или модули помогает сделать код более чистым, поддерживаемым и расширяемым.

### Принцип открытости/закрытости (Open/Closed Principle)

утверждает, что классы должны быть открыты для расширения и закрыты для модификации.

Вместо того чтобы изменять код существующих классов, мы должны стремиться к добавлению нового кода для расширения
функциональности. Это позволяет нам избежать потенциальных ошибок и проблем, которые могут возникнуть при изменении уже
работающего кода. Благодаря этому принципу мы можем создавать гибкие системы, которые легко поддаются изменениям и
расширению.

### Принцип подстановки Барбары Лисков (Liskov Substitution Principle)

гласит, что объекты должны быть заменяемыми своими подтипами без нарушения корректности программы.

Это означает, что если у нас есть класс-родитель и класс-потомок, то код, использующий объект первого, должен работать
корректно и с объектом второго. Подклассы не должны изменять предуслови_*я, постусловия или инварианты базового класса.
Этот принцип помогает нам строить иерархии наследования, которые логично и безопасно расширяют функциональность.

### Принцип разделения интерфейса (Interface Segregation Principle)

указывает на то, что клиенты не должны зависеть от интерфейсов, которые они не используют полностью.

Вместо того чтобы создавать общие интерфейсы с множеством методов, следует создавать более специфичные, которые
содержали бы только необходимые клиентам методы. Это позволяет избежать ненужной связности между классами и упрощает
изменения в коде.

### Принцип инверсии зависимостей (Dependency Inversion Principle)

говорит о том, что модули верхнего уровня не должны зависеть от модулей нижнего уровня.

Оба уровня должны зависеть от абстракций. Это означает, что мы должны стремиться к тому, чтобы зависимости между
классами строились на основе абстракций, интерфейсов или абстрактных классов, а не на конкретных реализациях. Этот
принцип позволяет нам создавать слабосвязанные системы, которые легко изменять и тестировать, а также способствует
возможности повторного использования кода.