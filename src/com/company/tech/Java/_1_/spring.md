1) Что такое контроллеры? обрабатывает запрос пользователя

2) Что такое IoС, dependency injection?
Inversion of Control (инверсия управления) — это некий абстрактный принцип, набор рекомендаций для написания слабо связанного кода. 
Суть которого в том, что каждый компонент системы должен быть как можно более изолированным от других, не полагаясь в своей работе на детали конкретной реализации других компонентов.
Dependency Injection (внедрение зависимостей) — это одна из реализаций этого принципа

3) Что такое фабрика компонентов (bean-ов)?
BeanFactory
Простой контейнер, который обеспечивает базовую поддержку DI (Dependency Injection, инъекция зависимостей).
Для работы с этим контейнером используется интерфейс org.springframework.beans.factory.BeanFactory.

4) Что такое @Autowired, @Component, @Bean, @Conifguration, @Controller, @RestController?
   @Autowired - Аннотация @Autowired обеспечивает контроль над тем, где и как автосвязывание должны быть осуществлено

@Controller is used to create web controllers that return views, which is further resolved by view resolver, while @RestController is used to create web services that return JSON or XML data.
Аннотация @Qualifier позволяет уточнить имя бина, который надо внедрить
@Service - (Сервис-слой приложения) Аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
Bean - это просто java объект